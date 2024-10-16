package Vatha;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

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

import com.example.unionservice.PdfViewer;
import com.example.unionservice.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import HealthPackage.DoctorProfile;
import HospitalNameList.ApplelyHospital;
import de.hdodenhof.circleimageview.CircleImageView;

public class SirajPurVatha extends AppCompatActivity {

    RecyclerView vathaRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_siraj_pur_vatha);
        vathaRecyclerView  = findViewById(R.id.vathaRecyclerView);
        toolbar  = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        DetailsTable();
        VathaSirajpurAdapter vathaSirajpurAdapter = new VathaSirajpurAdapter();
        vathaRecyclerView.setAdapter(vathaSirajpurAdapter);
        vathaRecyclerView.setLayoutManager(new LinearLayoutManager(SirajPurVatha.this));





    }

    private class VathaSirajpurAdapter extends RecyclerView.Adapter{
        private class readHolder extends RecyclerView.ViewHolder{
           Button vathaName;
           CardView vathaCard;


            public readHolder(@NonNull View itemView) {
                super(itemView);
                vathaName = itemView.findViewById(R.id.vathaName);
                vathaCard = itemView.findViewById(R.id.vathaCard);

            }
        }


        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.hospita_name_item, parent, false);
            return new readHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            readHolder readHolder = (readHolder) holder;
            hashMap = arrayList.get(position);
            String dName = hashMap.get("name");

            //Picasso.get().load(dcImage).placeholder(R.drawable.doctor).into(readHolder.dcImage);
            readHolder.vathaCard.startAnimation(AnimationUtils.loadAnimation(readHolder.vathaCard.getContext(),R.anim.recycler_anim03));
            readHolder.vathaName.setText(dName);


            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            readHolder.vathaName.setBackgroundColor(color);

            readHolder.vathaName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position==0){
                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/1IEoRC18EIR-mYtXx76RIcxAuRQRCWbvp/view?usp=sharing";
                        Intent intent = new Intent(SirajPurVatha.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(SirajPurVatha.this, ""+dName, Toast.LENGTH_SHORT).show();
                    }
                    else if (position==1) {
                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/1HTCg_TNRUNzSSs5PoSrOl0BFehTuAMfu/view?usp=sharing";
                        Intent intent = new Intent(SirajPurVatha.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(SirajPurVatha.this, ""+dName, Toast.LENGTH_SHORT).show();
                    }
                    else if (position==2) {

                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/1sECY9YhhTA3fqj2w2uQvOPZS2y71kes5/view?usp=sharing";
                        Intent intent = new Intent(SirajPurVatha.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(SirajPurVatha.this, ""+dName, Toast.LENGTH_SHORT).show();

                    }
                    else if (position==3) {

                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/1a_TcF77G1ip0KPiF2Y_akLX5jHLZ1RP_/view?usp=sharing\n";
                        Intent intent = new Intent(SirajPurVatha.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(SirajPurVatha.this, ""+dName, Toast.LENGTH_SHORT).show();
                    }

                }
            });



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
        hashMap.put("name","প্রতিবন্ধী ভাতাভোগীদের তালিকা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","প্রবাসীদের তালিকা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","বয়স্ক ভাতা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","বিধবা ভাতা");
        arrayList.add(hashMap);




    }
}