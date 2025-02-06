package com.satish.query.controller;

import com.satish.query.entity.Product;
import com.satish.query.service.ProductQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Class ProductQueryController
 * <p>
 * Description: This class represents ...
 * </p>
 *
 * @author satishkumarsubudhi
 * @since 05/02/25
 */
@RestController
@RequestMapping("/products")
public class ProductQueryController {

    @Autowired
    private ProductQueryService productQueryService;

    @GetMapping
    public List<Product> getProduct(){
        return  productQueryService.getProduct();
    }
}
