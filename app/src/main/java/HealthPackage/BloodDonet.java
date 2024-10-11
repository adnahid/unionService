package HealthPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.unionservice.R;

import Blood.BloodSocialMedia;

public class BloodDonet extends AppCompatActivity {

    Toolbar toolbar;
    CardView donetSearch,socialMediaDonner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_blood_donet);
        toolbar = findViewById(R.id.toolbar);
        donetSearch = findViewById(R.id.donetSearch);
        socialMediaDonner = findViewById(R.id.socialMediaDonner);


        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        donetSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodDonet.this,BloodGrouphList.class);
                startActivity(intent);
            }
        });


        socialMediaDonner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BloodDonet.this, BloodSocialMedia.class);
                startActivity(intent);
            }
        });


    }

}