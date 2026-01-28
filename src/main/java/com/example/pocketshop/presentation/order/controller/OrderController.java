package com.example.pocketshop.presentation.order.controller;

import com.example.pocketshop.application.order.service.OrderService;
import com.example.pocketshop.domain.order.entity.Order;
import com.example.pocketshop.presentation.order.dto.request.CreateOrderRequestDto;
import com.example.pocketshop.presentation.order.dto.response.GetAllOrderResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<Void> createOrder(
            @Valid @RequestBody CreateOrderRequestDto request
    ){
        orderService.createOrder(request);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("/get_all")
    public ResponseEntity<GetAllOrderResponseDto> getAllOrders(){
        return ResponseEntity.ok(orderService.getAllOrders());
    }
}
