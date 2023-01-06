package com.example.hiltretrofitjavagitsearch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.hiltretrofitjavagitsearch.adapter.RecyclerViewAdapter;
import com.example.hiltretrofitjavagitsearch.model.RecyclerData;
import com.example.hiltretrofitjavagitsearch.viewmodel.MainActivityViewModel;

import java.util.List;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {
    private RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
        initViewModel();

    }

    private void initViewModel() {
        MainActivityViewModel viewmodel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        viewmodel.getLiveData().observe(this, new Observer<List<RecyclerData>>() {
            @Override
            public void onChanged(List<RecyclerData> recyclerData) {
                if(recyclerData != null){
                    recyclerViewAdapter.setListItems(recyclerData);
                    recyclerViewAdapter.notifyDataSetChanged();
                }
                else{
                    Toast.makeText(MainActivity.this,"Error",Toast.LENGTH_SHORT).show();
                }

            }
        });
    viewmodel.makeAPICall();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter();
        recyclerView.setAdapter(recyclerViewAdapter);

    }
}