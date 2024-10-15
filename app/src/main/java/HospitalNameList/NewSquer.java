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

public class NewSquer extends AppCompatActivity {

    RecyclerView NewSquerHospitalRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_new_squer);
        NewSquerHospitalRecyclerView = findViewById(R.id.NewSquerHospitalRecyclerView);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        DetailsTable();
        NewSquerAdapter newSquerAdapter = new NewSquerAdapter();
        NewSquerHospitalRecyclerView.setAdapter(newSquerAdapter);
        NewSquerHospitalRecyclerView.setLayoutManager(new LinearLayoutManager(NewSquer.this));


    }

    private class NewSquerAdapter extends RecyclerView.Adapter{
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
                    Intent intent = new Intent(NewSquer.this, DoctorProfile.class);

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
        hashMap.put("name","ডাঃ মাকসুদা সুলতানা (সুরভী)");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01834565606");
        hashMap.put("dcSp","আল্ট্রাসনোগ্রাফী ও ইমেজিং বিশেষজ্ঞ মেডিসিন, বন্ধ্যাত্ব, গাইনী, চর্ম ও মহিলা রোগ অভিজ্ঞ");
        hashMap.put("dcTitle","এম.বি.বি.এস; এম.এস.সি ");
        hashMap.put("dcEducation","T.V.S. Anomly Scan, Thyroid, Breast, 3D-4D Color Doppler, Mak এম.বি.বি.এস; এম.এস.সি (ডায়াগনষ্টিক আল্ট্রাসনোগ্রাফী এন্ড মেডিকেল ইমেজিং) সি.ই.সি (ইকোকার্ডিওগ্রাফী");
        hashMap.put("dcChamber","নিউ স্কয়ার ডায়াগনস্টিক সেন্টার");
        hashMap.put("hospitalName","নিউ স্কয়ার ডায়াগনস্টিক সেন্টার");
        hashMap.put("dcTime","সার্বক্ষনিক (সরকারী অফিস সূচী ব্যতিত)");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ সলিম উল্যাহ");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01834565606");
        hashMap.put("dcSp","মেডিসিন, বাত ব্যথা, রোগ অভিজ্ঞ ও সনোলজিস্ট বিশেষজ্ঞ");
        hashMap.put("dcTitle","এম.বি.বি.এস; বিসিএস (স্বাস্থ্য) সিএমইউ (আল্ট্রাসনোগ্রাফী)");
        hashMap.put("dcEducation","এমবিবিএস (ঢাকা); এফসিজিপি (মেডিসিন) এফসিপিএস মেডিসিন এম.ফিল (বিএসএমএমইউ)। সিসিডি (ডায়াবেটিস) বারডেম সিসিসিডি (ন্যাশনাল হার্ট ফাউন্ডেশন)");
        hashMap.put("dcChamber","নিউ স্কয়ার ডায়াগনস্টিক সেন্টার");
        hashMap.put("hospitalName","নিউ স্কয়ার ডায়াগনস্টিক সেন্টার");
        hashMap.put("dcTime","সার্বক্ষনিক (সরকারী অফিস সূচী ব্যতিত)");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ প্রিয়া কুণ্ডু");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01834565606");
        hashMap.put("dcSp","গাইনী, প্রসূতি ও স্ত্রী রোগ চিকিৎসক বিশেষজ্ঞ");
        hashMap.put("dcTitle","এম.বি.বি.এস; পি.জি.টি গাইনী) গা");
        hashMap.put("dcEducation","এম.বি.বি.এস; পি.জি.টি গাইনী) গাইনী এন্ড অবস্ ( সিএমইউ (আল্ট্রা) ঢাকা।)");
        hashMap.put("dcChamber","নিউ স্কয়ার ডায়াগনস্টিক সেন্টার");
        hashMap.put("hospitalName","নিউ স্কয়ার ডায়াগনস্টিক সেন্টার");
        hashMap.put("dcTime","সার্বক্ষনিক অনকল");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ মোহাম্মদ মেহেদী হাসান");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01834565606");
        hashMap.put("dcSp","মেডিসিন, ডায়াবেটিস, বাত ব্যথা, হরমোন, থাইরয়েড রোগ চিকিৎসক");
        hashMap.put("dcTitle","এম.বি.বি.এস; (সি.ইউ) বিসিএস (স্বাস্থ্য) ডিইএম ");
        hashMap.put("dcEducation","এম.বি.বি.এস; (সি.ইউ) বিসিএস (স্বাস্থ্য) ডিইএম (হরমোন রোগ, বিএসএমএমইউ-সি) পিজিটি (মেডিসিন-ময়মনসিংহ মেডিকেল কলেজ))");
        hashMap.put("dcChamber","নিউ স্কয়ার ডায়াগনস্টিক সেন্টার");
        hashMap.put("hospitalName","নিউ স্কয়ার ডায়াগনস্টিক সেন্টার");
        hashMap.put("dcTime","সার্বক্ষনিক (সরকারী অফিস সূচী ব্যতিত)");
        arrayList.add(hashMap);

    }
}