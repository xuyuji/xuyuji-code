package org.jetsennet;

import java.util.Iterator;
import java.util.List;

import org.jetsennet.config.Config;
import org.jetsennet.entity.SettingFile;
import org.jetsennet.handle.Handle;

public class Setting {
	public static void main(String[] args) {
		new Setting().play();
	}
	
	public void play(){
		Config config = Config.getInstance();
		Handle handle = Handle.getInstance();
		List<SettingFile> files = config.getFiles();
		Iterator<SettingFile> it = files.iterator();
		while(it.hasNext()){
			handle.handle(it.next());
		}
	}
}
