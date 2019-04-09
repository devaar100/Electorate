package aarnav100.developer.electorateapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Candidates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidates);
        getSupportActionBar().setTitle("Candidates");
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = null;
                if(view.getId()==R.id.cand1){
                    url = "http://docs2.myneta.info/affidavits/ews3ls2014/65/Dr%20Harsh%20Vardhan.pdf";

                } else{
                    url = "http://docs2.myneta.info/affidavits/ews3ls2014/491/U05_01_05_Kapil%20Sibal.pdf";
                }
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                startActivity(i);
            }
        };
        findViewById(R.id.cand1).setOnClickListener(ocl);
        findViewById(R.id.cand2).setOnClickListener(ocl);
    }
}
