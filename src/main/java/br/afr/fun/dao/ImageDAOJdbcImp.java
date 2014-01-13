package br.afr.fun.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ImageDAOJdbcImp implements ImageDAO {

	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource ds) {
		jdbcTemplate = new JdbcTemplate(ds);
	}
	
	@Override
	public List<String> getImagesSince(Date date) {

		return jdbcTemplate.query("SELECT code FROM image WHERE inserted_date >= ?", new Object[]{date}, new RowMapper<String>() {
			
			public String mapRow(ResultSet rs, int row) throws SQLException {
				return rs.getString(1);
			}
		});
	}

	@Override
	public Integer addImage(String code, int featured) {
		return jdbcTemplate.update("INSERT INTO image VALUES(null, ?,?,?)", code, new Date(), featured);
	}

}
