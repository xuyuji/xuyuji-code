package org.jetsennet.entity;

import java.util.Map;

public class SettingFile {
	
	private String filePath;
	
	private String fileType;
	
	private Map<String, String> nodes;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Map<String, String> getNodes() {
		return nodes;
	}

	public void setNodes(Map<String, String> nodes) {
		this.nodes = nodes;
	}
	
	public String toString(){
		return "filePath:" + filePath + " fileType:" + fileType + " nodes:" + nodes;
	}
}
