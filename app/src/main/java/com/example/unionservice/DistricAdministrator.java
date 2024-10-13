package com.example.unionservice;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

public class DistricAdministrator extends AppCompatActivity {

    public static String DetailsTv = "";
    public static String DetailsTv2 = "";

    public static String url = "";

    ImageView admisImage;
    TextView admisTextTv,admisTextTv2;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_distric_administrator);
        admisImage = findViewById(R.id.admisImage);
        admisTextTv = findViewById(R.id.admisTextTv);
        admisTextTv2 = findViewById(R.id.admisTextTv2);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        admisTextTv.setText(DetailsTv);
        admisTextTv2.setText(DetailsTv2);
        Picasso.get().load(url).into(admisImage);














    }
}