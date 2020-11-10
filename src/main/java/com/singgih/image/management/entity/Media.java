package com.singgih.image.management.entity;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.singgih.image.management.util.Util;

public class Media {
	@SerializedName(value = "id")
	public String id;
	@SerializedName(value = "checksum")
	public String checkSum;
	@SerializedName(value = "original_file_name")
	public String originalFileName;
	@SerializedName(value = "new_file_name")
	public String newFileName;
	@SerializedName(value = "original_path")
	public String originalPath;
	@SerializedName(value = "destination_path")
	public String destinationPath;
	@SerializedName(value = "gdrive_path")
	public String gdrivePath;
	@SerializedName(value = "file_created_date")
	public Date fileCreatedDate;
	@SerializedName(value = "file_last_modified_date")
	public Date filelastModifiedDate;
	@SerializedName(value = "file_size")
	public Long fileSize;
	@SerializedName(value = "inserted_db_date")
	public Date insertedDbDate;
	@SerializedName(value = "moved_file_date")
	public Date movedFileDate;
	@SerializedName(value = "uploaded_gdrive_date")
	public Date uploadedGDriveDate;
	@SerializedName(value = "file_type")
	public String fileType;

	public Media() {
		this.id = Util.getID();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getMovedFileDate() {
		return movedFileDate;
	}

	public void setMovedFileDate(Date movedFileDate) {
		this.movedFileDate = movedFileDate;
	}

	public String getCheckSum() {
		return checkSum;
	}

	public void setCheckSum(String checkSum) {
		this.checkSum = checkSum;
	}

	public String getOriginalPath() {
		return originalPath;
	}

	public void setOriginalPath(String originalPath) {
		this.originalPath = originalPath;
	}

	public String getDestinationPath() {
		return destinationPath;
	}

	public void setDestinationPath(String destinationPath) {
		this.destinationPath = destinationPath;
	}

	public String getGdrivePath() {
		return gdrivePath;
	}

	public void setGdrivePath(String gdrivePath) {
		this.gdrivePath = gdrivePath;
	}

	public Date getFileCreatedDate() {
		return fileCreatedDate;
	}

	public void setFileCreatedDate(Date fileCreatedDate) {
		this.fileCreatedDate = fileCreatedDate;
	}

	public Date getFilelastModifiedDate() {
		return filelastModifiedDate;
	}

	public void setFilelastModifiedDate(Date filelastModifiedDate) {
		this.filelastModifiedDate = filelastModifiedDate;
	}

	public Long getFileSize() {
		return fileSize;
	}

	public void setFileSize(Long fileSize) {
		this.fileSize = fileSize;
	}

	public Date getInsertedDbDate() {
		return insertedDbDate;
	}

	public void setInsertedDbDate(Date insertedDbDate) {
		this.insertedDbDate = insertedDbDate;
	}

	public Date getUploadedGDriveDate() {
		return uploadedGDriveDate;
	}

	public void setUploadedGDriveDate(Date uploadedGDriveDate) {
		this.uploadedGDriveDate = uploadedGDriveDate;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getNewFileName() {
		return newFileName;
	}

	public void setNewFileName(String newFileName) {
		this.newFileName = newFileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	@Override
	public String toString() {
		return new Gson().toJson(this);
	}
}
