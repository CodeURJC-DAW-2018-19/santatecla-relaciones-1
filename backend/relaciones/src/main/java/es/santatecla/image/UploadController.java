package es.santatecla.image;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

//import es.santatecla.record.RecordService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
@Controller
public class UploadController {

//    @Autowired
//    RecordService recordService;

    private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "images");

    private AtomicInteger imageId = new AtomicInteger();
    private Map<Integer, Image> images = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() throws IOException {

        if (!Files.exists(FILES_FOLDER)) {
            Files.createDirectories(FILES_FOLDER);
        }
    }

    @RequestMapping("/imageUpload")
    public String index(Model model) {

        model.addAttribute("images", images.values());

        return "imageUpload";
    }

    @RequestMapping(value = "/image/upload", method = RequestMethod.POST)
    public String handleFileUpload(Model model, @RequestParam(value ="imageTitle") String imageTitle,
                                   @RequestParam(value ="file") MultipartFile file) {

        int id = imageId.getAndIncrement();

        String fileName = "image-" + id + ".jpg";

        if (!file.isEmpty()) {
            try {

                File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
                file.transferTo(uploadedFile);

                images.put(id, new Image(id, imageTitle));

                return "uploaded";

            } catch (Exception e) {

                model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());

                return "uploaded";
            }
        } else {

            model.addAttribute("error", "The file is empty");

            return "uploaded";
        }
    }

    @RequestMapping("/image/{id}")
    public void handleFileDownload(@PathVariable String id, HttpServletResponse res)
            throws FileNotFoundException, IOException {

        String fileName = "image-" + id + ".jpg";

        Path image = FILES_FOLDER.resolve(fileName);

        if (Files.exists(image)) {
            res.setContentType("image/jpeg");
            res.setContentLength((int) image.toFile().length());
            FileCopyUtils.copy(Files.newInputStream(image), res.getOutputStream());

        } else {
            res.sendError(404, "File" + fileName + "(" + image.toAbsolutePath() + ") does not exist");
        }
    }
}
