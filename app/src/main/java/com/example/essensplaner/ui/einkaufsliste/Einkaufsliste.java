package com.example.essensplaner.ui.einkaufsliste;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.essensplaner.R;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.util.ArrayList;

public class Einkaufsliste extends AppCompatActivity {

    RecyclerView rvEinkaufsliste;
    ArrayList<Product> test = new ArrayList<Product>() {
        //todo get products from db
    };
    EinkaufslisteAdapter einkaufslisteAdapter = new EinkaufslisteAdapter(this, test);
    EditText name;
    EditText anzahl;
    Button btnInsertEinkauf;
    Button btnDeleteEinkauf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_einkaufsliste);


        rvEinkaufsliste = findViewById(R.id.rvEinkaufsliste);

        rvEinkaufsliste.setAdapter(einkaufslisteAdapter);
        rvEinkaufsliste.setLayoutManager(new LinearLayoutManager(this));


        anzahl = findViewById(R.id.editTextTextPersonName);
        name = findViewById(R.id.editTextTextPersonName2);
        btnInsertEinkauf = findViewById(R.id.button);

        btnInsertEinkauf.setOnClickListener(v -> {
            try {
                btnInsertEinkauf(v);
            } catch (IOException e) {
                e.printStackTrace();
            }
            einkaufslisteAdapter.notifyDataSetChanged();
        });
        btnDeleteEinkauf = findViewById(R.id.button2);
        btnDeleteEinkauf.setOnClickListener(v -> {
            btnDeleteEinkauf(v);
            einkaufslisteAdapter.notifyDataSetChanged();
        });

    }

    //TODO timestamps

    public void btnInsertEinkauf(View view) throws IOException {
        Product p = findProduct();
        test.add(0, p);
        Thread thread = new Thread(() -> {
            try {
                //TODO body -> product
                post("http://localhost:3001/api/shoppinglist/", "{\"GroupId\":\"10\",\"product_name\":\"tests\",\"product_amount\":\"5\"}");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        thread.start();

    }

    public void btnDeleteEinkauf(View view) {
        if (test.size() > 0) {
            test.remove(0);
        }
    }

    public void post(String completeUrl, String body) {
        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(completeUrl);
        httpPost.setHeader("Content-type", "application/json");
        try {
            StringEntity stringEntity = new StringEntity(body);
            httpPost.getRequestLine();
            httpPost.setEntity(stringEntity);

            httpClient.execute(httpPost);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Product findProduct() {
        return new Product(Integer.parseInt(anzahl.getText().toString()), name.getText().toString());
    }
}