package com.groupone.attendance.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.groupone.attendance.entity.Attendance;
import com.groupone.attendance.repository.AttendanceRepository;

@Service
public class AttendanceServiceImpl 
{
	@Autowired
	AttendanceRepository attendanceRepository;
	
	public void save(MultipartFile file) throws EncryptedDocumentException, IOException 
	{
		List<List<String>> rows = new ArrayList<>();

		Workbook workbook = WorkbookFactory.create(file.getInputStream());
		Sheet sheet = workbook.getSheetAt(1);
		// Iterator<Row> rowIterator = sheet.iterator();
		rows = StreamSupport.stream(sheet.spliterator(), false)
				.map(row -> StreamSupport
				.stream(row.spliterator(), false)
				.map(this::getCellStringValue)
				.collect(Collectors.toList()))
				.collect(Collectors.toList());
		System.out.println("rows :: " + rows);
		// Save data to the database
		List<Attendance> excelDataList = rows.stream().map(row -> {
			Attendance excelData = new Attendance();
			excelData.setName(row.get(0));
			excelData.setFirstJoin(row.get(1));
			excelData.setLastLeave(row.get(2));
			excelData.setInMeetingDuration(row.get(3));
			excelData.setEmail(row.get(4));
			excelData.setParticipantId(row.get(5));
			excelData.setRole(row.get(6));
			return excelData;
		}).collect(Collectors.toList());
		attendanceRepository.saveAll(excelDataList);
	}
	private String getCellStringValue(Cell cell) {
		CellType cellType = cell.getCellType();

		if (cellType == CellType.STRING) {
			return cell.getStringCellValue();
		} else if (cellType == CellType.NUMERIC) {
			return String.valueOf(cell.getNumericCellValue());
		} else if (cellType == CellType.BOOLEAN) {
			return String.valueOf(cell.getBooleanCellValue());
		}

		return null;
	}
}
