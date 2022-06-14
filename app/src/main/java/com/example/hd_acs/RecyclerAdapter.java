package com.example.hd_acs;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private Context context;

    ArrayList<Data> arrayList = new ArrayList<>();
    public RecyclerAdapter(Context context ,ArrayList<Data> arrayList){
        this.arrayList = arrayList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Data data = arrayList.get(position);
        holder.title.setText(data.getTitle());

        holder.title.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(holder.title.getText().equals("Панама")){
                    context.startActivity(new Intent(context, HatsPanamaActivity.class));
                }else if(holder.title.getText().equals("Шляпа")) {
                    context.startActivity(new Intent(context, HatsHatActivity.class));
                }else if(holder.title.getText().equals("Козырёк")) {
                    context.startActivity(new Intent(context, HatsVisorActivity.class));
                }else if(holder.title.getText().equals("Картуз")) {
                    context.startActivity(new Intent(context, HatsKartuzActivity.class));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
        }
    }
}
