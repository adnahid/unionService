package com.example.unionservice.Api2;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.eithomework.R;

import com.example.unionservice.R;
import com.example.unionservice.model.FlowerResponse;

import java.util.ArrayList;
import java.util.List;

//import model.FlowerResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FlowerPage extends AppCompatActivity {

    List<FlowerResponse> FlowerList = new ArrayList<>();
    FlowerInterface flowerInterface;
    TextView resultTv;
    RecyclerView FlowerRecycler;

    recyclerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_flower_page);
        //resultTv = findViewById(R.id.resultTv);







        flowerInterface = RetrofitClass.GetRettrofit().create(FlowerInterface.class);
        flowerInterface.flower().enqueue(new Callback<List<FlowerResponse>>() {
            @Override
            public void onResponse(Call<List<FlowerResponse>> call, Response<List<FlowerResponse>> response) {

                if (response.isSuccessful()){
                    FlowerList = response.body();
                    setResult();
                }else {


                }



            }



            @Override
            public void onFailure(Call<List<FlowerResponse>> call, Throwable t) {
                Toast.makeText(FlowerPage.this, ""+t, Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void setResult() {
        FlowerRecycler = findViewById(R.id.FlowerRecycler);
        adapter = new recyclerAdapter(FlowerPage.this,FlowerList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(FlowerPage.this,LinearLayoutManager.VERTICAL,false);
        FlowerRecycler.setLayoutManager(layoutManager);
        FlowerRecycler.setAdapter(adapter);
    }
}