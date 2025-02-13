package ypjs.project.dto.categorydto;

import lombok.Getter;
import ypjs.project.domain.Category;
import ypjs.project.dto.itemdto.ItemListDto;

import java.util.List;

@Getter
public class CategoryOneDto {

    private Long categoryId;
    private Long parent;
    private String name;

    private List<ItemListDto> items;

    public CategoryOneDto() {}


    public CategoryOneDto(Category category, List<ItemListDto> items) {
        categoryId = category.getCategoryId();

        // category.parent가 null이 아닐 때만 값을 설정
        if (category.getParent() != null) {
            parent = category.getParent().getCategoryId();
        } else {
            parent = null;
        }

        name = category.getName();
        this.items = items;
    }

    }







