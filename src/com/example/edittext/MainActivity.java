package com.example.edittext;

import android.support.v7.app.ActionBarActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
	EditText editText;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText = (EditText) findViewById(R.id.edit);
		editText.addTextChangedListener(new TextWatcher() {
			int mCount;
			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {
				mCount =count;
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count,
					int after) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable s) {
				String result = formateBankno(s.toString());
				if (result.equals(s.toString())) {
					return;
				} 
				int index;
				if (mCount==0) {
					index = editText.getSelectionStart();
				}
				else
				{
					
					index = editText.getSelectionStart();
					
					if (index ==5||index ==10||index ==15||index ==20) {
						index+=1;
					}
				}
				Log.e("ddd", "index"+index);
				editText.setText(result);
				editText.setSelection(index);
				
				
			}
		});
	}
	private String formateBankno(String source) {
		
		StringBuffer buffer = new StringBuffer(source.replace(" ", ""));
		try {
			buffer.insert(4, " ");
			buffer.insert(9, " ");
			buffer.insert(14, " ");
			buffer.insert(19, " ");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return buffer.toString();
		
		
	}
	
}
