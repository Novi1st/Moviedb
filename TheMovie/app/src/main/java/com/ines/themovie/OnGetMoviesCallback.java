package com.ines.themovie;

import java.util.List;

/**
 * Created by Asus on 10/29/2018.
 */

public interface OnGetMoviesCallback {
    void onSuccess(List<Movie> movies);

    void onError();
}
