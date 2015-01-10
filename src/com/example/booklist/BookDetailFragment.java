package com.example.booklist;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class BookDetailFragment extends Fragment {

	public static final String ITEM_ID="item_id";
	BookContent.Book book;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//如果启动该fragment的时候，包含了ITEM_ID参数，
		if(getArguments().containsKey(ITEM_ID))
		{
			book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
		}
	}

	//重写该方法，该方法返回的View将作为Fragment的显示的组件
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View bookView = inflater.inflate(R.layout.fragment_book_detail,container,false);
		if(book!=null)
		{
			//让book的空间显示book对象的title属性
			((TextView) bookView.findViewById(R.id.booktitle)).setText(book.title);
			//让book的空间显示book对象的desc属性
			((TextView) bookView.findViewById(R.id.bookdesc)).setText(book.desc);
		}
		
		return bookView;
		
	}
	
}
