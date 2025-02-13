package ypjs.project.dto.itemdto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;

@Data
public class ItemReviewDto {

    private Long itemId;

    private Long itemReviewId;

    @Min(value = 1, message = "itemScore must be at least 1 or greater.")
    private int score;

    @NotBlank(message = "itemReviewName not be null")
    private String title;

    @NotBlank(message = "itemReviewContent not be null")
    private String content;


    public ItemReviewDto() {}


    public ItemReviewDto(Long itemId, Long itemReviewId,int score, String title, String content) {
        this.itemId = itemId;
        this.itemReviewId = itemReviewId;
        this.score = score;
        this.title = title;
        this.content = content;
    }




}
