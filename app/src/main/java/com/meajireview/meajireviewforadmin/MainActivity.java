package com.meajireview.meajireviewforadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btChangeInfo) Button btChangeInfo;
    @BindView(R.id.btChangeMenu) Button btChangeMenu;
    @BindView(R.id.toolBar) Toolbar toolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initToolbar();

        btChangeInfo.setOnClickListener(this);
        btChangeMenu.setOnClickListener(this);
    }

    private void initToolbar() {
        setSupportActionBar(toolBar);
        getSupportActionBar().setTitle("");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btChangeInfo:
                startActivity(new Intent(MainActivity.this,InfoEditActivity.class));
                break;
            case R.id.btChangeMenu:
                startActivity(new Intent(MainActivity.this,MenuEditActivity.class));
                break;
        }
    }
}
