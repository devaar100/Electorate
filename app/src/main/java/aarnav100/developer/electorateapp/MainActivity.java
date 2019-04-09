package aarnav100.developer.electorateapp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String lang = getSharedPreferences(CONST.MyPREFERENCES, this.MODE_PRIVATE).getString("language", "English");
        setLanguage(lang);
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = null;
                switch(view.getId()){
                    case R.id.btn1:
                        intent = new Intent(MainActivity.this,Constituency.class);
                        break;
                    case R.id.btn2:
                        intent = new Intent(MainActivity.this,Region.class);
                        break;
                    case R.id.btn3:
                        intent = new Intent(MainActivity.this,PwD.class);
                        break;
                    case R.id.btn4:
                        intent = new Intent(MainActivity.this,ThirdGender.class);
                        break;
                    case R.id.btn5:
                        intent = new Intent(MainActivity.this,Candidates.class);
                        break;
                    case R.id.btn6:
                        Toast.makeText(MainActivity.this, "Result yet to be declared", Toast.LENGTH_SHORT).show();
                        break;
                }
                if(intent!=null)
                    startActivity(intent);
            }
        };
        findViewById(R.id.btn1).setOnClickListener(ocl);
        findViewById(R.id.btn2).setOnClickListener(ocl);
        findViewById(R.id.btn3).setOnClickListener(ocl);
        findViewById(R.id.btn4).setOnClickListener(ocl);
        findViewById(R.id.btn5).setOnClickListener(ocl);
        findViewById(R.id.btn6).setOnClickListener(ocl);
    }

    void setLanguage(String lang){
        if(lang.equals("English")){
            ((Button)findViewById(R.id.btn1)).setText(R.string.btn1_eng);
            ((Button)findViewById(R.id.btn2)).setText(R.string.btn2_eng);
            ((Button)findViewById(R.id.btn3)).setText(R.string.btn3_eng);
            ((Button)findViewById(R.id.btn4)).setText(R.string.btn4_eng);
            ((Button)findViewById(R.id.btn5)).setText(R.string.btn5_eng);
            ((Button)findViewById(R.id.btn6)).setText(R.string.btn6_eng);
        } else{
            ((Button)findViewById(R.id.btn1)).setText(R.string.btn1_hin);
            ((Button)findViewById(R.id.btn2)).setText(R.string.btn2_hin);
            ((Button)findViewById(R.id.btn3)).setText(R.string.btn3_hin);
            ((Button)findViewById(R.id.btn4)).setText(R.string.btn4_hin);
            ((Button)findViewById(R.id.btn5)).setText(R.string.btn5_hin);
            ((Button)findViewById(R.id.btn6)).setText(R.string.btn6_hin);
        }
    }
}
