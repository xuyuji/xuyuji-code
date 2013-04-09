package org.jetsennet.config;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jetsennet.entity.SettingFile;

public class Config {
	private static final Logger logger= Logger.getLogger(Config.class);
	
	private static Config instance = new Config();
	
	private Map<String, String> params = new HashMap<String, String>();
	
	private List<SettingFile> files = new ArrayList<SettingFile>();
	
	private boolean isInit = false;
	
	private Config(){
		configuration();
	}
	
	public static Config getInstance(){
		return instance;
	}
	
	private void configuration(){
		if(!isInit){
			logger.info("开始解析Setting.xml");
			SAXReader reader = new SAXReader();
			File configFile = new File(Config.class.getClassLoader().getResource(".").getPath() + "/Setting.xml");
			if(!configFile.exists()){
				logger.error("找不到Setting.xml");
				return;
			}
			try {
				Document document = reader.read(configFile);
				Element root = document.getRootElement();
				
				logger.info("开始解析param");
				List<Element> paramList = root.selectNodes("./param");
				Iterator<Element> paramIt = paramList.iterator();
				while(paramIt.hasNext()){
					Element param = paramIt.next();
					params.put(param.attributeValue("name"), (String) param.getData());
				}
				logger.info("param解析完成");
				
				logger.info("开始解析文件信息");
				List<Element> folderList = root.selectNodes("./folder");
				Iterator<Element> folderIt = folderList.iterator();
				while(folderIt.hasNext()){
					Element folder = folderIt.next();
					String folderPath = folder.attributeValue("path");
					
					List<Element> fileList = folder.elements();
					Iterator<Element> fileIt = fileList.iterator();
					while(fileIt.hasNext()){
						SettingFile settingFile = new SettingFile();
						Element file = fileIt.next();
						settingFile.setFilePath(folderPath + System.getProperty("file.separator") + file.attributeValue("path"));
						settingFile.setFileType(file.attributeValue("type"));
						
						Map<String, String> nodes = new HashMap<String, String>();
						List<Element> nodeList = file.elements();
						Iterator<Element> nodeIt = nodeList.iterator();
						while(nodeIt.hasNext()){
							Element node = nodeIt.next();
							nodes.put(node.attributeValue("name"), node.attributeValue("ref"));
						}
						settingFile.setNodes(nodes);
						files.add(settingFile);
					}
				}
				logger.info("文件信息解析完成");
			} catch (DocumentException e) {
				logger.info(e);
				e.printStackTrace();
			}
			logger.info("Setting.xml解析完成");
			isInit = true;
		}else{
			logger.info("Setting.xml已解析");
		}
	}
	
	public Map<String, String> getParams() {
		return params;
	}

	public List<SettingFile> getFiles() {
		return files;
	}

	public static void main(String[] args) {
		System.out.println(Config.getInstance().getFiles());
	}
}
