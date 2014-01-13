package br.afr.fun.dao;

import java.util.Date;
import java.util.List;

public interface ImageDAO {
	public List<String> getImagesSince(Date date);
	public Integer addImage(String code, int featured);
}

/* 
 * 
 create table image (
         id int not null AUTO_INCREMENT primary key,
          code varchar(50) not null,
          inserted_date datetime,
          featured int
         );
 * */
