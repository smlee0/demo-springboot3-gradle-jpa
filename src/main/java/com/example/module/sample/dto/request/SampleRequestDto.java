package com.example.module.sample.dto.request;

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
public class SampleRequestDto {

	private Long id;
	@NotBlank(message = "샘플 명을 입력해 주세요.")
	private String name;
	@NotBlank(message = "샘플 코드를 입력해 주세요.")
	private String code;
	private List<MultipartFile> files;

}
