/**
 * 
 */
package com.taotao.manage.web.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.taotao.manage.service.PropertiesService;
import com.taotao.manage.web.bean.PicUploadResult;

/**
 * @author hc-3020-i3
 *
 */
@RequestMapping("pic/upload")
@Controller
public class PicUploadController {

	private static final ObjectMapper MAPPER = new ObjectMapper();

	private static final String[] IMAGE_TYPE = { ".jpg", ".jpge", ".png", "bmp", ".gif" };

	//有spring父容器和springmvc子容器     @value注解在当前的容器（springMvc）中查找资源内容
	@Autowired
	private PropertiesService propertiesService;
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.TEXT_HTML_VALUE)
	@ResponseBody
	public String upload(@RequestParam("uploadFile") MultipartFile uploadFile) throws IllegalStateException, IOException {
		Boolean flag = false;

		// 图片后缀校验

		for (String type : IMAGE_TYPE) {
			if (StringUtils.endsWithIgnoreCase(uploadFile.getOriginalFilename(), type)) {
				flag = true;
				break;
			}
		}

		PicUploadResult picUploadResult = new PicUploadResult();

		if (!flag) {
			picUploadResult.setError(1);
			String result = MAPPER.writeValueAsString(picUploadResult);
			return result;
		}

		// 获取服务器地址
		String filePath = getFilePath(uploadFile.getOriginalFilename());

		File file = new File(filePath);
		flag = false;
		// 上传到服务器
		uploadFile.transferTo(file);
		try {
			BufferedImage image = ImageIO.read(file);
			if (image != null) {
				picUploadResult.setWidth(String.valueOf(image.getWidth()));
				picUploadResult.setHeight(String.valueOf(image.getHeight()));
				flag = true;
			}
		} catch (Exception e) {
			
		}
		
		if(!flag){
			file.delete();
		}
		picUploadResult.setError(0);
		
		String picUrl = StringUtils.replace(StringUtils.substringAfter(filePath, "D:\\taotao-upload"), "\\", "/");
		picUploadResult.setUrl(this.propertiesService.IMAGE_BASE_USRL+picUrl);
		String result = MAPPER.writeValueAsString(picUploadResult);
		return result;
	}

	private String getFilePath(String originalFilename) {
		String baseFolder = this.propertiesService.IMAGE_FILE_PATH + File.separator + "image";
		Date nowDate = new Date();
		// 拼接存放地址
		String fileFolder = baseFolder + File.separator + new DateTime().toString("yyyy") + File.separator + new DateTime().toString("MM")
				+ File.separator + new DateTime().toString("dd");
		File file = new File(fileFolder);
		if (!file.isFile()) {
			file.mkdirs();
		}
		String fileName = new DateTime().toString("yyyyMMddssSSSS") + RandomUtils.nextInt(1000, 9999)+"."
				+ StringUtils.substringAfter(originalFilename, ".");
		return fileFolder + File.separator + fileName;
	}
}
