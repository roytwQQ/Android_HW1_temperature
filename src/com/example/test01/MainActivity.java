package com.example.test01;

import java.text.NumberFormat;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity {

	private Button toCelsiusBtn;
	private Button toFahrenheitBtn;
	private EditText showCelsius;
	private EditText showFahrenheit;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        toCelsiusBtn = (Button)findViewById(R.id.toCelsius);
        toFahrenheitBtn = (Button)findViewById(R.id.toFahrenheit);

        showCelsius = (EditText)findViewById(R.id.editText2);
        showFahrenheit = (EditText)findViewById(R.id.editText1);
        
        toCelsiusBtn.setOnClickListener(btnDoListener);
        toFahrenheitBtn.setOnClickListener(btnDoListener);

    }
    
    private Button.OnClickListener btnDoListener = 
    		new Button.OnClickListener() {
    			public void onClick(View v) {
    				
    				NumberFormat nf = NumberFormat.getInstance();
    				nf.setMaximumFractionDigits( 2 ); 
    				
    				switch (v.getId()) {
    				case R.id.toCelsius:
    					try{
        					float countF = Float.parseFloat(showFahrenheit.getText().toString());
        					float resC = (countF-32)*5/9;
        					String resC_S = nf.format(resC);
        					showCelsius.setText(resC_S);
        					break;
    					}catch(Exception e){
    						System.out.print(e);
    						break;
    					}
    					
    					
    				case R.id.toFahrenheit:
    					try{
    						float countC = Float.parseFloat(showCelsius.getText().toString());
        					float resF = countC*9/5+32;
        					String resF_S = nf.format(resF);

        					showFahrenheit.setText(resF_S);
        					break;		
    					}catch(Exception e){
    						System.out.print(e);
    						break;
    					}
    				
    				}
    			}
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
