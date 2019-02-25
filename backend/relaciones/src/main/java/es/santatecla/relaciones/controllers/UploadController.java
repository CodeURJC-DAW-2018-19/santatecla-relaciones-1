package es.santatecla.relaciones.controllers;

import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class UploadController {
    private String filename;
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://Users/Angel/Documents/GitHub/santatecla-relaciones-1/backend/relaciones/src/main/resources/static/images/";

    /*
     **File upload page
     */

    @GetMapping("/upload")
    public String index(){
        return "upload";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {

        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "The file is empty! Please select an upload file!");
            return "redirect:/uploadStatus";
        }

        try {
            // Get the file and save it to the specified folder
            byte[] bytes = file.getBytes();
            filename = file.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER + filename);
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", "File '" + filename + "'upload successul."+" The file size is approximately " +bytes.length/1024+" KB.");

        }
        catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    /*
     ** File upload information processing page
     */
    @GetMapping("/uploadStatus")
    public String uploadStatus(){
        return "uploadStatus";
    }


}
