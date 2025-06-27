//package com.dang.movie_test_thudo;
//
//
//import android.app.Activity;
//import android.os.Bundle;
//import android.util.Log;
//
//import androidx.annotation.Nullable;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.dang.movie_test_thudo.adapter.CategoriesAdapter;
//import com.dang.movie_test_thudo.adapter.MovieAdapter;
//import com.dang.movie_test_thudo.model.Category;
//import com.dang.movie_test_thudo.model.Movie;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//
//
//public class CategoriesActivity extends Activity implements MovieContract.View {
//
//    public static final String TAG = CategoriesActivity.class.getName();
//    private RecyclerView rvCategories;
//    private CategoriesPresenter presenter;
//    private CategoriesAdapter adapter;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Log.d(TAG, "onCreate");
//
//        setContentView(R.layout.main_activity);
//
//        rvCategories = findViewById(R.id.rvCategories);
//        rvCategories.setLayoutManager(new LinearLayoutManager(this));
//        presenter = new CategoriesPresenter(this);
//        try {
//            InputStream is = getAssets().open("list.json");
//
////        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//        presenter.loadCategories(is);
//
//        adapter = new CategoriesAdapter(presenter.categories, this);
//        rvCategories.setAdapter(adapter);
//        Log.i(TAG, "onCreate: "+presenter.categories.size());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//    @Override
//    public void showCategories(List<Category> categoryList) {
//        Log.d(TAG, "showCategories: " + categoryList.size());
//
//
//    }
//
//    @Override
//    public void showError(String message) {
//
//    }
//}
