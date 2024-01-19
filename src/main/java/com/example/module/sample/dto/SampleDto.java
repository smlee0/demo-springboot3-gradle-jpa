// package com.example.module.sample.dto;
//
// import lombok.Builder;
//
// public sealed interface SampleDto permits CreateRequest, CreateResponse {
// 	@Builder
// 	record CreateRequest(
// 		String DTOtitle,
// 		String DTOcontent
// 	) implements SampleDto {
// 	}
//
// 	@Builder
// 	record CreateResponse(
// 		String DTOtitle,
// 		String DTOcontent
// 	) implements SampleDto {
// 	}
// }