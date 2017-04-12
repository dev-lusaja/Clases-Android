package com.example.android.clase3;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Toast;

public class Clase3 extends Activity implements OnCheckedChangeListener{
	
	/* DECLARACION DE VARIABLES */
	EditText txt1,txt2,txt3;
	CheckBox chk1,chk2,chk3;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* MAPEO DE VARIABLES */
        txt1 = (EditText)findViewById(R.id.txt1);
        txt2 = (EditText)findViewById(R.id.txt2);
        txt3 = (EditText)findViewById(R.id.txt3);
        chk1 = (CheckBox)findViewById(R.id.chk1);
        chk2 = (CheckBox)findViewById(R.id.chk2);
        chk3 = (CheckBox)findViewById(R.id.chk3);
    
        /* AÑADIR CHECKED EVENTS */
        chk1.setOnCheckedChangeListener(this);
        chk2.setOnCheckedChangeListener(this);
        chk3.setOnCheckedChangeListener(this);
    }
    
    /* METODOS DE JAVA */
    public void Sumatoria(){
    	double x,y,z,sum = 0;
    	try
    	{
	    	x = Double.parseDouble(txt1.getText().toString());
	    	y = Double.parseDouble(txt2.getText().toString());
	    	z = Double.parseDouble(txt3.getText().toString());
	    	sum = x + y + z;
	    	Toast.makeText(getApplicationContext(), "La suma es: " + sum, Toast.LENGTH_LONG).show();
    	} catch (NumberFormatException e)
    	{
    		Error();
    	}
    }

    public void Raiz(){
    	double y, raiz=0;
    	try
    	{
	    	y = Double.parseDouble(txt2.getText().toString());
	    	raiz = Math.sqrt(y);
	    	Toast.makeText(getApplicationContext(), "La raiz cuadrada es: " + raiz, Toast.LENGTH_LONG).show();
    	} catch (NumberFormatException e)
    	{
    		Error();
    	}
    }

    public void QuintaParte(){
    	double z, quinta=0;
    	try
    	{
    		z = Double.parseDouble(txt3.getText().toString());
    		quinta = z / 5;
    		Toast.makeText(getApplicationContext(), "La quinta parte es: " + quinta, Toast.LENGTH_LONG).show();
    	} catch (NumberFormatException e)
    	{
    		Error();
    	}
    	
    }
    
    public void Error(){
    	Toast.makeText(getApplicationContext(), "Solo debe ingresar números", Toast.LENGTH_LONG).show();
    }
    
    /* METODO PARA EJECUTAR METODOS MATEMATICOS */
    public void Ejecutar(){
    	if (chk1.isChecked()){
    		Sumatoria();
    	} else if(chk2.isChecked()){
    		Raiz();
    	} else if(chk3.isChecked()){
    		QuintaParte();
    	}
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.clase3, menu);
        return true;
    }

	@Override
	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		Ejecutar();
	}
    
}
