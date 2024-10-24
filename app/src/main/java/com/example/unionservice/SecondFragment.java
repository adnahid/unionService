package com.example.unionservice;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


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

    ImageView emergencyCall,ministryCall,fireServiceCall,docKidsCall,
            foodCall,healthShebaCall,emerKidsCall,emeRiverCall;


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


        //ImageView
        emergencyCall = myView.findViewById(R.id.emergencyCall);
        ministryCall = myView.findViewById(R.id.ministryCall);
        fireServiceCall = myView.findViewById(R.id.fireServiceCall);
        docKidsCall = myView.findViewById(R.id.docKidsCall);
        foodCall = myView.findViewById(R.id.foodCall);
        healthShebaCall = myView.findViewById(R.id.healthShebaCall);
        emerKidsCall = myView.findViewById(R.id.emerKidsCall);
        emeRiverCall = myView.findViewById(R.id.emeRiverCall);

        //ImageUrl
        String emergencyCallUrl = "https://cdn-icons-png.flaticon.com/128/9747/9747121.png";
        String ministryCallUrl = "https://cdn-icons-png.flaticon.com/128/3014/3014736.png";
        String fireServiceCallUrl = "https://cdn-icons-png.flaticon.com/128/12252/12252834.png";
        String docKidsCallUrl = "https://cdn-icons-png.flaticon.com/128/4278/4278846.png";
        String foodCallUrl = "https://cdn-icons-png.flaticon.com/128/9434/9434620.png";
        String healthShebaCallUrl = "https://cdn-icons-png.flaticon.com/128/3195/3195462.png";
        String emerKidsCallUrl = "https://cdn-icons-png.flaticon.com/128/12570/12570546.png";
        String emeRiverCallUrl = "https://cdn-icons-png.flaticon.com/128/11483/11483369.png";






        Picasso.get().load(emergencyCallUrl).placeholder(R.drawable.doctor).into(emergencyCall);
        Picasso.get().load(ministryCallUrl).placeholder(R.drawable.doctor).into(ministryCall);
        Picasso.get().load(fireServiceCallUrl).placeholder(R.drawable.doctor).into(fireServiceCall);
        Picasso.get().load(docKidsCallUrl).placeholder(R.drawable.doctor).into(docKidsCall);
        Picasso.get().load(foodCallUrl).placeholder(R.drawable.doctor).into(foodCall);
        Picasso.get().load(healthShebaCallUrl).placeholder(R.drawable.doctor).into(healthShebaCall);
        Picasso.get().load(emerKidsCallUrl).placeholder(R.drawable.doctor).into(emerKidsCall);
        Picasso.get().load(emeRiverCallUrl).placeholder(R.drawable.doctor).into(emeRiverCall);











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