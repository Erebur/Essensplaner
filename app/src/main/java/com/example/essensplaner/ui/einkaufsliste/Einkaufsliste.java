package com.example.essensplaner.ui.einkaufsliste;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.essensplaner.R;

import java.util.ArrayList;

public class Einkaufsliste extends AppCompatActivity {

    public static boolean addToTop = false;
    RecyclerView rvEinkaufsliste;
    ArrayList<Product> test = new ArrayList<Product>() {
        //todo add more products from db
    };
    EinkaufslisteAdapter einkaufslisteAdapter = new EinkaufslisteAdapter(this, test);
    EditText name;
    EditText anzahl;
    Button btnInsertEinkauf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einkaufsliste);


        rvEinkaufsliste = findViewById(R.id.rvEinkaufsliste);

        rvEinkaufsliste.setAdapter(einkaufslisteAdapter);
        rvEinkaufsliste.setLayoutManager(new LinearLayoutManager((this)));


        anzahl = findViewById(R.id.editTextTextPersonName);
        name = findViewById(R.id.editTextTextPersonName2);
        btnInsertEinkauf = findViewById(R.id.button);

        btnInsertEinkauf.setOnClickListener(v -> {
            test.add(findProduct());
            einkaufslisteAdapter.notifyItemChanged(0);
        });

    }

    public void btnInsertEinkauf(View view) {
        if (!addToTop) {
            test.add(findProduct());
        } else {
            test.add(0, findProduct());
        }

    }

    private Product findProduct() {
        return new Product(Integer.parseInt(anzahl.getText().toString()), name.getText().toString());
    }
}