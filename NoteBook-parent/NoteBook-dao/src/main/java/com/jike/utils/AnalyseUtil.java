package com.jike.utils;

import org.json.JSONObject;

import com.baidu.aip.nlp.AipNlp;

public class AnalyseUtil {
	// ����APPID/AK/SK
	public static final String APP_ID = "11270281";
	public static final String API_KEY = "CqnXPVTXk2cCvd1TCNpLvzLj";
	public static final String SECRET_KEY = "GfreNzIVbF8U6MyNXyVlCRYnPsttDdOn";

	public static String getAnalyseResult(String text) {
		// ��ʼ��һ��AipNlp
		AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

		// ��ѡ�������������Ӳ���
		client.setConnectionTimeoutInMillis(2000);
		client.setSocketTimeoutInMillis(60000);

		// ��ѡ�����ô����������ַ, http��socket��ѡһ�����߾�������
		// client.setHttpProxy("proxy_host", proxy_port); // ����http����
		// client.setSocketProxy("proxy_host", proxy_port); // ����socket����

		// ��ѡ������log4j��־�����ʽ���������ã���ʹ��Ĭ������
		// Ҳ����ֱ��ͨ��jvm�����������ô˻�������
//		System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

		// ���ýӿ�
		// String text = "������һ�Ҹ߿Ƽ���˾";
		JSONObject res = client.lexer(text, null);
		// System.out.println(res.toString(2));
		return res.toString(2);

	}
}
