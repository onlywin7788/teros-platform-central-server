package com.teros.central_server.repository.apiservice.product;

import com.teros.central_server.entity.apiservice.product.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
}
