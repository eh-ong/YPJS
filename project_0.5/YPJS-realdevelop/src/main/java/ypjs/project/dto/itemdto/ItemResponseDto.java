package ypjs.project.dto.itemdto;

import lombok.Getter;
import ypjs.project.domain.Item;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
public class ItemResponseDto {
    private Long categoryId;
    private Long itemId;
    private String name;
    private String content;
    private int price;
    private int stock;
    private LocalDateTime createDate;


    public ItemResponseDto() {}

    public ItemResponseDto(Long categoryId, Long itemId, String name, String content, int price, int stock,
                           LocalDateTime createDate
                           ) {

        this.categoryId = categoryId;
        this.itemId = itemId;
        this.name = name;
        this.content = content;
        this.price = price;
        this.stock = stock;
        this.createDate = createDate;

    }


}