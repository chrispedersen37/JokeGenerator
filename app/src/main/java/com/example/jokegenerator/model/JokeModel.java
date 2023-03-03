package com.example.jokegenerator.model;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.jokegenerator.ServiceClient;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class JokeModel {
    public interface GetJokeResponseHandler {
        void response(Joke joke);
        void error();

    }

    public void getJoke(GetJokeResponseHandler handler){

        JsonObjectRequest jsonRequest = new JsonObjectRequest(Request.Method.GET, "https://v2.jokeapi.dev/joke/Any", null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Gson gson = new Gson();
                Joke joke = gson.fromJson(response.toString(), Joke.class);
                handler.response(joke);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                handler.error();
            }
        });
        ServiceClient client = ServiceClient.sharedServiceClient(null);

        client.addRequest(jsonRequest);
    }
}
