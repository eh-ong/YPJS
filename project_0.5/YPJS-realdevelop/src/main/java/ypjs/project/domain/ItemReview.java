package ypjs.project.domain;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Table(name = "item_review")
@Getter
public class ItemReview {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_review_id")
    private Long itemReviewId;

    @ManyToOne
    @JoinColumn(name = "item_review_item_id")
    private Item item;

    @ManyToOne
    @JoinColumn(name = "item_review_member_id")
    private Member member;

    @Column(name = "item_review_score")
    private int score;

    @Column(name = "item_review_title")
    private String title;

    @Lob
    @Column(name = "item_review_content", columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "item_review_create_date")
    @CreatedDate
    private LocalDateTime createDate;


    //생성자

    public ItemReview() {}

    public ItemReview(Item item, Member member, int score, String title, String content) {

        this.item = item;
        this.member = member;
        this.score = score;
        this.title = title;
        this.content = content;
        this.createDate = LocalDateTime.now();
    }



    //리뷰변경 메서드
    public Long change(int score, String title, String content) {
        this.score = score;
        this.title = title;
        this.content = content;

        return this.itemReviewId;
    }


    //연관관계 메서드
    public void setItem(Item item) {
        this.item = item;
    }
}