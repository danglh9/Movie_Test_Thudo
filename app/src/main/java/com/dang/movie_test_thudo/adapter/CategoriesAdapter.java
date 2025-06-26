//package com.dang.movie_test_thudo.adapter;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.dang.movie_test_thudo.R;
//import com.dang.movie_test_thudo.model.Category;
//import com.dang.movie_test_thudo.model.Movie;
//
//import java.util.List;
//
//public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.MovieViewHolder> {
//
//    private List<Category> categories;
//    private Context context;
//    private TextView tvCategoryTitle;
//
//    private RecyclerView rvMovies;
//    private MovieAdapter movieAdapter;
//
//    private final  String TAG= "CategoriesAdapter";
//
//
//    public CategoriesAdapter(List<Category> categories, Context context) {
//        this.context = context;
//        this.categories = categories;
//        Log.d(TAG, "categories size: "+ categories.size());
//
//    }
//
//    @NonNull
//    @Override
//    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_categories, parent, false);
//
//        tvCategoryTitle  = view.findViewById(R.id.tvCategoryTitle);
//        rvMovies = view.findViewById(R.id.rvMovies);
//
//
//        rvMovies.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL, false));
//
//
//
//        return new MovieViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
//        tvCategoryTitle.setText(categories.get(position).title);
////        Log.d("CategoriesAdapter", "onBindViewHolder: "+categories.get(position).title +" count Movie: "+ categories.get(position).movieList.size());
//        movieAdapter = new MovieAdapter(categories.get(position).movies, context, categories.get(position).viewType);
//        rvMovies.setDescendantFocusability(ViewGroup.FOCUS_AFTER_DESCENDANTS);
//        rvMovies.requestFocus(); // Nếu muốn chọn phần đầu tiên
//        rvMovies.setAdapter(movieAdapter);
//    }
//
//    @Override
//    public int getItemCount() {
//        int size = categories==null?0:categories.size();
//        Log.d(TAG, "getItemCount: "+ size);
//        return size;
//    }
//
//    public static class MovieViewHolder extends RecyclerView.ViewHolder{
//        ImageView ivMovie;
//
//        public MovieViewHolder(@NonNull View itemView) {
//            super(itemView);
//
//            ivMovie = itemView.findViewById(R.id.ivMovie);
//        }
//    }
//}
