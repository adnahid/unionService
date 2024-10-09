package HealthPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unionservice.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import javaClass.MyAdapter;

public class HospitalNameActivity extends AppCompatActivity {


    Toolbar toolbar;

    private RecyclerView hospitalNameRecyclerView;
    private MyAdapter adapter;
    private List<String> itemList;

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

//        String hos1 = "বাংলাদেশ ডায়াবেটিক্স জেনারেল হাসপাতাল";
//        String hos2 = "বসুরহাট নার্সিংহোম";
//        String hos3 = "বসুরহাট প্রাইভেট হাসপাতাল ইউনিট 1";

        hospitalNameRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //List<String> itemList = Arrays.asList(hos1,hos2,hos3);



//        HospitalNameAdapter hospitalNameAdapter = new HospitalNameAdapter(item);
//        hospitalNameRecyclerView.setAdapter(hospitalNameAdapter);



        itemList = new ArrayList<>();
        // Add items to the list
        itemList.add("বাংলাদেশ ডায়াবেটিক্স জেনারেল হাসপাতাল");
        itemList.add("বসুরহাট নার্সিংহোম");
        itemList.add("বসুরহাট প্রাইভেট হাসপাতাল ইউনিট 1");
        for (int i = 0; i < itemList.size(); i++)





            adapter = new MyAdapter(itemList, new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(HospitalNameActivity.this, ""+position, Toast.LENGTH_SHORT).show();

            }
        });







        hospitalNameRecyclerView.setAdapter(adapter);


    }
}