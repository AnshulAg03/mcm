package com.mcm.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mcm.api.dto.request.GetAttachmentsRequestDto;
import com.mcm.api.dto.response.GetAttachmentsResponseDto;
import com.mcm.api.entity.Attachment;
import com.mcm.api.repository.AttachmentRepository;

@RestController
public class AttachmentController {
	
	@Autowired
	AttachmentRepository attachmentRepository;

	@GetMapping("/attachmentList")
	public ResponseEntity getAttachments(@RequestBody GetAttachmentsRequestDto req){
		List<Attachment> attachments = attachmentRepository.findAllByCaseid(req.getCaseid());
		List<GetAttachmentsResponseDto> response = attachments.stream().map(GetAttachmentsResponseDto::new).collect(Collectors.toList());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}
