package com.example.unionservice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SecondFragment extends Fragment {

    String EmrService = "৯৯৯";
    String gov = "৩৩৩";
    String FireService = "১৬১৬৩";
    String FemaleAndChildren = "১০৯";
    String Vokytha = "১৬১২১";
    String Health = "১৬২৬৩";
    String ChailderHelp = "১০৯৮";
    String vounnaNum = "১০৯০";


    CardView jathioEmrService,govNews,fireService,femaleAndChildren,vokytha,
            health,chailderHelp,vounna;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View myView = inflater.inflate(R.layout.fragment_second, container, false);

        jathioEmrService = myView.findViewById(R.id.jathioEmrService);
        govNews = myView.findViewById(R.id.govNews);
        fireService = myView.findViewById(R.id.fireService);
        femaleAndChildren = myView.findViewById(R.id.femaleAndChildren);
        vokytha = myView.findViewById(R.id.vokytha);
        health = myView.findViewById(R.id.health);
        chailderHelp = myView.findViewById(R.id.chailderHelp);
        vounna = myView.findViewById(R.id.vounna);





        jathioEmrService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+EmrService));
                startActivity(intent);

            }
        });


        govNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+gov));
                startActivity(intent);

            }
        });


        fireService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+FireService));
                startActivity(intent);

            }
        });


        femaleAndChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+FemaleAndChildren));
                startActivity(intent);

            }
        });


        vokytha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+Vokytha));
                startActivity(intent);

            }
        });


        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+Health));
                startActivity(intent);

            }
        });


        chailderHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+ChailderHelp));
                startActivity(intent);

            }
        });


        vounna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+vounnaNum));
                startActivity(intent);

            }
        });







        return myView;
    }
}