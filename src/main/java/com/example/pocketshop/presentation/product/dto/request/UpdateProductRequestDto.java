package com.example.pocketshop.presentation.product.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProductRequestDto {
    @NotNull
    private Long id;
    private String name;
    @Positive
    private Integer price;
    @Positive
    private Integer addNum;
}
