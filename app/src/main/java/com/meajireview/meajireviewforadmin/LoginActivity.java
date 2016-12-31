package com.meajireview.meajireviewforadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by songm on 2016-11-14.
 */

public class LoginActivity extends AppCompatActivity{
    EditText id_text;
    EditText pass_text;
    Button login_button;
    Button signup_button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        id_text=(EditText)findViewById(R.id.id_text);
        pass_text=(EditText)findViewById(R.id.pass_text);
        login_button=(Button)findViewById(R.id.login_button);
        signup_button=(Button)findViewById(R.id.signup_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {       //login버튼 클릭 시
                ParseUser.logInInBackground(id_text.getText().toString(), pass_text.getText().toString(), new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if(parseUser!=null) {
                            startActivity(new Intent(LoginActivity.this, MainActivity.class));
                            Log.e("asdf",id_text.getText().toString());
                            Log.e("asdf",pass_text.getText().toString());
                        }
                        Log.e("asd1f",id_text.getText().toString());
                        Log.e("asdf1",pass_text.getText().toString());
                    }
                });

            }
        });

        signup_button.setOnClickListener(new View.OnClickListener() {       //signup버튼 클릭 시
            @Override
            public void onClick(View v) {
             //   startActivity(new Intent(LoginActivity.this, SignupActivity.class));
                finish();
            }
        });
    }
}
