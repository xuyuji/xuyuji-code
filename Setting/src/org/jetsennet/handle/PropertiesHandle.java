package org.jetsennet.handle;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.jetsennet.config.Config;
import org.jetsennet.entity.SettingFile;

public class PropertiesHandle implements IHandle {
	private static final Logger logger = Logger.getLogger(PropertiesHandle.class);
	
	Map<String, String> params;
	
	public PropertiesHandle(){
		params = Config.getInstance().getParams();	
	}
	
	@Override
	public void handle(SettingFile file) {
		try {
			logger.info("开始修改" + file.getFilePath());
			BufferedReader br = new BufferedReader(new FileReader(file.getFilePath()));
			StringBuilder sb = new StringBuilder();
			String line = null;
			Map<String, String> nodes = file.getNodes();
			while((line = br.readLine()) != null){
				int point = line.indexOf("=");
				if(point > -1){
					String key = line.substring(0, point);
					if(nodes.containsKey(key)){
						sb.append(key + "=" + params.get(nodes.get(key)) + "\r\n");
						nodes.remove(key);
					}else{
						sb.append(line + "\r\n");
					}
				}else{
					sb.append(line + "\r\n");
				}
			}
			if(nodes.size() > 0){
				sb.append("#Setting ADD\r\n");
				Iterator<Entry<String, String>> it = nodes.entrySet().iterator();
				while(it.hasNext()){
					Entry<String, String> entry = it.next();
					sb.append(entry.getKey() + "=" + params.get(entry.getValue()) + "\r\n");
				}
			}
			br.close();
			BufferedWriter bw = new BufferedWriter(new FileWriter(file.getFilePath()));
			bw.write(sb.toString());
			bw.close();
			logger.info(file.getFilePath() + "修改完成");
		} catch (FileNotFoundException e) {
			logger.error(e + file.getFilePath() + "不存在！");
			return;
		} catch (IOException e) {
			logger.error(e);
			return;
		}
	}

}
