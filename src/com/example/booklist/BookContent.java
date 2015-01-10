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
	//使用list集合记录系统所包含的Book对象
	public static List<Book> ITEMS = new ArrayList<Book>();
	//使用MAP集合记录系统所包含的Book对象
	public static Map<Integer,Book> ITEM_MAP = 
			new HashMap<Integer, Book>();
	private static void addItem(Book book)
	{
		ITEMS.add(book);
		ITEM_MAP.put(book.id, book);
	}
	static{
		//使用静态初始化代码块，将Book对象添加到List集合、Map集合
		addItem(new Book(1,"疯狂java讲义","一本全面的java学习图书..."));
		addItem(new Book(2, "疯狂android讲义", "很好的android学习图书..."));
		addItem(new Book(3, "我的笔记", "记录了我的Android开发学习过程.."));
	}
}
