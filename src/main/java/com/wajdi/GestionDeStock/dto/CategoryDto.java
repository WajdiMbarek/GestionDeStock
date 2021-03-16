package com.wajdi.GestionDeStock.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wajdi.GestionDeStock.model.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class CategoryDto {

    private Integer id;

    private String code;

    private String desiniation;
    @JsonIgnore
    private List<ArticleDto> articles;

    public static CategoryDto fromEntity(Category category) {
        if (category == null) {
            return null;
            // TODO throw an exception
        }
        //Category -> CategoryDto
        return CategoryDto.builder()
                .id(category.getId())
                .code(category.getCode())
                .desiniation(category.getDesiniation())
                .build();
    }

    public static Category toEntity(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
            // TODO throw an exception
        }

        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setCode(categoryDto.getCode());
        category.setDesiniation(categoryDto.getDesiniation());
        return category;
    }

}
