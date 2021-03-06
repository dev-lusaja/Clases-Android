package com.example.android.ejercicio_1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Ejercicio_1 extends Activity implements OnClickListener {
	
	/* DECLARACION DE VARIABLES */
	EditText txt1,txt2;
	Spinner spn1;
	CheckBox chk1,chk2;
	Button btn1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        /* MAPEO DE VARIABLES */
         txt1 = (EditText)findViewById(R.id.txt1);
        txt2 = (EditText)findViewById(R.id.txt2);
        chk1 = (CheckBox)findViewById(R.id.chk1);
        chk2 = (CheckBox)findViewById(R.id.chk2);
        btn1 = (Button)findViewById(R.id.btn1);
        spn1 = (Spinner)findViewById(R.id.spn1);
        
        /* CARGAR SPINER */
        ArrayAdapter cantidades = ArrayAdapter.createFromResource(this, R.array.cantidad_array, android.R.layout.simple_spinner_dropdown_item);
        spn1.setAdapter(cantidades);
        
        btn1.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.ejercicio_1, menu);
        return true;
    }


	@Override
	public void onClick(View arg0) {
		try
		{
			double precio,  total=0, subtotal=0, descuento = 0;
			int cantidad;
			String producto;
			producto = txt1.getText().toString();
			precio = Double.parseDouble(txt2.getText().toString());
			cantidad = Integer.parseInt(spn1.getSelectedItem().toString());
			subtotal = precio * cantidad;
			if (chk1.isChecked()){
				descuento = subtotal * 0.20;
			} else if (chk2.isChecked()){
				descuento = subtotal * 0.05;
			} else {
				Toast.makeText(getApplicationContext(), "Debe elejir una forma de pago", Toast.LENGTH_LONG).show();
			}
			total = subtotal - descuento;
			Toast.makeText(getApplicationContext(), "El total del producto " + producto + " es: " + total, Toast.LENGTH_LONG).show();
		} catch (Exception e){
			Error();
		}
	}
	
	public void Error(){
		Toast.makeText(getApplicationContext(), "Debe ingresar solo numeros en Precio", Toast.LENGTH_LONG).show();
	}
    
}
