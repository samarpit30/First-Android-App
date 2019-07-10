package com.diginfoexpert.MBAutodeals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExampleAdpater extends RecyclerView.Adapter<ExampleAdpater.ExampleviewHolder> {

    private ArrayList<ExampleItem> mExampleList;

    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public void setOnItemClicListener(OnItemClickListener listener){
        mListener = listener;
    }

    public class  ExampleviewHolder extends RecyclerView.ViewHolder{

        public ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        public TextView mTextView3;
        public TextView mTextView4;

        public ExampleviewHolder(@NonNull View itemView, final OnItemClickListener listener) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.myImageView1);
            mTextView1 = itemView.findViewById(R.id.myTextView1);
            mTextView2 = itemView.findViewById(R.id.myTextView2);
            mTextView3 = itemView.findViewById(R.id.myTextView3);
            mTextView4 = itemView.findViewById(R.id.myTextView4);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }

    public ExampleAdpater(ArrayList<ExampleItem> exampleList){
        mExampleList = exampleList;
    }

    @NonNull
    @Override
    public ExampleviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.example_item, parent, false);
        ExampleviewHolder evh = new ExampleviewHolder(v, mListener);
        return  evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleviewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        holder.mImageView.setImageResource(currentItem.getImageResource());
        holder.mTextView1.setText(currentItem.getText1());
        holder.mTextView2.setText(currentItem.getText2());
        holder.mTextView3.setText(currentItem.getText3());
        holder.mTextView4.setText(currentItem.getText4());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }
}
