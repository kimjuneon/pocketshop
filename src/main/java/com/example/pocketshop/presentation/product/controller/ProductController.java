package com.example.pocketshop.presentation.product.controller;

import com.example.pocketshop.application.product.service.ProductService;
import com.example.pocketshop.presentation.product.dto.request.CreateProductRequestDto;
import com.example.pocketshop.presentation.product.dto.request.DeleteProductRequestDto;
import com.example.pocketshop.presentation.product.dto.request.UpdateProductRequestDto;
import com.example.pocketshop.presentation.product.dto.response.GetAllProductResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    public ResponseEntity<Void> createProduct(
            @Valid @RequestBody CreateProductRequestDto request
    ){
        log.info("상품 등록 api 호출");
        productService.createProduct(request);

        return ResponseEntity.status(201).build();
    }

    @GetMapping("get_all")
    public ResponseEntity<GetAllProductResponseDto> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @PutMapping("update")
    public ResponseEntity<Void> updateProduct(
            @Valid @RequestBody UpdateProductRequestDto request
            ){
        productService.updateProduct(request);

        return ResponseEntity.status(200).build();
    }

    @DeleteMapping("delete")
    public ResponseEntity<Void> deleteProduct(
            @Valid @RequestBody DeleteProductRequestDto request
    ){
        productService.deleteProduct(request.getProductId());

        return ResponseEntity.status(200).build();
    }
}
