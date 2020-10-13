package com.mcm.api.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.mcm.api.dto.request.GetAttachmentsRequestDto;
import com.mcm.api.dto.request.SaveAttachmentRequestDto;
import com.mcm.api.dto.response.ErrorResponseDto;
import com.mcm.api.dto.response.GetAttachmentsResponseDto;
import com.mcm.api.dto.response.SuccessResponseDto;
import com.mcm.api.entity.Attachment;
import com.mcm.api.entity.Cases;
import com.mcm.api.repository.AttachmentRepository;
import com.mcm.api.repository.CaseRepository;

@RestController
public class AttachmentController {

	@Autowired
	AttachmentRepository attachmentRepository;
	
	@Autowired
	CaseRepository caseRepository;

	@GetMapping("/attachmentList")
	public ResponseEntity getAttachments(@RequestBody GetAttachmentsRequestDto req){
		List<Attachment> attachments = attachmentRepository.findAllByCaseid(req.getCaseid());
		List<GetAttachmentsResponseDto> response = attachments.stream().map(GetAttachmentsResponseDto::new).collect(Collectors.toList());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(path = "/attachment", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
	@Transactional
	public ResponseEntity getAttachments(@RequestBody SaveAttachmentRequestDto req){

		MultipartFile file = req.getFileToUpload();
		byte[] bytes;
		try {
			bytes = file.getBytes();

			Path path = Paths.get(file.getOriginalFilename());
			Files.write(path, bytes);
			Attachment attachment = new Attachment();
			attachment.setCaseid(req.getCaseid());
			attachment.setFilen(file.getOriginalFilename());
			attachment.setTimestmp(String.valueOf(System.currentTimeMillis()));
			attachment.setDbfilename(String.valueOf(System.currentTimeMillis())+".pdf");
			attachment.setTeamid(req.getTeamid());
			attachmentRepository.save(attachment);
			Optional<Cases> case_ = caseRepository.findById(req.getCaseid());
			if(case_.isPresent()) {
				Cases c = case_.get();
				c.setDateupdate(new BigDecimal(System.currentTimeMillis()));
				caseRepository.save(c);
			}
		} catch (IOException e) {
			return new ResponseEntity<>(new ErrorResponseDto("attachment not inserted"), HttpStatus.OK);
		}

		return new ResponseEntity<>(new SuccessResponseDto("success"), HttpStatus.OK);
	}
}
