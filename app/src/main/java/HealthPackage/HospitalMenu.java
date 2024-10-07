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

import com.example.unionservice.HospitalAndDoctorMenu;
import com.example.unionservice.R;

public class HospitalMenu extends AppCompatActivity {

    CardView doctorSearch,nearPharmecy,upzilaDoctor;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hospital_menu);
        toolbar = findViewById(R.id.toolbar);
        doctorSearch = findViewById(R.id.doctorSearch);
        nearPharmecy = findViewById(R.id.nearPharmecy);
        upzilaDoctor = findViewById(R.id.upzilaDoctor);


        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        upzilaDoctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HospitalMenu.this,UpZilaDoctorList.class);
                startActivity(intent);

            }
        });


        doctorSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HospitalMenu.this, HospitalNameActivity.class);
                startActivity(intent);

            }
        });

        nearPharmecy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(HospitalMenu.this,PharmecyList.class);
                startActivity(intent);

            }
        });






    }
}