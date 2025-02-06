package com.satish.command.service;

import com.satish.dto.ProductEvent;
import com.satish.command.entity.Product;
import com.satish.command.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Class ProductCommandService
 * <p>
 * Description: This class represents ...
 * </p>
 *
 * @author satishkumarsubudhi
 * @since 05/02/25
 */
@Service
public class ProductCommandService {

    @Autowired
    private IProductRepository iProductRepository;

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public Product createProduct(Product product) {
        Product savedProduct = iProductRepository.save(product);
        ProductEvent event = new ProductEvent("created", savedProduct);
        kafkaTemplate.send("product-event", event);
        return savedProduct;
    }

    public Product updateProduct(Long id, Product product) {
        Product currentProduct = iProductRepository.findById(id).get();
        currentProduct.setDescription(product.getDescription());
        currentProduct.setPrice(product.getPrice());
        Product savedProduct = iProductRepository.save(currentProduct);
        ProductEvent event = new ProductEvent("updated", savedProduct);
        kafkaTemplate.send("product-event", event);
        return savedProduct;
    }
}
