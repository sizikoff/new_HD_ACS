package com.example.hd_acs.database;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hd_acs.database2.ZakazContract;
import com.example.hd_acs.R;

public class ProdAdapter extends RecyclerView.Adapter<ProdAdapter.ProdViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public ProdAdapter(Context context, Cursor cursor){
        mContext = context;
        mCursor =cursor;
    }

    public class ProdViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_model_item;
        public TextView textView_material_item;
        public TextView textView_color_item;
        public TextView textView_amount_item;
        public TextView textView_empl_prod;
        public TextView textView_time_prod;

        public ProdViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_model_item = itemView.findViewById(R.id.textView_model_prod);
            textView_material_item = itemView.findViewById(R.id.textView_material_prod);
            textView_color_item = itemView.findViewById(R.id.textView_color_prod);
            textView_amount_item = itemView.findViewById(R.id.textView_amount_prod);
            textView_empl_prod = itemView.findViewById(R.id.textView_emp_prod);
            textView_time_prod = itemView.findViewById(R.id.textView_time_prod);
        }
    }

    @NonNull
    @Override
    public ProdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_prod,parent,false);
        return new ProdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProdViewHolder holder, int position) {
        //to make sure data is dispalyed on the item
        if(!mCursor.moveToPosition(position)){
            return;
        }
        String model = mCursor.getString(mCursor.getColumnIndex(ProductionContract.ProductionEntry.COLUMN_MODEL));
        String amount = mCursor.getString(mCursor.getColumnIndex(ProductionContract.ProductionEntry.COLUMN_AMOUNT));
        String color = mCursor.getString(mCursor.getColumnIndex(ProductionContract.ProductionEntry.COLUMN_COLOR));
        String material = mCursor.getString(mCursor.getColumnIndex(ProductionContract.ProductionEntry.COLUMN_MATERIAL));
        String emp = mCursor.getString(mCursor.getColumnIndex(ProductionContract.ProductionEntry.COLUMN_EMPLOEYY));
        String time = mCursor.getString(mCursor.getColumnIndex(ProductionContract.ProductionEntry.COLUMN_TIMESTAMP));

        //read id out of the database
        long id = mCursor.getLong(mCursor.getColumnIndex(ZakazContract.ZakazEntry._ID));


        holder.textView_model_item.setText(model);
        holder.textView_color_item.setText(color);
        holder.textView_material_item.setText(material);
        holder.textView_amount_item.setText(String.valueOf(amount));
        holder.textView_empl_prod.setText(String.valueOf(emp));
        holder.textView_time_prod.setText(String.valueOf(time));
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
