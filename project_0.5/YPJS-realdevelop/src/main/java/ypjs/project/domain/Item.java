package ypjs.project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "item")
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Item {



    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_category_id")
    private Category category;

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<ItemReview> reviews = new ArrayList<>();


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Like> likes = new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Cart> carts = new ArrayList<>();


    @ManyToOne
    @JoinColumn(name = "item_member_id")
    private Member member;


    @Column(name = "item_name")
    private String name;

    @Lob
    @Column(name = "item_content", columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "item_price")
    private int price;

    @Column(name = "item_stock")
    private int stock;

    @Column(name = "item_file_name")
    private String fileName;

    @Column(name = "item_file_path")
    private String filePath;

    @Column(name = "item_create_date")
    @CreatedDate
    private LocalDateTime createDate;


    @Column(name = "item_cnt")
    private int cnt = 0;

    @Column(name = "item_ratings")
    private Double ratings = 0.0;

    @Column(name = "item_like_count")
    private int likeCount = 0;


    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    private List<ItemQna> qnas = new ArrayList<>();



    //생성자

    public Item() {}

    public Item(Category category, Member member, String name, String content, int price, int stock) {
        this.category = category;
        this.member = member;
        this.name = name;
        this.content = content;
        this.price = price;
        this.stock = stock;
        this.createDate = LocalDateTime.now();

    }


    //상품변경메서드
    public Long change(Category category, String name, String content, int price, int stock) {
        this.category = category;
        this.name = name;
        this.content = content;
        this.price = price;
        this.stock = stock;


        return this.itemId;
    }


    //파일추가 메서드
    public void addfile(String fileName, String filePath) {
        this.fileName = fileName;
        this.filePath = filePath;

    }




    //평점계산
    public void updateItemRatings() {

        if (reviews == null || reviews.isEmpty()) {
            this.ratings = 0.0;
        }

        double totalScore = 0;
        int count = 0; // 평가된 리뷰의 개수를 세기 위한 변수
        for (ItemReview itemReview : reviews) {
            if (itemReview.getScore() != 0) {
                //double score = Math.min(Math.max(review.getItemScore(), 1.0), 5.0);
                //totalScore += score;
                totalScore += itemReview.getScore();
                count++;
            }
        }
        if (count > 0) {
            double averageScore = totalScore / count;
            // 소숫점 첫째자리까지 반환
            this.ratings = Math.round(averageScore * 10.0) / 10.0; //소숫점 첫째자리까지 반환
        } else {
            this.ratings = 0.0;
        }

    }





    //연관관계 메서드
    public void setCategory(Category category) {
        this.category = category;
    }


    public void addItemReview(ItemReview itemReview) {
        reviews.add(itemReview);
        itemReview.setItem(this);
    }

    public void removeItemReview(ItemReview itemReview) {
        reviews.remove(itemReview);
    }



    //==재고 제거 메서드==//
    public void removeStock(int count) {
        this.stock -= count;
    }

    //==재고 추가 메서드==//
    public void addStock(int count) {
        this.stock += count;
    }


    //==좋아요 메서드==//
    public void addLike(){
        this.likeCount += 1;
    }

    public void deleteLike(){
        if (this.likeCount > 0) {
            this.likeCount -= 1;
        }
    }



}