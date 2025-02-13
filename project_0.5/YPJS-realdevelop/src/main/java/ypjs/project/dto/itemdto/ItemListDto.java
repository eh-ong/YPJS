package ypjs.project.dto.itemdto;

import lombok.Data;
import ypjs.project.domain.Item;

@Data
public class ItemListDto {

    private Long itemId;
    private String name;
    private String content;
    private int price;
    private int stock;
    private double ratings;
    private String filePath;
    private int cnt;

    public ItemListDto() {}

    public ItemListDto(Item item) {

        itemId = item.getItemId();
        name = item.getName();
        content = item.getContent();
        price = item.getPrice();
        stock = item.getStock();
        ratings = item.getRatings();
        filePath = item.getFilePath();
        cnt = item.getCnt();

    }




}
