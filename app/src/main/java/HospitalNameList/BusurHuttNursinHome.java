package HospitalNameList;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unionservice.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

import HealthPackage.DoctorProfile;
import de.hdodenhof.circleimageview.CircleImageView;

public class BusurHuttNursinHome extends AppCompatActivity {

    RecyclerView NursinHomeHospitalRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_busur_hutt_nursin_home);
        NursinHomeHospitalRecyclerView  = findViewById(R.id.NursinHomeHospitalRecyclerView);
        toolbar  = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        DetailsTable();
        NursinHomeHospitalAdapter nursinHomeHospitalAdapter = new NursinHomeHospitalAdapter();
        NursinHomeHospitalRecyclerView.setAdapter(nursinHomeHospitalAdapter);
        NursinHomeHospitalRecyclerView.setLayoutManager(new LinearLayoutManager(BusurHuttNursinHome.this));


    }

    private class NursinHomeHospitalAdapter extends RecyclerView.Adapter{
        private class readHolder extends RecyclerView.ViewHolder{
            TextView dcName,dcSpcialist,dcDegree,hospitalName;
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
            View view = layoutInflater.inflate(R.layout.doctor_item, parent, false);
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



            toolbar.setTitle(dcChamber);
            Picasso.get().load(dcImage).placeholder(R.drawable.doctor).into(readHolder.dcImage);
            readHolder.dcCardView.startAnimation(AnimationUtils.loadAnimation(readHolder.dcCardView.getContext(),R.anim.recycler_anim03));


            readHolder.dcName.setText(dName);
            readHolder.dcSpcialist.setText(dcSp);
            readHolder.dcDegree.setText(dcEducation);
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
                    Intent intent = new Intent(BusurHuttNursinHome.this, DoctorProfile.class);

                    DoctorProfile.DCNAME = dName;
                    DoctorProfile.DCTITLE = dcTitle;
                    DoctorProfile.DCNUMBRE = dcNumber;
                    DoctorProfile.DCSP = dcSp;
                    DoctorProfile.DCED = dcEducation;
                    DoctorProfile.DCCHAMBER = dcChamber;
                    DoctorProfile.DCTIME = dcTime;
                    DoctorProfile.ToolText = dcChamber;
                    Bitmap bitmap = ( (BitmapDrawable) readHolder.dcImage.getDrawable() ).getBitmap();
                    DoctorProfile.ImageBitmap = bitmap;

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
        hashMap.put("name","সহকারী অধ্যাপক ডাঃ আ.ফ.ম. আব্দুল হক");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01816136833");
        hashMap.put("dcSp","বক্ষব্যাধি মেডিসিন, ডায়াবেটিস ও এ্যাজমা রোগশেষজ্ঞ");
        hashMap.put("dcTitle","এম.বি.বি.এসঃ (সি.ইউ) বি.সি.এস (স্বাস্থ্য)। ডি.টি.সি.ডি (বি.এস.এম.এম.ইউ)");
        hashMap.put("dcEducation","এফ.সি.সি.পি (ইউ.এস.এ) সি.সি.ডি (বারডেম) এ্যাসিসটেন্ট প্রফেসর, আবদুল মালেক উকিল মেডিকেল কলেজ ও হাসপাতাল, নোয়াখালী।");
        hashMap.put("dcChamber","বসুরহাট নার্সিং হোম");
        hashMap.put("hospitalName","বসুরহাট নার্সিং হোম");
        hashMap.put("dcTime","প্রতিদিন সকাল ৮টা থেকে সকাল ৯টা পর্যন্ত। (শুক্রবার বন্ধ)");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ মৃণাল সাহা");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01816136833");
        hashMap.put("dcSp","মেডিসিন ও বাত-ব্যথা বিশেষজ্ঞ");
        hashMap.put("dcTitle","এম.বি.বি.এস; বি.সি.এস (স্বাস্থ্য)");
        hashMap.put("dcEducation","এম.বি.বি.এস. বি.সি.এস (স্বাস্থ্য): এফ.সি.পি.এস (শেষ পর্ব) এম.ডি.পার্ট' II (শিশু মেডিসিন), সিএমইউ (আল্ট্রাসনোগ্রাফী) পি.জি হাসপাতাল, ঢাকা।");
        hashMap.put("dcChamber","বসুরহাট নার্সিং হোম");
        hashMap.put("hospitalName","বসুরহাট নার্সিং হোম");
        hashMap.put("dcTime","প্রতিদিন বিকাল ৪টা থেকে সন্ধ্যা ৬টা পর্যন্ত। (শুক্রবার বন্ধ)।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ মোহম্মদ সেলিম");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01816136833");
        hashMap.put("dcSp","মেডিসিন, নিউরোমেডিসিন, বাতব্যাথা ও ডায়াবেটিস চিকিৎসক বিশেষজ্ঞ");
        hashMap.put("dcTitle","এম.ডি (মেডিসিন) এম.এ.সি.পি (আমেরিকা)");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","বসুরহাট নার্সিং হোম");
        hashMap.put("hospitalName","বসুরহাট নার্সিং হোম");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ৯টা থেকে বিকাল ৫টা।");
        arrayList.add(hashMap);



    }
}