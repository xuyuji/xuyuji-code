package org.xuyuji.chapter18;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.regex.Pattern;

public class DirList {
	public static void main(String[] args) {
		File path = new File(".");
		String[] list;
//		if(args.length==0)
//			list = path.list();
//		else
//			list = path.list(new DirFilter(args[0]));
		System.out.println(path.getAbsolutePath()+" size:"+fileSize(path)+"b");
		list = path.list(new DirFilter("[a-z]*"));
		Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);
		for(String dirItem : list)
			System.out.println(dirItem);
	}
	public static long fileSize(File file){
		long size = 0;
		if(file.isDirectory()){
			for(File f : file.listFiles())
				size += fileSize(f);
		}else{
			size = file.length();
		}
		return size;
	}
}

class DirFilter implements FilenameFilter{
	private Pattern pattern;
	public DirFilter(String regex){
		pattern = Pattern.compile(regex);
	}
	public boolean accept(File dir, String name){
		return pattern.matcher(name).matches();
	}
}