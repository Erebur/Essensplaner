package com.example.essensplaner.einkaufsliste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.essensplaner.R;

import java.util.ArrayList;

public class EinkaufslisteAdapter extends RecyclerView.Adapter<EinkaufslisteAdapter.ViewHolder> {

    ArrayList<Produkt> produkts;
    Context context;


    public EinkaufslisteAdapter( Context context , ArrayList<Produkt> produkts) {
        this.produkts = produkts;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view =  inflater.inflate(R.layout.recycler_view_item  , parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.myTextView1.setText(produkts.get(position).getName());
        holder.myTextView2.setText(produkts.get(position).getBeschreibung());
    }

    @Override
    public int getItemCount() {
        return produkts.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView myTextView1 , myTextView2;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView1  = itemView.findViewById(R.id.textView1);
            myTextView2  = itemView.findViewById(R.id.textView2);


        }
    }
}
