package com.example.pocketshop.application.order.service;

import com.example.pocketshop.domain.order.entity.Order;
import com.example.pocketshop.domain.order.repository.OrderRepository;
import com.example.pocketshop.domain.product.entity.Product;
import com.example.pocketshop.domain.product.repository.ProductRepository;
import com.example.pocketshop.presentation.order.dto.request.CreateOrderRequestDto;
import com.example.pocketshop.presentation.order.dto.response.GetAllOrderResponseDto;
import com.example.pocketshop.presentation.order.dto.OrderDetail;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;

    @Transactional
    public void createOrder(CreateOrderRequestDto request){
        Product product = productRepository.findByIdForUpdate(request.getProductId())
                .orElseThrow(() -> new IllegalArgumentException("해당 아이디의 제품을 찾을 수 없습니다."));
        int num = product.getNum() - request.getNum();
        if(num < 0){
            log.warn("재고는 0보다 작아질 수 없습니다");
            return;
        }
        product.setNum(num);
        Order order = new Order(request.getProductId(), request.getNum());
        orderRepository.save(order);
    }

    @Transactional(readOnly = true)
    public GetAllOrderResponseDto getAllOrders(){
        List<Order> orders = orderRepository.findAll();
        List<Long> productIds = new ArrayList<>();

        for(Order order : orders){
            if(!productIds.contains(order.getProductId()))
                productIds.add(order.getProductId());
        }

        Map<Long, String> productIdNameMap = productRepository.findIdNameByIds(productIds)
                .stream().collect(Collectors.toMap(
                        row -> (Long) row[0],
                        row -> (String) row[1]
                ));

        List<OrderDetail> orderDetails = new ArrayList<>();

        for(Order order : orders){
            orderDetails.add(new OrderDetail(
                    order.getId(),
                    order.getProductId(),
                    productIdNameMap.get(order.getProductId()),
                    order.getNum()
            ));
        }

        return new GetAllOrderResponseDto(orderDetails);
    }
}
