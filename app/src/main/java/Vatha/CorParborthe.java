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

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.unionservice.PdfViewer;
import com.example.unionservice.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class CorParborthe extends AppCompatActivity {
    RecyclerView AmtholiVathaRecyclerView;
    Toolbar toolbar;

    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_amtholi_vatha_list);
        AmtholiVathaRecyclerView = findViewById(R.id.AmtholiVathaRecyclerView);
        toolbar = findViewById(R.id.toolbar);

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


        DetailsTable();
        AmtholiVathaAdapter amtholiVathaAdapter  = new AmtholiVathaAdapter();
        AmtholiVathaRecyclerView.setAdapter(amtholiVathaAdapter);
        AmtholiVathaRecyclerView.setLayoutManager(new LinearLayoutManager(CorParborthe.this));


    }

    private class AmtholiVathaAdapter extends RecyclerView.Adapter{
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

                        PdfViewer.ToolText= dName;
                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/1uwZ1hi8CKaKDwOe1H0NfL28cYXnysAgS/view?usp=sharing\n";
                        Intent intent = new Intent(CorParborthe.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(CorParborthe.this, ""+dName, Toast.LENGTH_SHORT).show();

                    }
                    else if (position==1) {

                        PdfViewer.ToolText= dName;
                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/158ij8RA_-dBALzpwVQ6M6u13N1gW7WHB/view?usp=sharing";
                        Intent intent = new Intent(CorParborthe.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(CorParborthe.this, ""+dName, Toast.LENGTH_SHORT).show();


                    }
                    else if (position==2) {

                        PdfViewer.ToolText= dName;
                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/1U-4_6IONmabARg20wrDA8t5HaPEvN8UZ/view?usp=sharing\n";
                        Intent intent = new Intent(CorParborthe.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(CorParborthe.this, ""+dName, Toast.LENGTH_SHORT).show();

                    }

                    else if (position==3) {

                        PdfViewer.ToolText= dName;
                        PdfViewer.pdfUrl = "https://drive.google.com/file/d/1w6bBgJIFY4ECdYDNyAeVN9_oP7TrwDaw/view?usp=sharing";
                        Intent intent = new Intent(CorParborthe.this, PdfViewer.class);
                        startActivity(intent);
                        Toast.makeText(CorParborthe.this, ""+dName, Toast.LENGTH_SHORT).show();
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
        hashMap.put("name","চর পার্বতী প্রবাসী");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","চর পার্বতী বিধবা ভাতা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","চর পার্বতী বয়স্ক ভাতা");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("name","চর পার্বতী প্রতিবন্ধী ভাতা");
        arrayList.add(hashMap);






    }
}