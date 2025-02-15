package com.bus.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bus.entities.Driver;

public interface DriverRepo extends JpaRepository<Driver, Long> {

}
