package com.dsc.android.bcamp1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context context;
    private LayoutInflater layoutInflater;
    private List<RecyclerViewData> recyclerViewDataList = new ArrayList<>();

    public RecyclerViewAdapter(Context context) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setRecyclerViewDataList(List<RecyclerViewData> recyclerViewDataList) {
        this.recyclerViewDataList = recyclerViewDataList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final RecyclerViewData data = recyclerViewDataList.get(position);
        holder.txtName.setText(data.getName());
        holder.txtEmail.setText(data.getEmail());
        Glide.with(context).load(data.getImage()).apply(RequestOptions.circleCropTransform())
                .into(holder.iconImg);
    }

    @Override
    public int getItemCount() {
        return recyclerViewDataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView txtName, txtEmail;
        ImageView iconImg;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.name_textView);
            txtEmail = itemView.findViewById(R.id.email_textView);
            iconImg = itemView.findViewById(R.id.icon_view);


        }
    }
}
