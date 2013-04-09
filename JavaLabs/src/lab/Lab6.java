package lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 使用java.net下包获取网站资源
 * 
 * @author xuyuji
 *
 */
public class Lab6 {
	//获取该路径网页的HTML
	public static String getTargetHTML(String path){
		String content = "";
		String currentLine = "";
		URL url;
		HttpURLConnection httpURLConnection;
		BufferedReader br;
		try {
			url = new URL(path);
			httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.connect();
			br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "UTF-8"));
			while( (currentLine = br.readLine()) != null){
				content += currentLine + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;
	}
	//在一个登录页面提交http请求，获取返回页面HTML
	public static String getLoginHTML(String path, String user, String password){
		String HTML = "";
		
		
		
		return HTML;
	}
	
	public static void main(String[] args) {
		String targetHTML = getTargetHTML("http://localhost:8080/jnmp_js/juum/jnetsystemweb/login.htm");
		System.out.println(targetHTML);
	}
}
