package com.dang.movie_test_thudo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.leanback.widget.Presenter;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.dang.movie_test_thudo.utils.Utils;
import com.google.common.collect.Lists;

import java.util.List;

public class CardPresenterHorizontal extends Presenter {

    public List<String> listBanner = Lists.newArrayList(
            "https://image.baophapluat.vn/w840/Uploaded/2025/hfobhvwbucqaow/2022_06_15/nha-thiet-ke-poster-phim-le-791655133447-5792.jpg",
            "https://ephoto360.com/uploads/worigin/2020/07/20/taoanhcheposterphimdinhmusuongonline5f156a56b32ca_da3b502225e6c1f091aa5fafb6be6ea4.jpg",
            "https://cdn.baohatinh.vn/images/4e215a0e09a69e852ace2f38e36c4a6ce59b40ea6ec247bdd99befd469b167e174ebd2e4fe4fdfd5cf0809cbfde5161f/poster-phim.jpg",
            "https://designercomvn.s3.ap-southeast-1.amazonaws.com/wp-content/uploads/2019/06/27045927/top-15-bo-phim-kinh-di-khong-dam-xem-mot-minh.jpg",
            "https://sadesign.vn/pictures/picfullsizes/2024/12/03/chia-se-mien-phi-bo-action-movie-poster-2.jpg",
            "https://image.anninhthudo.vn/w1000/Uploaded/2025/ipjoohb/2023_09_27/00e237e7-6e51-475a-863b-439f46467a1f-2821-7326.jpeg",
            "https://nguoiduatin.mediacdn.vn/ndt/16/01/19/202/18484196/1_67537.jpg",
            "https://image.dienthoaivui.com.vn/x,webp,q90/https://dashboard.dienthoaivui.com.vn/uploads/dashboard/editor_upload/poster-phim-hoc-duong-1.jpg"
    );

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_movie_leanback_horizontal, parent, false);
        view.setFocusable(true);
        view.setFocusableInTouchMode(true);
        view.setBackgroundResource(R.drawable.item_background_selector);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, Object item) {
        View view = viewHolder.view;
        ImageView imageView = view.findViewById(R.id.ivMovie);
        imageView.setClipToOutline(true);
        int radius = 40;
        Glide.with(view.getContext())
                .load(Utils.getRandomElement(listBanner))
                .centerCrop()
                .transform(new RoundedCorners(radius))
                .into(imageView);
    }

    @Override
    public void onUnbindViewHolder(ViewHolder viewHolder) {
    }
}

