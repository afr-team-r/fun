package br.afr.fun.controller;

import java.io.File;
import java.nio.file.Files;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ImageController {

	@Value("#{myProps.filesPath}")
	private String imagesPath;
	
	@RequestMapping(value="/i/{code}")
	@ResponseBody
	public byte[] process(@PathVariable String code) {
		
		try {
			File fi = new File(imagesPath + code);
			return Files.readAllBytes(fi.toPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	} 
		
}
