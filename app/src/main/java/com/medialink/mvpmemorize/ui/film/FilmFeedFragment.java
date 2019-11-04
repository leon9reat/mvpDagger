package com.medialink.mvpmemorize.ui.film;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.medialink.mvpmemorize.Injector;
import com.medialink.mvpmemorize.R;
import com.medialink.mvpmemorize.model.Film;
import com.medialink.mvpmemorize.repository.film.FilmRepository;
import com.medialink.mvpmemorize.ui.extension.BaseViewAdapter;

import java.util.List;

import javax.inject.Inject;


/**
 * A simple {@link Fragment} subclass.
 */
public class FilmFeedFragment extends Fragment
        implements FilmFeedContract.View {
    private RecyclerView recyclerView;
    private ConstraintLayout emptyLayout;
    @Inject
    FilmRepository repository;

    private FilmFeedContract.Presenter presenter;
    private FilmFeedAdapter adapter;


    public FilmFeedFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Injector.obtain(getActivity()).inject(this);
        new FilmFeedPresenter(this, repository);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_film_feed, container, false);
        recyclerView = view.findViewById(R.id.list_view);
        emptyLayout = view.findViewById(R.id.empty_view);
        setupRecyclerView();
        return view;
    }

    private void setupRecyclerView() {
        adapter = new FilmFeedAdapter();
        adapter.setItemClickListener(new BaseViewAdapter.ItemClickListener() {
            @Override
            public void onItemClickListener(Object item) {
                if (item instanceof Film) {
                    Toast.makeText(getContext(), "This is film " + ((Film) item).getTitle(), Toast.LENGTH_LONG);
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        if (presenter != null) {
            presenter.start();
        }
    }

    @Override
    public void setItemToView(List<Film> list) {
        emptyLayout.setVisibility(View.GONE);
        adapter.clearData();
        adapter.setItems(list);
    }

    @Override
    public void setNoDataLoadToView() {
        recyclerView.setVisibility(View.GONE);
        emptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void setErrorToView() {
        recyclerView.setVisibility(View.GONE);
        emptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void setPresenter(FilmFeedContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
