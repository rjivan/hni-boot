package org.hni.data.repository;

import org.hni.data.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by rjivan on 11/10/16.
 */
public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(String lastName);
}
