package com.android.testing1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DataContainer dataContainer = new DataContainer();
    ListView listView;
    TextView tvDetails;
    String [] details;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDetails = findViewById(R.id.tvDetails);
        details= getResources().getStringArray(R.array.descriptions);

        listView = findViewById(R.id.lvList);

        MyAdapter adapter = new MyAdapter(this, dataContainer.productName, dataContainer.productBrand, dataContainer.images);
        listView.setAdapter(adapter);

        //set item Click on list view

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for(int i = 0; i < 100; i++) {
                    if (position == i) {

                    }
                }
            }
        });





        //the phone is in landscape mode
        if ( findViewById(R.id.landscapeMode) != null)
        {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.detailsFrag))  // I want to show the detail fragment
                   // I want to show the list fragment
                    .commit();  //commit is to save everything that we've done so far
        }



    }


}


class MyAdapter extends ArrayAdapter<String>
{
        Context context;
        String [] rProduct;
        String [] rBrand;
        int [] rImgs;

        MyAdapter(Context c, String [] title, String [] description, int [] imgs) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rProduct = title;
            this.rBrand = description;
            this.rImgs = imgs;
        }


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            @SuppressLint("ViewHolder") View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            //set our resource on view
            images.setImageResource(rImgs[position]);
            myTitle.setText(rProduct[position]);
            myDescription.setText(rBrand[position]);

            return row;
        }


}




