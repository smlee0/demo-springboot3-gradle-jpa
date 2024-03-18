package com.example.module.api.v1.account.dto.response;

import com.example.library.common.CommonFilter;
import com.example.library.constant.AccountRoleType;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 계정 응답 DTO
 *
 * @author LEESEMIN
 */
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class AccountResponseDto extends CommonFilter {

	private Long id;
	private String username;
	private String nickname;
	private String email;
	private String phone;
	private String thumbImgUploadPath;
	private String thumbImgOriginName;
	private AccountRoleType accountRole;

}
