package br.afr.fun.controller;

import java.util.LinkedList;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import br.afr.fun.bo.ImageBO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger("system");
	private static final Integer DAYS_AGO = 7;
	
	@Value("#{myProps.imagesUrl}")
	private String imagesUrl;
	
	@Value("#{myProps.homeUrl}")
	private String homeUrl;
	
	@Autowired
	private ImageBO imageBO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)	
	public String home() {
		return "redirect:/st";
	}
	
	@RequestMapping(value = "/{code}", method = RequestMethod.GET)	
	public String home(Model model, @PathVariable(value = "code") String code, @RequestParam(value="action", required=false) String action, HttpSession session) {		
		
		LinkedList<String> imageList = new LinkedList<String>(imageBO.getImagesSince(DAYS_AGO)); 
		
		Integer index = (Integer) session.getAttribute("index");
		
		if(index == null || code.equals("st")) {
			index = imageList.size()-1;
		} else {
			index = imageList.indexOf(code);
		}		
			
		session.setAttribute("index", index);
		
		model.addAttribute("imgUrl", imagesUrl.replace("{0}", imageList.get(index)));
		
		if (index-1 >= 0)
			model.addAttribute("nextUrl", homeUrl.replace("{0}", imageList.get(index-1)));
		
		if(index+1 < imageList.size())
			model.addAttribute("prevUrl", homeUrl.replace("{0}", imageList.get(index+1)));
				
		logger.info("OK!");
		
		return "home";
	}
	
}

/*

- LISTS

ArrayList: iteracao rapida, rapido acesso randomico (cte)
Vector: arraylist syncronized (lento)
LinkedList: rapido acesso randomico (cte), iteracao mais lenta, rapida insercao e delecao, rapido acesso ao comeco e fim (peek, poll e offer)

- SETS





 */
