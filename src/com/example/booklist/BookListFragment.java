package com.example.booklist;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class BookListFragment extends ListFragment {
	private Callbacks mCallbacks;
	//����һ���ص��ӿڣ���Fragment����Activity��Ҫʵ�ָýӿ�
	//��Fragment��ͨ���ýӿ��������ڵ�Activity����
	public interface Callbacks{
		public void onItemSelected(Integer id);
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		
		//����ListFragment��ʾ���б��ֻҪ����ListFragment�ṩ��setAdapter��������
		//��ListFragment��ʾITEMS��Ķ���б���
		setListAdapter(new ArrayAdapter<BookContent.Book>(getActivity(), 
				android.R.layout.simple_list_item_activated_1,
				android.R.id.text1,
				BookContent.ITEMS));
	}
	
	//��fragment����ӡ���ʾ��Activity��ʱ�򣬻ص��÷���
	@Override
	public void onAttach(Activity activity) {
			// TODO Auto-generated method stub
			super.onAttach(activity);
			//���Activityû��ʵ��callback�ӿڣ����쳣
			if(!(activity instanceof Callbacks))
			{
				throw new IllegalStateException("BookListFragment���ڵ�Activity����ʵ��callback�ӿ�");
			}
			//��Activity����callback����
			mCallbacks = (Callbacks) activity;
		}
	
	//����ĳ���б�ص��ķ���
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		//����mCallback��onItemSelected����
		mCallbacks.onItemSelected(BookContent.ITEMS.get(position).id);
	}

	//����fragment����������activity��ɾ��ʱ�ص��÷���
	@Override
	public void onDetach() {
		// TODO Auto-generated method stub
		super.onDetach();
		mCallbacks = null;
	}
	
	
	//��Item���Ա�ѡ��
	public void setActivateOnItemClick(boolean activateOnItemClick)
	{
		getListView().setChoiceMode(
				activateOnItemClick ? ListView.CHOICE_MODE_SINGLE:ListView.CHOICE_MODE_NONE);
	}
	
	
}
