package com.corporate.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Excel {

    private static XSSFWorkbook libro;
    private static FileInputStream file;

    public static String leerDatosExcel (String ruta, String hoja, int rowValue, int cellValue) throws IOException {
        String valor = null;
        file= new FileInputStream(new File(ruta));
        libro=new XSSFWorkbook(file);
        Sheet sheet = libro.getSheet(hoja);
        Row row = sheet.getRow(rowValue);
        Cell cell = row.getCell(cellValue);
        valor=cell.getStringCellValue();
        libro.close();
        file.close();
        return valor;

    }

    public static int CantidadExcel (String ruta, String hoja) throws IOException {
        file= new FileInputStream(new File(ruta));
        libro=new XSSFWorkbook(file);
        Sheet sheet = libro.getSheet(hoja);
        int cant=0;
        while(sheet.getRow(cant)!=null) {cant++;}
        return cant;
    }
}