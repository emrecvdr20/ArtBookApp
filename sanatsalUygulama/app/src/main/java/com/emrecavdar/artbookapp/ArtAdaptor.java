package com.emrecavdar.artbookapp;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.emrecavdar.artbookapp.databinding.RecylerRowBinding;
import java.util.ArrayList;
public class ArtAdaptor extends RecyclerView.Adapter<ArtAdaptor.ArtHolder> {
    ArrayList<Art> artArrayList;
    public ArtAdaptor(ArrayList<Art> artArrayList) {
        this.artArrayList = artArrayList;
    }
    @NonNull
    @Override
    public ArtHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecylerRowBinding recylerRowBinding = RecylerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ArtHolder(recylerRowBinding);
    }
    @Override
    public void onBindViewHolder(@NonNull ArtHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.binding.recylerViewTextView.setText(artArrayList.get(position).name);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),MainActivity2.class);
                intent.putExtra("info","old");
                intent.putExtra("artId",artArrayList.get(position).id);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return artArrayList.size();
    }
    public class ArtHolder extends RecyclerView.ViewHolder{
        private RecylerRowBinding binding;
        public ArtHolder(RecylerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }
}