package com.example.module.api.v1.account.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.example.entity.Account;
import com.example.module.api.v1.account.repository.custom.AccountRepositoryCustom;

/**
 * 샘플 레포지토리
 *
 * @author LEESEMIN
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, QuerydslPredicateExecutor<Account>, AccountRepositoryCustom {

	Optional<Account> findByEmail(String email);

}
