package com.example.datascience.dao;

import com.example.datascience.pojo.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Gabri
 */
@Repository
public interface ExampleRepository extends JpaRepository<Example,Integer> {
}
