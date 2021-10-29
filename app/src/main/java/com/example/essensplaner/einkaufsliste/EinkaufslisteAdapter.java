package com.example.essensplaner.einkaufsliste;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.essensplaner.Produkt;

import java.util.ArrayList;

public class EinkaufslisteAdapter extends RecyclerView.Adapter<EinkaufslisteAdapter.ViewHolder> {

    ArrayList<Produkt> mdlProdukt

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
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

            txtNr = (TextView) itemView.findViewById(R.id.nr);
            txtDatum = (TextView) itemView.findViewById(R.id.datum);

        }
    };
    }
}
