package com.excelautomation;

import com.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

        // ilk rowdaki ikinci cell e git ve yazdır
        //1. yol
 //       Row row=sheet.getRow(1);
 //       Cell cell21=row2.g

        //2. yol
        Cell row1sell2= sheet.getRow(4).getCell(1);
        System.out.println(row1sell2);

//        2nd row'daki ilk cell'e git ve datanin ABD'ye esit oldugunu assert e
        Cell row2Cell1 = sheet.getRow(1).getCell(0);
        System.out.println("data ABD olmali: "+row2Cell1);

        boolean esitMi=row2Cell1.toString().equals("ABD");

        Assert.assertTrue(esitMi);

//        3rd row'daki 2nd cell-chain the row and cell
        Cell row3Cell2= sheet.getRow(2).getCell(1);
        System.out.println(row3Cell2);

//  row sayisini bul
        int rowSayisi= sheet.getLastRowNum()+1;
        System.out.println(rowSayisi);

    //Kullanilan row sayisini bul
        int kullanilanRowSayisi= sheet.getPhysicalNumberOfRows();
        System.out.println(kullanilanRowSayisi);

    //Ulke ve baskent key-value ciftlerini map object olarak yazdir
    Map<String,String> dunyaBaskentleri=new HashMap<>();

    int ulkeColumn=0;
    int baskentColumn=1;
    /*
    row numarası 1'den baslar, cunku header 0. indextedir
    En sondaki row'un indeksi: lastRowNumber yada getLastRowNum()+1 ;

    ABD: sheet.getRow(1).getCell(0);
    Fransa:sheet.getRow(2).getCell(0);
    .......
     */
        for(int rowNumarasi=1; rowNumarasi<rowSayisi; rowNumarasi++){
            String ulke= sheet.getRow(rowNumarasi).getCell(ulkeColumn).toString();
            String baskent= sheet.getRow(rowNumarasi).getCell(baskentColumn).toString();

            System.out.println("Ulke: "+ulke);
            System.out.println("Baskent: "+baskent);

            dunyaBaskentleri.put(ulke,baskent);// Map e ulke ve baskent eklemis olduk
        }
        System.out.println(dunyaBaskentleri);
}
@Test
    public void excelUtilDemo(){
    String path="./src/test/java/resources/Baskent.xlsx";
    String sheetName="Sayfa1";

    // excelUtil class okumak için önce bir nesne olusturduk
    ExcelUtil excelUtil=new ExcelUtil(path,sheetName);
    // ExcelUtil deki methodları cağırabiliriz

    System.out.println(excelUtil.getDataList());

    System.out.println(excelUtil.columnCount());

    System.out.println(excelUtil.rowCount());

    System.out.println(excelUtil.getCellData(5,1));

    System.out.println(excelUtil.getColumnsNames());
}
}
