package com.tekup.ecommerce.repository;

import com.tekup.ecommerce.entities.Ordre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdreRepo extends JpaRepository<Ordre, Integer> {
}
