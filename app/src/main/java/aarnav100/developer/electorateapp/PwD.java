package aarnav100.developer.electorateapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PwD extends AppCompatActivity {
    String pwd_app = "https://play.google.com/store/apps/details?id=pwd.eci.com.pwdapp&hl=en_IN";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw_d);
        getSupportActionBar().setTitle("PwD - Divyang Facilities");
    }
}
