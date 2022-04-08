package com.varun.mycv.controller;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;

import com.opencsv.CSVReader;
import com.varun.mycv.entity.CsvEntity;

public class ReadFile {

	// read Csv File
	public List<CsvEntity> readCsvFile() throws Exception {

		CSVReader reader = new CSVReader(
				new FileReader("C:\\Users\\Varun Waiskar\\Desktop\\Spring Software Pvt\\jobs-sitemap3.csv"));
		String[] nextLine;

		CsvEntity csv = new CsvEntity();
		List<CsvEntity> list = new ArrayList<CsvEntity>();

		reader.readNext();

		while ((nextLine = reader.readNext()) != null) {

			csv = new CsvEntity();

			csv.setJobTitle(nextLine[4]);

			csv.setJobType(nextLine[7]);

			csv.setJobLocation(nextLine[6]);

			csv.setReferralDetails(nextLine[8]);

			csv.setJobCompany(nextLine[9]);

			csv.setPreviewLink(nextLine[5]);

			list.add(csv);

			// nextLine[] is an array of values from the line
			System.out.println(csv);
		}

		return list;

	}

	// read Excel File
	public List<CsvEntity> readExcelFile(String file) {

		String excelFilePath = "C:\\Users\\Varun Waiskar\\Desktop\\Spring Software Pvt\\jobs-sitemap3.xlsx";
		CsvEntity csv = new CsvEntity();
		List<CsvEntity> list = new ArrayList<CsvEntity>();

		FileInputStream inputStream;

		try {
			inputStream = new FileInputStream(excelFilePath);
			Workbook workbook = new XSSFWorkbook(inputStream);
			Sheet firstSheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = firstSheet.iterator();
			rowIterator.next();

			while (rowIterator.hasNext()) {
				Row currentRow = rowIterator.next();

				csv = new CsvEntity();

				csv.setJobTitle(currentRow.getCell(4).toString());

				csv.setJobType(currentRow.getCell(7).toString());

				csv.setJobLocation(currentRow.getCell(6).toString());

				csv.setReferralDetails(currentRow.getCell(8).toString());

				csv.setJobCompany(currentRow.getCell(9).toString());

				csv.setPreviewLink(currentRow.getCell(5).toString());

				list.add(csv);

			}

			workbook.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(">> error in csv read");
			e.printStackTrace();
		}

		return list;

	}

}
