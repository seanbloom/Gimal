package com.example.amospricle.gimal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class LogInActivity extends AppCompatActivity {


	private  EditText emailEdt;
	private  EditText pwdEdt;
	private Button signBtn;
	private Button loginBtn;
	private String email;
	private String password;

	private void bind(){
		emailEdt =(EditText) findViewById(R.id.logEmailEdt);
		pwdEdt =(EditText) findViewById(R.id.logPwEdt);
		signBtn = (Button) findViewById(R.id.logSignBtn);
		loginBtn = (Button) findViewById(R.id.logLogBtn);

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.log_in);
		bind();
		signBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent mainIntent = new Intent(LogInActivity.this, SignUpActivity.class);
				startActivity(mainIntent);
				finish();
			}
		});
		loginBtn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Toast.makeText(LogInActivity.this, "회원정보를 제대로 입력해주세요.", Toast.LENGTH_SHORT).show();
			}
		});
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.menu_main, menu);
		return true;
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		//noinspection SimplifiableIfStatement
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
