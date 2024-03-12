package com.example.module.sample.dto.response;

import com.example.library.common.CommonFilter;

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
public class SampleInsertResponseDto extends CommonFilter {

	private Long id;

	private String name;

	private String title;

	private String contents;

	private String thumbImgUploadPath;
	
	private String thumbImgOriginName;

}
