package com.example.module.sample.service;

import java.util.List;

import com.example.module.sample.dto.request.SampleRequestDto;
import com.example.module.sample.dto.response.SampleResponseDto;

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
	void insertSample(SampleRequestDto requestDto);

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
