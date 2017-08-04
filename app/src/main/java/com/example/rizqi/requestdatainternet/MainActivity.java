package com.example.rizqi.requestdatainternet;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.ParsedRequestListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView textId, textTitle, textDesc;
    RecyclerView recyclerView;
    ArrayList<Movie> movieArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //Getting User LIST
//        AndroidNetworking.get("https://fierce-cove-29863.herokuapp.com/getAllUsers/{pageNumber}")
//                .addPathParameter("pageNumber", "0")
//                .addQueryParameter("limit", "3")
//                .setTag(this)
//                .setPriority(Priority.LOW)
//                .build()
//                .getAsObjectList(User.class, new ParsedRequestListener<List<User>>() {
//
//                    @Override
//                    public void onResponse(List<User> users) {
//                        Log.d("MYAPP", "userList size : " + users.size());
//                        for (User user : users) {
//                            Log.d("MYAPP", "id : " + user.getId());
//                            Log.d("MYAPP", "Firstname : " + user.getFirstname());
//                            Log.d("MYAPP", "Lastname : " + user.getLastname());
//
//                        }
//                    }
//
//
//                        @Override
//                        public void onError (ANError anError){
//
//                        }
//                    });
//                }

        movieArrayList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyleview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        final MovieAdapter movieAdapter = new MovieAdapter(movieArrayList);
        recyclerView.setAdapter(movieAdapter);

        AndroidNetworking.get("https://ghibliapi.herokuapp.com/films")
//                .addPathParameter("FilmId", "0")
//                .addQueryParameter("limit", "3")
                .setTag(this)
                .setPriority(Priority.LOW)
                .build()
                .getAsObjectList(Movie.class, new ParsedRequestListener<List<Movie>>() {

                    @Override
                    public void onResponse(List<Movie> movies) {
                        Log.d("MOVIE", "Movie size : " + movies.size());
                        for (Movie movie : movies)
                        {
                            movieArrayList.add(movie);
//                             textId = (TextView) findViewById(R.id.textid);
//                             textTitle = (TextView) findViewById(R.id.texttitle);
//                             textDesc = (TextView) findViewById(R.id.textdesc);
//
//                            textId.setText(movie.getId());
//                            textTitle.setText(movie.getTitle());
//                            textDesc.setText(movie.getDescription());
//
//
//                            Log.d("MOVIE", "ID " + movie.getId());
//                            Log.d("MOVIE", "TITLE " + movie.getTitle());
//                            Log.d("MOVIE", "DESCRIPTION " + movie.getDescription());
//                            Log.d("MOVIE", "People " + movie.getPeople());
//                            Log.d("MOVIE", "Location " + movie.getLocations());
//                            Log.d("MOVIE", "URL " + movie.getUrl());
//                            Log.d("MOVIE", "_________________________________");


                        }
                        movieAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(ANError anError) {

                        Log.d("MOVIE", anError.getErrorDetail());
                    }


                });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
