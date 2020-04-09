package com.apecircle.easytranslib;

import com.apecircle.easytranslib.bean.XlsWriteBean;
import com.apecircle.easytranslib.method.WriteXlsAndTransManager;
import com.apecircle.easytranslib.method.WriteXlsManager;
import com.apecircle.easytranslib.trans.GoogleApi;
import com.apecircle.easytranslib.utils.DateTimeUtil;

import java.io.File;

public class WriteXmlTransToXls {
	private static String VALUE_PATH = "Test";  //value文件夹存放的名字
	private static String XLS_NAME = "test.xlsx"; //要生成xls的名字
	private static String ROOT_PATH; // 当前路径

	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		File file = new File("");
		ROOT_PATH = file.getAbsolutePath();
		XlsWriteBean bean = new XlsWriteBean.Builder()
				.setRootPath(ROOT_PATH)
				.setFileFloderName(VALUE_PATH)
				.setXlsName(XLS_NAME)
				.builder();
		WriteXlsAndTransManager.getInstance().startWrite(bean.getBuilder());
		System.out.println("在 " + ROOT_PATH + File.separator + VALUE_PATH + "生成文件啦!! 花费时间：" + DateTimeUtil.getDisplayLength((System.currentTimeMillis() - startTime)));
	}


}	
