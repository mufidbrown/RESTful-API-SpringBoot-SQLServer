package proyekmagang.restfullapi.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

public class ExcelUploadService {

    public static boolean isValidExcelFile(MultipartFile file){
        return Objects.equals(file.getContentType(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

    }
}
