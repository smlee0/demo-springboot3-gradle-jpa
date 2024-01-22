package com.example.module.sample.dto;

import static com.example.module.sample.dto.SampleDto.*;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;

/**
 * 샘플 Sealed DTO
 *
 * @author LEESEMIN
 */
public sealed interface SampleDto permits InsertRequestDto, InsertResponseDto {
	/**
	 * 샘플 등록 요청 DTO
	 * @param id
	 * @param name
	 * @param title
	 * @param contents
	 * @param files
	 */
	record InsertRequestDto(
		Long id,
		@NotBlank(message = "이름을 입력해 주세요.!@#$")
		String name,
		@NotBlank(message = "제목을 입력해 주세요.")
		String title,
		@NotBlank(message = "내용을 입력해 주세요.")
		String contents,
		List<MultipartFile> files
	) implements SampleDto {
	}

	record InsertResponseDto(
		Long id,
		String name,
		String title,
		String contents,
		String thumbImgUploadPath,
		String thumbImgOriginName
	) implements SampleDto {
	}
}