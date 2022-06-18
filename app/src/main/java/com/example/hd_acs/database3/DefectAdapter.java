package com.example.hd_acs.database3;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hd_acs.R;

public class DefectAdapter extends RecyclerView.Adapter<DefectAdapter.DefectViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public DefectAdapter(Context context, Cursor cursor){
        mContext = context;
        mCursor =cursor;
    }

    public class DefectViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_model_item;
        public TextView textView_material_item;
        public TextView textView_color_item;
        public TextView textView_amount_item;
        public TextView textView_time_prod;
        public TextView textView_emp_prod;

        public DefectViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_model_item = itemView.findViewById(R.id.textView_model_prod);
            textView_material_item = itemView.findViewById(R.id.textView_material_prod);
            textView_color_item = itemView.findViewById(R.id.textView_color_prod);
            textView_amount_item = itemView.findViewById(R.id.textView_amount_prod);
            textView_time_prod = itemView.findViewById(R.id.textView_time_prod);
            textView_emp_prod = itemView.findViewById(R.id.textView_emp_prod);
        }
    }

    @NonNull
    @Override
    public DefectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_prod,parent,false);
        return new DefectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DefectViewHolder holder, int position) {
        //to make sure data is dispalyed on the item
        if(!mCursor.moveToPosition(position)){
            return;
        }
        String model = mCursor.getString(mCursor.getColumnIndex(DefectContract.DefectEntry.COLUMN_MODEL));
        String amount = mCursor.getString(mCursor.getColumnIndex(DefectContract.DefectEntry.COLUMN_AMOUNT));
        String color = mCursor.getString(mCursor.getColumnIndex(DefectContract.DefectEntry.COLUMN_COLOR));
        String material = mCursor.getString(mCursor.getColumnIndex(DefectContract.DefectEntry.COLUMN_MATERIAL));
        String empl = mCursor.getString(mCursor.getColumnIndex(DefectContract.DefectEntry.COLUMN_EMPLOEYY));
        String time = mCursor.getString(mCursor.getColumnIndex(DefectContract.DefectEntry.COLUMN_TIMESTAMP));

        //read id out of the database
        long id = mCursor.getLong(mCursor.getColumnIndex(DefectContract.DefectEntry._ID));


        holder.textView_model_item.setText(model);
        holder.textView_color_item.setText(color);
        holder.textView_material_item.setText(material);
        holder.textView_amount_item.setText(String.valueOf(amount));
        holder.textView_time_prod.setText(String.valueOf(time));
        holder.textView_emp_prod.setText(String.valueOf(empl));
        holder.itemView.setTag(id);

    }

    @Override
    public int getItemCount() {
        return mCursor.getCount();
    }

    public void swapCursor(Cursor newCursor){
        if(mCursor!=null){
            mCursor.close();
            mCursor = newCursor;

            if(newCursor!=null){
                notifyDataSetChanged();
            }
        }
    }
}
