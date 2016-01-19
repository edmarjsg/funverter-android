package com.funverter.activity;

import android.os.Bundle;

import com.funverter.converter.apps.converters.R;
import com.funverter.helper.ConverterActivity;
import com.funverter.converter.WeightUnit;


public class WeightConverterActivity extends ConverterActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState, this,
                "weight", R.layout.activity_weight_converter,
                this.getClass(), WeightUnit.class);
    }
}
