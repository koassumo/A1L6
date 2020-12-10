package com.geekbrains.a1l6_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    Button addItemBtn, removeItemBtn, moveBtn;

    RecyclerViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initRecyclerView();
        initBtnsOnClick();
    }

    private void initViews() {
        recyclerView = findViewById(R.id.recyclerView);
        addItemBtn = findViewById(R.id.addBtn);
        removeItemBtn = findViewById(R.id.removeBtn);
        moveBtn = findViewById(R.id.moveBtn);
    }

    private void initRecyclerView() {
        DataClass[] data = new DataClass[] {
                new DataClass(ContextCompat.getDrawable(getApplicationContext(), R.drawable.bamby),
                        "Олененок", true),
                new DataClass(ContextCompat.getDrawable(getApplicationContext(), R.drawable.flowers),
                        "Цветы", false),
                new DataClass(ContextCompat.getDrawable(getApplicationContext(), R.drawable.grass),
                        "Трава", true),
                new DataClass(ContextCompat.getDrawable(getApplicationContext(), R.drawable.halftree),
                        "Пень", false),
                new DataClass(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nature),
                        "Природа", true),
                new DataClass(ContextCompat.getDrawable(getApplicationContext(), R.drawable.plante_feuilles),
                        "Листья", true),
                new DataClass(ContextCompat.getDrawable(getApplicationContext(), R.drawable.tree_and_grass),
                        "Дерево и трава", true),
                new DataClass(ContextCompat.getDrawable(getApplicationContext(), R.drawable.tree_and_lake),
                        "Дерево и озеро", false)};

        ArrayList<DataClass> list = new ArrayList<>(data.length);
        list.addAll(Arrays.asList(data));

        //GridLayoutManager layoutManager = new GridLayoutManager(getBaseContext(), 3);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getBaseContext());
        adapter = new RecyclerViewAdapter(list);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void initBtnsOnClick() {
        addItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataClass dataClass = new DataClass(ContextCompat.getDrawable(getApplicationContext(), R.drawable.tree_and_lake),
                        "Дерево и озеро", false);
                adapter.addItem(dataClass);
            }
        });

        removeItemBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.removeItem();
            }
        });

        moveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.moveElement();
            }
        });
    }
}
