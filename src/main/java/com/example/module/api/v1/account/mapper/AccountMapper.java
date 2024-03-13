package com.example.module.api.v1.account.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.entity.Account;
import com.example.module.api.v1.account.dto.request.AccountRequestDto;
import com.example.module.api.v1.account.dto.response.AccountResponseDto;

/**
 * 계정 맵퍼 (mapstruct)
 *
 * @author LEESEMIN
 */
@Mapper
public interface AccountMapper {
	AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

	/**
	 * AccountRequestDto -> Account 변환
	 *
	 * @param requestDto
	 * @return
	 */
	// @Mapping(target = "thumbImgUploadPath", ignore = true)
	// @Mapping(target = "thumbImgOriginName", ignore = true)
	Account toEntity(AccountRequestDto requestDto);

	/**
	 * Account -> AccountResponseDto 변환
	 *
	 * @param account
	 * @return
	 */
	AccountResponseDto toDto(Account account);

}
