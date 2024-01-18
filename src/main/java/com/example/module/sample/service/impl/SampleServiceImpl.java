package com.example.module.sample.service.impl;

import java.util.List;

import com.example.library.annotation.TransactionalService;
import com.example.module.sample.dto.request.SampleRequestDto;
import com.example.module.sample.dto.response.SampleResponseDto;
import com.example.module.sample.mapper.SampleMapper;
import com.example.module.sample.repository.SampleRepository;
import com.example.module.sample.service.SampleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 샘플 서비스 구현부
 *
 * @author LEESEMIN
 */
@Slf4j
@RequiredArgsConstructor
@TransactionalService
public class SampleServiceImpl implements SampleService {

	/**
	 * 샘플 레포지토리
	 */
	private final SampleRepository sampleRepository;

	/**
	 * 샘플 목록 호출
	 *
	 * @param requestDto
	 * @return
	 */
	@Override
	public List<SampleResponseDto> selectSampleList(SampleRequestDto requestDto) {
		// .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
		return SampleMapper.INSTANCE.toList(sampleRepository.findAll());
	}

	/**
	 * 샘플 등록
	 *
	 * @param requestDto
	 * @return
	 */
	@Override
	public void insertSample(SampleRequestDto requestDto) {
		sampleRepository.save(SampleMapper.INSTANCE.toEntity(requestDto));
	}

	/**
	 * 샘플 수정
	 *
	 * @param requestDto
	 * @return
	 */
	@Override
	public void updateSample(SampleRequestDto requestDto) {
		sampleRepository.save(SampleMapper.INSTANCE.toEntity(requestDto));
	}

	/**
	 * 샘플 삭제
	 *
	 * @param requestDto
	 * @return
	 */
	@Override
	public void deleteSample(SampleRequestDto requestDto) {
		sampleRepository.delete(SampleMapper.INSTANCE.toEntity(requestDto));
	}
}
