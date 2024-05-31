package com.example.news_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.news_api.api.NewsServices;
import com.example.news_api.api.apiClient;
import com.example.news_api.model.newsResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button submit;
    EditText country;
    RecyclerView recyclerView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        submit=findViewById(R.id.submit);
        country=findViewById(R.id.country);

//        list.add(new news("desc1","title1",R.drawable.plant,ctry));
//        list.add(new news("desc2","titl2",R.drawable.flower,ctry));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerView.setAdapter(new recylerview_adapter(MainActivity.this,list));

        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String ctry = country.getText().toString();

                if (ctry.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter country", Toast.LENGTH_SHORT).show();
                } else if (ctry.length() > 2) {
                    Toast.makeText(MainActivity.this, "Please Enter Only First 2 character of Country", Toast.LENGTH_SHORT).show();
                } else {
                    NewsServices services = apiClient.getClient().create(NewsServices.class);
                    Call<newsResponse> call = services.getCurrentNews(ctry, "fbbe764ae7ef457bb85f903e486425d7");
                    call.enqueue(new Callback<newsResponse>() {
                        @Override
                        public void onResponse(Call<newsResponse> call, Response<newsResponse> response) {
                            if (response.isSuccessful()) {
                                newsResponse newsResponse = response.body();
                                if (newsResponse != null && newsResponse.getArticles() != null) {
                                    List<newsResponse.Article> list1 = newsResponse.getArticles();
                                    List<news> newsList = new ArrayList<>();
                                    for (com.example.news_api.model.newsResponse.Article article : list1) {
                                        newsList.add(new news(article.getDescription(), article.getTitle(), article.getUrlToImage(), ctry));
                                    }
                                    recyclerView.setAdapter(new recylerview_adapter(MainActivity.this, newsList));
                                } else {
                                    Toast.makeText(MainActivity.this, "No News Found Please Enter Proper Country Name ", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(MainActivity.this, "Failed to Fetch news", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<newsResponse> call, Throwable t) {
                            Toast.makeText(MainActivity.this, "Failed to Fetch News", Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
                
        });

    }
}