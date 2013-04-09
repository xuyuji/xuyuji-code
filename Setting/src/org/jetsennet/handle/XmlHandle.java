package org.jetsennet.handle;

import org.apache.log4j.Logger;
import org.jetsennet.entity.SettingFile;

public class XmlHandle implements IHandle {
	private static final Logger logger= Logger.getLogger(XmlHandle.class);
	
	@Override
	public void handle(SettingFile file) {
		logger.error(file.getFilePath() + "解析失败,尚不支持xml文件格式！");
	}

}
