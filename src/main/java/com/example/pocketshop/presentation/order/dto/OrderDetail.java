package com.example.pocketshop.presentation.order.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class OrderDetail{
    private Long orderId;
    private Long productId;
    private String productName;
    private Integer productNum;
}
