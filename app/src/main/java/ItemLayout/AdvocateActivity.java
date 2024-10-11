package ItemLayout;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
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
import java.util.Random;

import Upzila.AminalOfficer;
import Upzila.UpzilaPersonProfile;
import de.hdodenhof.circleimageview.CircleImageView;

public class AdvocateActivity extends AppCompatActivity {

    RecyclerView advocateRecyclerView;
    Toolbar toolbar;
    ArrayList<HashMap<String,String>> arrayList = new ArrayList<>();
    HashMap<String,String> hashMap = new HashMap<>();
    String body="hi there";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_advocate);
        toolbar  = findViewById(R.id.toolbar);
        advocateRecyclerView = findViewById(R.id.advocateRecyclerView);
        DetailsTable();

        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


        AdvocateAdapter advocateAdapter = new AdvocateAdapter();
        advocateRecyclerView.setAdapter(advocateAdapter);
        advocateRecyclerView.setLayoutManager(new LinearLayoutManager(AdvocateActivity.this));


    }

    private class AdvocateAdapter extends RecyclerView.Adapter{

        int Native = 0;
        int Read = 1;


        private class readHolder extends RecyclerView.ViewHolder{
            TextView advocateName,advocateDegree;
            CircleImageView advocateImage;
            CardView advocateCardView;
            Button detailsBtn;


            public readHolder(@NonNull View itemView) {
                super(itemView);
                advocateName = itemView.findViewById(R.id.advocateName);
                advocateDegree = itemView.findViewById(R.id.advocateDegree);
                advocateImage = itemView.findViewById(R.id.advocateImage);
                advocateCardView = itemView.findViewById(R.id.advocateCardView);
                detailsBtn = itemView.findViewById(R.id.detailsBtn);




            }
        }

//        private class nativeHolder extends RecyclerView.ViewHolder{
//            TemplateView my_template;
//
//            public nativeHolder(@NonNull View itemView) {
//                super(itemView);
//                my_template = itemView.findViewById(R.id.my_template);
//            }
//        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = getLayoutInflater();

            View view = layoutInflater.inflate(R.layout.ad_item, parent, false);
            return new  readHolder(view);
//            if (viewType == Read) {
//                View view = layoutInflater.inflate(R.layout.ambulance_item, parent, false);
//                return new readHolder(view);
//
//            }

//            View view = layoutInflater.inflate(R.layout.native_item, parent, false);
//            return new nativeHolder(view);
        }


        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

            //if (getItemViewType(position)==Read){
            readHolder readHolder = (readHolder) holder;
            hashMap = arrayList.get(position);
            //hashMap = finalArrayList.get(position);
            String adName  = hashMap.get("adName");
            String adTitle = hashMap.get("adTitle");
            String adPhone  = hashMap.get("adPhone");
            String AdImage = hashMap.get("AdImage");
            String adGmail = hashMap.get("adGmail");
            String adChTex1st = hashMap.get("adChTex1st");
            String adChTex1stDes = hashMap.get("adChTex1stDes");
            String adChTex2nd = hashMap.get("adChTex2nd");
            String adChTex2ndDes = hashMap.get("adChTex2ndDes");

            readHolder.advocateCardView.startAnimation(AnimationUtils.loadAnimation(readHolder.advocateCardView.getContext(),R.anim.recycler_anim04));
            Picasso.get().load(AdImage).into(readHolder.advocateImage);


            readHolder.advocateName.setText(adName);
            readHolder.advocateDegree.setText(adTitle);

            Random rnd = new Random();
            int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
            readHolder.detailsBtn.setBackgroundColor(color);






            readHolder.advocateCardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(AdvocateActivity.this, LRDWProfileActivity.class);

                    LRDWProfileActivity.AdName = adName;
                    LRDWProfileActivity.AdTitle = adTitle;
                    LRDWProfileActivity.AdGm = adGmail;
                    LRDWProfileActivity.AdPh = adPhone;
                    LRDWProfileActivity.AdCh01 = adChTex1st;
                    LRDWProfileActivity.AdCh01Des = adChTex1stDes;
                    LRDWProfileActivity.AdCh02 = adChTex2nd;
                    LRDWProfileActivity.AdCh02Des = adChTex2ndDes;

                    Bitmap bitmap = ( (BitmapDrawable) readHolder.advocateImage.getDrawable() ).getBitmap();
                    LRDWProfileActivity.ImageBitmap = bitmap;

                    startActivity(intent);
                }
            });

//            readHolder.AmbmeassageImage.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
////                        Intent intent = new Intent(Intent.ACTION_SEND);
////                        intent = Intent.createChooser(intent,"sms:"+phoneNumber);
////                        startActivity(intent);
//
//                    Uri uri = Uri.parse("smsto:" + phoneNumber);
//
//                    Intent smsSIntent = new Intent(Intent.ACTION_SENDTO, uri);
//                    // add the message at the sms_body extra field
//                    smsSIntent.putExtra("sms_body", body);
//                    try{
//                        startActivity(smsSIntent);
//                    } catch (Exception ex) {
//                        Toast.makeText(AmbulanceList.this, "Your sms has failed...",
//                                Toast.LENGTH_LONG).show();
//                        ex.printStackTrace();
//                    }
//
//
//                }
//            });




            //}

//            else {
//                nativeHolder nativeHolder = (nativeHolder) holder;
//
//                AdLoader adLoader = new AdLoader.Builder(SadActivity.this, "ca-app-pub-8411075266548653/2415594861")
//                        .forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
//                            @Override
//                            public void onNativeAdLoaded(NativeAd nativeAd) {
//                                nativeHolder.my_template.setNativeAd(nativeAd);
//                            }
//                        })
//                        .build();
//
//                adLoader.loadAd(new AdRequest.Builder().build());
//            }


        }

        @Override
        public int getItemCount() {
            return arrayList.size();
            //return finalArrayList.size();
        }


//        @Override
//        public int getItemViewType(int position) {
//
//          //  hashMap = finalArrayList.get(position);
//            hashMap = arrayList.get(position);
//            String itemType = hashMap.get("itemType");
//            if (itemType.contains("read")) return Read;
//            else
//                return Native;
//
//        }

    }
//    private void finalArrayListTable(){
//
//        finalArrayList = new ArrayList<>();
//
//        for ( int x=0; x<arrayList.size(); x++){
//
//            if ( x>1 && x%30==0){
//                hashMap = new HashMap<>();
//                hashMap.put("itemType","NativeAd");
//                finalArrayList.add(hashMap);
//            }
//
//            hashMap = arrayList.get(x);
//            finalArrayList.add(hashMap);
//        }
//
//    }


    public void DetailsTable(){

        arrayList = new ArrayList<>();

        hashMap = new HashMap<>();
        hashMap.put("adName", "মোঃ হেফজুল বাহার");
        hashMap.put("adTitle", "এল.এল.বি (অনার্স), এল.এল.এম\n" +
                "এডভোকেট দেওয়ানী ও ফৌজদারী আদালত জজ কোর্ট, নোয়াখালী।");
        hashMap.put("adPhone", "01815-156552");
        hashMap.put("AdImage", "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("adGmail", "mhbahar6552@gmail.com");
        hashMap.put("adChTex1st", "বসুরহাট চেম্বার।");
        hashMap.put("adChTex1stDes", "রৌশন আরা মার্কেট, কবিরহাট রোড, বসুরহাট, কোম্পানীগঞ্জ, নোয়াখালী।");
        hashMap.put("adChTex2nd", "কোর্ট চেম্বার।");
        hashMap.put("adChTex2ndDes", "শাহাদাত এন্ড এসোসিয়েটস রুম নং-৯৮, জজ কোর্ট, নোয়াখালী।\n" +
                "নোয়াখালী");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("adName", "মোঃ হেফজুল বাহার");
        hashMap.put("adTitle", "এল.এল.বি (অনার্স), এল.এল.এম\n" +
                "এডভোকেট দেওয়ানী ও ফৌজদারী আদালত জজ কোর্ট, নোয়াখালী।");
        hashMap.put("adPhone", "01815-156552");
        hashMap.put("AdImage", "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("adGmail", "mhbahar6552@gmail.com");
        hashMap.put("adChTex1st", "বসুরহাট চেম্বার।");
        hashMap.put("adChTex1stDes", "রৌশন আরা মার্কেট, কবিরহাট রোড, বসুরহাট, কোম্পানীগঞ্জ, নোয়াখালী।");
        hashMap.put("adChTex2nd", "কোর্ট চেম্বার।");
        hashMap.put("adChTex2ndDes", "শাহাদাত এন্ড এসোসিয়েটস রুম নং-৯৮, জজ কোর্ট, নোয়াখালী।\n" +
                "নোয়াখালী");
        arrayList.add(hashMap);


        hashMap = new HashMap<>();
        hashMap.put("adName", "মোঃ হেফজুল বাহার");
        hashMap.put("adTitle", "এল.এল.বি (অনার্স), এল.এল.এম\n" +
                "এডভোকেট দেওয়ানী ও ফৌজদারী আদালত জজ কোর্ট, নোয়াখালী।");
        hashMap.put("adPhone", "01815-156552");
        hashMap.put("AdImage", "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("adGmail", "mhbahar6552@gmail.com");
        hashMap.put("adChTex1st", "বসুরহাট চেম্বার।");
        hashMap.put("adChTex1stDes", "রৌশন আরা মার্কেট, কবিরহাট রোড, বসুরহাট, কোম্পানীগঞ্জ, নোয়াখালী।");
        hashMap.put("adChTex2nd", "কোর্ট চেম্বার।");
        hashMap.put("adChTex2ndDes", "শাহাদাত এন্ড এসোসিয়েটস রুম নং-৯৮, জজ কোর্ট, নোয়াখালী।\n" +
                "নোয়াখালী");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("adName", "মোঃ হেফজুল বাহার");
        hashMap.put("adTitle", "এল.এল.বি (অনার্স), এল.এল.এম\n" +
                "এডভোকেট দেওয়ানী ও ফৌজদারী আদালত জজ কোর্ট, নোয়াখালী।");
        hashMap.put("adPhone", "01815-156552");
        hashMap.put("AdImage", "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("adGmail", "mhbahar6552@gmail.com");
        hashMap.put("adChTex1st", "বসুরহাট চেম্বার।");
        hashMap.put("adChTex1stDes", "রৌশন আরা মার্কেট, কবিরহাট রোড, বসুরহাট, কোম্পানীগঞ্জ, নোয়াখালী।");
        hashMap.put("adChTex2nd", "কোর্ট চেম্বার।");
        hashMap.put("adChTex2ndDes", "শাহাদাত এন্ড এসোসিয়েটস রুম নং-৯৮, জজ কোর্ট, নোয়াখালী।\n" +
                "নোয়াখালী");
        arrayList.add(hashMap);

        hashMap = new HashMap<>();
        hashMap.put("adName", "মোঃ হেফজুল বাহার");
        hashMap.put("adTitle", "এল.এল.বি (অনার্স), এল.এল.এম\n" +
                "এডভোকেট দেওয়ানী ও ফৌজদারী আদালত জজ কোর্ট, নোয়াখালী।");
        hashMap.put("adPhone", "01815-156552");
        hashMap.put("AdImage", "http://file-chittagong.portal.gov.bd/uploads/a490cfeb-992f-476d-9529-9d5ae5191e5f//640/5de/2bd/6405de2bd1438727275200.jpg");
        hashMap.put("adGmail", "mhbahar6552@gmail.com");
        hashMap.put("adChTex1st", "বসুরহাট চেম্বার।");
        hashMap.put("adChTex1stDes", "রৌশন আরা মার্কেট, কবিরহাট রোড, বসুরহাট, কোম্পানীগঞ্জ, নোয়াখালী।");
        hashMap.put("adChTex2nd", "কোর্ট চেম্বার।");
        hashMap.put("adChTex2ndDes", "শাহাদাত এন্ড এসোসিয়েটস রুম নং-৯৮, জজ কোর্ট, নোয়াখালী।\n" +
                "নোয়াখালী");
        arrayList.add(hashMap);






    }

}