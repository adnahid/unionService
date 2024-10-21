package ItemLayout;

import android.content.ClipData;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.unionservice.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

public class DetailsUnion extends AppCompatActivity {

    Toolbar toolbar;
    public static String DetailsText  = "";
    public static String UnionToolTex  = "";
    TextView unionDetailsTex;
    FloatingActionButton copyBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_details_union);

        unionDetailsTex = findViewById(R.id.unionDetailsTex);
        toolbar = findViewById(R.id.toolbar);
        copyBtn = findViewById(R.id.copyBtn);


        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


        copyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ClipboardManager _clipboard = (ClipboardManager) getSystemService(DetailsUnion.CLIPBOARD_SERVICE);
                _clipboard.setText(DetailsText);

//                ClipboardManager clipboard = (ClipboardManager) getSystemService(DetailsUnion.CLIPBOARD_SERVICE);
//                ClipData clip = ClipData.newPlainText("copy",DetailsText);
//                clipboard.pr(clip);
                Toast.makeText(DetailsUnion.this, "কপি", Toast.LENGTH_SHORT).show();

            }
        });

        toolbar.setTitle(UnionToolTex);
        unionDetailsTex.setText(DetailsText);





    }



//    private void copyToClipboard(String text) {
//        ClipboardManager clipboard = (ClipboardManager) getSystemService(DetailsUnion.CLIPBOARD_SERVICE);
//        ClipData clip = ClipData.newPlainText("Copied Text", text);
//        clipboard.notifyAll();
//
//    }
}