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

public class NewPopular extends AppCompatActivity {

    RecyclerView NewPopularHospitalRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_popular);
        NewPopularHospitalRecyclerView  = findViewById(R.id.NewPopularHospitalRecyclerView);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        DetailsTable();
        NewPopularAdapter newPopularAdapter = new NewPopularAdapter();
        NewPopularHospitalRecyclerView.setAdapter(newPopularAdapter);
        NewPopularHospitalRecyclerView.setLayoutManager(new LinearLayoutManager(NewPopular.this));


    }

    private class NewPopularAdapter extends RecyclerView.Adapter{
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
                    Intent intent = new Intent(NewPopular.this, DoctorProfile.class);

                    DoctorProfile.DCNAME = dName;
                    DoctorProfile.DCTITLE = dcTitle;
                    DoctorProfile.DCNUMBRE = dcNumber;
                    DoctorProfile.DCSP = dcSp;
                    DoctorProfile.DCED = dcEducation;
                    DoctorProfile.DCCHAMBER = dcChamber;
                    DoctorProfile.DCTIME = dcTime;
                    DoctorProfile.ToolText = dcNumber;
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
        hashMap.put("name","ডাঃ মোঃ শাহাদাত হোসেন সাগর");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01830-278786");
        hashMap.put("dcSp","হৃদরোগ  বিশেষজ্ঞ");
        hashMap.put("dcTitle","এম.বি.বি.এস; বিসিএস (স্বাস্থ্য)");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","নিউ পপুলার হসপিটাল");
        hashMap.put("hospitalName","নিউ পপুলার হসপিটাল");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ১০টা-দুপুর ২টা");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ মহিন উদ্দিন রাজু");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01830-278786");
        hashMap.put("dcSp","নাক, কান, গলা, থাইরয়েড রোগ বিশেষজ্ঞ ও হেড-নেক সার্জন");
        hashMap.put("dcTitle","এফ.সি.পি.এস (ই.এন.টি) এফ.পি");
        hashMap.put("dcEducation","এম.বি.বি.এস: ডি.এল.ও (ই.এন.টি) বি.এস.এম.এম.ইউ");
        hashMap.put("dcChamber","নিউ পপুলার হসপিটাল");
        hashMap.put("hospitalName","নিউ পপুলার হসপিটাল");
        hashMap.put("dcTime","প্রতি শুক্রবার বিকাল ৩টা থেকে রাত ৮টা পর্যন্ত");

        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ মাকসুদা সুলতানা (সুরভী)");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/9439/9439276.png");
        hashMap.put("dcNumber","01830-278786");
        hashMap.put("dcSp","আল্ট্রাসনোগ্রাফী ও ইমেজিং বিশেষজ্ঞ মেডিসিন, বন্ধ্যাত্ব, গাইনী, চর্ম ও মহিলা রোগ অভিজ্ঞ");
        hashMap.put("dcTitle","সি.ই.সি (ইকোকার্ডিওগ্রাফী");
        hashMap.put("dcEducation","এমবিবিএস, বি.সি.এস (স্বাস্থ্য) এম.এস.সি, (ডায়াগনষ্টিক আল্ট্রাসনোগ্রাফী। এন্ড মেডিকেল ইমেজিং) স্পেশালী ট্রেইন্ড অন T.V.S. Anomaly Scan, Thyroid, Breast, 3D-4D Color Dopplar, Msk)");
        hashMap.put("dcChamber","নিউ পপুলার হসপিটাল");
        hashMap.put("hospitalName","নিউ পপুলার হসপিটাল");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ১০টা-দুপুর ২টা পর্যন্ত");
        arrayList.add(hashMap);



    }
}


