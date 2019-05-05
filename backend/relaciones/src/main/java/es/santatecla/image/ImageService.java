package es.santatecla.image;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

	private AtomicInteger imageId = new AtomicInteger();
	private Map<Integer, Image> images = new ConcurrentHashMap<>();
	private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "images");
	
	public String uploadPhoto(Model model, String imageTitle, MultipartFile file) {
		int id = imageId.getAndIncrement();

        String fileName = "image-" + id + ".jpg";

        if (!file.isEmpty()) {
            try {

                File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
                file.transferTo(uploadedFile);

                images.put(id, new Image(id, imageTitle));

                return "upload-status";

            } catch (Exception e) {

                model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());

                return "uploaded";
            }
        } else {

            model.addAttribute("error", "The file is empty");

            return "upload-status";
        }
	}
	
	public void getPhoto(String id, HttpServletResponse res) throws IOException {
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
