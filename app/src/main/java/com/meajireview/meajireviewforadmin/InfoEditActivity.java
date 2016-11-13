package com.meajireview.meajireviewforadmin;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by songm on 2016-11-13.
 */

public class InfoEditActivity extends AppCompatActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    @BindView(R.id.toolBar) Toolbar toolBar;
    @BindView(R.id.btOpen) Button btOpen;
    @BindView(R.id.btClose) Button btClose;
    @BindView(R.id.txtOpen) TextView textOpen;
    @BindView(R.id.radioGroup) RadioGroup radioGroup;
    @BindView(R.id.radioTrue) RadioButton radioTrue;
    @BindView(R.id.radioFalse) RadioButton radioFalse;
    @BindView(R.id.editPhone) EditText editPhone;

    int openHour, opneMin, closeHour, closeMin;
    boolean isDelibery;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_edit);

        ButterKnife.bind(this);
        initToolbar();

        btOpen.setOnClickListener(this);
        btClose.setOnClickListener(this);
        radioGroup.setOnCheckedChangeListener(this);
    }

    private void initToolbar() {
        setSupportActionBar(toolBar);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("정보수정하기");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btOpen:
                TimePickerDialog openTimePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        openHour = hourOfDay;
                        opneMin = minute;

                        Log.e("dddd",""+openHour+opneMin);
                    }
                },openHour,opneMin,false);
                openTimePickerDialog.show();
                break;

            case R.id.btClose:
                TimePickerDialog closeTimePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        closeHour = hourOfDay;
                        closeMin = minute;

                        Log.e("dddd",""+openHour+opneMin);
                    }
                },closeHour,closeMin,false);
                closeTimePickerDialog.show();
                break;
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId){
            case R.id.radioTrue:
                isDelibery=true;
                break;
            case R.id.radioFalse:
                isDelibery=false;
                break;
        }
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
