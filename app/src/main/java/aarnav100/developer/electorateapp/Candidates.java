package aarnav100.developer.electorateapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Candidates extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_candidates);
        getSupportActionBar().setTitle("Candidates");
    }
}
