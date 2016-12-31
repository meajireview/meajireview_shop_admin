package com.meajireview.meajireviewforadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btChangeInfo) Button btChangeInfo;
    @BindView(R.id.btChangeMenu) Button btChangeMenu;
    @BindView(R.id.toolBar) Toolbar toolBar;
    @BindView(R.id.txtRating) TextView txtRating;
    @BindView(R.id.txtOpen) TextView txtOpen;
    @BindView(R.id.txtDelivery) TextView txtDelivery;
    @BindView(R.id.txtPhone) TextView txtPhone;

    int shopId= -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initToolbar();

        initData();

        btChangeInfo.setOnClickListener(this);
        btChangeMenu.setOnClickListener(this);
    }

    private void initData() {
        ParseQuery<ParseObject> query = ParseQuery.getQuery("Shop");
        query.whereEqualTo("shop_id",getShopId());
        query.getFirstInBackground(new GetCallback<ParseObject>() {
            @Override
            public void done(ParseObject parseObject, ParseException e) {
                if(parseObject.getBoolean("isdelivery"))
                   txtDelivery.setText("배달함");
                else
                    txtDelivery.setText("배달안함");

                txtOpen.setText("준비중...");
                txtPhone.setText(parseObject.getString("phone"));
            }
        });
    }
    int getShopId(){
        ParseUser curUser = ParseUser.getCurrentUser();
        return curUser.getInt("shop_id");
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
                Intent intent = new Intent(MainActivity.this,MenuEditActivity.class);
                intent.putExtra("shopId",getShopId());
                startActivity(intent);
                break;
        }
    }
}
