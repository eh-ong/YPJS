package ypjs.project.dto.categorydto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import ypjs.project.domain.Category;

@Data
public class CategoryRequestDto {



    @NotNull(message = "parentId not be null")
    private Long parentId;

    @NotBlank(message = "name not be null")
    private String name;


    public CategoryRequestDto() {}
    public CategoryRequestDto(Long parentId, String name) {


        this.parentId = parentId;
        this.name = name;
    }



}