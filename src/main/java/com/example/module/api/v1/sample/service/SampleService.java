package com.example.module.api.v1.sample.service;

import java.util.List;

import com.example.module.api.v1.sample.dto.request.SampleInsertRequestDto;
import com.example.module.api.v1.sample.dto.request.SampleRequestDto;
import com.example.module.api.v1.sample.dto.response.SampleInsertResponseDto;
import com.example.module.api.v1.sample.dto.response.SampleResponseDto;

/**
 * 샘플 서비스
 *
 * @author LEESEMIN
 */
public interface SampleService {

	/**
	 * 샘플 목록 호출
	 *
	 * @param requestDto
	 * @return
	 */
	List<SampleResponseDto> selectSampleList(SampleRequestDto requestDto);

	/**
	 * 샘플 등록
	 *
	 * @param requestDto
	 * @return
	 */
	SampleInsertResponseDto insertSample(SampleInsertRequestDto requestDto);

	/**
	 * 샘플 수정
	 *
	 * @param requestDto
	 * @return
	 */
	void updateSample(SampleRequestDto requestDto);

	/**
	 * 샘플 삭제
	 *
	 * @param requestDto
	 * @return
	 */
	void deleteSample(SampleRequestDto requestDto);
}
