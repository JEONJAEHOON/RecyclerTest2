package com.example.recyclertest2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * 홍드로이드 강의 내용
 * */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder>{

    private ArrayList<MainData> arrayList;

    public MainAdapter(ArrayList<MainData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.img.setImageResource(arrayList.get(position).getImg());
        holder.tv1.setText(arrayList.get(position).getTv1());
        holder.tv2.setText(arrayList.get(position).getTv2());

//        holder.itemView.setTag(position);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String curName = holder.tv1.getText().toString();
//                Toast.makeText(view.getContext(), curName, Toast.LENGTH_SHORT).show();;
//            }
//        });
//
//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View view) {
//                remove(holder.getAdapterPosition());
//
//                return true;
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position) {
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected ImageView img;
        protected TextView tv1;
        protected TextView tv2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.img = (ImageView) itemView.findViewById(R.id.img);
            this.tv1 = (TextView) itemView.findViewById(R.id.tv1);
            this.tv2 = (TextView) itemView.findViewById(R.id.tv2);
        }
    }
}
