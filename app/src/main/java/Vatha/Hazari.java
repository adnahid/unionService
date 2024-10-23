package Vatha;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Hazari extends AppCompatActivity {

    RecyclerView HazariCorRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_hazari);
        HazariCorRecyclerView = findViewById(R.id.HazariCorRecyclerView);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });

        DetailsTable();
        HazariCorAdapter hazariCorAdapter = new HazariCorAdapter();
        HazariCorRecyclerView.setAdapter(hazariCorAdapter);
        HazariCorRecyclerView.setLayoutManager(new LinearLayoutManager(Hazari.this));

    }

    private class HazariCorAdapter extends RecyclerView.Adapter{
        private class readHolder extends RecyclerView.ViewHolder{
            Button vathaName;
            CardView vathaCard;


            public readHolder(@NonNull View itemView) {
                super(itemView);
                vathaName = itemView.findViewById(R.id.vathaName);
                //vathaCard = itemView.findViewById(R.id.vathaCard);

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
            readHolder.vathaName.startAnimation(AnimationUtils.loadAnimation(readHolder.vathaName.getContext(),R.anim.recycler_anim03));
            readHolder.vathaName.setText(dName);


            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            readHolder.vathaName.setBackgroundColor(color);

            readHolder.vathaName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (position==0){
                        // PdfViewer.assetsName = "companyganj.pdf";

                        PdfViewer.ToolText= dName;
                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/1a4m4VT8t6tTAEVlBAlx_sBJd4YRWHvBi/view?usp=sharing";
                        Intent intent = new Intent(Hazari.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(Hazari.this, ""+dName, Toast.LENGTH_SHORT).show();

                    }
                    else if (position==1) {

                        PdfViewer.ToolText= dName;
                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/14BORw3f8RouUSmjNfdU12l94OTT_3bEl/view?usp=sharing";
                        Intent intent = new Intent(Hazari.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(Hazari.this, ""+dName, Toast.LENGTH_SHORT).show();

                    }
                    else if (position==2) {

                        PdfViewer.ToolText= dName;
                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/1dbINhXMFWKKNrSYaj1uiI5WcnJFw211m/view?usp=sharing";
                        Intent intent = new Intent(Hazari.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(Hazari.this, ""+dName, Toast.LENGTH_SHORT).show();

                    }

                    else if (position==3) {

                        PdfViewer.ToolText= dName;
                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/1V-RbrJwNnX2oUVp68Y4go7O_ux-U1vlV/view?usp=sharing";
                        Intent intent = new Intent(Hazari.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(Hazari.this, ""+dName, Toast.LENGTH_SHORT).show();

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
        hashMap.put("name","চরহাজারি ইউনিয়ন বিধবা ভাতা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","চরহাজারী ইউনিয়ন প্রতিবন্ধী ভাতা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","চরহাজারী ইউনিয়ন বয়স্ক ভাতা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","চরহাজারী ইউনিয়ন মুক্তিযোদ্ধা ভাতা");
        arrayList.add(hashMap);




    }
}