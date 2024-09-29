package com.example.unionservice.Api2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.example.eithomework.R;

import com.example.unionservice.R;
import com.example.unionservice.model.FlowerResponse;

import java.util.List;

//import model.FlowerResponse;

public class recyclerAdapter extends RecyclerView.Adapter<recyclerAdapter.viewHolder> {
    Context context;
    List<FlowerResponse>flowerResponseList;


    public recyclerAdapter (Context context, List<FlowerResponse> flowerResponseList) {
        this.context = context;
        this.flowerResponseList = flowerResponseList;
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView categoryTv,instructionsTv,priceTv,photoTv,nameTv;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            categoryTv = itemView.findViewById(R.id. categoryTv);
            instructionsTv = itemView.findViewById(R.id. instructionsTv);
            priceTv = itemView.findViewById(R.id. priceTv);
            photoTv = itemView.findViewById(R.id. photoTv);
            nameTv = itemView.findViewById(R.id. nameTv);

        }
    }



    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.flower_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        FlowerResponse flowerResponse = flowerResponseList.get(position);


            holder.categoryTv.setText(flowerResponse.getCategory());
            holder.instructionsTv.setText(flowerResponse.getInstructions());
            String price = String.valueOf(flowerResponse.getPrice());
            holder.priceTv.setText(price);
            holder.photoTv.setText(flowerResponse.getPhoto());
            holder.nameTv.setText(flowerResponse.getName());




    }

    @Override
    public int getItemCount() {
        return flowerResponseList.size();
    }


}
