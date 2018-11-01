package com.example.consultants.listlikeviews.view.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.consultants.listlikeviews.R;
import com.example.consultants.listlikeviews.model.Person;
import com.example.consultants.listlikeviews.model.PersonGenerator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends AppCompatActivity {

    @BindView(R.id.etPersonName)
    EditText etPersonName;
    @BindView(R.id.etPersonAge)
    EditText etPersonAge;
    @BindView(R.id.etPersonGender)
    EditText etPersonGender;

    RecyclerView rvPersonList;
    RecyclerViewAdapter adapter;
    RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        ButterKnife.bind(this);

        bindRecyclerView();

    }

    private void bindRecyclerView() {
        adapter = new RecyclerViewAdapter(PersonGenerator.generate(20));
        layoutManager = new LinearLayoutManager(this);
        rvPersonList = findViewById(R.id.rvPersonList);
        rvPersonList.setAdapter(adapter);
        rvPersonList.setLayoutManager(layoutManager);
    }


    public void onNewPerson(View view) {
        Person person = new Person(etPersonName.getText().toString(),
                etPersonAge.getText().toString(),
                etPersonGender.getText().toString());

        adapter.add(person);
        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
    }
}
