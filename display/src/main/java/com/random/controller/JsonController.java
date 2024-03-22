package com.random.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.random.entity.ManualTable;
import com.random.repository.ManualTableRepository;
import com.random.service.ExcelService;

@RestController
@RequestMapping("/get")
public class JsonController {
	
	@Autowired
	ManualTableRepository manualTableRepository;

	@Autowired
    private ExcelService excelService;
	
	// creating the excel file report (22-03-2024)
	@GetMapping("/reportExcel")
    public ResponseEntity<byte[]> getDataFromPreviouslyExistedTable() throws IOException {
        List<ManualTable> listTable = manualTableRepository.findAll();

        ByteArrayInputStream in = excelService.manualTableToExcel(listTable);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=manual_table.xlsx");

        return ResponseEntity.ok().headers(headers).body(in.readAllBytes());
    }
}
