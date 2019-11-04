package com.medialink.mvpmemorize.ui.extension;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder<I> extends RecyclerView.ViewHolder {

    public BaseViewHolder(@LayoutRes int resId, @NonNull ViewGroup parent) {
        super(LayoutInflater.from(parent.getContext())
                .inflate(resId, parent, false));
    }

    public void bindView(I object) {};
}
