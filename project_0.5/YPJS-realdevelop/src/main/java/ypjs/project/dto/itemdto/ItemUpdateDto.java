package ypjs.project.dto.itemdto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

@Data
public class ItemUpdateDto {
    private Long itemId;
    @NotNull(message = "Category ID not be null")
    private Long categoryId;

    @NotBlank(message = "ItemName not be null")
    private String name;
    @NotBlank(message = "ItemContent not be null")
    private String content;

    @Min(value = 1, message = "ItemPrice must be at least 1 or greater.")
    private int price;

    @Min(value = 1, message = "ItemStock must be at least 1 or greater.")
    private int stock;



    public ItemUpdateDto(){}

    public ItemUpdateDto(Long itemId,Long categoryId, String name, String content, int price, int stock) {
        this.itemId = itemId;
        this.categoryId = categoryId;
        this.name = name;
        this.content = content;
        this.price = price;
        this.stock = stock;

    }
}
