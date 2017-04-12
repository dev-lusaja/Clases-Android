package com.example.android_clase_2;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


/* IMPLEMENTAR METODO PARA BOTON */
public class Clase2 extends Activity implements OnClickListener{
	
	/* DECLARACION DE VARIABLES */
	EditText a, b;
	Spinner combo;
	Button btn1;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* MAPEO DE VARIABLES */
        a = (EditText)findViewById(R.id.txt1);
        b = (EditText)findViewById(R.id.txt2);
        combo = (Spinner)findViewById(R.id.spnCombo);
        btn1 = (Button)findViewById(R.id.btnCalcular);
        btn1.setOnClickListener(new OnClickListener(){
			@Override
			public void onClick(View v) {
				Ejecutar();
			}
        });
        
        /* INVOCAR EL ARRAY */
        ArrayAdapter datos=ArrayAdapter.createFromResource(this, R.array.ARREGLO, android.R.layout.simple_spinner_dropdown_item);
        combo.setAdapter(datos);
    }


    public void Ejecutar(){
    	int cantidad = Integer.parseInt(a.getText().toString());
    	double precio = Double.parseDouble(b.getText().toString());
    	String sele = combo.getSelectedItem().toString();
    	double desc = 0, total = 0;
    	
    	total = precio * cantidad;
    	if (sele.equals("CONTADO")){
    		desc = total * 0.18;
    	} else if (sele.equals("FINANCIADO")){
    		desc = total * 0.05;
    	}
    	Toast.makeText(getApplicationContext(), "El neto es: " + (total - desc) , Toast.LENGTH_LONG).show();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.clase2, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	}
}
