package com.sky.test;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 使用POI操作Excel文件
 */
public class POITest {

    /**
     * 通过POI创建Excel文件并写入文件内容
     */
    public static void write() throws Exception {
        // 在内存中创建一个Excel文件
        XSSFWorkbook excel = new XSSFWorkbook();
        // 创建一个sheet页
        XSSFSheet sheet = excel.createSheet("info");
        // 创建行对象，从0开始
        XSSFRow row = sheet.createRow(0);
        // 创建单元格并写入文件内容
        row.createCell(1).setCellValue("姓名");
        row.createCell(2).setCellValue("年龄");

        // 创建一个新行
        row = sheet.createRow(1);
        row.createCell(1).setCellValue("张三");
        row.createCell(2).setCellValue("20");

        row = sheet.createRow(2);
        row.createCell(1).setCellValue("李四");
        row.createCell(2).setCellValue("21");

        // 通过输出流将内存中的Excel文件写入磁盘
        FileOutputStream out = new FileOutputStream(new File("/Users/xinjiang/Desktop/itheima/SkyProject/materials/day12/info.xlsx"));
        excel.write(out);

        // 关闭资源
        out.close();
        excel.close();
    }

    /**
     * 通过POI读取Excel文件内容
     *
     * @throws Exception
     */
    public static void read() throws Exception {
        // 读取已存在的Excel文件，用到了FileInputStream
        FileInputStream in = new FileInputStream(new File("/Users/xinjiang/Desktop/itheima/SkyProject/materials/day12/info.xlsx"));
        XSSFWorkbook excel = new XSSFWorkbook(in);

        // 读取Excel中的第一个sheet页
        XSSFSheet sheet = excel.getSheetAt(0);

        // 获取sheet页中最后一行有文字的行号
        int lastRowNum = sheet.getLastRowNum();

        for (int i = 0; i <= lastRowNum; i++) {
            // 获取行对象
            XSSFRow row = sheet.getRow(i);
            String cellValue1 = row.getCell(1).getStringCellValue();
            String cellValue2 = row.getCell(2).getStringCellValue();

            System.out.println(cellValue1 + " " + cellValue2);
        }

        in.close();
        excel.close();
    }

    public static void main(String[] args) throws Exception {
        // write();
        read();
    }
}
