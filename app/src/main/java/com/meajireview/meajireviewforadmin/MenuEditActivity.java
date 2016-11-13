package com.meajireview.meajireviewforadmin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by songm on 2016-11-13.
 */

public class MenuEditActivity extends AppCompatActivity {
    @BindView(R.id.toolBar) Toolbar toolBar;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_edit);

        ButterKnife.bind(this);
        initToolbar();
        initRecyclerView();

        makeList();
    }

    /**
     * toolbar 초기화 메소드<br>
     */
    private void initToolbar() {
        setSupportActionBar(toolBar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("메뉴수정하기");
    }
    /**
     * RecyclerView 초기화 메소드<br>
     */
    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
    }

    /**
     * List생성 메소드<br>
     */
    private void makeList() {
        List<ShopItem> shopItems = new ArrayList<>();

        for(int i=0;i<11;i++)                          //나중에 db에서 가져올 때 변경 필요.
            shopItems.add(new ShopItem("치닭삼","6000원"));

        recyclerView.setAdapter(new MenuAdapter(getApplicationContext(),shopItems));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_ok,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.action_ok){
            finish();
            return true;
         }
        return super.onOptionsItemSelected(item);
    }
}
