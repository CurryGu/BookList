package com.example.booklist;

import android.app.Activity;
import android.os.Bundle;

import com.example.booklist.BookListFragment.Callbacks;

public class SelectBookActivity extends Activity implements Callbacks {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//���ز����ļ�
		setContentView(R.layout.activity_book_twopane);
	}

	@Override
	public void onItemSelected(Integer id) {
		Bundle arguments = new Bundle();
		arguments.putInt(BookDetailFragment.ITEM_ID, id);
		//����bookdetailfragment����
		BookDetailFragment fragment = new BookDetailFragment();
		//��fragment�������
		fragment.setArguments(arguments);
		//ʹ��fragments�滻book_detail_container������ǰ��ʾ��fragment
		getFragmentManager().beginTransaction()
		.replace(R.id.book_detail_container, fragment)
		.commit();
	}

}
