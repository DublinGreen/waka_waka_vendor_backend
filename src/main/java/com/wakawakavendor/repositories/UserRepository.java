package com.wakawakavendor.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.wakawakavendor.models.User;

/**
 * The interface User repository.
 *
 * @author idisimagha dublin-green
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
