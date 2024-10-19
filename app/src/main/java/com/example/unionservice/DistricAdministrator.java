package com.example.unionservice;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.squareup.picasso.Picasso;

import ItemLayout.LRDWProfileActivity;

public class DistricAdministrator extends AppCompatActivity {

    public static String DetailsTv = "";
    public static String DetailsTv2 = "";

    public static String url = "";

    public static String adph = "";
    public static String adgm = "";

    ImageView admisImage;
    TextView admisTextTv,admisTextTv2;

    Toolbar toolbar;

    String body = "hi there";
    CardView adPhone,adGmail,adMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_distric_administrator);
        admisImage = findViewById(R.id.admisImage);
        admisTextTv = findViewById(R.id.admisTextTv);
        admisTextTv2 = findViewById(R.id.admisTextTv2);
        adPhone = findViewById(R.id.adPhone);
        adGmail = findViewById(R.id.adGmail);
        adMessage = findViewById(R.id.adMessage);
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
        Picasso.get().load(url).placeholder(R.color.white).into(admisImage);


        adPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:"+adph));
                startActivity(intent);

            }
        });

        adGmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_TEXT, "Text you want to share");
                startActivity(Intent.createChooser(intent, ""+adgm));

            }
        });


        adMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("smsto:" +adph);
                Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
                smsSIntent.putExtra("sms_body", body);
                try{
                    startActivity(smsSIntent);
                } catch (Exception ex) {
                    Toast.makeText(DistricAdministrator.this, "Your sms has failed...",
                            Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }

            }
        });
















    }
}