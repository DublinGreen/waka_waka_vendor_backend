package com.wakawakavendor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wakawakavendor.models.Product;

/**
 *
 * @author idisimagha dublin-green
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
