package com.example.jesseviauandroidtest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jesseviauandroidtest.pojo.Term;

import java.util.ArrayList;

public class CustomRecyclerViewAdapter extends RecyclerView.Adapter<CustomRecyclerViewAdapter.CustomViewHolder> {

    private ArrayList<Term> Terms;

    public CustomRecyclerViewAdapter(ArrayList<Term> Terms){
        this.Terms = Terms;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listview_item, null);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Term term  = Terms.get(position);
        holder.name.setText(term.getName());
        holder.description.setText(term.getDefinition());
    }

    @Override
    public int getItemCount() {
        if(Terms != null){
            return Terms.size();
        }
        return 0;
    }

    class CustomViewHolder extends  RecyclerView.ViewHolder{
        protected TextView name;
        protected TextView description;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            this.name = itemView.findViewById(R.id.name);
            this.description = itemView.findViewById(R.id.itemDescription);
        }
    }

}
