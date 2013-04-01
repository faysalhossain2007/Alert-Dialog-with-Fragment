package com.faysal.alertdialog;

import com.faysal.alertdialog.AlertDialogRadio.AlertPositiveListener;


import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/** Since this class attaches the dialog fragment "AlertDialogRadio",
 *  it is suppose to implement the interface "AlertPositiveListener" 
 */
public class MainActivity extends Activity implements AlertPositiveListener {
	/** Stores the selected item's position */
	int position = 0;
	
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);        
        
        OnClickListener listener = new OnClickListener() {			
			@Override
			public void onClick(View v) {
				/** Getting the fragment manager */
				FragmentManager manager = getFragmentManager();
				
				/** Instantiating the DialogFragment class */
				AlertDialogRadio alert = new AlertDialogRadio();
				
				/** Creating a bundle object to store the selected item's index */
				Bundle b  = new Bundle();
				
				/** Storing the selected item's index in the bundle object */
				b.putInt("position", position);
				
				/** Setting the bundle object to the dialog fragment object */
				alert.setArguments(b);
				
				/** Creating the dialog fragment object, which will in turn open the alert dialog window */
				alert.show(manager, "alert_dialog_radio");			
				
			}
		};      
        
        /** Getting the reference of the button from the main layout */
        Button btn = (Button) findViewById(R.id.btn_choose);
        
        /** Setting a button click listener for the choose button */
        btn.setOnClickListener(listener);
        
    }
    
    
    /** Defining button click listener for the OK button of the alert dialog window */
    @Override
    public void onPositiveClick(int position) {
    	this.position = position;
    	
    	/** Getting the reference of the textview from the main layout */
    	TextView tv = (TextView) findViewById(R.id.tv_android);
    	
    	/** Setting the selected android version in the textview */
    	tv.setText("Your Choice : " + Android.code[this.position]);    	
    }
}