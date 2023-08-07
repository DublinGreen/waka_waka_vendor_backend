package com.wakawakavendor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wakawakavendor.models.Rate;

/**
 *
 * @author idisimagha dublin-green
 */
@Repository
public interface RateRepository extends JpaRepository<Rate, Long> {
}
