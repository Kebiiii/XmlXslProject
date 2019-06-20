package com.apecircle.easytranslib.method;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.apecircle.easytranslib.bean.XlsReadBean;

public class BaseSheet {

	protected static Set<Entry<String, String>> LANGMAP;
	protected static Set<Entry<String, String>> FLOADER;
	public BaseSheet() {
		SheetEnum[] sheetEnums = SheetEnum.values();
		int length = sheetEnums.length;
		Map<String, String> language_map = new HashMap<>();
		Map<String, String> floder_map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			language_map.put(sheetEnums[i].getTitle(), sheetEnums[i].getValueFileName());
			floder_map.put(sheetEnums[i].getValueFileName(), sheetEnums[i].getTitle());
			LANGMAP = language_map.entrySet();
			FLOADER = floder_map.entrySet();
		}
	}
	
	/**
	 * 通过语言，获取对应的文件夹名称
	 * @param language
	 * @return
	 */
	protected String getFloderByLang(String language) {
		for (Entry<String, String> entry : LANGMAP) {
			if (entry.getKey().contains(language)) {
				return entry.getValue();
			}
		}
		return null;
	}
	
	/**
	 * 通过语言，获取对应的文件夹名称
	 * @param flodername
	 * @return
	 */
	public String getLangByFloder(String flodername) {
		for (Entry<String, String> entry : FLOADER) {
			if (entry.getKey().equals(flodername)) {
				return entry.getValue();
			}
			
		}
		return null;
	}
	
	/**
	 * 创建文件夹
	 * @param path
	 * @return
	 */
	protected String createFloder(String rootpath,String path) {
		String[] paths = path.split("/");
		int length = paths.length;
		String currentPath = rootpath;
		for (int i = 0; i < length; i++) {
			String dir = paths[i];
			File file = new File(currentPath, dir);
			if (!file.exists()) {
				file.mkdir();
			}
			currentPath = file.getAbsolutePath();
		}
		return currentPath;
	}
	
	/**
	 * 创建文件，然后把 string 的通用格式写上
	 * @param path
	 */
	protected void createFileAndData(String path,boolean isArrayFile,XlsReadBean.Builder builder){
		File file = null;
		if(isArrayFile){
			file = new File(path,builder.getArrayName());
		}else{
			file = new File(path,builder.getStringName());
		}
		if (file.exists()) {
			file.delete();
		}
		FileOutputStream fos = null;
		try {
			file.createNewFile();
			fos = new FileOutputStream(file);
			StringBuilder sb = new StringBuilder();
			sb.append(
					"<?xml version=\"1.0\" encoding=\"utf-8\"?>\r\n"
							+ "<resources>").append("\r\n");
			

			fos.write(sb.toString().getBytes("utf-8"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
}
