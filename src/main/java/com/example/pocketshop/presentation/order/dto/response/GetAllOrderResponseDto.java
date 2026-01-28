package com.example.pocketshop.presentation.order.dto.response;

import com.example.pocketshop.presentation.order.dto.OrderDetail;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllOrderResponseDto {
    private List<OrderDetail> orderDetails;

}
