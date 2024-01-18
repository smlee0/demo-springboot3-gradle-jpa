package com.example.module.sample.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.library.annotation.RunBodyValidator;
import com.example.module.sample.controller.validator.InsertSampleValidator;
import com.example.module.sample.dto.request.SampleRequestDto;
import com.example.module.sample.dto.response.SampleResponseDto;
import com.example.module.sample.service.SampleService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 샘플 컨트롤러
 *
 * @author LEESEMIN
 */
@Slf4j
@RequiredArgsConstructor
@RestController
public class SampleController {
	/**
	 * 샘플 서비스
	 */
	private final SampleService sampleService;

	/**
	 * 샘플 목록 호출
	 *
	 * @return
	 */
	@GetMapping("/api/v1/sample")
	public ResponseEntity<?> list(SampleRequestDto requestDto) {
		List<SampleResponseDto> sampleList = sampleService.selectSampleList(requestDto);
		return ResponseEntity.ok().body(sampleList);
	}

	/**
	 * 샘플 등록 액션
	 *
	 * @return
	 */
	@PostMapping("/api/v1/sample")
	@RunBodyValidator(InsertSampleValidator.class)
	public ResponseEntity<?> insert(@Validated SampleRequestDto requestDto) {
		sampleService.insertSample(requestDto);

		return ResponseEntity.ok().build();
	}

	/**
	 * 샘플 수정 액션
	 *
	 * @return
	 */
	@PutMapping("/api/v1/sample")
	public ResponseEntity<?> update(SampleRequestDto requestDto) {
		sampleService.updateSample(requestDto);

		return ResponseEntity.ok().build();
	}

	/**
	 * 샘플 삭제 액션
	 *
	 * @return
	 */
	@DeleteMapping("/api/v1/sample")
	public ResponseEntity<?> delete(SampleRequestDto requestDto) {
		sampleService.deleteSample(requestDto);

		return ResponseEntity.ok().build();
	}
}
