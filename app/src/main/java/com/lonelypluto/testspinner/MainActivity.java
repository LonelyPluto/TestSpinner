package com.lonelypluto.testspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.lonelypluto.testspinner.adapter.SpinnerBaseAdapter;
import com.lonelypluto.testspinner.bean.CityBean;

import java.util.ArrayList;
import java.util.List;
/**
 * @Description: Spinner测试
 * @author: ZhangYW
 * @time: 2018/8/8 10:53
 */
public class MainActivity extends AppCompatActivity {

    private Spinner spinner_array;
    private ArrayAdapter adapter_array;

    private Spinner spinner_array_customstyle;// 自定义样式Spinner
    private ArrayAdapter adapter_array_customstyle;

    private Spinner spinner_base;
    private SpinnerBaseAdapter adapter_base;
    private List<CityBean> list = new ArrayList<>();

    private TextView tv;// 显示spinner选中的值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initView();
    }

    /**
     * 初始化数据
     */
    private void initData(){
        for (int i = 0; i < 5; i++) {
            CityBean cityBean = new CityBean();
            cityBean.setId(i+"");
            cityBean.setName("北京");
            list.add(cityBean);
        }
    }

    /**
     * 初始化view
     */
    private void initView(){

        adapter_array = ArrayAdapter.createFromResource(this, R.array.city, android.R.layout.simple_spinner_item);
        // 设置下拉列表的风格
        adapter_array.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // 将adapter添加到spinner中
        spinner_array = (Spinner)findViewById(R.id.main_spinner_array);
        spinner_array.setAdapter(adapter_array);

        adapter_array_customstyle = ArrayAdapter.createFromResource(this, R.array.city, R.layout.spinner_array_item);
        // 设置下拉列表的风格
        adapter_array_customstyle.setDropDownViewResource(R.layout.spinner_array_dropdown_item);
        // 将adapter添加到spinner中
        spinner_array_customstyle = (Spinner)findViewById(R.id.main_spinner_array_customstyle);
        spinner_array_customstyle.setAdapter(adapter_array_customstyle);

        adapter_base = new SpinnerBaseAdapter(this, list);
        spinner_base = (Spinner)findViewById(R.id.main_spinner_base);
        spinner_base.setAdapter(adapter_base);
        // 为spinner设置点击事件
        spinner_base.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                tv.setText(list.get(i).getName()+list.get(i).getId());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tv = (TextView)findViewById(R.id.main_tv);
    }
}
