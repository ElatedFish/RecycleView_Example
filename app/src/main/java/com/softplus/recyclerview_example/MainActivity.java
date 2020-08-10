package com.softplus.recyclerview_example;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.HashMap;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinkedList<HashMap<String, String>> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv);

        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        generateData();

        RecyclerView.Adapter adapter = new MyAdapter(data);
        recyclerView.setAdapter(adapter);
    }

    private void generateData() {
        data = new LinkedList<>();

        for (int i = 0; i < 100; i++) {
            HashMap<String, String> row = new HashMap<>();
            int random = (int)(Math.random() * 100);
            row.put("title", "Title " + random);
            row.put("date", "Date: " + random);
            data.add(row);
        }
    }
}