package com.singgih.image.management.entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class MediaRowMapper implements RowMapper<Media> {
	@Override
	public Media mapRow(ResultSet rs, int rowNum) throws SQLException {
		Media customer = new Media();
		customer.setId(rs.getString("id"));
		return customer;
	}
}