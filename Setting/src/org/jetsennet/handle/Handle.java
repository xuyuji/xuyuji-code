package org.jetsennet.handle;

import org.apache.log4j.Logger;
import org.jetsennet.entity.SettingFile;

public class Handle implements IHandle {
	private static final Logger logger = Logger.getLogger(Handle.class);
	
	private static final String PROPERTIES = "properties";

	private static final String XML = "xml";
	
	private PropertiesHandle propertiesHandle;
	
	private XmlHandle xmlHandle;
	
	private static Handle instance = new Handle();
	
	private Handle(){
		propertiesHandle = new PropertiesHandle();
		xmlHandle = new XmlHandle();
	}
	
	public static Handle getInstance(){
		return instance;
	}
	
	@Override
	public void handle(SettingFile file) {
		if(PROPERTIES.equalsIgnoreCase(file.getFileType())){
			propertiesHandle.handle(file);
		}else if(XML.equalsIgnoreCase(file.getFileType())){
			xmlHandle.handle(file);
		}
		else{
			logger.error(file.getFilePath() + "解析失败,尚不支持" + file.getFileType() + "格式!");
		}
	}

}
