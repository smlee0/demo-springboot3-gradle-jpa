package com.example.module.sample.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.entity.Sample;
import com.example.module.sample.dto.SampleDto;
import com.example.module.sample.dto.request.SampleRequestDto;
import com.example.module.sample.dto.response.SampleResponseDto;

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
	Sample toInsertEntity(SampleDto.InsertRequestDto requestDto);

	/**
	 * 샘플 등록 DTO 변환
	 *
	 * @param sample
	 * @return
	 */
	SampleDto.InsertResponseDto toInsertDto(Sample sample);
}
