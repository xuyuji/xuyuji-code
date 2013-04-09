package xuyuji;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String filePath = new String(req.getParameter("filePath").getBytes("ISO-8859-1"), "UTF-8");
		File file = new File(filePath);
		file.delete();
		resp.sendRedirect("/UploadAndDownload/filelist.jsp");
	}
}
