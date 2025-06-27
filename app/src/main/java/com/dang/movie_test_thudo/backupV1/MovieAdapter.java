//package com.dang.movie_test_thudo.adapter;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.KeyEvent;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.dang.movie_test_thudo.R;
//import com.dang.movie_test_thudo.model.Movie;
//
//import java.util.List;
//
//public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
//
//    private List<Movie> movies;
//    private Context context;
//
//    private int viewType;
//
//
//    public MovieAdapter(List<Movie> movies,Context context, int viewType) {
//        this.context  = context;
//        this.movies = movies;
//        this.viewType = viewType;
//    }
//
//    @NonNull
//    @Override
//    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = this.viewType == 1 ? LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_movie_horizontal, parent, false):
//                LayoutInflater.from(parent.getContext())
//                        .inflate(R.layout.item_movie_vertical, parent, false);
//        return new MovieViewHolder(view);
//    }
//
//    @Override
//    public void onViewAttachedToWindow(@NonNull MovieViewHolder holder) {
//        super.onViewAttachedToWindow(holder);
//        holder.itemView.setFocusable(true);
//        holder.itemView.setFocusableInTouchMode(true);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
////        holder.ivMovie.setImageURI(Uri.movies.get(position).imageUrl);
//        Log.i("MovieAdapter", "onBindViewHolder: "+movies.get(position).getThumbnail());
//        Glide.with(context).load(movies.get(position).getThumbnail()).into(holder.ivMovie);
//
//        holder.itemView.setOnKeyListener((v, keyCode, event) -> {
//            if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
//                // Người dùng nhấn OK trên remote
//
//                Movie movie = movies.get(position);
//                // Mở chi tiết phim hoặc hành động khác
//                Log.i("MovieAdapter", "Click phim: "+movie.getTitle() );
//                return true;
//            }
//            return false;
//        });
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return movies==null?0:movies.size();
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
