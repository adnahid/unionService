package HealthPackage;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unionservice.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class UpZilaDoctorList extends AppCompatActivity {

    RecyclerView UpzilaDoctorRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_up_zila_doctor_list);
        UpzilaDoctorRecyclerView = findViewById(R.id.UpzilaDoctorRecyclerView);
        toolbar  = findViewById(R.id.toolbar);
        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


        DetailsTable();
        UpzilaDocAdapter upzilaDocAdapter = new UpzilaDocAdapter();
        UpzilaDoctorRecyclerView.setAdapter(upzilaDocAdapter);
        UpzilaDoctorRecyclerView.setLayoutManager(new LinearLayoutManager(UpZilaDoctorList.this));

    }

    private class UpzilaDocAdapter extends RecyclerView.Adapter{

        int Native = 0;
        int Read = 1;

        private class readHolder extends RecyclerView.ViewHolder{
            TextView dcName,dcSpcialist,dcDegree;
            CircleImageView dcImage;
            CardView dcCardView;



            public readHolder(@NonNull View itemView) {
                super(itemView);
                dcName = itemView.findViewById(R.id.dcName);
                dcSpcialist = itemView.findViewById(R.id.dcSpcialist);
                dcDegree = itemView.findViewById(R.id.dcDegree);
                dcImage = itemView.findViewById(R.id.dcImage);
                dcCardView = itemView.findViewById(R.id.dcCardView);

//                dcPhoneNumber = itemView.findViewById(R.id.dcPhoneNumber);
//                dcPhoneImage = itemView.findViewById(R.id.dcPhoneImage);
            }
        }


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.upz_doctor_item, parent, false);
            return new readHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            readHolder readHolder = (readHolder) holder;
            hashMap = arrayList.get(position);
            String dName = hashMap.get("name");
            String dcSp  = hashMap.get("dcSp");
            String dcTime = hashMap.get("dcTime");
            String dcImage = hashMap.get("dcImage");
            String dcNumber = hashMap.get("dcNumber");
            String dcTitle = hashMap.get("dcTitle");
            String dcEducation = hashMap.get("dcEducation");
            String dcChamber = hashMap.get("dcChamber");


            Picasso.get().load(dcImage).placeholder(R.drawable.doctor).into(readHolder.dcImage);
            readHolder.dcCardView.startAnimation(AnimationUtils.loadAnimation(readHolder.dcCardView.getContext(),R.anim.recycler_anim03));


            readHolder.dcName.setText(dName);
            readHolder.dcDegree.setText(dcTitle);
            readHolder.dcSpcialist.setText(dcSp);
            //String ph = String.valueOf(dcNumber.toString());



//            Bitmap bitmap = new Bitmap();
//            Bitmap circleBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
//
//            BitmapShader shader = new BitmapShader (bitmap,  Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
//            Paint paint = new Paint();
//            paint.setShader(shader);
//
//            Canvas c = new Canvas(circleBitmap);
//            c.drawCircle(bitmap.getWidth()/2, bitmap.getHeight()/2, bitmap.getWidth()/2, paint);
//            readHolder.dcImage.setImageBitmap(circleBitmap);

            readHolder.dcCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(UpZilaDoctorList.this, DoctorProfile.class);
                    DoctorProfile.DCNAME = dName;
                    DoctorProfile.DCTITLE = dcTitle;
                    DoctorProfile.DCNUMBRE = dcNumber;
                    DoctorProfile.DCSP = dcSp;
                    DoctorProfile.DCED = dcEducation;
                    DoctorProfile.DCCHAMBER = dcChamber;
                    DoctorProfile.DCTIME = dcTime;
                    startActivity(intent);

                }
            });




//            readHolder.dcPhoneImage.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                        Intent intent = new Intent(Intent.ACTION_DIAL);
//                        intent.setData(Uri.parse("tel:"+ph));
//                        startActivity(intent);
//                }
//            });





        }

        @Override
        public int getItemCount() {
            return arrayList.size();
        }




    }

    public void DetailsTable(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ আফম আবদুল হক");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcSp","মেডিসিন, বাত-ব্যথা, ডায়াবেটিস ও অ্যাজমা রোগ বিশেষজ্ঞ");
        hashMap.put("dcNumber","01720173475");
        hashMap.put("dcTitle","আর এম ও");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন)");
        hashMap.put("dcChamber","উপজেলা স্বাস্থ্য কমপ্লেক্স");
        hashMap.put("dcTime","প্রতিদিন স্বাস্থ্য সেবায় নিয়োজিত থাকেন,জরুরী প্রয়োজন ব্যতীত।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ আফম আবদুল হক");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcSp","batRog,jor etc");
        hashMap.put("dcNumber","01720173475");
        hashMap.put("dcTitle","আর এম ও");
        hashMap.put("dcEducation","Mbbs bsc dhaka Medical");
        hashMap.put("dcWork","উপজেলা স্বাস্থ্য কমপ্লেক্স");
        hashMap.put("dcChamber","উপজেলা স্বাস্থ্য কমপ্লেক্স");
        hashMap.put("dcTime","প্রতিদিন স্বাস্থ্য সেবায় নিয়োজিত থাকেন,জরুরী প্রয়োজন ব্যতীত।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ আফম আবদুল হক");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcSp","batRog,jor etc");
        hashMap.put("dcNumber","01720173475");
        hashMap.put("dcTitle","আর এম ও");
        hashMap.put("dcEducation","Mbbs bsc dhaka Medical");
        hashMap.put("dcWork","উপজেলা স্বাস্থ্য কমপ্লেক্স");
        hashMap.put("dcChamber","উপজেলা স্বাস্থ্য কমপ্লেক্স");
        hashMap.put("dcTime","প্রতিদিন স্বাস্থ্য সেবায় নিয়োজিত থাকেন,জরুরী প্রয়োজন ব্যতীত।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ আফম আবদুল হক");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcSp","batRog,jor etc");
        hashMap.put("dcNumber","01720173475");
        hashMap.put("dcTitle","আর এম ও");
        hashMap.put("dcEducation","Mbbs bsc dhaka Medical");
        hashMap.put("dcWork","উপজেলা স্বাস্থ্য কমপ্লেক্স");
        hashMap.put("dcChamber","উপজেলা স্বাস্থ্য কমপ্লেক্স");
        hashMap.put("dcTime","প্রতিদিন স্বাস্থ্য সেবায় নিয়োজিত থাকেন,জরুরী প্রয়োজন ব্যতীত।");
        arrayList.add(hashMap);



    }
}