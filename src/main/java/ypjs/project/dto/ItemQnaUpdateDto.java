package ypjs.project.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemQnaUpdateDto {

    private Long itemQnaId;

    private String question;

    private String answer;

}