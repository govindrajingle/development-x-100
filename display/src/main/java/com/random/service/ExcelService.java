package com.random.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import com.random.entity.GemReportDetails;
import com.random.entity.ManualTable;

@Service
public class ExcelService {
	
	public ByteArrayInputStream gemReportDetailsToExcel(List<GemReportDetails> listTable) throws IOException {
        String[] columns = {
            "sno", "branch", "reg_no", "validity", "current_status", "firm", "standard", "product_name", 
            "variety", "brand", "is_valid", "log_dt", "request_type", "application_id", "included_models", 
            "bis_id", "bis_sort_order", "license_no", "district_name", "state_name", "validity_date", 
            "scale", "license_grant_date", "reg_date", "str_status_code", "full_name_and_address", 
            "address", "city", "country"
        };

        try (
            Workbook workbook = new HSSFWorkbook();
            ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("gem_report_dtl");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Row for Header
            Row headerRow = sheet.createRow(0);

            // Header
            for (int col = 0; col < columns.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(columns[col]);
                cell.setCellStyle(headerCellStyle);
            }

            int rowIdx = 1;
            for (GemReportDetails details : listTable) {
                Row row = sheet.createRow(rowIdx++);

                // Set cell values based on the properties of GemReportDetails
                // For example:
                row.createCell(0).setCellValue(details.getSno());
                row.createCell(1).setCellValue(details.getBranch());
                row.createCell(2).setCellValue(details.getBranch());
                row.createCell(3).setCellValue(details.getBranch());
                row.createCell(4).setCellValue(details.getBranch());
                row.createCell(5).setCellValue(details.getBranch());
                row.createCell(6).setCellValue(details.getBranch());
                row.createCell(7).setCellValue(details.getBranch());
                row.createCell(8).setCellValue(details.getBranch());
                row.createCell(9).setCellValue(details.getBranch());
                // Continue for the rest of the properties...
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }

    public ByteArrayInputStream manualTableToExcel(List<ManualTable> manualTables) throws IOException {
        String[] columns = {"Sr No", "Test"};

        try (
                Workbook workbook = new HSSFWorkbook();  // Use HSSFWorkbook here
                ByteArrayOutputStream out = new ByteArrayOutputStream();
        ) {
            CreationHelper createHelper = workbook.getCreationHelper();

            Sheet sheet = workbook.createSheet("ManualTable");

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            headerFont.setColor(IndexedColors.BLUE.getIndex());

            CellStyle headerCellStyle = workbook.createCellStyle();
            headerCellStyle.setFont(headerFont);

            // Row for Header
            Row headerRow = sheet.createRow(0);

            // Header
            for (int col = 0; col < columns.length; col++) {
                Cell cell = headerRow.createCell(col);
                cell.setCellValue(columns[col]);
                cell.setCellStyle(headerCellStyle);
            }

            // CellStyle for Age
            CellStyle ageCellStyle = workbook.createCellStyle();
            ageCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("#"));

            int rowIdx = 1;
            for (ManualTable manualTable : manualTables) {
                Row row = sheet.createRow(rowIdx++);

                row.createCell(0).setCellValue(manualTable.getSr_no());
                row.createCell(1).setCellValue(manualTable.getTest());
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }
    }
}