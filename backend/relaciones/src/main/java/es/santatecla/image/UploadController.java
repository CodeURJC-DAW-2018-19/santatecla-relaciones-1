package es.santatecla.image;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UploadController {

	private ImageService imageService;
	
	@Autowired
	public UploadController(ImageService imageService) {
		this.imageService = imageService;
	}
	
//	@RequestMapping("/image-upload")
//    public String index(Model model) {
//
//        model.addAttribute("images", images.values());
//
//        return "image-upload";
//    }
//
    // @RequestMapping("/upload-image")
    // public String handleFileUpload(@RequestParam MultipartFile file) {

    //     return this.imageService.uploadPhoto(file);
    // }

	@RequestMapping("/image/{id}")
    public void handleFileDownload(@PathVariable String id, HttpServletResponse res)
            throws FileNotFoundException, IOException {

        this.imageService.getPhoto(id, res);
    }
}
