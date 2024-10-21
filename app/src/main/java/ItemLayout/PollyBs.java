package ItemLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.unionservice.PdfViewer;
import com.example.unionservice.R;
import com.example.unionservice.webViewActivity;

public class PollyBs extends AppCompatActivity {

    CardView pollApplicationRules,pollApplication,pMitter,jonalOffice,ovigok,pollInsdurstrialApplicationRules,
            pollInsdurstrialApplication,pollFree;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_polly_bs);
        pollApplicationRules = findViewById(R.id.pollApplicationRules);
        pollApplication = findViewById(R.id.pollApplication);
        pMitter = findViewById(R.id.pMitter);
        jonalOffice = findViewById(R.id.jonalOffice);
        ovigok = findViewById(R.id.ovigok);
        pollInsdurstrialApplicationRules = findViewById(R.id.pollInsdurstrialApplicationRules);
        pollInsdurstrialApplication = findViewById(R.id.pollInsdurstrialApplication);
        pollFree = findViewById(R.id.pollFree);
        toolbar = findViewById(R.id.toolbar);



        toolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });



        pollApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webViewActivity.ToolBarText = "নতুন সংযোগের জন্য আবেদন";
                webViewActivity.url = "http://www.rebpbs.com/";
                Intent intent = new Intent(PollyBs.this, webViewActivity.class);
                startActivity(intent);
            }
        });

        pollApplicationRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PdfViewer.assetsName = "pollyapplication.pdf";
                PdfViewer.ToolText = "আবেদনের নিয়ম";
                PdfViewer.pdfUrl = "https://drive.google.com/file/d/1U-hZP5f7JhgiydBdfK9WqrJU48-2q1Cr/view?usp=sharing";
                Intent intent = new Intent(PollyBs.this, PdfViewer.class);
                startActivity(intent);
            }
        });



        pollInsdurstrialApplicationRules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PdfViewer.assetsName = "indurstial.pdf";
                PdfViewer.ToolText = "শিল্প সংযোগ আবেদনের নিয়ম";
                PdfViewer.pdfUrl = "https://drive.google.com/file/d/1BHJ3XZldML1Bh8ouD5LjcV0iLeH-SrrY/view?usp=sharing";
                Intent intent = new Intent(PollyBs.this, PdfViewer.class);
                startActivity(intent);
            }
        });

        pollInsdurstrialApplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webViewActivity.ToolBarText = "শিল্প সংযোগের আবেদন";
                webViewActivity.url = "http://industry.rebpbs.com/UI/App/frm_main_application.aspx";
                Intent intent = new Intent(PollyBs.this, webViewActivity.class);
                startActivity(intent);
            }
        });


        pollFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webViewActivity.ToolBarText = "ফি পরিশোধ করণ";
                webViewActivity.url = "http://www.rebpbs.com/UI/App/frm_main_application.aspx";
                Intent intent = new Intent(PollyBs.this, webViewActivity.class);
                startActivity(intent);
            }
        });




        ovigok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webViewActivity.ToolBarText = "অভিযোগ কেন্দ্র";
                webViewActivity.url = "http://www.rebpbs.com/UI/frm_feedback.aspx";
                Intent intent = new Intent(PollyBs.this, webViewActivity.class);
                startActivity(intent);
            }
        });


        pollFree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webViewActivity.ToolBarText = "ফি পরিশোধ করণ";
                webViewActivity.url = "http://industry.rebpbs.com/UI/frm_payment_gateway.aspx";
                Intent intent = new Intent(PollyBs.this, webViewActivity.class);
                startActivity(intent);
            }
        });


    }
}