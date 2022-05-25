package com.varun.mycv.csv;

import java.io.FileInputStream;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.opencsv.CSVReader;
import com.varun.mycv.entity.CsvEntity;
import com.varun.mycv.entity.ReferralPreviewType;
import com.varun.mycv.entity.ReferralType;
import com.varun.mycv.entity.UpdateUserReferralRequest;

public class ReadFile {

	public List<UpdateUserReferralRequest> getJobsList(JobPortal jobPortal, String location) throws Exception {

		switch (jobPortal) {
		case JobServe:
			return readJobServeCsvFile(location);
		case WorkingStartup:
			return readWorkingStartupCsvFile(location);
		}

		return null;

	}

	public List<UpdateUserReferralRequest> readJobServeCsvFile(String location) throws Exception {

		CSVReader reader = new CSVReader(new FileReader(location));
		String[] nextLine;

		UpdateUserReferralRequest reqEntity = new UpdateUserReferralRequest();

		List<UpdateUserReferralRequest> list = new ArrayList<UpdateUserReferralRequest>();

		reader.readNext();

		while ((nextLine = reader.readNext()) != null) {

			reqEntity = new UpdateUserReferralRequest();

			reqEntity.setReferralType(ReferralType.JOB_SPEC);
			reqEntity.setReferralTargetEmail("randeep@mycvtracker.com");

			// description
			String desc[] = nextLine[12].split("<img src=");
			reqEntity.setReferralDetails(desc[0]);

			// title
			reqEntity.setReferralTargetSubject(nextLine[4]);

			reqEntity.setJobType(nextLine[11]);

			reqEntity.setJobLocation(nextLine[8]);

			reqEntity.setPreviewType(ReferralPreviewType.NONE);
			// reqEntity.setPreviewLink("");

			if (nextLine[9] != null) {

				reqEntity.setJobCompany(nextLine[9]);

				reqEntity.setReferralTargetSubject(nextLine[4] + " at " + nextLine[9]);
			}

			reqEntity.setRefPublic(false);
			reqEntity.setBountyEnable(false);

			list.add(reqEntity);

		}

		return list;

	}

	// read Csv File
	public List<UpdateUserReferralRequest> readWorkingStartupCsvFile(String location) throws Exception {

		CSVReader reader = new CSVReader(
				new FileReader(location));
		String[] nextLine;

		UpdateUserReferralRequest reqEntity = new UpdateUserReferralRequest();

		List<UpdateUserReferralRequest> list = new ArrayList<UpdateUserReferralRequest>();

		reader.readNext();

		while ((nextLine = reader.readNext()) != null) {

			reqEntity = new UpdateUserReferralRequest();

			reqEntity.setReferralType(ReferralType.JOB_SPEC);
			reqEntity.setReferralTargetEmail("randeep@mycvtracker.com");

			// description
			reqEntity.setReferralDetails(nextLine[9]);

			// title
			reqEntity.setReferralTargetSubject(nextLine[6]);

			reqEntity.setJobType(nextLine[8]);

			reqEntity.setJobLocation(nextLine[7]);

			reqEntity.setPreviewType(ReferralPreviewType.WEB_PAGE_URL);
			reqEntity.setPreviewLink(nextLine[11]);

			reqEntity.setJobCompany(nextLine[10]);

			reqEntity.setRefPublic(true);
			reqEntity.setBountyEnable(false);

			list.add(reqEntity);

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

				csv.setReferralDetails(currentRow.getCell(8).toString());

				csv.setReferralTargetSubject(currentRow.getCell(4).toString());

				csv.setJobType(currentRow.getCell(7).toString());

				csv.setJobLocation(currentRow.getCell(6).toString());

				csv.setJobCompany(currentRow.getCell(9).toString());

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
