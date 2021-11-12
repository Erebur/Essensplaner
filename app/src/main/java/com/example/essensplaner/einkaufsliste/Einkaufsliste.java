package com.example.essensplaner.einkaufsliste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.example.essensplaner.R;

import java.util.ArrayList;

public class Einkaufsliste extends AppCompatActivity {

    RecyclerView rvEinkaufsliste ;


    ArrayList<Product> test = new ArrayList<Product>()
    {{
        add(new Product("Pommes", "bro idk"));
        add(new Product("Salat", "i still dk"));
    }};

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
        System.out.println("hey");
    }
}