package com.rop.moviestreamer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rop.moviestreamer.R;
import com.rop.moviestreamer.model.AllCategory;
import com.rop.moviestreamer.model.CategoryItem;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainRecyclerAdapter extends RecyclerView.Adapter<MainRecyclerAdapter.MainViewHolder> {
    Context context;
    List<AllCategory> allCategoryList;

    public MainRecyclerAdapter(Context context, List<AllCategory> allCategoryList) {
        this.context = context;
        this.allCategoryList = allCategoryList;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MainViewHolder(LayoutInflater.from(context).inflate(R.layout.main_recycler_row_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, final int position) {
        holder.categoryName.setText(allCategoryList.get(position).getCategoryTitle());
        setItemRecycler(holder.itemRecycler,allCategoryList.get(position).getCategoryItemList());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,allCategoryList.get(position).getCategoryTitle()+"",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return allCategoryList.size();
    }


    public static final class MainViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        RecyclerView itemRecycler;


        public MainViewHolder(@NonNull View itemView){
            super(itemView);
            categoryName = itemView.findViewById(R.id.item_category);
            itemRecycler = itemView.findViewById(R.id.item_recycler);
        }
    }

    private void setItemRecycler(RecyclerView recyclerView, List<CategoryItem> categoryItemList){
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(context,categoryItemList);
        recyclerView.setLayoutManager(new LinearLayoutManager(context, RecyclerView.HORIZONTAL,false));
        recyclerView.setAdapter(itemRecyclerAdapter);
    }
}
