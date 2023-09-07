package com.demo.repo;

import com.demo.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface DemoRepo extends JpaRepository<TestEntity, Long> {

    List<TestEntity> findAll();
}
