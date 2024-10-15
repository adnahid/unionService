package HospitalNameList;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
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

import HealthPackage.DoctorList;
import HealthPackage.DoctorProfile;
import ItemLayout.LRDWProfileActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class ApplelyHospital extends AppCompatActivity {
    RecyclerView ApplelyHospitalRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_applely_hospital);
        ApplelyHospitalRecyclerView  = findViewById(R.id.ApplelyHospitalRecyclerView);
        toolbar  = findViewById(R.id.toolbar);


        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        DetailsTable();
        AppleyAdapter appleyAdapter = new AppleyAdapter();
        ApplelyHospitalRecyclerView.setAdapter(appleyAdapter);
        ApplelyHospitalRecyclerView.setLayoutManager(new LinearLayoutManager(ApplelyHospital.this));

    }
    private class AppleyAdapter extends RecyclerView.Adapter{
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
                    Intent intent = new Intent(ApplelyHospital.this, DoctorProfile.class);

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
        hashMap.put("name","ডাঃ মোঃ জাকির হোসেন");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01834565606");
        hashMap.put("dcSp","মেডিসিন,বাত-ব্যথা ও প্যারালাইসিস রোগ বিশেষজ্ঞ");
        hashMap.put("dcTitle","বিএসএমএমইউ");
        hashMap.put("dcEducation","বিএসএমএমইউ (পিজি হাসপাতাল)");
        hashMap.put("dcChamber","অ্যাপোলো হসপিটাল");
        hashMap.put("hospitalName","অ্যাপোলো হসপিটাল");
        hashMap.put("dcTime","শুক্রবার বিকেল থেকে রাত ৮টা পর্যন্ত।");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ মুহাম্মদ সাখাওয়াত হোসাইন");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01834565606");
        hashMap.put("dcSp","মেডিসিন, এলার্জি, যক্ষা ও বক্ষব্যাধি বিশেষজ্ঞ");
        hashMap.put("dcTitle","এবিসি, সিভিএব (স্বাস্থা)");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","অ্যাপোলো হসপিটাল");
        hashMap.put("hospitalName","অ্যাপোলো হসপিটাল");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ১০টা-দুপুর ২টা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ মোঃ মনির খান");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01834565606");
        hashMap.put("dcSp","নাক, কান, গলা রোগ অভিজ্ঞ ও হেডনেক সার্জন");
        hashMap.put("dcTitle","এফসিজিপি (মেডিসিন) এফসিপিএস");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","অ্যাপোলো হসপিটাল");
        hashMap.put("hospitalName","অ্যাপোলো হসপিটাল");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ৯ টা থেকে দুপুর ১টা পর্যন্ত।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","সহকারী অধ্যাপক ডাঃ মোঃ সফিকুল ইসলাম");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01834565606");
        hashMap.put("dcSp","চর্ম, এলার্জী ও যৌন রোগ বিশেষজ্ঞ");
        hashMap.put("dcTitle","এফসিজিপি (মেডিসিন) এফসিপিএস");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","অ্যাপোলো হসপিটাল");
        hashMap.put("hospitalName","অ্যাপোলো হসপিটাল");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ১০টা-দুপুর ২টা");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ ইসরাত জাহান");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/9439/9439276.png");
        hashMap.put("dcNumber","01834565606");
        hashMap.put("dcSp","গাইনী, প্রসূতি, বন্ধ্যাত্ব ও স্ত্রী রোগ চিকিৎসক");
        hashMap.put("dcTitle","গাইনী প্রসূতি, বন্ধ্যাত্ব স্ত্রী রোগের চিকিৎসক ও সার্জন");
        hashMap.put("dcEducation","এই মর্মে কোন প্রকার তথ্য পাওয়া যায়নি");
        hashMap.put("dcChamber","অ্যাপোলো হসপিটাল");
        hashMap.put("hospitalName","অ্যাপোলো হসপিটাল");
        hashMap.put("dcTime","রোগী দেখার সময় প্রতি মঙ্গলবার বিকাল ২:০০টা দেখে সন্ধ্যা ৬টা পর্যন্ত।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ প্রিয়া কুন্ডু");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/9439/9439276.png");
        hashMap.put("dcNumber","01834565606");
        hashMap.put("dcSp","গাইনী, প্রসূতি, বন্ধ্যাত্ব ও স্ত্রী রোগ চিকিৎসক");
        hashMap.put("dcTitle","গাইনী, প্রসূতি, বন্ধ্যাত্ব ও স্ত্রী রোগ চিকিৎসক");
        hashMap.put("dcEducation","এই মর্মে কোন প্রকার তথ্য পাওয়া যায়নি");
        hashMap.put("dcChamber","অ্যাপোলো হসপিটাল");
        hashMap.put("hospitalName","অ্যাপোলো হসপিটাল");
        hashMap.put("dcTime","রোগী দেখার সময়। প্রতিদিন সকাল ১০টা থেকে বিকাল ৪টা পর্যন্ত");
        arrayList.add(hashMap);

    }
}