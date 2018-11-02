package com.ines.themovie;

import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Asus on 10/29/2018.
 */

public interface TMDbApi {
    @GET("movie/popular")
    retrofit2.Call<MoviesResponse> getPopularMovies(
            @Query("api_key") String apiKey,
            @Query("language") String language,
            @Query("page") int page
    );


}
