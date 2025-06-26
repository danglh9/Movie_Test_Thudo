package com.dang.movie_test_thudo.presenter;

import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;

import com.dang.movie_test_thudo.model.Movie;

public class MoviePresenterSelector extends PresenterSelector {
    private final Presenter type1 = new CardPresenterHorizontal();
    private final Presenter type2 = new CardPresenterVertical();

    @Override
    public Presenter getPresenter(Object item) {
        if (item instanceof Movie) {
            Movie movie = (Movie) item;
            return movie.getViewType() == 2 ? type2 : type1;
        }
        return type1;
    }
}