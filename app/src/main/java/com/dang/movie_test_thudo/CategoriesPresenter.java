//package com.dang.movie_test_thudo;
//
//import android.util.Log;
//
//import com.dang.movie_test_thudo.model.Category;
//import com.dang.movie_test_thudo.model.Movie;
//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.lang.reflect.Type;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class CategoriesPresenter implements CategoriesContract.Presenter {
//    private MovieContract.View view;
//
//    List<Category> categories = new ArrayList<>();
//    public CategoriesPresenter(MovieContract.View view) {
//        this.view = view;
//    }
//
//    @Override
//    public void loadCategories(InputStream is) {
////        List<Category> categories = loadCategories();
////        if (categories != null) {
////            view.showCategories(categories);
////            Log.d("CategoriesPresenter", "loadCategories: "+ categories.size());
////        } else {
////            view.showError("Không thể load dữ liệu");
////        }
//
//
//        //            InputStream is = get().open("categories_200x25_viewtype.json");
//        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
//
//        Gson gson = new Gson();
//        Type listType = new TypeToken<List<Category>>() {}.getType();
//        categories = gson.fromJson(reader, listType);
//        if (categories != null) {
//            view.showCategories(categories);
//            Log.d("CategoriesPresenter", "loadCategories: "+ categories.get(1).movies.size());
//        } else {
//            view.showError("Không thể load dữ liệu");
//        }
//
//        // Tiếp theo: truyền vào Adapter
////            adapter.setData(listCategorie);
//        //
//
//
//
//    }
//
//    @Override
//    public void onDestroy() {
//        view=null;
//    }
//}
