package com.example.mustafa.personnelmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.mustafa.personnelmanagement.model.Employed;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.TextHttpResponseHandler;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    ListView mListViewEmployed;
    ArrayList<Employed> mListEmployeds = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListViewEmployed = findViewById(R.id.list_view_employed);

        final ArrayAdapter<Employed> adapter = new ArrayAdapter<Employed>(
                this,
                R.layout.list_item_employed,
                R.id.text_view_employed,
                mListEmployeds
        );

        mListViewEmployed.setAdapter(adapter);

        mListViewEmployed.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent detailIntent = new Intent(
                        MainActivity.this,
                        DetailActivity.class
                );
                detailIntent.putExtra("employed",mListEmployeds.get(position));
                startActivity(detailIntent);
            }
        });

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("https://sheltered-plains-70686.herokuapp.com/api/employed",
                new TextHttpResponseHandler() {
                    @Override
                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                        Log.e("MainActivity","No funciona");
                    }

                    @Override
                    public void onSuccess(int statusCode, Header[] headers, String responseString) {
                    Log.d("MainActivity","OK_>Response: "+responseString);
                        Gson gson = new GsonBuilder().create();
                        Employed[] employeds = gson.fromJson(responseString,Employed[].class);
                        adapter.clear();
                        for (Employed employed: employeds){
                            adapter.add(employed);
                        }
                    }
                });




    }


}
