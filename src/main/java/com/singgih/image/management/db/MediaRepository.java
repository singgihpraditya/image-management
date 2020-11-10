package com.singgih.image.management.db;

import com.singgih.image.management.entity.Media;

public interface MediaRepository {
	public int save(String hashCode, Media media);
	public Media getMediaByNameAndSize(String hashCode, String fileName, long fileSize);
	public Media getMediaByChecksum(String hashCode, String checksum);
	public int updateMedia(String hashCode, Media media);	
}
