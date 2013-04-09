package org.xuyuji.chapter18;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class T7 {
	public static void main(String[] args) {
		try {
			Scanner scanner = new Scanner(System.in);
			System.out.println("input filename(in this package):");
			String fileName = scanner.nextLine();
			System.out.println("need find word:");
			String wordName = scanner.nextLine();
			BufferedReader br = new BufferedReader(new FileReader("D:\\workspace\\ThinkingInJava\\src\\org\\xuyuji\\chapter18\\"+fileName));
			List<String> list = new LinkedList<String>();
			String in;
			while((in = br.readLine()) != null){
				list.add(in);
			}
			for(int i = list.size(); i > 0; i--){
				if(list.get(i-1).indexOf(wordName) != -1)
					System.out.println(list.get(i-1));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
