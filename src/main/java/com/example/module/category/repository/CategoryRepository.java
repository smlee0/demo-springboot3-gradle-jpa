package com.example.module.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.entity.Category;
import com.example.module.category.repository.custom.CategoryRepositoryCustom;

/**
 * 카테고리 레포지토리
 *
 * @author LEESEMIN
 */
@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, QuerydslPredicateExecutor<Category>, CategoryRepositoryCustom {

}
