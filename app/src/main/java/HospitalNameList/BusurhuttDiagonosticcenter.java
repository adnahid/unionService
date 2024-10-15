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

public class BusurhuttDiagonosticcenter extends AppCompatActivity {

    RecyclerView BusurhuttDiagonosticRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_busurhutt_diagonosticcenter);
        BusurhuttDiagonosticRecyclerView  = findViewById(R.id.BusurhuttDiagonosticRecyclerView);
        toolbar  = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        DetailsTable();
        BusurhuttDiaAdapter busurhuttDiaAdapter = new BusurhuttDiaAdapter();
        BusurhuttDiagonosticRecyclerView.setAdapter(busurhuttDiaAdapter);
        BusurhuttDiagonosticRecyclerView.setLayoutManager(new LinearLayoutManager(BusurhuttDiagonosticcenter.this));

    }

    private class BusurhuttDiaAdapter extends RecyclerView.Adapter{
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
                    Intent intent = new Intent(BusurhuttDiagonosticcenter.this, DoctorProfile.class);

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
        hashMap.put("name","ডাঃ অজয় মজুমদার");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01812129232");
        hashMap.put("dcSp","মেডিসিন, হৃদরোগ ও বাতজ্বর বিশেষজ্ঞ");
        hashMap.put("dcTitle","ডি-কার্ড কার্ডিওলজী সিনিয়র কনসালটেন্ট জেলা সদর হাসপাতাল, লক্ষ্মীপুর।");
        hashMap.put("dcEducation","এম.বি.বি.এস; বি.সি.এস (স্বাস্থ্য) এফ.সি.পি.এস- || মেডিসিন)");
        hashMap.put("dcChamber","বসুরহাট ডায়াগনষ্টিক সেন্টার ");
        hashMap.put("hospitalName","বসুরহাট ডায়াগনষ্টিক সেন্টার ");
        hashMap.put("dcTime","প্রতি সোমবার বিকাল ৫টা থেকে রাত ৮টা পর্যন্ত।");
        arrayList.add(hashMap);



        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ বিপ্লব মজুমদার");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01812129232");
        hashMap.put("dcSp","হাঁড়-জোড়া, বাত ব্যথা, প্যারালাইসিস বিশেষজ্ঞ ও ট্রমা সার্জন");
        hashMap.put("dcTitle","কনসালটেন্ট পঙ্গু হাসপাতাল, ঢাকা।");
        hashMap.put("dcEducation","এম.বি.বি.এস; বি.সি.এস (স্বাস্থ্য) ডি.অর্থো; এম.এস (অর্থোপেডিক্স)");
        hashMap.put("dcChamber","বসুরহাট ডায়াগনষ্টিক সেন্টার ");
        hashMap.put("hospitalName","বসুরহাট ডায়াগনষ্টিক সেন্টার ");
        hashMap.put("dcTime","প্রতি মাসের ১ম, ৩য় ও ৫ম বৃহস্পতিবার বিকাল ৪টা থেকে সন্ধ্যা ৭টা পর্যন্ত।");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ এস.এম আতিক হাসান খান");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01812129232");
        hashMap.put("dcSp","চর্ম, যৌন, ব্রন ও এলার্জি রোগ বিশেষজ্ঞ ");
        hashMap.put("dcTitle","এম.বি.বি.এস (ডি.এম.সি) ডিডিভি");
        hashMap.put("dcEducation","এম.বি.বি.এস (ডি.এম.সি) ডিডিভি (চর্ম ও যৌন) বঙ্গবন্ধু শেখ মুজিব মেডিকেল বিশ্ববিদ্যালয়, ঢাকা");
        hashMap.put("dcChamber","বসুরহাট ডায়াগনষ্টিক সেন্টার ");
        hashMap.put("hospitalName","বসুরহাট ডায়াগনষ্টিক সেন্টার ");
        hashMap.put("dcTime","প্রতি বৃহস্পতিবার বিকাল ৩টা থেকে ৬টা পর্যন্ত।");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","ডাঃ আব্দুর রকিব");
        hashMap.put("dcImage","https://cdn-icons-png.flaticon.com/128/2785/2785482.png");
        hashMap.put("dcNumber","01812129232");
        hashMap.put("dcSp","মেডিসিন, বাত-ব্যথা, এলার্জি ও ডায়াবেটিস রোগ অভিজ্ঞ");
        hashMap.put("dcTitle","সিসিডি (ডায়াবেটলজি-বারডেম) এম ডি (অন কোর্স) রেডিওলজি");
        hashMap.put("dcEducation","এম.বি.বি.এস, (ঢাকা মেডিকেল কলেজ) বি.সি.এস (স্বাস্থ্য) পিজিটি (মেডিসিন)");
        hashMap.put("dcChamber","বসুরহাট ডায়াগনষ্টিক সেন্টার ");
        hashMap.put("hospitalName","বসুরহাট ডায়াগনষ্টিক সেন্টার ");
        hashMap.put("dcTime","প্রতি শুক্রবার সকাল ১০টা-দুপুর ২টা");
        arrayList.add(hashMap);

    }
}