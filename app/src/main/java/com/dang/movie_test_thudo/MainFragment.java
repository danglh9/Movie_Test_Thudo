package com.dang.movie_test_thudo;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;

import com.dang.movie_test_thudo.model.Movie;
import com.dang.movie_test_thudo.presenter.MoviePresenterSelector;

public class MainFragment extends BrowseSupportFragment {
    private ArrayObjectAdapter rowsAdapter;
    private boolean isLoading = false;
    private int currentPage = 0;
    private static final int PAGE_SIZE = 25;
    private static final int MAX_CATEGORY = 200; // nếu bạn muốn giới hạn

    private final String TAG = MainFragment.class.getName();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setupUI();
        setupAdapter();
        loadMoreRows();
        setOnItemViewSelectedListener((itemViewHolder, item, rowViewHolder, row) -> {
            int lastIndex = rowsAdapter.size() - 1;
            int currentIndex = rowsAdapter.indexOf(row);
            if (!isLoading && currentIndex >= lastIndex - 3) {
                Log.i(TAG, "onActivityCreated: LOAD MORE...." + currentPage + " "+ isLoading);
                loadMoreRows();
            }
        });

        setupEventListeners();
    }

    private void setupEventListeners() {
        setOnItemViewClickedListener((itemViewHolder, item, rowViewHolder, row) -> {
            if (item instanceof Movie) {
                Movie movie = (Movie) item;
                String demoUrl = "https://vip.opstream17.com/20240224/1272_8231dfa9/3000k/hls/mixed.m3u8";
                Intent intent = new Intent(getActivity(), PlayerActivity.class);
                intent.putExtra("title", movie.getTitle());
                intent.putExtra("url",demoUrl);
                startActivity(intent);
                Log.d("CLICK", "Clicked movie: " + movie.getTitle());

            }
        });
    }

    private void setupUI() {
        setTitle("Kho Phim");
        setHeadersState(HEADERS_ENABLED);
        setHeadersTransitionOnBackEnabled(true); // Không cần chuyển animation
        setBrandColor(Color.parseColor("#4d4d4d"));
        rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        setAdapter(rowsAdapter);
    }

    private void setupAdapter() {
        rowsAdapter = new ArrayObjectAdapter(new ListRowPresenter());
        setAdapter(rowsAdapter);
    }

    private void loadMoreRows() {
        Log.i(TAG, "loadMoreRows: "+currentPage +" isLoading:"+ isLoading);
        if (isLoading || currentPage * PAGE_SIZE >= MAX_CATEGORY) return;
        isLoading = true;

        getView().post(() -> {
            for (int i = 0; i < PAGE_SIZE && currentPage * PAGE_SIZE + i < MAX_CATEGORY; i++) {
                int categoryIndex = currentPage * PAGE_SIZE + i;
                ArrayObjectAdapter listRowAdapter = new ArrayObjectAdapter(new MoviePresenterSelector());

                int viewType = Math.random() < 0.5 ? 1 : 2;
                for (int j = 0; j < 25; j++) {
                    listRowAdapter.add(new Movie(j + 1, "Phim " + (j+1), "https://your_image_url", viewType));
                }

                HeaderItem header = new HeaderItem(categoryIndex, "Danh mục " + categoryIndex);
                rowsAdapter.add(new ListRow(header, listRowAdapter));
            }

            currentPage++;
            isLoading = false;
        });
    }


}
