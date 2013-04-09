package org.xuyuji.chapter18;

import java.io.File;

public class Test {
	public static void main(String[] args) {
		File file = new File(".");
		printFileTree(file);
	}
	
	private static void printFileTree(File file){
		printFileTree(file, 0);
	}
	
	private static void printFileTree(File file, long level){
		for(int i=0; i<level-1; i++)
			System.out.print("\t");
		System.out.print(" ");
		System.out.println(file.getName());
		if(file.isDirectory()){
			for(File f : file.listFiles())
				printFileTree(f, level+1);
		}
	}
}
