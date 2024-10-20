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

public class BusurHuttMaa extends AppCompatActivity {

    RecyclerView MaaOsusuHospitalRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_busur_hutt_maa);
        MaaOsusuHospitalRecyclerView = findViewById(R.id.MaaOsusuHospitalRecyclerView);
        toolbar  = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        DetailsTable();
         MaaOSusuHospitalAdapter maaOSusuHospitalAdapter = new MaaOSusuHospitalAdapter();
        MaaOsusuHospitalRecyclerView.setAdapter(maaOSusuHospitalAdapter);
        MaaOsusuHospitalRecyclerView.setLayoutManager(new LinearLayoutManager(BusurHuttMaa.this));


    }

    private class MaaOSusuHospitalAdapter extends RecyclerView.Adapter{
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
                    Intent intent = new Intent(BusurHuttMaa.this, DoctorProfile.class);

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
        hashMap.put("name","ডাঃ বি বি আমেনা ফেনসী");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/9439/9439276.png");
        hashMap.put("dcNumber","01856459913");
        hashMap.put("dcSp","গাইনী ও মেডিসিন রোগে অভিজ্ঞ");
        hashMap.put("dcTitle","উপ: সহকারী কমি: মেডিকেল অফিসার");
        hashMap.put("dcEducation","ডি.এম.এফ (ঢাকা), পি.জি.টি (মেডিসিন ও গাইনী) এফ.টি উপজেলা স্বাস্থ্য কমপ্লেক্স, কোম্পানীগঞ্জ, নোয়াখালী");
        hashMap.put("dcChamber","বসুরহাট মা ও শিশু হাসপাতাল ");
        hashMap.put("hospitalName","বসুরহাট মা ও শিশু হাসপাতাল ");
        hashMap.put("dcTime","সার্বক্ষণিক");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ মাকসুদা সুলতানা (সুরভী)");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/9439/9439276.png");
        hashMap.put("dcNumber","01856459913");
        hashMap.put("dcSp","মআল্ট্রাসনোগ্রাফী ও ইমেজিং বিশেষজ্ঞ, মেডিসিন, গাইনী, চর্ম ও মহিলা রোগ চিকিৎসক");
        hashMap.put("dcTitle","সহকারী সার্জন");
        hashMap.put("dcEducation","M.B.B.S, B.C.S (স্বাস্থ্য) MSC (ডায়াগনস্টিক মেডিকেল সোনোগ্রাফি এবং ইমেজিং) T.V.S, অ্যানোম্যালিস্ক্যান, কালার ডপলার, M.S.K সিস্টেম, ইকোকার্ডিওগ্রাফি, P.G.T (মেডিসিন, স্কিন এবং ভিডি, গাইনি এবং Obs) বিষয়ে বিশেষভাবে প্রশিক্ষিত)");
        hashMap.put("dcChamber","বসুরহাট মা ও শিশু হাসপাতাল");
        hashMap.put("hospitalName","বসুরহাট মা ও শিশু হাসপাতাল");
        hashMap.put("dcTime","প্রতিদিন বিকাল ৫টা-রাত ৮টা পর্যন্ত।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ নয়ন চন্দ্র দেবনাথ");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01856459913");
        hashMap.put("dcSp","চর্ম-যৌন, এলার্জি ও কুষ্ঠ রোগ বিশেষজ্ঞ");
        hashMap.put("dcTitle","মেম্বার, বাংলাদেশ ডার্মাটোলজিক্যাল সোসাইটি (বিডিএস)");
        hashMap.put("dcEducation","এমবিবিএস, বিসিএস (স্বাস্থ্য); সিসিডি (বারডেম) ডিডিভি (চর্ম ও যৌন) বিএসএমএমইউ, পিজি হাসপাতাল, ঢাকা");
        hashMap.put("dcChamber","বসুরহাট মা ও শিশু হাসপাতাল");
        hashMap.put("hospitalName","বসুরহাট মা ও শিশু হাসপাতাল");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ১০টা-দুপুর ২টা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","সহঃ অধ্যাপক ডাঃ শ্যামল চন্দ্র বণিক");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01834565606");
        hashMap.put("dcSp","মেডিসিন, বাত-ব্যথা, ডায়াবেটিস ও অ্যাজমা রোগ বিশেষজ্ঞ");
        hashMap.put("dcTitle","এফসিজিপি (মেডিসিন) এফসিপিএস");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","বসুরহাট সিটি হসপিটালেন");
        hashMap.put("hospitalName","বসুরহাট সিটি হসপিটাল");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ১০টা-দুপুর ২টা");
        arrayList.add(hashMap);

    }
}