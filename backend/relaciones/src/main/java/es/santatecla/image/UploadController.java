package es.santatecla.image;

import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
    @RequestMapping(value = "/image/upload", method = RequestMethod.POST)
    public String handleFileUpload(Model model, @RequestParam(value ="imageTitle") String imageTitle,
                                   @RequestParam(value ="file") MultipartFile file) {

        return this.imageService.uploadPhoto(model, imageTitle, file);
    }

	@RequestMapping("/image/{id}")
    public void handleFileDownload(@PathVariable String id, HttpServletResponse res)
            throws FileNotFoundException, IOException {

        this.imageService.getPhoto(id, res);
    }
}
