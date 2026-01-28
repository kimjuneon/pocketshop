package com.example.pocketshop.domain.product.repository;

import com.example.pocketshop.domain.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("select p.id, p.name from Product p where p.id in :ids")
    List<Object[]> findIdNameByIds(@Param("ids") List<Long> ids);
}
