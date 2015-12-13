package com.example.amospricle.gimal;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class SignUpActivity extends AppCompatActivity {



	private TextView signupBtn;



	private  EditText emailEdt;
	private  EditText pwdEdt;
	private  EditText nickEdt;
	private  EditText numberEdt;
	private String email;
	private String password;
	private String nickName;
	private String phoneNumber;
	private String number;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sign_up);





		signupBtn = (TextView)findViewById (R.id.signupBtn);



		numberEdt = (EditText) findViewById(R.id.numberEdt);
		emailEdt = (EditText) findViewById(R.id.emailEdt);
		pwdEdt = (EditText) findViewById(R.id.pwdEdt);
		nickEdt = (EditText) findViewById(R.id.nickEdt);


		signupBtn.setOnClickListener(new View.OnClickListener() {
			//@Override
			public void onClick(View v) {

				number =numberEdt.getText().toString();
				if(number.length()==2){
					int numInt;
					try{
						numInt= Integer.parseInt(number);
						if(numInt >= 0 && numInt<=99){
							password =pwdEdt.getText().toString();
							nickName =nickEdt.getText().toString();
							number =numberEdt.getText().toString();
							Intent mainIntent = new Intent(SignUpActivity.this, MainActivity.class);
							mainIntent.putExtra("nickName",nickName);
							mainIntent.putExtra("number",number);
							SignUpActivity.this.startActivity(mainIntent);
							SignUpActivity.this.finish();
						}
					}catch(Exception e){

						Toast.makeText(SignUpActivity.this, "닉네임과 학번을 다시 확인해 주세요.", Toast.LENGTH_SHORT).show();
					}
				}
				else{
					Toast.makeText(SignUpActivity.this, "닉네임과 학번을 다시 확인해 주세요.", Toast.LENGTH_SHORT).show();
				}

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
