package com.example.booklist;

import android.app.Activity;
import android.os.Bundle;

import com.example.booklist.BookListFragment.Callbacks;

public class SelectBookActivity extends Activity implements Callbacks {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//加载布局文件
		setContentView(R.layout.activity_book_twopane);
	}

	@Override
	public void onItemSelected(Integer id) {
		Bundle arguments = new Bundle();
		arguments.putInt(BookDetailFragment.ITEM_ID, id);
		//创建bookdetailfragment对象
		BookDetailFragment fragment = new BookDetailFragment();
		//向fragment传入参数
		fragment.setArguments(arguments);
		//使用fragments替换book_detail_container容器当前显示的fragment
		getFragmentManager().beginTransaction()
		.replace(R.id.book_detail_container, fragment)
		.commit();
	}

}
