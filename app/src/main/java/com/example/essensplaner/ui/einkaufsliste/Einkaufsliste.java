package com.example.essensplaner.ui.einkaufsliste;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.essensplaner.R;

import java.util.ArrayList;

public class Einkaufsliste extends AppCompatActivity {

    RecyclerView rvEinkaufsliste ;


    ArrayList<Product> test = new ArrayList<Product>() {
    }; //todo add more products from db

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einkaufsliste);


        rvEinkaufsliste = findViewById(R.id.rvEinkaufsliste);

        EinkaufslisteAdapter einkaufslisteAdapter = new EinkaufslisteAdapter(this , test);

        rvEinkaufsliste.setAdapter(einkaufslisteAdapter);
        rvEinkaufsliste.setLayoutManager(new LinearLayoutManager((this)));

    }

    public void btnInsertEinkauf(View view) {
        test.add(new Product(findViewById(R.id.editTextTextPersonName).getText(), R.id.editTextTextPersonName2));
        EinkaufslisteAdapter einkaufslisteAdapter = new EinkaufslisteAdapter(this, test);
        rvEinkaufsliste.setAdapter(einkaufslisteAdapter);
        rvEinkaufsliste.setLayoutManager(new LinearLayoutManager((this)));

    }
}