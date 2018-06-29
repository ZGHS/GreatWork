package com.jike.utils;

import java.util.ArrayList;
import java.util.List;

public class NewsUtil {
	public static List<String> getNews(List<String> cityNames) {
		if (cityNames != null) {
			List<String> result = new ArrayList<>();
			String mPrefix = "https://baike.baidu.com/item/";
			for (int i = 0; i < cityNames.size(); i++) {
				String cString = cityNames.get(i);
				result.add(mPrefix + cString);
			}
			return result;
		}
		return null;
	}
}
