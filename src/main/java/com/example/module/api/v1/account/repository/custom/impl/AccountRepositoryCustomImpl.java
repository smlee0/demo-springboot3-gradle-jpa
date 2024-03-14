package com.example.module.api.v1.account.repository.custom.impl;

import com.example.module.api.v1.account.repository.custom.AccountRepositoryCustom;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

/**
 * 계정 레포지토리 커스텀 구현부
 *
 * @author LEESEMIN
 */
@RequiredArgsConstructor
public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

	private final JPAQueryFactory queryFactory;

}