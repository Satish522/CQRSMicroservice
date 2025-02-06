package com.satish.query.repository;

import com.satish.query.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class IProductRepository
 * <p>
 * Description: This class represents ...
 * </p>
 *
 * @author satishkumarsubudhi
 * @since 05/02/25
 */
@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
}
