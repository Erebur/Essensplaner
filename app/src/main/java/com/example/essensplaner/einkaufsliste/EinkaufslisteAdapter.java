package com.example.essensplaner.einkaufsliste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.essensplaner.Produkt;
import com.example.essensplaner.R;

import java.util.ArrayList;

public class EinkaufslisteAdapter extends RecyclerView.Adapter<EinkaufslisteAdapter.ViewHolder> {

    ArrayList<Produkt> mdlProdukt ;

    public EinkaufslisteAdapter(ArrayList<Produkt> produkts) {
        this.mdlProdukt = produkts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.activity_einkaufsliste, parent, false);

        // Return a new holder instance
        return new ViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView txtNr;
        public TextView txtDatum;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);


        }
    };
    }
}
