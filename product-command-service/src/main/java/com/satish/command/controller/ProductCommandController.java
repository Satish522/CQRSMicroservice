package com.satish.command.controller;

import com.satish.command.entity.Product;
import com.satish.command.service.ProductCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Class ProductCommandController
 * <p>
 * Description: This class represents ...
 * </p>
 *
 * @author satishkumarsubudhi
 * @since 05/02/25
 */
@RestController
@RequestMapping("/products")
public class ProductCommandController {

    @Autowired
    private ProductCommandService productCommandService;

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return  productCommandService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return productCommandService.updateProduct(id, product);
    }

}
