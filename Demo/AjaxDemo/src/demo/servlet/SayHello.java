package demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SayHello extends HttpServlet{
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		String name = (String) req.getParameter("name");
		String msg = "";
		if("admin".equals(name))
			msg = "管理员，你好！";
		else
			msg = name + "，你好！";
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.write(msg);
		out.flush();
		out.close();
	}
}
