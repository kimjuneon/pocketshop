package com.example.pocketshop.application.product.service;

import com.example.pocketshop.domain.product.entity.Product;
import com.example.pocketshop.domain.product.repository.ProductRepository;
import com.example.pocketshop.presentation.product.dto.request.CreateProductRequestDto;
import com.example.pocketshop.presentation.product.dto.request.UpdateProductRequestDto;
import com.example.pocketshop.presentation.product.dto.response.GetAllProductResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public void createProduct(CreateProductRequestDto request){
        productRepository.save(new Product(request.getPrice(), request.getName(), request.getNum()));
    }

    @Transactional(readOnly = true)
    public GetAllProductResponseDto getAllProduct(){
        List<Product> products =  productRepository.findAll();

        return new GetAllProductResponseDto(products);
    }

    @Transactional
    public void updateProduct(UpdateProductRequestDto request) {
        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("해당 id의 상품이 존재하지 않습니다."));
        if(request.getPrice() != null)
            product.setPrice(request.getPrice());
        if(request.getName() != null)
            product.setName(request.getName());
        if(request.getAddNum() != null){
            int num = product.getNum();
            product.setNum(num + request.getAddNum());
        }
    }

    @Transactional
    public void deleteProduct(Long productId){
        productRepository.deleteById(productId);
    }
}
