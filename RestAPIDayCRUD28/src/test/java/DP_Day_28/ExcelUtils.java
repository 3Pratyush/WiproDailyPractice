package DP_Day_28;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils
{
    public static String[][] getExcelData() throws IOException
    {
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/TestData.xlsx");

        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        Sheet sheet = workbook.getSheet("Sheet1");

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getLastCellNum();

        String data[][] = new String[rows - 1][cols];

        DataFormatter formatter = new DataFormatter();

        for (int i = 1; i < rows; i++)
        {
            Row row = sheet.getRow(i);

            for (int j = 0; j < cols; j++)
            {
                data[i - 1][j] = formatter.formatCellValue(row.getCell(j));
            }
        }

        workbook.close();
        fis.close();

        return data;
    }
}