package Vatha;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.example.unionservice.R;

public class VathaThalika extends AppCompatActivity {

    CardView vathaSirajpur,cotParboti,corCakdtha,corPokirha,muchaPur,
            corElihe,rumpur,hazari;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_vatha_thalika);
        vathaSirajpur = findViewById(R.id.vathaSirajpur);
        cotParboti = findViewById(R.id.cotParboti);
        corCakdtha = findViewById(R.id.corCakdtha);
        corPokirha = findViewById(R.id.corPokirha);
        muchaPur = findViewById(R.id.muchaPur);
        corElihe = findViewById(R.id.corElihe);
        rumpur = findViewById(R.id.rumpur);
        hazari = findViewById(R.id.hazari);
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

        cotParboti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this, CorParborthe.class);
                startActivity(intent);
            }
        });



        corCakdtha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this, Corcakdha.class);
                startActivity(intent);
            }
        });



        corPokirha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this, Corpokirha.class);
                startActivity(intent);
            }
        });



        muchaPur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this, Muchapur.class);
                startActivity(intent);
            }
        });


        corElihe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this, EliaerCor.class);
                startActivity(intent);
            }
        });


        rumpur.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this, Rampur.class);
                startActivity(intent);
            }
        });

        hazari.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VathaThalika.this, Hazari.class);
                startActivity(intent);
            }
        });




    }
}