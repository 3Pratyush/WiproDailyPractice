package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    public static Object[][] getExcelData(String path) throws Exception {

        FileInputStream fis = new FileInputStream(path);

        Workbook wb = new XSSFWorkbook(fis);

        Sheet sheet = wb.getSheetAt(0);

        int rows = sheet.getPhysicalNumberOfRows();
        int cols = sheet.getRow(0).getPhysicalNumberOfCells();

        Object[][] data = new Object[rows - 1][cols];

        for (int i = 1; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                data[i - 1][j] =
                        sheet.getRow(i).getCell(j).toString();
            }
        }

        wb.close();

        return data;
    }
}