package xuyuji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DownloadServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String filePath = new String(req.getParameter("filePath").getBytes("ISO-8859-1"),"UTF-8");
		File file = new File(filePath);
		if(file.exists()){
			String fileName = file.getName();
			resp.setContentType("application/x-download");
			resp.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName.substring(fileName.indexOf("_") + 1), "UTF-8"));
			
			FileInputStream in = new FileInputStream(file);
			OutputStream out = resp.getOutputStream();
			
			byte[] buf = new byte[1024];
			int len = -1;
			while((len = in.read(buf)) != -1){
				out.write(buf, 0, len);
			}
			
			in.close();
			out.close();
		}else{
			resp.setContentType("text/html");
			PrintWriter pw = resp.getWriter();
			pw.println("<h1 style='color:red	'>文件不存在</h1>");
		}
	}
}
