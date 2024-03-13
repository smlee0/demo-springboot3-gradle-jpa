package com.example.module.api.v1.sample.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.entity.Sample;
import com.example.module.api.v1.sample.dto.request.SampleInsertRequestDto;
import com.example.module.api.v1.sample.dto.request.SampleRequestDto;
import com.example.module.api.v1.sample.dto.response.SampleInsertResponseDto;
import com.example.module.api.v1.sample.dto.response.SampleResponseDto;

/**
 * 샘플 맵퍼 (mapstruct)
 *
 * @author LEESEMIN
 */
@Mapper
public interface SampleMapper {
	SampleMapper INSTANCE = Mappers.getMapper(SampleMapper.class);

	/**
	 * SampleRequestDto -> Sample 변환
	 *
	 * @param requestDto
	 * @return
	 */
	// @Mapping(target = "thumbImgUploadPath", ignore = true)
	// @Mapping(target = "thumbImgOriginName", ignore = true)
	Sample toEntity(SampleRequestDto requestDto);

	/**
	 * Sample -> SampleResponseDto 변환
	 *
	 * @param sample
	 * @return
	 */
	SampleResponseDto toDto(Sample sample);

	/**
	 * List<Sample> -> List<SampleResponseDto> 변환
	 *
	 * @param sampleList
	 * @return
	 */
	List<SampleResponseDto> toList(List<Sample> sampleList);

	/**
	 * 샘플 등록 엔티티 변환
	 *
	 * @param requestDto
	 * @return
	 */
	Sample toInsertEntity(SampleInsertRequestDto requestDto);

	/**
	 * 샘플 등록 DTO 변환
	 *
	 * @param sample
	 * @return
	 */
	SampleInsertResponseDto toInsertDto(Sample sample);
}
