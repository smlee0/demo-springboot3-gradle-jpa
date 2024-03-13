package com.example.module.api.v1.sample.repository.custom.impl;

import com.example.module.api.v1.sample.repository.custom.SampleRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

/**
 * 샘플 레포지토리 커스텀 구현부
 *
 * @author LEESEMIN
 */
@RequiredArgsConstructor
public class SampleRepositoryCustomImpl implements SampleRepositoryCustom {

	private final JPAQueryFactory queryFactory;

}