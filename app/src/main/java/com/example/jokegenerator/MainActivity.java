package com.example.jokegenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jokegenerator.model.Joke;
import com.example.jokegenerator.model.JokeModel;
import com.example.jokegenerator.model.JokeRequest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ServiceClient.sharedServiceClient(getApplicationContext());
        setContentView(R.layout.activity_main);
    }

    public void postJoke(View view){
        ProgressBar progressBar = findViewById(R.id.pbLoadingJoke);
        progressBar.setVisibility(View.VISIBLE);

        JokeModel model = new JokeModel();
        model.getJoke(new JokeModel.GetJokeResponseHandler() {
            @Override
            public void response(Joke joke) {
                TextView jokebox = findViewById(R.id.lblJoke);
                if(joke.type.equals("twopart")){
                    progressBar.setVisibility(View.GONE);
                    jokebox.setText(joke.setup + "\n \n" + joke.delivery);
                } else {
                    progressBar.setVisibility(View.GONE);
                    jokebox.setText(joke.joke);
                }

            }

            @Override
            public void error() {

            }
        });

    }
}