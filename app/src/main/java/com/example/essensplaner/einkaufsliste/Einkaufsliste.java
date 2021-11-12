package com.example.essensplaner.einkaufsliste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.example.essensplaner.Produkt;
import com.example.essensplaner.R;

import java.util.ArrayList;

public class Einkaufsliste extends AppCompatActivity {


    ArrayList<Produkt> test = new ArrayList<Produkt>()
    {{
        add(new Produkt("Pommes", "bro idk"));
        add(new Produkt("Salat", "i still dk"));
    }};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einkaufsliste);


        RecyclerView rvEinkaufsliste = (RecyclerView) findViewById(R.id.rvEinkaufsliste);
        ArrayAdapter<Produkt> ad = new ArrayAdapter<Produkt>(this, R.layout.activity_einkaufsliste, test);
        EinkaufslisteAdapter ea = new EinkaufslisteAdapter(test);
        rvEinkaufsliste.setAdapter(ea);
        rvEinkaufsliste.setLayoutManager(new LinearLayoutManager((this)));

    }

    public void btnInsertEinkauf(View view) {
        System.out.println("hey");
    }
}