package ypjs.project.dto.categorydto;

import lombok.Data;
import lombok.Getter;
import ypjs.project.domain.Category;

@Data
public class CategoryResponseDto {

    private Long categoryId;
    private Category parent;
    private String name;


    public CategoryResponseDto() {}
    public CategoryResponseDto(Long categoryId, Category parent, String name) {

        this.categoryId = categoryId;
        this.parent = parent;
        this.name = name;
    }




}