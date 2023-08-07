package com.wakawakavendor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wakawakavendor.models.Vendor;

/**
 * The interface vendor repository.
 *
 * @author idisimagha dublin-green
 */
@Repository
public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
