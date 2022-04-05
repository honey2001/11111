package com.example.mynotes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.example.mynotes.R;
import com.example.mynotes.adapter.NoteAdapter;
import com.example.mynotes.model.Note;

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
        dummyData();

        noteAdapter= new NoteAdapter(noteData);
        recyclerView.setAdapter(noteAdapter);
        StaggeredGridLayoutManager layoutManager= new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);


    }

    private void dummyData(){
        noteData= new ArrayList<>();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd/MM/yyyy");
        for (int i=0; i<30; i++){


            noteData.add(new Note("Note"+i,"This is description"+i,dateFormat.format(new Date())));
        }

    }
}