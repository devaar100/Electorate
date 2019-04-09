package aarnav100.developer.electorateapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class Settings extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        sharedpreferences = getSharedPreferences(CONST.MyPREFERENCES, this.MODE_PRIVATE);
        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor = sharedpreferences.edit();
                if(view.getId()==R.id.rad_hindi){
                    editor.putString("language", "Hindi");
                } else{
                    editor.putString("language", "English");
                }
                editor.commit();
                startActivity(new Intent(Settings.this,MainActivity.class));
            }
        };
        findViewById(R.id.rad_hindi).setOnClickListener(ocl);
        findViewById(R.id.rad_english).setOnClickListener(ocl);
    }
}
