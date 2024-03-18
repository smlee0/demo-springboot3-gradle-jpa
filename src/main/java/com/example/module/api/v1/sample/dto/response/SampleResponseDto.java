package com.example.module.api.v1.sample.dto.response;

import com.example.library.common.dto.filter.CommonFilter;

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
public class SampleResponseDto extends CommonFilter {

	private Long id;

	private String name;

	private String title;

	private String contents;

	private String thumbImgUploadPath;

	private String thumbImgOriginName;

}
