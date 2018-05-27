package com.jike.utils;

import java.util.ArrayList;
import java.util.List;

import com.jike.entity.Result;
import com.jike.entity.Result.Item;

public class CityNameUtil {
	public static List<String> getCityName(Result result) {

		// 缩略词 含义 缩略词 含义 缩略词 含义 缩略词 含义
		// PER 人名 LOC 地名 ORG 机构名 TIME 时间

		List<String> cityNames = new ArrayList<>();
		List<Item> items = result.getItems();
		for (int i = 0; i < items.size(); i++) {
			Item item = items.get(i);
			String ne = item.getNe();
			if (ne.equals("LOC")||ne.equals("PER")||ne.equals("ORG")||ne.equals("TIME")) {
				cityNames.add(item.getItem());
			}
		}
		return cityNames;
	}
}
