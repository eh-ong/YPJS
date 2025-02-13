package ypjs.project.dto.itemdto;

import lombok.Data;
import ypjs.project.domain.Item;

@Data
public class ItemFileDto {


    public String fileName;
    public String filePath;

    public ItemFileDto(){}

    public ItemFileDto(Item item) {
        fileName = item.getFileName();
        filePath = item.getFilePath();
    }
}
