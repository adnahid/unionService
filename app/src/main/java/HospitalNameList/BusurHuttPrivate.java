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

public class BusurHuttPrivate extends AppCompatActivity {

    RecyclerView BusurHuttPrivateHospitalRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_busur_hutt_private);
        BusurHuttPrivateHospitalRecyclerView = findViewById(R.id.BusurHuttPrivateHospitalRecyclerView);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        DetailsTable();
        BusurHuttPrivateAdapter busurHuttPrivateAdapter = new BusurHuttPrivateAdapter();
        BusurHuttPrivateHospitalRecyclerView.setAdapter(busurHuttPrivateAdapter);
        BusurHuttPrivateHospitalRecyclerView.setLayoutManager(new LinearLayoutManager(BusurHuttPrivate.this));



    }

    private class BusurHuttPrivateAdapter extends RecyclerView.Adapter{
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
                    Intent intent = new Intent(BusurHuttPrivate.this, DoctorProfile.class);

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
        hashMap.put("name","ডাঃ এ.এন.এম মনিরুজ্জামান");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01874-948860,01822-283088 ");
        hashMap.put("dcSp","(শিশু) বিশেষজ্ঞ");
        hashMap.put("dcTitle","এম.বি.বি.এস. বি.সি.এস (স্বাস্থ্য) ডি.সি.এইচ (শিশু), এম.ডি (শিশু স্বাস্থ্য)");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","বসুরহাট প্রাইভেট হাসপাতাল");
        hashMap.put("hospitalName","বসুরহাট প্রাইভেট হাসপাতাল ");
        hashMap.put("dcTime","প্রতিদিন সকাল ৭টা-৮টা, বিকাল ৪টা-রাত ১০:০০টা।");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ পার্থ সারথী মজুমদার");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01874-948860 ,01822-283088 ");
        hashMap.put("dcSp","জেনারেল সার্জন, লেপারোস্কপিক সার্জন, শিশু-কিশোর রোগ বিশেষজ্ঞ ও সার্জন");
        hashMap.put("dcTitle","এম.বি.বি.এস: এফ.সি.পি.এস (সার্জারী), এম.এস (শিশু সার্জারী)");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","বসুরহাট প্রাইভেট হাসপাতাল");
        hashMap.put("hospitalName","বসুরহাট প্রাইভেট হাসপাতাল");
        hashMap.put("dcTime","প্রতি বৃহস্পতিবার বিকাল ৩টা থেকে রাত ৮টা পর্যন্ত।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ মোঃ মাহমুদুর রহমান (নোমান)");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01874-948860 , 01822-283088");
        hashMap.put("dcSp","মেডিসিন বাত-ব্যথা, বাতজ্বর, হৃদরোগ, বক্ষব্যাধি, এ্যাজমা ও ডায়াবেটিস বিশেষজ্ঞ");
        hashMap.put("dcTitle","এম.বি.বি.এস. ডি.এস.সি (ঢাকা)। বি.সি.এস (স্বাস্থ্য) এফ.সি.পি.এস (মেডিসিন)");
        hashMap.put("dcEducation","বি.এস.এম.ইউ, বঙ্গবন্ধু শেখ মুজিব মেডিকেল বিশ্ববিদ্যালয়, ঢাকা। ");
        hashMap.put("dcChamber","বসুরহাট প্রাইভেট হাসপাতাল");
        hashMap.put("hospitalName","বসুরহাট প্রাইভেট হাসপাতাল");
        hashMap.put("dcTime","সময়ঃ প্রতি বৃহস্পতিবার বিকাল ৪টা থেকে রাত ৮টা পর্যন্ত।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ রওশন জাহান লাকী");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01874-948860 , 01822-283088");
        hashMap.put("dcSp","গাইনী, প্রসূতি ও সার্জন বিশেষজ্ঞ");
        hashMap.put("dcTitle","এম.বি.বি.এস। বি.সি.এস (স্বাস্থ্য), পি.জি.টি (গাইনী) সি.এম.ইউ ই.ও.সি স");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","বসুরহাট প্রাইভেট হাসপাতাল");
        hashMap.put("hospitalName","বসুরহাট প্রাইভেট হাসপাতাল");
        hashMap.put("dcTime","প্রতিদিন বিকাল ৪টা থেকে রাত ৮টা পর্যন্ত।");
        arrayList.add(hashMap);

    }
}