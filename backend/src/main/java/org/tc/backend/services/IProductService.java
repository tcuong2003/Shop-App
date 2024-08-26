package org.tc.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.tc.backend.dtos.ProductDTO;
import org.tc.backend.dtos.ProductImageDTO;
import org.tc.backend.models.Product;
import org.tc.backend.models.ProductImage;
import org.tc.backend.responses.ProductResponse;

import java.util.List;

public interface IProductService {
    Product createProduct(ProductDTO productDTO) throws Exception;
    List<Product> findProductByIds(List<Long> productIds);
    Product getProductById(Long id) throws Exception;
    Page<ProductResponse> getAllProducts(String keyword, Long categoryId, PageRequest pageRequest);
    Product updateProduct(Long id, ProductDTO productDTO) throws Exception;
    void deleteProduct(Long id);
    boolean existsProductByName(String name);
    ProductImage createProductImage(Long productId, ProductImageDTO productImageDTO) throws Exception;
}
