package com.example.booklist;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BookListFragment extends ListFragment {
	private Callbacks mCallbacks;
	//定义一个回调接口，该Fragment所在Activity需要实现该接口
	//该Fragment将通过该接口与它所在的Activity交互
	public interface Callbacks{
		public void onItemSelected(Integer id);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		//控制ListFragment显示的列表项，只要调用ListFragment提供的setAdapter方法即可
		//让ListFragment显示ITEMS里的多个列表项
		setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(), 
				android.R.layout.simple_list_item_activated_1,
				android.R.id.text1,
				BookContent.ITEMS));
	}
	
	//当fragment被添加、显示到Activity的时候，回调该方法
	@Override
	public void onAttach(Activity activity) {
			// TODO Auto-generated method stub
			super.onAttach(activity);
			//如果Activity没有实现callback接口，报异常
			if(!(activity instanceof Callbacks))
			{
				throw new IllegalStateException("BookListFragment所在的Activity必须实现callback接口");
			}
			//把Activity当成callback对象
			mCallbacks = (Callbacks) activity;
		}
	
	//单击某个列表回调的方法
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		//激发mCallback的onItemSelected方法
		mCallbacks.onItemSelected(BookContent.ITEMS.get(position).id);
	}

	//当该fragment从它所属的activity中删除时回调该方法
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		mCallbacks = null;
	}
	
	
	//让Item可以被选中
	public void setActivateOnItemClick(boolean activateOnItemClick)
	{
		getListView().setChoiceMode(
				activateOnItemClick ? ListView.CHOICE_MODE_SINGLE:ListView.CHOICE_MODE_NONE);
	}
	
	
}
