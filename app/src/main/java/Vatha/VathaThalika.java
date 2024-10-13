package Vatha;

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

public class VathaThalika extends AppCompatActivity {

    CardView vathaSirajpur,vathaAmtholi,vathaMohonpur,
            vathaHuymiyenPur,vathaCoderHutt;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vatha_thalika);
        vathaSirajpur = findViewById(R.id.vathaSirajpur);
        vathaAmtholi = findViewById(R.id.vathaAmtholi);
        vathaMohonpur = findViewById(R.id.vathaMohonpur);
        vathaHuymiyenPur = findViewById(R.id.vathaHuymiyenPur);
        vathaCoderHutt = findViewById(R.id.vathaCoderHutt);
        toolbar = findViewById(R.id.toolbar);


        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             onBackPressed();
             finish();
            }
        });


        vathaSirajpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this,SirajPurVatha.class);
                startActivity(intent);
            }
        });

        vathaAmtholi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this,AmtholiVathaList.class);
                startActivity(intent);
            }
        });



        vathaMohonpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this,MohonPurVathaList.class);
                startActivity(intent);
            }
        });



        vathaHuymiyenPur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this,HumayenPurVatha.class);
                startActivity(intent);
            }
        });



        vathaCoderHutt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this,CorerHuttVatha.class);
                startActivity(intent);
            }
        });



    }
}