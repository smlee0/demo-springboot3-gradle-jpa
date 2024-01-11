package com.example.module.category.repository.custom.impl;

import org.springframework.data.jpa.repository.query.JpaQueryMethodFactory;

import com.example.module.category.repository.custom.CategoryRepositoryCustom;

import lombok.RequiredArgsConstructor;

/**
 * 카테고리 레포지토리 커스텀 구현부
 *
 * @author LEESEMIN
 */
@RequiredArgsConstructor
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

	private final JpaQueryMethodFactory queryFactory;

}