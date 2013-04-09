package xuyuji.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

public class ImgToFile {
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
	
	public void createCode(String FilePath) throws IOException{
		BufferedImage bi = new BufferedImage(IMG_WIDTH, IMG_HEIGHT, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = bi.createGraphics();
		Random random = new Random();
		
		g2d.setFont(new Font("宋体", Font.BOLD, 14));
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, IMG_WIDTH, IMG_HEIGHT);
		
		int x1, y1, x2, y2;
		for(int i = 0; i < 50; i++){
			g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
			x1 = random.nextInt(IMG_WIDTH);
			y1 = random.nextInt(IMG_HEIGHT);
			x2 = random.nextInt(3) + x1;
			y2 = random.nextInt(3) + y1;
			g2d.drawLine(x1, y1, x2, y2);
		}
		
		char[] charArray = strs.toCharArray();
		String code = "";
		for(int i = 0; i < 4; i++){
			g2d.setColor(new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
			String s = String.valueOf(charArray[random.nextInt(charArray.length)]);
			code += s;
			g2d.drawString(s, 15 * (i + 1), 15 + random.nextInt(3));
		}
		System.out.println(code);
		
		FileOutputStream fos = new FileOutputStream(new File(FilePath));
		ImageIO.write(bi, "jpeg", fos);
		fos.close();
	}
	
	public static void main(String[] args) {
		ImgToFile test = new ImgToFile();
		System.out.println(ImgToFile.class.getClassLoader().getResource(".").getPath());
		try {
			test.createCode("Test.jpeg");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
