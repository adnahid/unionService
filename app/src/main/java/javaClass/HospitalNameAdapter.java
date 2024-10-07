package javaClass;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unionservice.R;

import java.util.List;

public class HospitalNameAdapter extends RecyclerView.Adapter<HospitalNameAdapter.ViewHolder> {

    private List<String> itemLists;

    public HospitalNameAdapter (List<String> itemLists){
        this.itemLists = itemLists;
    }



    @NonNull
    @Override
    public HospitalNameAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_name_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HospitalNameAdapter.ViewHolder holder, int position) {
        holder.hospitalName.setText(itemLists.get(position));



    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView hospitalName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hospitalName = itemView.findViewById(R.id.hospitalName);

        }
    }
}
