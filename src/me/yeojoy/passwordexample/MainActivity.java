package me.yeojoy.passwordexample;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText mEt1, mEt2, mEt3, mEt4;
    
    private String number1, number2, number3, number4;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mEt1 = (EditText) findViewById(R.id.et_1);
        mEt2 = (EditText) findViewById(R.id.et_2);
        mEt3 = (EditText) findViewById(R.id.et_3);
        mEt4 = (EditText) findViewById(R.id.et_4);
        
        mEt1.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1) {
                    number1 = mEt1.getText().toString();
                    mEt2.requestFocus();
                }
            }
            
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            
            @Override public void afterTextChanged(Editable s) { }
        });
        
        mEt2.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1) {
                    number2 = mEt2.getText().toString();
                    mEt3.requestFocus();
                }
            }
            
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            
            @Override public void afterTextChanged(Editable s) { }
        });
        
        mEt3.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1) {
                    number3 = mEt3.getText().toString();
                    mEt4.requestFocus();
                }
            }
            
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            
            @Override public void afterTextChanged(Editable s) { }
        });
        
        mEt4.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 1) {
                    
                    number4 = mEt4.getText().toString();
                    
                    Toast.makeText(MainActivity.this, "Password : " + number1 + number2 + number3 + number4, Toast.LENGTH_SHORT).show();
                }
            }
            
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) { }
            
            @Override public void afterTextChanged(Editable s) { }
        });
        mEt2.setOnKeyListener(mListener);
        mEt3.setOnKeyListener(mListener);
        mEt4.setOnKeyListener(mListener);
    }

    private OnKeyListener mListener = new OnKeyListener() {
        
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event.getAction() == KeyEvent.ACTION_DOWN) {
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    switch (v.getId()) {
                        case R.id.et_4:
                            if (mEt4.getText().toString().length() == 0) {
                                mEt3.requestFocus();
                                mEt3.setText("");
                            }
                            break;
                            
                        case R.id.et_3:
                            mEt2.requestFocus();
                            mEt2.setText("");
                            break;
                            
                        case R.id.et_2:
                            mEt1.requestFocus();
                            mEt1.setText("");
                            break;
                    }
                }
            }
            return false;
        }
    };

}
