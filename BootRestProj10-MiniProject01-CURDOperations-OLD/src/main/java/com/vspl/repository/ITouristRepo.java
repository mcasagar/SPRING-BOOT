package com.vspl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vspl.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
