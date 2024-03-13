package com.example.module.api.v1.account.dto.request;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * 샘플 요청 DTO
 *
 * @author LEESEMIN
 */
@Getter
@Setter
@Builder
public class AccountRequestDto {

	private Long id;
	@NotBlank(message = "이름을 입력해 주세요.")
	private String name;
	@NotBlank(message = "제목을 입력해 주세요.")
	private String title;
	@NotBlank(message = "내용을 입력해 주세요.")
	private String contents;
	private List<MultipartFile> files;

}
