package com.satish.query.service;

import com.satish.dto.ProductEvent;
import com.satish.query.entity.Product;
import com.satish.query.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Class ProductQueryService
 * <p>
 * Description: This class represents ...
 * </p>
 *
 * @author satishkumarsubudhi
 * @since 05/02/25
 */
@Service
public class ProductQueryService {

    @Autowired
    private IProductRepository iProductRepository;


    @Transactional
    @KafkaListener(groupId = "product-event-group", topics = "product-event")
    public void processEvents(ProductEvent productEvent){
        Product product = productEvent.getProduct();
        if(productEvent.getEventType().equals("created")){
            iProductRepository.save(product);
        }
        if(productEvent.getEventType().equals("updated")){
            Product currentProduct = iProductRepository.findById(product.getId()).get();
            currentProduct.setName(product.getName());
            currentProduct.setDescription(product.getDescription());
            currentProduct.setPrice(product.getPrice());
            iProductRepository.save(currentProduct);
        }
    }

    public List<Product> getProduct() {
        return iProductRepository.findAll();
    }
}
