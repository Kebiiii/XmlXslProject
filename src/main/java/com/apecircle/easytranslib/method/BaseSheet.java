package com.apecircle.easytranslib.method;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.apecircle.easytranslib.bean.XlsReadBean;


/**
 * @author zhengshaorui 2018/6/24
 */
public class BaseSheet {
	// 这两个要一一对应
	private static final String[] LANGUAGE_NAMES = new String[]{
			"简体中文/Chinese", "繁体中文-台湾", "繁体中文-香港", "默认/Default", "英语/English", "捷克/Czech",
			"丹麦语/Danish", "荷兰语/Dutch", "西班牙/Spanish", "芬兰语/Finnish",
			"葡萄牙语/Portuguese", "法语/French", "德语/Deutsch", "希腊语/Greek",
			"意大利语/Italian", "日语/Japanese", "挪威语/Norwegian", "波兰语/Polish",
			"罗马尼亚语/Romanian", "俄语/Russian", "瑞典语/Swedish", "土耳其语/Turkish",
			"阿拉伯语/Arabic", "匈牙利语/Hungarian",
			"泰语/Thai", "波斯语/Persian", "越南语/Vietnamese", "韩语/Korean"};

	private static final String[] LANGUAGE_FLODERS = new String[]{
			"values-zh-rCN", "values-zh-rTW", "values-zh-rHK", "values", "values-en", "values-cs-rCZ",
			"values-da-rDK", "values-nl", "values-es", "values-fi-rFI",
			"values-pt", "values-fr", "values-de-rDE", "values-el-rGR",
			"values-it-rIT", "values-ja", "values-nb-rNO", "values-pl-rPL",
			"values-ro-rRO", "values-ru-rRU", "values-sv-rSE", "values-tr-rTR",
			"values-ar", "values-hu-rHU",
			"values-th-rTH", "values-fa", "values-vi-rVN", "values-ko-rKR"};
	
	
	protected static Set<Entry<String, String>> LANGMAP;
	protected static Set<Entry<String, String>> FLOADER;
	public BaseSheet() {
		int length = LANGUAGE_NAMES.length;
		Map<String, String> language_map = new HashMap<>();
		Map<String, String> floder_map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			language_map.put(LANGUAGE_NAMES[i], LANGUAGE_FLODERS[i]);
			floder_map.put(LANGUAGE_FLODERS[i], LANGUAGE_NAMES[i]);
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
