package com.example.hd_acs.database2;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hd_acs.R;

public class ZakazAdapter extends RecyclerView.Adapter<ZakazAdapter.GroceryViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public ZakazAdapter(Context context, Cursor cursor){
        mContext = context;
        mCursor =cursor;
    }

    public class GroceryViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_model_item;
        public TextView textView_material_item;
        public TextView textView_color_item;
        public TextView textView_amount_item;

        public GroceryViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_model_item = itemView.findViewById(R.id.textView_model_item);
            textView_material_item = itemView.findViewById(R.id.textView_material_item);
            textView_color_item = itemView.findViewById(R.id.textView_color_item);
            textView_amount_item = itemView.findViewById(R.id.textView_amount_item);
        }
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item,parent,false);
        return new GroceryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        //to make sure data is dispalyed on the item
        if(!mCursor.moveToPosition(position)){
            return;
        }
        String model = mCursor.getString(mCursor.getColumnIndex(ZakazContract.ZakazEntry.COLUMN_NAME));
        String amount = mCursor.getString(mCursor.getColumnIndex(ZakazContract.ZakazEntry.COLUMN_AMOUNT));
        String color = mCursor.getString(mCursor.getColumnIndex(ZakazContract.ZakazEntry.COLUMN_COLOR));
        String material = mCursor.getString(mCursor.getColumnIndex(ZakazContract.ZakazEntry.COLUMN_MATERIAL));

        //read id out of the database
        long id = mCursor.getLong(mCursor.getColumnIndex(ZakazContract.ZakazEntry._ID));


        holder.textView_model_item.setText(model);
        holder.textView_color_item.setText(color);
        holder.textView_material_item.setText(material);
        holder.textView_amount_item.setText(String.valueOf(amount));
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
