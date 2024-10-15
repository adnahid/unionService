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

public class CompanigongUnited extends AppCompatActivity {

    RecyclerView CompanigongUnitedHospitalRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_companigong_united);
        CompanigongUnitedHospitalRecyclerView = findViewById(R.id.CompanigongUnitedHospitalRecyclerView);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        DetailsTable();
        CompanigongUniteAdapter companigongUniteAdapter = new CompanigongUniteAdapter();
        CompanigongUnitedHospitalRecyclerView.setAdapter(companigongUniteAdapter);
        CompanigongUnitedHospitalRecyclerView.setLayoutManager(new LinearLayoutManager(CompanigongUnited.this));


    }

    private class CompanigongUniteAdapter extends RecyclerView.Adapter{
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
                    Intent intent = new Intent(CompanigongUnited.this, DoctorProfile.class);

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
        hashMap.put("name","ডাঃ রিপন কুমার সরকার");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01878471287");
        hashMap.put("dcSp","নাক, কান, গলারোগ বিশেষজ্ঞ এন্ড হেড, নেক সার্জন");
        hashMap.put("dcTitle","এমবিবিএস (সিএমসি), বিসিএস (স্বাস্থ্য) এমএস (ইএনটি-বিএসএমএমইউ)");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","কোম্পানীগঞ্জ ইউনাইটেড হসপিটাল");
        hashMap.put("hospitalName","কোম্পানীগঞ্জ ইউনাইটেড হসপিটাল");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ৯টা থেকে রাত ৮ টা পর্যন্ত");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ মোঃ জুবায়ের হোসেন");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01878471287");
        hashMap.put("dcSp","নবজাতক ও শিশু কিশোর রোগে অভিজ্ঞ");
        hashMap.put("dcTitle","এম.বি.বি.এস; পি.জি.টি (শিশু স্বাস্থ্য) পি.জি.টি (নিওনেটলজি), পি.এ.এল.এস ");
        hashMap.put("dcEducation","এম.বি.বি.এস; পি.জি.টি (শিশু স্বাস্থ্য) পি.জি.টি (নিওনেটলজি), পি.এ.এল.এস রেজিস্ট্রার (ইনচার্জ), শিশু স্বাস্থ্য বিভাগ, অ্যাপোলো- ইমপেরিয়াল হাসপাতাল মেডিকেল অফিসার (এক্স) চট্টগ্রাম মা-শিশু ও জেনারেল হাসপাতাল আগ্রাবাদ, চট্টগ্রাম।");
        hashMap.put("dcChamber","কোম্পানীগঞ্জ ইউনাইটেড হসপিটাল ");
        hashMap.put("hospitalName","কোম্পানীগঞ্জ ইউনাইটেড হসপিটাল ");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ৬টা থেকে রাত ১০:০০টা পর্যন্ত শনিবার সকাল ৮টা- দুপুর ১২টা পর্যন্ত।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ এস. এম. ইকবাল হোসাইন ");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01878471287");
        hashMap.put("dcSp","চর্ম, যৌন, এলার্জি ও কুষ্ঠরোগ বিশেষজ্ঞ");
        hashMap.put("dcTitle","এম.বি.বি.এস; বি.সি.এস (স্বাস্থ্য) ডি.ডি.ভি- বি.এস.এম.এম.ইউ ");
        hashMap.put("dcEducation","এম.বি.বি.এস; বি.সি.এস (স্বাস্থ্য) ডি.ডি.ভি- বি.এস.এম.এম.ইউ (পিজি হাসপাতাল) চর্ম ও যৌনরোগ বিশেষজ্ঞ, চট্টগ্রাম মেডিকেল কলেজ হাসপাতাল।");
        hashMap.put("dcChamber","কোম্পানীগঞ্জ ইউনাইটেড হসপিটাল");
        hashMap.put("hospitalName","কোম্পানীগঞ্জ ইউনাইটেড হসপিটাল");
        hashMap.put("dcTime","প্রতি শুক্রবার বিকাল ৩টা থেকে সন্ধ্যা ৫টা পর্যন্ত।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ সলিম উল্যাহ");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01878471287");
        hashMap.put("dcSp","মেডিসিন, বাত-ব্যথা রোগ অভিজ্ঞ ও সনোলজিস্ট বিশেষজ্ঞ");
        hashMap.put("dcTitle","এমবিবিএস; বিসিএস (স্বাস্থ্য) সিএমইউ (আল্ট্রাসনোগ্রাফী) ");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","কোম্পানীগঞ্জ ইউনাইটেড হসপিটাল");
        hashMap.put("hospitalName","কোম্পানীগঞ্জ ইউনাইটেড হসপিটাল");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ১০টা-থেকে দুপুর ২টা");
        arrayList.add(hashMap);

    }
}