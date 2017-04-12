package com.example.android.clase_4;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Clase_4 extends Activity implements OnClickListener{

	/* DECLARACION DEVARIABLES */
	EditText n,a;
	Button btnProcesar;
	RadioButton rb1, rb2, rb3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        
        /* MAPEO DE VARIABLES */
        n = (EditText)findViewById(R.id.txtn);
        a = (EditText)findViewById(R.id.txta);
        btnProcesar = (Button)findViewById(R.id.btnProcesar);
        rb1 = (RadioButton)findViewById(R.id.rb1);
        rb2 = (RadioButton)findViewById(R.id.rb2);
        rb3 = (RadioButton)findViewById(R.id.rb3);
        
        /* ELEJIR EL RADIO BUTTON QUE ESTARA SELECCIONADO */
        rb1.setChecked(true);
        
        btnProcesar.setOnClickListener(this);
    }

    
    /* METODOS */
    
    public void Ejecutar(){
    	String x = "", y = "", acu = "";
    	x = n.getText().toString();
    	y = a.getText().toString();
    	
    	if(rb1.isChecked()){
    		acu = acu + rb1.getText().toString();
    	} else if (rb2.isChecked()){
    		acu = acu + rb2.getText().toString();
    	} else if (rb3.isChecked()){
    		acu = acu + rb3.getText().toString();
    	}
    	
    	Toast.makeText(getApplicationContext(), "El nombre es: " + x + "\n" +
    											"El apellido es: " + y + "\n" + 
    											"El sexo es: " + acu, Toast.LENGTH_LONG).show();
    }
    
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.clase_4, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		if(btnProcesar == arg0){
			Ejecutar();
		}
	}
    
}
