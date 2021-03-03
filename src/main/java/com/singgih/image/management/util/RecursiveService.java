package com.singgih.image.management.util;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import com.singgih.image.management.entity.Media;

@Component
public class RecursiveService {
	Logger logger = LoggerFactory.getLogger(RecursiveService.class);

	public void walk(String hashCode, String path) throws Exception {
		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(hashCode, f.getAbsolutePath());
				System.out.println("Dir:" + f.getAbsoluteFile());
			} else {
				logger.debug("------------- File:" + f.getAbsoluteFile()+"------------------------");
				Media media = new Media();
				media.setOriginalFileName(f.getName());
				media.setOriginalPath(f.getAbsolutePath());
				media.setFileSize(f.length() / 1024);
				
				logger.debug(hashCode + "Media : "+media.toString());
				
				try (InputStream is = Files.newInputStream(Paths.get(f.getAbsolutePath()))) {
				    String md5 = DigestUtils.md5DigestAsHex(is);
				    logger.debug(md5);
				}

//				Metadata metadata = ImageMetadataReader.readMetadata(f);
//				for(Directory directory:metadata.getDirectories()) {
//					  for (Tag tag : directory.getTags()) {
//						 
//						  logger.debug(tag.getTagName()++tag.getDescription());
////			                System.out.println(tag.get());
//			                
//			                
//			            }
//				}
			}
		}
	}
}
