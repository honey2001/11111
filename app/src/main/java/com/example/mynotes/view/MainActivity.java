package com.example.mynotes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.example.mynotes.R;
import com.example.mynotes.adapter.NoteAdapter;
import com.example.mynotes.model.Note;
import com.example.mynotes.model.NoteUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    FloatingActionButton fabAdd;
    RecyclerView recyclerView;
    ArrayList<Note> noteData;
    NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        addListener();
    }

    @Override
    protected void onResume() {
        super.onResume();

        noteAdapter.notifyDataSetChanged();
    }

    private void init(){

        recyclerView= findViewById(R.id.rv_notes);
        fabAdd= findViewById(R.id.fab_add);

        noteData= NoteUtils.getInstance().getAll();



        noteAdapter= new NoteAdapter(noteData);
        recyclerView.setAdapter(noteAdapter);
        StaggeredGridLayoutManager layoutManager= new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


    }
    private void addListener(){
        fabAdd.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v){
          goToAddActivity();
        }
    });

}
    private  void goToAddActivity(){
        Intent intent= new Intent(this, AddActivity.class);
    }

}