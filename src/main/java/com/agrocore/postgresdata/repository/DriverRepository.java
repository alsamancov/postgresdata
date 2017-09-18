package com.agrocore.postgresdata.repository;

import com.agrocore.postgresdata.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Long> {
    Driver findByName(String name);
}
