package org.xuyuji.chapter13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T10 {
	public static void main(String[] args) {
		String str = "Java now has regular expressions";
		String[] regexs = {"^Java", "\\Breg.*", "n.w\\s+h(a|i)s" , "s?", "s*", "s+", "s{4}", "s{1}.", "s{0,3}"};
		for(String regex : regexs){
			System.out.println("******" + regex + "******");
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(str);
			while(m.find()){
				System.out.println(m.group());
			}
		}
	}
}
