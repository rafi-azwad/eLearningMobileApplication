package Core;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class ReadFromXL {

    public static String ReadData(int k) {
        HashMap<Integer, String>  Values = new HashMap<Integer, String>();
        int p=0;
        try {
            String path = System.getProperty("user.dir");
            String xlFile = path + "\\src\\test\\resources\\File\\eLearning.xlsx";
            File file = new File(xlFile);
            FileInputStream fis = new FileInputStream(file);
            XSSFWorkbook workbook = new XSSFWorkbook(fis);
            //XSSFSheet sheet = workbook.getSheetAt(0); //as index
            XSSFSheet sheet = workbook.getSheet("Sheet1");
            int rowCount = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rowCount; i++) {
                XSSFRow row = sheet.getRow(i);

                int cellCount = row.getPhysicalNumberOfCells();
                for (int j = 0; j < cellCount; j++) {
                    XSSFCell cell = row.getCell(j);
                    //String cellValues= getCellValue(cell);
                    String cellValues = cell.getStringCellValue();
                    Values.put(p, cellValues);
                    //System.out.println(Values.get(p));
                    p++;
                }
                System.out.println();

            }

            fis.close();
        }
        catch (Exception e){
            System.out.println(e);
        }
        return  Values.get(k);
    }
}



