package com.example.module.sample.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.entity.Sample;
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
}
