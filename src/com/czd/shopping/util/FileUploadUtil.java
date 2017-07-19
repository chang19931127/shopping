package com.czd.shopping.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * 
 * @author Administrator 一个文件上传的 工具类，性能可能不高，嘿嘿
 */
public class FileUploadUtil {
	private String filePath = null;

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	private String getExt(String fileName) {
		return fileName.substring(fileName.lastIndexOf(".") + 1);
	}

	private String createFileName(String fileName) {
		return UUID.randomUUID().toString() + "." + getExt(fileName);
	}

	public String uploadFile(File file, String fileName, String path) {
		if (path != null) {
			filePath = path;
		}
		return uploadFile(file, fileName);
	}

	public void delete(String fileName) {
		new File(fileName).delete();
	}

	//String [] 数组
	public String[] bankImage(String path) {
		File file = new File(path);
		return file.list(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith("gif");
			}
		});
	}

	// 上传文件，返回新的文件名
	public String uploadFile(File file, String fileName) {
		// 生成文件名
		String newName = createFileName(fileName);
		InputStream input = null;
		OutputStream output = null;
		try {
			input = new FileInputStream(file);
			output = new FileOutputStream(filePath + File.separator + newName);
			byte[] b = new byte[1024];
			int length = 0;
			while ((length = input.read(b)) != -1) {
				output.write(b, 0, length);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 流 关闭
			try {
				input.close();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					output.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return newName;
	}
}
