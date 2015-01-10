package com.example.booklist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.location.Address;

public class BookContent {
	public static class Book
	{
		public Integer id;
		public String title;
		public String desc;
		public Book(Integer id, String title, String desc) {
			super();
			this.id = id;
			this.title = title;
			this.desc = desc;
		}
		@Override
		public String toString() {
			return title;
		}
		
	}
	//ʹ��list���ϼ�¼ϵͳ��������Book����
	public static List<Book> ITEMS = new ArrayList<Book>();
	//ʹ��MAP���ϼ�¼ϵͳ��������Book����
	public static Map<Integer,Book> ITEM_MAP = 
			new HashMap<Integer, Book>();
	private static void addItem(Book book)
	{
		ITEMS.add(book);
		ITEM_MAP.put(book.id, book);
	}
	static{
		//ʹ�þ�̬��ʼ������飬��Book������ӵ�List���ϡ�Map����
		addItem(new Book(1,"���java����","һ��ȫ���javaѧϰͼ��..."));
		addItem(new Book(2, "���android����", "�ܺõ�androidѧϰͼ��..."));
		addItem(new Book(3, "�ҵıʼ�", "��¼���ҵ�Android����ѧϰ����.."));
	}
}
