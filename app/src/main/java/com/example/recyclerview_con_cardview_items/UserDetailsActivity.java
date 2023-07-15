
package com.example.recyclerview_con_cardview_items;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class UserDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);

        Bundle bundle = this.getIntent().getExtras();

        ImageView imgUser = (ImageView) findViewById(R.id.imgUserDetails);
        Glide.with(UserDetailsActivity.this).load(bundle.getString("image")).into(imgUser);

        TextView lblName = (TextView) findViewById(R.id.twUserName);
        lblName.setText(bundle.getString("name"));

        TextView lblEmail = (TextView) findViewById(R.id.twEmail);
        lblEmail.setText(bundle.getString("email"));

        TextView lblAccount = (TextView) findViewById(R.id.twAccount);
        lblAccount.setText(bundle.getString("username"));

        TextView lblCheck = (TextView) findViewById(R.id.twCheck);
        lblCheck.setText(bundle.getString("ein"));

        TextView lblUpdate = (TextView) findViewById(R.id.twUpdate);
        lblUpdate.setText(bundle.getString("domain"));

        TextView lblPhone = (TextView) findViewById(R.id.twCall1);
        lblPhone.setText(bundle.getString("phone"));

        TextView lblPerson = (TextView) findViewById(R.id.twPerson);
        lblPerson.setText(bundle.getString("maiden"));
    }
}