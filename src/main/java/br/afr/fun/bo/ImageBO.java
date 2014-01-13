package br.afr.fun.bo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.afr.fun.dao.ImageDAO;

@Service
public class ImageBO {
	
	@Autowired
	private ImageDAO imageDAO;
	
	public List<String> getImagesSince(int daysAgo) {
		
		Calendar date = new GregorianCalendar();
		date.add(Calendar.DAY_OF_YEAR, -daysAgo);
		
		return imageDAO.getImagesSince(date.getTime());
	}
	
	public Integer addImage(String code, int featured) {
		return imageDAO.addImage(code, featured);
	}
}
