package xuyuji.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetCode extends HttpServlet{
	/**
	 * 验证码图片宽度 
	 */
	private final int IMG_WIDTH = 90;
	/**
	 * 验证码图片高度 
	 */
	private final int IMG_HEIGHT = 20;
	/**
	 * 验证码字库
	 */
	private final String strs = "1234567890abcdefghijklmnopqrstuvwxyz一二三四五六七八九十壹贰叁肆伍陆柒捌玖零";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedImage bi = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bi.createGraphics();
		Random random = new Random();
		//设置字体
		g2d.setFont(new Font("宋体", Font.BOLD, 14));
		//填充白色矩形
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
		
		int x1, y1, x2, y2;
		for(int i = 0; i < 50; i++){
			//随机色
			g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
			x1 = random.nextInt(IMG_WIDTH);
			y1 = random.nextInt(IMG_HEIGHT);
			x2 = random.nextInt(3) + x1;
			y2 = random.nextInt(3) + y1;
			g2d.drawLine(x1, y1, x2, y2);
		}
		
		//4字符验证码
		char[] charArray = strs.toCharArray();
		String code = "";
		for(int i = 0; i < 4; i++){
			g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
			String s = String.valueOf(charArray[random.nextInt(charArray.length)]);
			code += s;
			g2d.drawString(s, 15 * (i + 1), 15);
		}
		
		//将验证码值放入session中，以待验证。此Demo没有使用。
		HttpSession session = req.getSession();
		session.setAttribute("code", code);
		// 禁止缓存
        resp.setHeader("Prama", "no-cache");
        resp.setHeader("Coche-Control", "no-cache");
        resp.setDateHeader("Expires", 0);
        resp.setContentType("image/jpeg");
        // 将图像输出到
        ServletOutputStream sos = resp.getOutputStream();
        ImageIO.write(bi, "jpeg", sos);
        sos.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}
}
