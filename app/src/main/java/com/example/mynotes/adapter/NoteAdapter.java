package com.example.mynotes.adapter;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mynotes.R;
import com.example.mynotes.model.Note;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder>
{
    private ArrayList<Note> noteData;


    public NoteAdapter(ArrayList<Note> noteData){
        this.noteData= noteData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @androidx.annotation.NonNull ViewGroup viewGroup, int i) {
        View view= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_item_note, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @androidx.annotation.NonNull ViewHolder viewHolder, int i) {
        viewHolder.bindView(noteData.get(i));
    }

    @Override
    public int getItemCount() {
        return noteData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvCreateDate;
        ImageView imvDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            init(itemView);
        }

        private void init(View itemView) {
            tvTitle= itemView.findViewById(R.id.tv_title);
            tvCreateDate= itemView.findViewById(R.id.tv_create_date);
            imvDelete= itemView.findViewById(R.id.imv_delete);


        }

        private void bindView(Note note){
        tvTitle.setText(note.getTitle());
        tvCreateDate.setText(note.getCreateDate());
        }
    }
}
