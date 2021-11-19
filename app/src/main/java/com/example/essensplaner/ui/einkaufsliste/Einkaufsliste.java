package com.example.essensplaner.ui.einkaufsliste;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.essensplaner.R;

import java.util.ArrayList;

public class Einkaufsliste extends AppCompatActivity {

    RecyclerView rvEinkaufsliste;
    ArrayList<Product> test = new ArrayList<Product>() {
//todo add more products from db
    };
    EinkaufslisteAdapter einkaufslisteAdapter = new EinkaufslisteAdapter(this, test);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einkaufsliste);


        rvEinkaufsliste = findViewById(R.id.rvEinkaufsliste);

        rvEinkaufsliste.setAdapter(einkaufslisteAdapter);
        rvEinkaufsliste.setLayoutManager(new LinearLayoutManager((this)));
    }

    public void btnInsertEinkauf(View view) {
        test.add(findProduct());
        rvEinkaufsliste.setLayoutManager(new LinearLayoutManager((this)));
    }

    private Product findProduct() {
        Product product = new Product();
        product.setAmount(Integer.parseInt(((EditText) findViewById(R.id.editTextTextPersonName)).getText().toString()));
        product.setName(((EditText) findViewById(R.id.editTextTextPersonName2)).getText().toString());
        return product;
    }
}