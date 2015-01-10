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
		//���������fragment��ʱ�򣬰�����ITEM_ID������
		if(getArguments().containsKey(ITEM_ID))
		{
			book = BookContent.ITEM_MAP.get(getArguments().getInt(ITEM_ID));
		}
	}

	//��д�÷������÷������ص�View����ΪFragment����ʾ�����
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View bookView = inflater.inflate(R.layout.fragment_book_detail,container,false);
		if(book!=null)
		{
			//��book�Ŀռ���ʾbook�����title����
			((TextView) bookView.findViewById(R.id.booktitle)).setText(book.title);
			//��book�Ŀռ���ʾbook�����desc����
			((TextView) bookView.findViewById(R.id.bookdesc)).setText(book.desc);
		}
		
		return bookView;
		
	}
	
}
