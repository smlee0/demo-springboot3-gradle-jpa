package com.example.module.account.dto.response;

import com.example.library.common.CommonFilter;
import com.example.library.constant.AccountRoleType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 샘플 응답 DTO
 *
 * @author LEESEMIN
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class AccountResponseDto extends CommonFilter {

	private Long id;
	private String name;
	private String email;
	private AccountRoleType accountRole;

}
