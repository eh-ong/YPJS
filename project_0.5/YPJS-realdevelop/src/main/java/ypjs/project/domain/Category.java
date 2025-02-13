package ypjs.project.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "category")
public class Category {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long categoryId;

    //연관관계 메서드
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();


    @Column(name = "category_name")
    private String name;


    //자신을 부모타입으로 가짐
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_parent_id")
    private Category parent;


    //자식은 여러개 가질 수 있음
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();


    //생성자
    public Category() {}


    public Category (Category parent, String name) {
        this.parent = parent;
        this.name = name;
    }


    //카테고리 부모 롱타입으로
    public void LongCategory(Category parent) {
        this.parent = parent;
    }

    //카테고리 변경 메서드
    public Long changeCategory (Category parent, String name) {
        this.parent = parent;
        this.name = name;

        return this.categoryId;
    }






    //연관관계 메서드
    public void addChildCategory(Category child) {
        this.child.add(child);
        child.parent = this;
    }


    public void addItem(Item item) {
        items.add(item);
        item.setCategory(this);
    }



}