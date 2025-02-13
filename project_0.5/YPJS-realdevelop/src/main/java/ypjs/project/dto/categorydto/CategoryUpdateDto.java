package ypjs.project.dto.categorydto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import ypjs.project.domain.Category;

@Data
public class CategoryUpdateDto {

    private Long categoryId;

    @NotNull(message = "parent not be null")
    private Long parent;

    @NotBlank(message = "name not be null")
    private String name;

    public CategoryUpdateDto() {}

    public CategoryUpdateDto(Long categoryId, Long parent, String name) {
        this.categoryId = categoryId;
        this.parent = parent;
        this.name = name;
    }
}
