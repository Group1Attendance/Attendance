package com.groupone.attendance.controller;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.groupone.attendance.service.impl.AttendanceServiceImpl;

public class AttendanceController {
	@Autowired
	private AttendanceServiceImpl attendanceServiceImpl;

	@GetMapping("/")
	public String sayHello() {
		return " Hi.. Welcome";
	}

	@PostMapping("/upload")
	public ResponseEntity<List<List<String>>> uploadExcel(@RequestParam("file") MultipartFile file)
			throws EncryptedDocumentException, IOException {
		
		attendanceServiceImpl.save(file);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
