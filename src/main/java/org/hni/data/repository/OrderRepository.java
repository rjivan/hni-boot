package org.hni.data.repository;

import org.hni.data.domain.Organization;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Organization, Long> {

}
