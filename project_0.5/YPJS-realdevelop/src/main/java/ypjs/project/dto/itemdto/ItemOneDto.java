package ypjs.project.dto.itemdto;

import lombok.Data;
import ypjs.project.domain.Item;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class ItemOneDto {

    private Long itemId;
    private String name;
    private String content;
    private int price;
    private double ratings;
    private LocalDateTime createDate;
    private int cnt;
    private String filePath;

    private List<ItemReviewListDto> reviews;

    
    public ItemOneDto(Item item) {
        this.itemId = item.getItemId();
        this.name = item.getName();
        this.content = item.getContent();
        this.price = item.getPrice();
        this.ratings = item.getRatings();
        this.createDate = item.getCreateDate();
        this.cnt = item.getCnt();
        filePath = item.getFilePath();


        this.reviews = item.getReviews().stream()
                .map(ItemReviewListDto::new)
                .collect(Collectors.toList());
    }
}
