package xuyuji;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet{
	//使用临时文件临界点10M
	private static final int TEMP_MAX_SIZE = 10 * 1024 * 1024;
	//文件大小上限10M
	private static final int FILE_MAX_SIZE = 10 * 1024 * 1024;
	
	private static String folder_path;
	
	@Override
	public void init() throws ServletException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		folder_path = getServletContext().getRealPath("/") + "Upload/" + sdf.format(new Date()) + "/";
		File file = new File(folder_path);
		if(!file.exists()){
			file.mkdirs();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(TEMP_MAX_SIZE);
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(FILE_MAX_SIZE);
		try {
			List<FileItem> list = upload.parseRequest(req);
			Iterator<FileItem> it = list.iterator();
			while(it.hasNext()){
				FileItem fi = it.next();
				if(!fi.isFormField()){
					InputStream in = fi.getInputStream();
					FileOutputStream out = new FileOutputStream(new File(folder_path + System.currentTimeMillis() + "_" + fi.getName()));
					
					byte [] buf = new byte [1024];
					int len = -1;
					while ((len = in.read(buf)) != -1){
						out.write(buf, 0, len);
					}
					
					in.close();
					out.close();
				}
			}
		} catch (FileUploadException e) {
			System.out.println(e);
		} finally {
		}
		
		resp.sendRedirect("/UploadAndDownload/filelist.jsp");
	}
	
	public static String getFolderPath(){
		return folder_path;
	}
}
