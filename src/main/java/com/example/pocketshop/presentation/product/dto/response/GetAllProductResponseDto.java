package com.example.pocketshop.presentation.product.dto.response;

import com.example.pocketshop.domain.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponseDto {
    private List<Product> products;
}
