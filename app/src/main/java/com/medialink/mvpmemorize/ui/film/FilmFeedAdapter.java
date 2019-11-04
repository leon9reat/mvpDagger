package com.medialink.mvpmemorize.ui.film;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.LayoutRes;

import com.medialink.mvpmemorize.R;
import com.medialink.mvpmemorize.model.Film;
import com.medialink.mvpmemorize.ui.extension.BaseViewAdapter;
import com.medialink.mvpmemorize.ui.extension.BaseViewHolder;

public class FilmFeedAdapter extends BaseViewAdapter<Film> {

    @Override
    public BaseViewHolder<Film> createHolder(ViewGroup parent, int viewType) {
        return new FilmViewHolder(R.layout.view_film_item, parent);
    }

    @Override
    public void bindHolder(BaseViewHolder holder, int position) {
        holder.bindView(getItem(position));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getItemClickListener() == null) {
                    return;
                }

                getItemClickListener().onItemClickListener(getItem(position));
            }
        });
    }

    public static class FilmViewHolder extends BaseViewHolder<Film> {
        TextView tvTitle;

        public FilmViewHolder(@LayoutRes int resId, ViewGroup parent) {
            super(resId, parent);
            tvTitle = itemView.findViewById(R.id.title);
        }

        @Override
        public void bindView(final Film film) {
            tvTitle.setText(film.getTitle());
        }
    }
}
