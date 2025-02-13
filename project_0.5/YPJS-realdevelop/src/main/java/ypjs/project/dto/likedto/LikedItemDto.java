package ypjs.project.dto.likedto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ypjs.project.domain.Item;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LikedItemDto {

    private Long itemId;
    private String name;
    private int price;
    private String filename;
    private String filepath;

    public LikedItemDto(Item item){
        itemId = item.getItemId();
        name = item.getName();
        price = item.getPrice();
        filename = item.getFileName();
        filepath = item.getFilePath();
    }

}
