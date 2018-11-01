package com.example.consultants.listlikeviews.view.listview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.consultants.listlikeviews.R;
import com.example.consultants.listlikeviews.model.PersonGenerator;
import com.example.consultants.listlikeviews.view.recyclerview.RecyclerViewActivity;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lvPersonList = findViewById(R.id.lvPerson);
        ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), R.layout.listview_item, PersonGenerator.generate(10));
        lvPersonList.setAdapter(adapter);
    }

    public void onRecyclerViewActivity(View view) {

        Intent intent = new Intent(getApplicationContext(), RecyclerViewActivity.class);
        startActivity(intent);
    }
}
