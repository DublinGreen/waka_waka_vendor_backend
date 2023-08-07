package com.wakawakavendor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wakawakavendor.models.Category;

/**
 *
 * @author idisimagha dublin-green
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
