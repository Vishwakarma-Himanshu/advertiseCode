package com.cg.onlineadvapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlineadvapi.domain.Category;
@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer>{

}
