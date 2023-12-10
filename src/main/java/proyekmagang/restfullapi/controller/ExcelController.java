package proyekmagang.restfullapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import proyekmagang.restfullapi.entity.Excel;
import proyekmagang.restfullapi.service.ExcelService;

import java.util.List;
import java.util.Map;


@RestController
@AllArgsConstructor
@RequestMapping("excels")
public class ExcelController {

    private ExcelService excelService;

    //untuk import excel

    @PostMapping("/upload-excels-data")
    public ResponseEntity<?> uploadExcelsData(@RequestParam("file") MultipartFile file){
        this.excelService.saveExcelsToDatabase(file);
        return ResponseEntity
                .ok(Map.of("Message", "Excels data uploaded and save to database successfully"));
    }

    @GetMapping
    public ResponseEntity<List<Excel>> getExcels(){
        return new ResponseEntity<>(excelService.getExcels(), HttpStatus.FOUND);
    }

    //end import excel
}
