package com.pduleba.spring.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pduleba.spring.boot.model.Shipwreck;

public interface ShipwreckRepository extends JpaRepository<Shipwreck, Long> {

}
