package com.example.module.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.entity.Sample;
import com.example.module.sample.repository.custom.SampleRepositoryCustom;

/**
 * 샘플 레포지토리
 *
 * @author LEESEMIN
 */
@Repository
public interface SampleRepository extends JpaRepository<Sample, Long>, QuerydslPredicateExecutor<Sample>, SampleRepositoryCustom {

	boolean existsByName(String name);

}
