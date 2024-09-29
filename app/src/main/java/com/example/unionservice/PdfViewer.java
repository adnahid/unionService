package com.example.unionservice;

import android.os.Bundle;
import android.view.View;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.listener.OnLoadCompleteListener;

public class PdfViewer extends AppCompatActivity {

    PDFView pdfView;

    Toolbar toolbar;

    public static String assetsName = "";

    LottieAnimationView myLottie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.pdfviewer);
        pdfView  = findViewById(R.id.pdfView);
        toolbar  = findViewById(R.id.toolbar);
        myLottie = findViewById(R.id.myLottie);

        pdfView.setVisibility(View.INVISIBLE);
        myLottie.setVisibility(View.VISIBLE);


        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });



        pdfView.fromAsset(assetsName)
                .onLoad(new OnLoadCompleteListener() {
                    @Override
                    public void loadComplete(int nbPages) {
                       pdfView.setVisibility(View.VISIBLE);
                       myLottie.setVisibility(View.GONE);
                    }
                })
                .load();





    }
}