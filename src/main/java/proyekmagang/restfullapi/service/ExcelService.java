package proyekmagang.restfullapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import proyekmagang.restfullapi.entity.Excel;
import proyekmagang.restfullapi.repository.ExcelRepository;
import proyekmagang.restfullapi.service.user.ExcelUploadService;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ExcelService {

    private ExcelRepository excelRepository;


    //    untuk upload excel
    public void saveExcelsToDatabase(MultipartFile file){
        if (ExcelUploadService.isValidExcelFile(file)){
            try {
                List<Excel> excels = ExcelUploadService.getExcelsDataFromExcel(file.getInputStream());
                this.excelRepository.saveAll(excels);
            } catch (IOException e) {
                throw new IllegalArgumentException("The file is not a valid excel file");
            }
        }
    }

    public List<Excel> getExcels(){
        return excelRepository.findAll();
    }
    //    end upload excel
}
