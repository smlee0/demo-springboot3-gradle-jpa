package com.example.module.api.v1.sample.dto;

/**
 * 샘플 Sealed DTO
 * TODO Sealed Permit + Record를 활용해서 DTO를 만들 경우 발생하는 문제점 (해당 이유로 class 타입으로 사용 예정)
 * TODO 1. Setter 없음(불변성 한계): Record는 불변이므로 동적으로 필드 변경이 필요한 상황에 대응 불가능
 * TODO 2. 상속 제한: Record는 final로 선언됨. 공통으로 사용되는 필드값을 빼둘 수 없음 (중복 데이터 증가)
 *
 * @author LEESEMIN
 */
// public sealed interface SampleDto permits SelectRequestDto, SelectResponseDto, InsertRequestDto, InsertResponseDto {
// 	/**
// 	 * 샘플 목록 요청 DTO
// 	 * @param id
// 	 * @param name
// 	 * @param title
// 	 * @param contents
// 	 * @param files
// 	 */
// 	record SelectRequestDto(
// 		Long id,
// 		@NotBlank(message = "이름을 입력해 주세요.")
// 		String name,
// 		@NotBlank(message = "제목을 입력해 주세요.")
// 		String title,
// 		@NotBlank(message = "내용을 입력해 주세요.")
// 		String contents,
// 		List<MultipartFile> files
// 	) implements SampleDto {
// 		// 전달받은 인자값 활용 가능 (생성자 자동 선언)
// 	}
//
// 	/**
// 	 * 샘플 목록 응답 DTO
// 	 * @param id
// 	 * @param name
// 	 * @param title
// 	 * @param contents
// 	 * @param thumbImgUploadPath
// 	 * @param thumbImgOriginName
// 	 */
// 	record SelectResponseDto(
// 		Long id,
// 		String name,
// 		String title,
// 		String contents,
// 		String thumbImgUploadPath,
// 		String thumbImgOriginName
// 	) implements SampleDto {
// 	}
//
// 	/**
// 	 * 샘플 등록 요청 DTO
// 	 * @param id
// 	 * @param name
// 	 * @param title
// 	 * @param contents
// 	 * @param files
// 	 */
// 	record InsertRequestDto(
// 		Long id,
// 		@NotBlank(message = "이름을 입력해 주세요.!@#$")
// 		String name,
// 		@NotBlank(message = "제목을 입력해 주세요.")
// 		String title,
// 		@NotBlank(message = "내용을 입력해 주세요.")
// 		String contents,
// 		List<MultipartFile> files
// 	) implements SampleDto {
// 	}
//
// 	/**
// 	 * 샘플 등록 응답 DTO
// 	 * @param id
// 	 * @param name
// 	 * @param title
// 	 * @param contents
// 	 * @param thumbImgUploadPath
// 	 * @param thumbImgOriginName
// 	 */
// 	record InsertResponseDto(
// 		Long id,
// 		String name,
// 		String title,
// 		String contents,
// 		String thumbImgUploadPath,
// 		String thumbImgOriginName
// 	) implements SampleDto {
// 	}
// }