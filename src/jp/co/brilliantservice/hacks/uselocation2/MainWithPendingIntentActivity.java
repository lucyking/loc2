package jp.co.brilliantservice.hacks.uselocation2;

import jp.co.brilliantservice.hacks.uselocation.R;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainWithPendingIntentActivity extends Activity {

//    private static final String LOG_TAG = "UseLocation";
	
	static long myminute = 5;
	
	

	

    // LocationManagerの取得
    LocationManager mLocationManager = null;

    PendingIntent pendingIntent = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main); //play the init phone number
		((TextView) findViewById(R.id.textView2)).setText("Count Times#:"+ Receiver.mycount);
		((TextView) findViewById(R.id.textView3)).setText("Intervial mins#:"+ myminute);
		((TextView) findViewById(R.id.textView1)).setText("Present  Rec#:"+ Receiver.phoneNu);
         

        mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

        int requestCode = 0x432f;

        Intent intent = new Intent(this, Receiver.class);
        pendingIntent = PendingIntent.getBroadcast(this, requestCode, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);

        // LocationListenerを登録
        mLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, myminute*60*1*1000, 0.0F,
                pendingIntent);
        


       

     
    }

    public boolean onCreateOptionsMenu(Menu menu){             //menu
    	MenuInflater inflater = getMenuInflater();
    	inflater.inflate(R.menu.mainmenu,menu);
    	return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item){
    	switch (item.getItemId()){
    	case R.id.item1:
    		setContentView(R.layout.main); // play the new Phone Number
    		((TextView) findViewById(R.id.textView2)).setText("Count Times#:"+ Receiver.mycount);
    		((TextView) findViewById(R.id.textView3)).setText("Intervial mins#:"+ myminute);
    		((TextView) findViewById(R.id.textView1)).setText("Present  Rec#:"+ Receiver.phoneNu);
    		
    		return true;
    		
    	case R.id.item2:
    		setContentView(R.layout.add);    //add the Phone Number
        	Button button = (Button)findViewById(R.id.button1);      //add_button
        	button.setOnClickListener(new View.OnClickListener() {   //set button_methon
    			@Override
    			public void onClick(View view) {
    				// TODO Auto-generated method stub
    	    		EditText lat=(EditText)findViewById(R.id.editText1);
    	    		String _lat = lat.getText().toString();
    	    		Receiver.phoneNu = _lat;
    	    		
    	    		
    	    		 setContentView(R.layout.main); //play the init phone number
    	    			((TextView) findViewById(R.id.textView2)).setText("Count Times#:"+ Receiver.mycount);
    	    			((TextView) findViewById(R.id.textView3)).setText("Intervial mins#:"+ myminute);
    	    			((TextView) findViewById(R.id.textView1)).setText("Present  Rec#:"+ Receiver.phoneNu);
    	    	         
    	    		
    			}
    		});
        	
        	
        	
    		return true;
    
    		
    	case R.id.item3:
    		setContentView(R.layout.info); 
    		
    	/*	
    		EditText lat=(EditText)findViewById(R.id.editText1);
    		String _lat = lat.getText().toString();
    		Receiver.phoneNu = _lat;
    	 */
    	 //	String _lat= "koko" ;//lat.getText().toString();
    	  // ((TextView) findViewById(R.id.textView1)).setText(_lat); //assign the display PhNumber
    	    
    		
    		return true;
    		
    	case R.id.item4:
    		setContentView(R.layout.intervial); 
    		Button button2 = (Button)findViewById(R.id.button1);      //add_button
        	button2.setOnClickListener(new View.OnClickListener() {   //set button_methon
    			@Override
    			public void onClick(View view) {
    				// TODO Auto-generated method stub
    	    		EditText mouth=(EditText)findViewById(R.id.editText1);
    	    		String _mouth = mouth.getText().toString();
    	    		EditText day=(EditText)findViewById(R.id.editText2);
    	    		String _day =  day.getText().toString();
    	    		EditText hour =(EditText)findViewById(R.id.editText3);
    	    		String _hour = hour.getText().toString();
    	    		EditText minute=(EditText)findViewById(R.id.editText4);
    	    		String _minute = minute.getText().toString();
    	    		long themouth =  Integer.parseInt(_mouth);
    	    		long theday =  Integer.parseInt(_day) + 30*themouth;
    	    		long thehour =  Integer.parseInt(_hour) + 24*theday;
    	    		myminute =  Integer.parseInt(_minute) + 60*thehour;
    	    		
    	    		
    	    		 setContentView(R.layout.main); //play the init phone number
    	    			((TextView) findViewById(R.id.textView2)).setText("Count Times#:"+ Receiver.mycount);
    	    			((TextView) findViewById(R.id.textView3)).setText("Intervial mins#:"+ myminute);
    	    			((TextView) findViewById(R.id.textView1)).setText("Present  Rec#:"+ Receiver.phoneNu);
    	    	         
    	    		
    	    		
    			}
    		});
    		return true;
    		
    	default:
    		return true;
    	}
    }
    
    
 

    
    @Override
    public void onPause() {
        super.onPause();
        mLocationManager.removeUpdates(pendingIntent);
        // mLocationManager.removeProximityAlert(pendingIntent);
    }
    
    
    
}
