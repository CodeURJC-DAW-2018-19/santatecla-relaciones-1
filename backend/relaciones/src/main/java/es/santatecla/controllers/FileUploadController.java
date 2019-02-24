package es.santatecla.controllers;


import es.santatecla.models.Record;
import es.santatecla.services.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class FileUploadController {

    @Autowired
    RecordService recordService;


    @PostMapping("/savedRecord")
    public String saveConcept(Model model, Record record, @RequestParam("file")MultipartFile multipartFile, RedirectAttributes redirectAttributes) {
        if(!multipartFile.isEmpty()){
            Path derectorioRecursos = Paths.get("src//main//resources//static//uploads");
            String rootPath = derectorioRecursos.toFile().getAbsolutePath();
            try {
                byte[] bytes = multipartFile.getBytes();
                Path rutaCompleta = Paths.get(rootPath + "//" + multipartFile.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                redirectAttributes.addFlashAttribute("Información", "Imagen subida correctamente ' " + multipartFile.getOriginalFilename() + "'");
                record.setImage(multipartFile.getOriginalFilename());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        recordService.addRecord(record);
        return "redirect:/index";
    }

}