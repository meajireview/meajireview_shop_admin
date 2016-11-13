package com.meajireview.meajireviewforadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

                startActivity(new Intent(LoginActivity.this, MainActivity.class));

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
