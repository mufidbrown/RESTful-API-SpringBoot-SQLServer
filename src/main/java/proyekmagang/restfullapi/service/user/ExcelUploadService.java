package proyekmagang.restfullapi.service.user;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;
import proyekmagang.restfullapi.entity.Excel;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelUploadService {

    public static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    }

    public static List<Excel> getExcelsDataFromExcel(InputStream inputStream){
        List<Excel> excels = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheet("excels");

            int rowIndex =0;
            for (Row row : sheet){
                if (rowIndex ==0){
                    rowIndex++;
                    continue;
                }
                Iterator<Cell> cellIterator = row.iterator();
                int cellIndex = 0;
                Excel excel = new Excel();
                while (cellIterator.hasNext()){
                    Cell cell = cellIterator.next();
                    switch (cellIndex){
                        case 0 -> excel.setProductId((int) cell.getNumericCellValue());
                        case 1 -> excel.setProductName(cell.getStringCellValue());
                        case 2 -> excel.setPrice((int)cell.getNumericCellValue());
                        case 3 -> excel.setQuantity((int)cell.getNumericCellValue());
                        case 4 -> excel.setDescription(cell.getStringCellValue());
                        default -> {

                        }
                    }
                    cellIndex++;
                }
                excels.add(excel);
            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return excels;
    }

}
