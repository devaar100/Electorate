package aarnav100.developer.electorateapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Region extends AppCompatActivity {

    ListView listView;
    ArrayList<Locality> localities;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_region);
        getSupportActionBar().setTitle("Shakur Basti");
        localities = new ArrayList();
        localities.add(new Locality(1,"PASCHIM VIHAR","1 - SHIVA ENCLAVE A-4, PASCHIM VIHAR, 2 - STAFF QTRS. BHARTIYA VIDYAPEETH EDUCATIONAL COMPLEX, A-4, PASCHIM VIHAR, 3 - NIVEDITA ENCLAVE, A-6 PASCHIM VIHAR"));
        localities.add(new Locality(2,"PASCHIM VIHAR","1 - SHIVA ENCLAVE A-4, PASCHIM VIHAR, 2 - STAFF QTRS. BHARTIYA VIDYAPEETH EDUCATIONAL COMPLEX, A-4, PASCHIM VIHAR, 3 - NIVEDITA ENCLAVE, A-6 PASCHIM VIHAR"));
        localities.add(new Locality(3,"PASCHIM VIHAR","1 - SHIVA ENCLAVE A-4, PASCHIM VIHAR, 2 - STAFF QTRS. BHARTIYA VIDYAPEETH EDUCATIONAL COMPLEX, A-4, PASCHIM VIHAR, 3 - NIVEDITA ENCLAVE, A-6 PASCHIM VIHAR"));
        localities.add(new Locality(4,"PASCHIM VIHAR","1 - SHIVA ENCLAVE A-4, PASCHIM VIHAR, 2 - STAFF QTRS. BHARTIYA VIDYAPEETH EDUCATIONAL COMPLEX, A-4, PASCHIM VIHAR, 3 - NIVEDITA ENCLAVE, A-6 PASCHIM VIHAR"));
        localities.add(new Locality(5,"PASCHIM VIHAR","1 - SHIVA ENCLAVE A-4, PASCHIM VIHAR, 2 - STAFF QTRS. BHARTIYA VIDYAPEETH EDUCATIONAL COMPLEX, A-4, PASCHIM VIHAR, 3 - NIVEDITA ENCLAVE, A-6 PASCHIM VIHAR"));
        localities.add(new Locality(6,"PASCHIM VIHAR","1 - SHIVA ENCLAVE A-4, PASCHIM VIHAR, 2 - STAFF QTRS. BHARTIYA VIDYAPEETH EDUCATIONAL COMPLEX, A-4, PASCHIM VIHAR, 3 - NIVEDITA ENCLAVE, A-6 PASCHIM VIHAR"));
        localities.add(new Locality(7,"PASCHIM VIHAR","1 - SHIVA ENCLAVE A-4, PASCHIM VIHAR, 2 - STAFF QTRS. BHARTIYA VIDYAPEETH EDUCATIONAL COMPLEX, A-4, PASCHIM VIHAR, 3 - NIVEDITA ENCLAVE, A-6 PASCHIM VIHAR"));
        localities.add(new Locality(8,"PASCHIM VIHAR","1 - SHIVA ENCLAVE A-4, PASCHIM VIHAR, 2 - STAFF QTRS. BHARTIYA VIDYAPEETH EDUCATIONAL COMPLEX, A-4, PASCHIM VIHAR, 3 - NIVEDITA ENCLAVE, A-6 PASCHIM VIHAR"));
        localities.add(new Locality(9,"PASCHIM VIHAR","1 - SHIVA ENCLAVE A-4, PASCHIM VIHAR, 2 - STAFF QTRS. BHARTIYA VIDYAPEETH EDUCATIONAL COMPLEX, A-4, PASCHIM VIHAR, 3 - NIVEDITA ENCLAVE, A-6 PASCHIM VIHAR"));
        localities.add(new Locality(10,"PASCHIM VIHAR","1 - SHIVA ENCLAVE A-4, PASCHIM VIHAR, 2 - STAFF QTRS. BHARTIYA VIDYAPEETH EDUCATIONAL COMPLEX, A-4, PASCHIM VIHAR, 3 - NIVEDITA ENCLAVE, A-6 PASCHIM VIHAR"));
        listView = (ListView)findViewById(R.id.listview);
        listView.setAdapter(new LocalityAdapter());
    }

    private class LocalityAdapter extends BaseAdapter {

        View.OnClickListener ocl = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Region.this, aarnav100.developer.electorateapp.Locality.class));
            }
        };

        @Override
        public int getCount() {
            return localities.size();
        }

        @Override
        public Locality getItem(int i) {
            return localities.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = getLayoutInflater().inflate(R.layout.locality_list_item, null);
            Locality locality = getItem(i);
            ((TextView) v.findViewById(R.id.partNumber)).setText(locality.getNum());
            ((TextView) v.findViewById(R.id.locality)).setText(locality.getLocality());
            ((TextView) v.findViewById(R.id.localityDetails)).setText(locality.getLocalityDetails());
            v.setOnClickListener(ocl);
            return v;
        }
    }

    private class Locality {
        int num;
        String locality;
        String localityDetails;

        public Locality(int num, String locality, String localityDetails) {
            this.num = num;
            this.locality = locality;
            this.localityDetails = localityDetails;
        }

        public String getNum() {
            return String.valueOf(num);
        }

        public String getLocality() {
            return locality;
        }

        public String getLocalityDetails() {
            return localityDetails;
        }
    }

}
