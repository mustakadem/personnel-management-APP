package com.example.mustafa.personnelmanagement;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mustafa.personnelmanagement.model.Employed;
import com.squareup.picasso.Picasso;


/**
 * Created by mustafa on 14/12/2017.
 */

public class DetailActivity extends AppCompatActivity  {

    ImageView mImageViewEmployed;
    TextView mTextViewEmployedName;
    TextView mTextViewEmployedSurnames;
    TextView mTextViewEmployedLatestStudies;
    TextView mTextViewEmployedLatestJob;
    TextView mTextViewEmployedEmail;
    TextView mTextViewEmployedMovil;
    TextView mTextViewEmployedAddress;
    TextView mTextViewEmployedJobPosition;
    TextView mTextViewEmployedDepartament;
    Employed employed;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        employed = new Employed();

        mImageViewEmployed= findViewById(R.id.employed_logo_image_view);
        mTextViewEmployedName = findViewById(R.id.employed_name_text_view);
        mTextViewEmployedSurnames= findViewById(R.id.employed_surnames_text_views);
        mTextViewEmployedLatestStudies = findViewById(R.id.latest_studies_text_view);
        mTextViewEmployedLatestJob = findViewById(R.id.latest_job_text_view);
        mTextViewEmployedEmail = findViewById(R.id.email_text_view);
        mTextViewEmployedMovil = findViewById(R.id.movil_text_view);
        mTextViewEmployedAddress = findViewById(R.id.address_text_view);
        mTextViewEmployedJobPosition = findViewById(R.id.job_position_text_view);
        mTextViewEmployedDepartament = findViewById(R.id.departament_text_view);

        Intent detailIntent = DetailActivity.this.getIntent();

        if (detailIntent.hasExtra("employed")){
            employed = (Employed)detailIntent.getSerializableExtra("employed");
        }

        Log.d("DetailAcivity","Image Src: "+employed.getImage());

        Picasso.with(this).load(employed.getImage()).into(mImageViewEmployed);
        mTextViewEmployedName.setText(employed.getName());
        mTextViewEmployedSurnames.setText(employed.getSurnames());
        mTextViewEmployedLatestStudies.setText(employed.getLasted_studies());
        mTextViewEmployedLatestJob.setText(employed.getLasted_job());
        mTextViewEmployedEmail.setText(employed.getEmail());
        mTextViewEmployedMovil.setText(employed.getMovil());
        mTextViewEmployedAddress.setText(employed.getAddress());
        mTextViewEmployedJobPosition.setText(employed.getJob_position());
        mTextViewEmployedDepartament.setText(employed.getDepartament());
    }

}
