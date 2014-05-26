package com.Shaikhhamadali.blogspot.makecall;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class MakeCall extends Activity {
	//variables
	EditText eTNumber;
	Button btnCall;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_make_call);
		//create instance of Edit Text to get number to call 
		eTNumber=(EditText)findViewById(R.id.eTNumber);
		//create instance of Button to make Call
		btnCall=(Button)findViewById(R.id.btnCall);
		btnCall.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//call method we initialized for making a call
				makeCall();	
			}
		});
	}

	protected void makeCall() {
		//create instance of Intent and pass Intent.ACTION_CALL
		/*Intent.ACTION_CALL is Action to Perform a call to someone specified by the data. 
		  If input is nothing, an empty dialer is started; else getData() is URI of a phone number
		  to be dialed or a tel: URI of an explicit phone number.
		 */
		Intent phoneIntent = new Intent(Intent.ACTION_CALL);
		//set data with tel: +(number to call)
		phoneIntent.setData(Uri.parse("tel:"+eTNumber.getText().toString()));
		try {
			//start activity to perform call action
			startActivity(phoneIntent);

		}
		//catch if exception generated and show toast
		catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(MakeCall.this, 
					"Call faild, please try again later.", Toast.LENGTH_SHORT).show();
		}
	}

}
