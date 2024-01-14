package com.example.module.category.repository.custom.impl;

import com.example.module.category.repository.custom.CategoryRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

/**
 * 카테고리 레포지토리 커스텀 구현부
 *
 * @author LEESEMIN
 */
@RequiredArgsConstructor
public class CategoryRepositoryCustomImpl implements CategoryRepositoryCustom {

	private final JPAQueryFactory queryFactory;

}