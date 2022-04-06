package com.example.mynotes.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mynotes.R;
import com.example.mynotes.model.Note;
import com.example.mynotes.model.NoteUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddActivity extends AppCompatActivity {
    EditText edtTitle;
    EditText edtDescription;
    Button btnSave;
    Button btnCanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        init();
        addListener();
    }

    private void init(){
        edtTitle= findViewById(R.id.edit_title);
        edtDescription= findViewById(R.id.edit_description);
        btnSave= findViewById(R.id.btn_save);
        btnCanel=findViewById(R.id.btn_cancel);

    }

    private void addListener(){
        btnCanel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title= edtTitle.getText().toString();
                String description = edtDescription.getText().toString();
                if( title.isEmpty()){
                    showToast("Ban chua nhap tieu de");
                    return;
                }
                if(description.isEmpty()){
                    showToast("ban chua nhap noi dung");
                    return;
                }
                SimpleDateFormat dateFormat =new SimpleDateFormat("dd/MM/yyy");
                Note note = new Note(title,description,dateFormat.format(new Date()));

                NoteUtils.getInstance().addNote(note);
                showToast("them moi thanh cong!");
                finish();
            }
        });
    }
    private void showToast(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}