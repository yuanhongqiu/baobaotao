/**
 * 
 */
package com.taotao.manage.service;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author hc-3020-i3
 *
 */
public class PropertiesService {
	
	@Value("{IMAGE_FILE_PATH}")
	public String IMAGE_FILE_PATH;
	
	@Value("{IMAGE_BASE_USRL}")
	public String IMAGE_BASE_USRL;

}
