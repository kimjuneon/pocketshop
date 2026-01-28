package com.example.pocketshop.presentation.product.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequestDto {
    @NotNull
    private String name;
    @NotNull
    private Integer price;
    @NotNull
    private Integer num;
}
