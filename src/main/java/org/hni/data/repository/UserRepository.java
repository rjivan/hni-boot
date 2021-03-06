package org.hni.data.repository;

import org.hni.data.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    List<User> findByLastName(@Param("lastName") String lastName);

    Optional<User> findByEmail(String email);
}
