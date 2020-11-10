package com.singgih.image.management.db;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.singgih.image.management.entity.Media;
import com.singgih.image.management.entity.MediaRowMapper;

@Repository
public class MediaRepositoryImpl implements MediaRepository {
	Logger logger = LoggerFactory.getLogger(MediaRepositoryImpl.class);

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int save(String hashCode, Media media) {
		logger.debug(hashCode + "Insert new media : " + media.getId());
		return jdbcTemplate.update("insert into media (id, original_file_name, original_path,file_type) values(?)", media.getId());
	}

	@Override
	public Media getMediaByChecksum(String hashCode, String checksum) {
		String sqlQuery = "select * from media where checksum=?";
		Object[] param =  new Object[] { checksum };
		
		logger.debug(hashCode + "SQL Query : "+sqlQuery);
		logger.debug(hashCode + "SQL Param : "+param);
		
		return jdbcTemplate.queryForObject(sqlQuery, param, new MediaRowMapper());

	}

	@Override
	public Media getMediaByNameAndSize(String hashCode, String fileName, long fileSize) {
		String sqlQuery = "select * from media where original_file_name=? and file_size=?";
		Object[] param =   new Object[] { fileName, fileSize };
		
		logger.debug(hashCode + "SQL Query : "+sqlQuery);
		logger.debug(hashCode + "SQL Param : "+param);
		
		return jdbcTemplate.queryForObject(sqlQuery, param, new MediaRowMapper());
	}
	
	@Override
	public int updateMedia(String hashCode, Media media) {
		String sqlQuery = "update media set checksum = ?,"
                + " original_file_name = ?,"
                + " new_file_name = ?,"
                + " original_path = ?,"
                + " destination_path = ?,"
                + " gdrive_path = ?,"
                + " file_created_date = ?,"
                + " file_last_modified_date = ?,"
                + " file_size = ?,"
                + " inserted_db_date = ?,"
                + " moved_file_date = ?,"
                + " uploaded_gdrive_date = ?,"
                + " file_type = ? where id = ?";
		Object[] param =  new Object[] {
        		media.getCheckSum(), 
        		media.getOriginalFileName(),
        		media.getNewFileName(),
        		media.getOriginalPath(),
        		media.getDestinationPath(),
        		media.getGdrivePath(),
        		media.getFileCreatedDate(),
        		media.getFilelastModifiedDate(),
        		media.getFileSize(),
        		media.getInsertedDbDate(),
        		media.getMovedFileDate(),
        		media.getUploadedGDriveDate(),
        		media.getFileType(),
        		media.getId()};
		
		logger.debug(hashCode + "SQL Query : "+sqlQuery);
		logger.debug(hashCode + "SQL Param : "+param);
		
        return jdbcTemplate.update(sqlQuery,
        			param
                );

	}
}
