package com.example.essensplaner;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link einkaufsliste#newInstance} factory method to
 * create an instance of this fragment.
 */
public class einkaufsliste extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public einkaufsliste() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment einkaufsliste.
     */
    // TODO: Rename and change types and number of parameters
    public static einkaufsliste newInstance(String param1, String param2) {
        einkaufsliste fragment = new einkaufsliste();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    ListView listView;
    Produkt[] test = {new Produkt("Pommes" , "bro idk")  ,new Produkt("Salat" , "i still dk")};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
//        listView =
//        ArrayAdapter<Produkt> arrayAdapter = new ArrayAdapter<Produkt>(this , R.layout.fragment_einkaufsliste,R.id.textView,test);
//        listView.setAdapter(arrayAdapterP);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_einkaufsliste, container, false);
    }




}