package br.afr.fun.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.afr.fun.bo.ImageBO;

@Controller
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UploadController.class);
	
	@Value("#{myProps.filesPath}")
	private String imagesPath;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyyHHmmssSSS");
	
	@Autowired
	private ImageBO imageBO;

	@RequestMapping(value = "/upload")
	public String process(@ModelAttribute("success") String success, Model model) {
		
		if (success.equals("")) {
			model.addAttribute("status", "Escolha uma imagem para o upload:");
			model.addAttribute("color", "orange");
		} else {
			model.addAttribute("status", "Upload feito com sucesso!");
			model.addAttribute("color", "green");
		}
		
		return "upload";
	}

	@RequestMapping(value = "/upload/go", method = RequestMethod.POST)
	public String processUpload(@RequestParam(value = "upfile", required = false) MultipartFile upfile, RedirectAttributes redirectAttributes) {

		if (!upfile.isEmpty()) {

			FileOutputStream fos = null;

			try {
				String extensao = null;

				if ((extensao = validateFileType(upfile.getContentType())) == null) {
					throw new Exception();
				}
				
				// REMOVEME
				extensao = "";
								
				String code = sdf.format(new Date()).toString() + extensao;
				
				fos = new FileOutputStream(imagesPath + code);
				fos.write(upfile.getBytes());
				
				if (imageBO.addImage(code, 0) > 0) {
					redirectAttributes.addFlashAttribute("success","OK");
				}

			} catch (Exception e) {

			} finally {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} 
		return "redirect:/upload";
	}
	
	private String validateFileType(String contentType) {
		
		if(contentType.equals("image/jpeg")) return ".jpg";
		if(contentType.equals("image/gif")) return ".gif";
		if(contentType.equals("image/png")) return ".png";
		if(contentType.equals("image/bmp")) return ".bmp";
		
		return null;
	}
	
	
//	public void setPath(String path) {
//		this.imagesPath = path;
//	}
}