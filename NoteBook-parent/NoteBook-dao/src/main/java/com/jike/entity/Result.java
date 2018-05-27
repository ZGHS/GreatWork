package com.jike.entity;

import java.util.List;

public class Result {

	String log_id;
	String text;
	List<Item> items;

	public static class Item {

		String formal;
		String[] loc_details;
		String item;
		String pos;
		String ne;
		String[] basic_words;
		Integer byte_length;
		Integer byte_offset;
		String uri;

		public String getNe() {
			return ne;
		}

		public void setNe(String ne) {
			this.ne = ne;
		}

		public String getItem() {
			return item;
		}

		public void setItem(String item) {
			this.item = item;
		}

		@Override
		public String toString() {
			return "Item [item=" + item + ", ne=" + ne + "]";
		}

	}

//	public Integer getLog_id() {
//		return log_id;
//	}
//
//	public void setLog_id(Integer log_id) {
//		this.log_id = log_id;
//	}
	

	public String getText() {
		return text;
	}

	public String getLog_id() {
		return log_id;
	}

	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Result [log_id=" + log_id + ", text=" + text + ", items=" + items + "]";
	}

}
