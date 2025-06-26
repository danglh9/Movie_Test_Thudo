package com.dang.movie_test_thudo.presenter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.dang.movie_test_thudo.R;
import com.dang.movie_test_thudo.model.Movie;
import com.dang.movie_test_thudo.utils.Utils;
import com.google.common.collect.Lists;

import java.util.List;

public class CardPresenterVertical extends Presenter {

    public List<String> listBanner = Lists.newArrayList(
            "https://media-cdn-v2.laodong.vn/Storage/NewsPortal/2022/9/6/1089731/03_TIEU-VY-01.jpg",
            "https://genk.mediacdn.vn/2017/photo-1-1496042071517.jpg",
            "https://vb.1cdn.vn/2022/12/03/nbn_teaser-poster_fb.jpg",
            "https://danviet-24h.ex-cdn.com/files/upload/4-2020/images/2020-12-02/bo-gia_teaser-1--1606900159-476-width660height873.jpg",
            "https://ephoto360.com/uploads/worigin/2019/12/08/anh-che-mat-biec5decd68e9069a_815645cc3563afbd26ec548704476b35.jpg",
            "https://khenphim.com/wp-content/uploads/2022/04/Pee-Nak-3-1-poster.jpg");

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_movie_leanback_vertical, parent, false);
        ImageView imageView = view.findViewById(R.id.ivMovie);
        imageView.setClipToOutline(true);
        imageView.setFocusable(true);
        imageView.setFocusableInTouchMode(true);
        imageView.setBackgroundResource(R.drawable.item_background_selector);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        Movie movie = (Movie) item;
        View view = viewHolder.view;
        TextView tvIndex = view.findViewById(R.id.tvIndex);
        ImageView imageView = view.findViewById(R.id.ivMovie);
        tvIndex.setText(movie.getId() + "");
        Glide.with(view.getContext())
                .load(Utils.getRandomElement(listBanner))
                .centerCrop()
                .into(imageView);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
    }
}

