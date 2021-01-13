package com.example.fragmentsinterfaceex4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Fragment1.OnFragment1Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button boto1 = findViewById(R.id.botoActivity1);

        boto1.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        //TODO: quan clica el botó 1 s'infla el Fragment1

        FragmentManager fm = getSupportFragmentManager();

        if (fm.findFragmentById(R.id.contenidor1) == null) { //comprova si hi ha un fragment
            Fragment1 fragment1 = new Fragment1();
            fm.beginTransaction().replace(R.id.contenidor1, fragment1).commit(); //.add si no hi ha res
            // o .replace si vol substituir o afegir
        }

    }

    @Override
    public void onFragment1Click(String text) {
        //Arriba quan clico el botó1 del fragment1
        // inflar el fragmentDetalls
        FragmentManager fm = getSupportFragmentManager();

        if (fm.findFragmentById(R.id.contenidor2) == null) {
            FragmentDetalls frmDetalls = new FragmentDetalls();
            fm.beginTransaction().replace(R.id.contenidor2, frmDetalls).commit();
        }
    }
}