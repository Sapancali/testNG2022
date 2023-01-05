package com.excelautomation;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Day12_C12_ReadExcel {
/*
    Import the apache poi dependency in your pom file
    resources package olustur > java altinda acilmali (java'ya sag tikla ve dosyayi olustur)
    Add the excel file on the resources folder
    Yeni package olustur: excelautomation
    Yeni class olustur : ReadExcel
    test method olustur: readExcel()
    Dosyanin adresini String olarak bir konteynira koy
    dosyayi ac
    fileinputstream kullanarak workbook'u ac
    ilk worksheet'i ac
    ilk row'a git
    ilk row'daki ilk cell'e git ve yazdir
    ilk row'daki ikinci cell'e git ve yazdir
    2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert e
    3rd row'daki 2nd cell-chain the row and cell
    row sayisini bul
    Kullanilan row sayisini bul
    Ulke ve baskent key-value ciftlerini map object olarak yazdir
    */
    @Test
    public void readExcel() throws IOException {
//Dosyanin adresini String olarak bir konteynira koy

    String path="./src/test/java/resources/Baskent.xlsx";

  //  dosyayı aç

        FileInputStream fileInputStream=new FileInputStream(path);
        //fileinputstream kullanarak workbook'u ac

        Workbook workbook= WorkbookFactory.create(fileInputStream);

        // ilk sheet i aç
        Sheet sheet= workbook.getSheetAt(0); // sheet sayfaları "0" indeksten başlar

        // ilk row a git
        Row ilkRow=sheet.getRow(0);  // row lar index 0 dan başlar

        // ilk row'daki ilk cell'e git ve yazdir
        Cell ilkCell= ilkRow.getCell(0); // cell index 0 dan başlar
        System.out.println(ilkCell);





}
}
