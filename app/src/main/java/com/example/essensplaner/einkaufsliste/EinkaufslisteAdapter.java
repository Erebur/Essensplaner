package com.example.essensplaner.einkaufsliste;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.essensplaner.R;

import java.util.ArrayList;

public class EinkaufslisteAdapter extends RecyclerView.Adapter<EinkaufslisteAdapter.ViewHolder> {

    ArrayList<Product> products;
    Context context;


    public EinkaufslisteAdapter( Context context , ArrayList<Product> products) {
        this.products = products;
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
        holder.myTextView1.setText(products.get(position).getName());
        holder.myTextView2.setText(products.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView myTextView1 , myTextView2;
        //TODO Google image search
        ImageView myImage ;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            myTextView1  = itemView.findViewById(R.id.textView1);
            myTextView2  = itemView.findViewById(R.id.textView2);


        }
    }
}
