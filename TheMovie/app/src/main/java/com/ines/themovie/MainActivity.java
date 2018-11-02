package com.ines.themovie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView moviesList;
    private MoviesAdapter adapter;

    private MoviesRepository moviesRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moviesRepository = MoviesRepository.getInstance();

        moviesList = findViewById(R.id.movies_list);
        moviesList.setLayoutManager(new LinearLayoutManager(this));

        moviesRepository.getMovies(new OnGetMoviesCallback() {
            @Override
            public void onSuccess(List<Movie> movies) {
                adapter = new MoviesAdapter(movies);
                moviesList.setAdapter(adapter);
            }

            @Override
            public void onError() {
                Toast.makeText(MainActivity.this, "Please check your internet connection.", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.optionmenu, menu);
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.about) {
            startActivity(new Intent(this, AboutActivity.class));
        } else if (item.getItemId() == R.id.setting) {
            startActivity(new Intent(this, SettingActivity.class));
        } else if (item.getItemId() == R.id.notif) {
            startActivity(new Intent(this, NotifictionActivity.class));
        } else if (item.getItemId() == R.id.lenguage) {
            startActivity(new Intent(this, LenguageActivity.class));
        }

        return true;
    }
}