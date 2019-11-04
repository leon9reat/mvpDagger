package com.medialink.mvpmemorize.ui.extension;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseViewAdapter<I> extends RecyclerView.Adapter<BaseViewHolder> {
    private List<Object> items = new ArrayList<>();
    private ItemClickListener itemClickListener;

    public ItemClickListener getItemClickListener() {
        return itemClickListener;
    }

    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public List<Object> getItems() {
        return items;
    }

    public Object getItem(int position) {
        return items.get(position);
    }

    public void clearData() {
        int count = getItemCount();
        this.items.clear();
        notifyItemRangeRemoved(0, count);
    }

    public void setItems(List<I> items) {
        this.items.addAll(items);
        notifyItemRangeInserted(0, items.size());
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return createHolder(parent, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        bindHolder(holder, position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public abstract BaseViewHolder<I> createHolder(ViewGroup parent, int viewType);
    public abstract void bindHolder(BaseViewHolder holder, int position);

    public interface ItemClickListener<I> {
        void onItemClickListener(I item);
    }
}
