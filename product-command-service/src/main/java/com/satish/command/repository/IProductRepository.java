package com.satish.command.repository;

import com.satish.command.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Class IProductRepository
 * <p>
 * Description: This class represents ...
 * </p>
 *
 * @author satishkumarsubudhi
 * @since 05/02/25
 */
public interface IProductRepository extends JpaRepository<Product, Long> {
}
