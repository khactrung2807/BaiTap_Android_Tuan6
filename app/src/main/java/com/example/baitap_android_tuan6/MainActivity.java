package com.example.baitap_android_tuan6;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Poular> listPoular;
    private AdapterRecycler adapterRecycler;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private DatabaseHandler databaseHandler;
    private ImageButton imageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseHandler = new DatabaseHandler(this);
        imageButton = findViewById(R.id.imgButAdd);
        listPoular = new ArrayList<>();

        Poular p1 = new Poular(1,R.drawable.poular1,"250","Nice Armchair");
        Poular p2 = new Poular(2,R.drawable.poular2,"350","Morden Armchair");
        Poular p3 = new Poular(3,R.drawable.poular3,"350","Circle Armchair");
        Poular p4 = new Poular(4,R.drawable.poular4,"550","Matteo Armchair");
//
//        databaseHandler.addPoular(p1);
//        databaseHandler.addPoular(p2);
//        databaseHandler.addPoular(p3);
//        databaseHandler.addPoular(p4);

        listPoular = databaseHandler.getAllPoular();
        recyclerView = findViewById(R.id.recyclerView);
        adapterRecycler = new AdapterRecycler(listPoular);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setAdapter(adapterRecycler);
        recyclerView.setLayoutManager(layoutManager);

        adapterRecycler.setOnClick(new AdapterRecycler.onClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("poular",listPoular.get(position));
                startActivity(intent);
            }
        });
    }
}