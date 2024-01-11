package com.example.module.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Category;

/**
 * 카테고리 레포지토리
 *
 * @author LEESEMIN
 */
@Repository
// public interface CategoryRepository extends JpaRepository<Category, Long>, QuerydslPredicateExecutor<Category>, CategoryRepositoryCustom {
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
