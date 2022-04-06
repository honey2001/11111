package com.example.mynotes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.mynotes.R;
import com.example.mynotes.adapter.NoteAdapter;
import com.example.mynotes.model.Note;
import com.example.mynotes.model.NoteUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<Note> noteData;
    NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    private void init(){

        recyclerView= findViewById(R.id.rv_notes);
        noteData= NoteUtils.getInstance().getAll();



        noteAdapter= new NoteAdapter(noteData);
        recyclerView.setAdapter(noteAdapter);
        StaggeredGridLayoutManager layoutManager= new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


    }


}