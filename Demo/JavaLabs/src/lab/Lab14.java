package lab;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;

/**
 * Zip压缩 注：Java原生ZipOutputStream中文处理会乱码，这里用的是ant里的ZipOutputStream，故需要ant.jar。
 * 
 * @author xuyuji
 * 
 */
public class Lab14 {

	public void zip(String filePath, String zipPath) throws Exception {
		File file = new File(filePath);
		if (!file.exists()) {
			System.out.println(file.getAbsolutePath() + "不存在!");
		}
		zipPath = zipPath.replaceAll("[\\/]", File.separator.replace("\\", "\\\\"));
		File zipFolder = new File(zipPath.substring(0,
				zipPath.lastIndexOf(File.separator)));
		zipFolder.mkdirs();
		ZipOutputStream zos = new ZipOutputStream(new CheckedOutputStream(
				new FileOutputStream(zipPath), new Adler32()));
		compress(file, zos, "");
		zos.close();
	}

	private void compress(File f, ZipOutputStream zos, String dir) throws Exception {
		if (f.isDirectory()) {
			for(File file : f.listFiles()){
				compress(file, zos, dir + f.getName() + File.separator);
			}
		} else {
			BufferedOutputStream out = new BufferedOutputStream(zos);
			BufferedInputStream in = new BufferedInputStream(new FileInputStream(f));
			zos.putNextEntry(new ZipEntry(dir + f.getName()));
			
			int len = -1;
			byte[] buff = new byte[1024];
			while((len = in.read(buff)) != -1){
				out.write(buff, 0, len);
			}
			
			in.close();
			out.flush();
		}
	}

	public static void main(String[] args) throws Exception {
		new Lab14().zip("D:/MSG", "D:/1/2/3/4/5/6.zip");
	}
}
