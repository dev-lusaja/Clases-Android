package com.example.android.clase_4;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Clase_4 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.clase_4, menu);
        return true;
    }
    
}
