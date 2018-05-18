package com.wlmiao.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.POIXMLException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.StringUtils;

public class XlsxUtil {

    public static XSSFWorkbook generateXlsFile(List<String> titleList, List<List<String>> valueList) {
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook();

        Sheet sheet = xssfWorkbook.createSheet();

        Integer rowIndex = 0;
        Integer colIndex = 1;

        if(CollectionUtils.isEmpty(titleList)){
            return xssfWorkbook;
        }

        Row row = sheet.createRow(rowIndex++);
        for(String title : titleList){
            row.createCell(0).setCellValue("id");
            row.createCell(colIndex++).setCellValue(title);
        }

        if(CollectionUtils.isEmpty(valueList)){
            return xssfWorkbook;
        }

        for(List<String> line : valueList){
            if(CollectionUtils.isEmpty(line)){
                continue;
            }

            row = sheet.createRow(rowIndex++);
            row.createCell(0).setCellValue(Integer.valueOf(rowIndex-1).toString());
            colIndex = 1;

            for(String value : line){
                row.createCell(colIndex++).setCellValue(value);
            }
        }

        return xssfWorkbook;
    }

    public static List<List<List<String>>> read(File file) throws IOException {
        if (!file.exists() || !file.isFile()) {
            return null;
        }

        Workbook workbook;
        try {
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(new FileInputStream(file));
            workbook = xssfWorkbook;
        } catch (POIXMLException e) {
            try {
                HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(file));
                workbook = hssfWorkbook;
            } catch (POIXMLException e1) {
                return null;
            }
        }

        List<List<List<String>>> response = new ArrayList<>();
        for (Integer sheetIndex = 0; sheetIndex < workbook.getNumberOfSheets(); sheetIndex++) {
            List<List<String>> sheetList = new ArrayList<>();
            Sheet sheet = workbook.getSheetAt(sheetIndex);
            if (sheet == null) {
                continue;
            }

            for (int rowNum = 0; rowNum <= sheet.getLastRowNum(); rowNum++) {
                List<String> rowStringList = new ArrayList<>();
                Row row = sheet.getRow(rowNum);
                if (row == null) {
                    continue;
                }
                for (int cellNum = 0; cellNum <= row.getLastCellNum(); cellNum++) {
                    Cell cell = row.getCell(cellNum);
                    if (cell == null) {
                        continue;
                    }
                    cell.setCellType(CellType.STRING);
                    String value = cell.getStringCellValue().trim();
                    if (!StringUtils.isEmpty(value)) {
                        rowStringList.add(value);
                    } else {
                        rowStringList.add("");
                    }
                }

                sheetList.add(rowStringList);
            }
            response.add(sheetList);
        }

        return response;
    }

    /**
     * 读取xlsx文件（兼容xls）
     * 以第一行作为title，生成hashmap
     */
    public static List<HashMap<String, String>> readFromXls(String filePath) throws Exception {

        List<HashMap<String, String>> response = new ArrayList<>();
        List<List<List<String>>> annoListFile = XlsxUtil.read(filePath);
        List<List<String>> annoSheet = annoListFile.get(0);

        List<String> title = annoSheet.get(0);

        for (Integer rowNumber = 1; rowNumber < annoSheet.size(); rowNumber++) {
            HashMap<String, String> map = new HashMap<>();
            List<String> row = annoSheet.get(rowNumber);
            for (Integer index = 0; index < title.size() && index < row.size(); index++) {
                map.put(title.get(index), row.get(index));
            }
            response.add(map);
        }

        return response;
    }


    public static List<List<List<String>>> read(String path) throws IOException {
        File file = new File(path);
        return read(file);
    }

}
