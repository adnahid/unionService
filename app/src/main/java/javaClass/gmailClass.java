package javaClass;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;

import androidx.core.content.ContextCompat;

import com.example.unionservice.MainActivity;

public class gmailClass {

   public static Context context;

    public static String mygmail = "myselfabout432@gmail.com";

    public static void gmailMethod(){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_TEXT, "Text you want to share");
        ContextCompat.startActivity(context, Intent.createChooser(intent, mygmail), null);





    }




}
