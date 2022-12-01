package com.example.wedding.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.example.wedding.Adapter.PopularAdapter;
import com.example.wedding.Domain.Popular;
import com.example.wedding.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private RecyclerView.Adapter adapter, adapter2;
private RecyclerView recyclerViewPopularlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewPopular();
    }

    private void recyclerViewPopular() {
        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerViewPopularlist =findViewById(R.id.view1);
        recyclerViewPopularlist.setLayoutManager(linearLayoutManager);
        recyclerViewPopularlist.setItemAnimator(new DefaultItemAnimator());
        recyclerViewPopularlist.addItemDecoration(new DividerItemDecoration(MainActivity.this, LinearLayoutManager.VERTICAL));

        ArrayList<Popular> popularlist = new ArrayList<>();
        popularlist.add(new Popular(1,"Tôm hùm","hi hi hi",R.drawable.mon1));
        popularlist.add(new Popular(1,"Tôm hùm","hi hi hi",R.drawable.mon1));
        popularlist.add(new Popular(1,"Tôm hùm","hi hi hi",R.drawable.mon1));
        popularlist.add(new Popular(1,"Tôm hùm","hi hi hi",R.drawable.mon1));

        adapter = new PopularAdapter(popularlist);
        recyclerViewPopularlist.setAdapter(adapter);
    }
}