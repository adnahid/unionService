package HealthPackage;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unionservice.R;

import java.util.Arrays;
import java.util.List;

import javaClass.HospitalNameAdapter;

public class HospitalNameActivity extends AppCompatActivity {

    RecyclerView hospitalNameRecyclerView;
    Toolbar toolbar;

    HospitalNameAdapter hospitalNameClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hospital_name);
        toolbar = findViewById(R.id.toolbar);
        hospitalNameRecyclerView = findViewById(R.id.hospitalNameRecyclerView);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        hospitalNameRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> item = Arrays.asList("বাংলাদেশ ডায়াবেটিক্স জেনারেল হাসপাতাল","বসুরহাট নার্সিংহোম ","বসুরহাট প্রাইভেট হাসপাতাল ইউনিট 1");

        HospitalNameAdapter hospitalNameAdapter = new HospitalNameAdapter(item);
        hospitalNameRecyclerView.setAdapter(hospitalNameAdapter);





    }
}