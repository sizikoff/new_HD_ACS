package com.example.hd_acs.database4;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hd_acs.R;

public class StorageAdapter extends RecyclerView.Adapter<StorageAdapter.DefectViewHolder> {
    private Context mContext;
    private Cursor mCursor;

    public StorageAdapter(Context context, Cursor cursor){
        mContext = context;
        mCursor =cursor;
    }

    public class DefectViewHolder extends RecyclerView.ViewHolder {
        public TextView textView_material_stor;
        public TextView textView_time_stor;
        public TextView textView_color_stor;
        public TextView textView_amount_stor;


        public DefectViewHolder(@NonNull View itemView) {
            super(itemView);

            textView_material_stor = itemView.findViewById(R.id.textView_material_stor);
            textView_time_stor = itemView.findViewById(R.id.textView_time_stor);
            textView_color_stor = itemView.findViewById(R.id.textView_color_stor);
            textView_amount_stor = itemView.findViewById(R.id.textView_amount_stor);

        }
    }

    @NonNull
    @Override
    public DefectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_storage,parent,false);
        return new DefectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DefectViewHolder holder, int position) {
        //to make sure data is dispalyed on the item
        if(!mCursor.moveToPosition(position)){
            return;
        }

        String amount = mCursor.getString(mCursor.getColumnIndex(StorageContract.StorageEntry.COLUMN_AMOUNT));
        String color = mCursor.getString(mCursor.getColumnIndex(StorageContract.StorageEntry.COLUMN_COLOR));
        String material = mCursor.getString(mCursor.getColumnIndex(StorageContract.StorageEntry.COLUMN_MATERIAL));
        String time = mCursor.getString(mCursor.getColumnIndex(StorageContract.StorageEntry.COLUMN_TIMESTAMP));

        //read id out of the database
        long id = mCursor.getLong(mCursor.getColumnIndex(StorageContract.StorageEntry._ID));


        holder.textView_color_stor.setText(color);
        holder.textView_material_stor.setText(material);
        holder.textView_amount_stor.setText(String.valueOf(amount));
        holder.textView_time_stor.setText(String.valueOf(time));
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
