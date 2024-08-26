package org.tc.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tc.backend.models.ProductImage;

import java.util.List;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
    List<ProductImage> findByProductId(Long productId);
}
