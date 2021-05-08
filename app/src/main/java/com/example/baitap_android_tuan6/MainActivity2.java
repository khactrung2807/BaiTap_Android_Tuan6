package com.example.baitap_android_tuan6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private static ArrayList<Poular> arrayList;
    private ListView listView;
    private AdapterList adapterList;
    static {
        arrayList = new ArrayList<>();
    }
    private TextView tvTotal;
    private TextView tvSub;
    private TextView tvQuan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listView = findViewById(R.id.lvPoular);
        tvSub = findViewById(R.id.tvSubPrice);
        tvTotal = findViewById(R.id.tvTotalPrice);

        Intent intent = getIntent();
        Poular p = (Poular) intent.getSerializableExtra("poular");
        arrayList.add(p);

        double sub = 0;
        for (Poular pou : arrayList) {
            sub += Double.parseDouble(pou.getPricePoular());
        }
        tvSub.setText("$"+String.valueOf(sub));
        tvTotal.setText("$"+String.valueOf(sub));

        adapterList = new AdapterList(this,R.layout.listview_item,arrayList);
        listView.setAdapter(adapterList);
    }
}