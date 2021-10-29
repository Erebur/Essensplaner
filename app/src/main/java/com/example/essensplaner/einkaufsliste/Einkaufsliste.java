package com.example.essensplaner.einkaufsliste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.essensplaner.Produkt;
import com.example.essensplaner.R;

public class Einkaufsliste extends AppCompatActivity {


    Produkt[] test = {new Produkt("Pommes", "bro idk"), new Produkt("Salat", "i still dk")};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einkaufsliste);



        RecyclerView rvAuftrage = (RecyclerView) findViewById(R.id.rvEinkaufsliste);
        ArrayAdapter<Produkt> ad = new ArrayAdapter<Produkt>(this, R.layout.activity_einkaufsliste, test);
//        rvAuftrage.setAdapter();
        rvAuftrage.setLayoutManager(new LinearLayoutManager((this)));

    }

    public void btnInsertEinkauf(View view) {
        System.out.println("hey");
    }
}