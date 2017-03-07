package cn.edu.niit.t3_1_login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xsl on 2016/6/9.
 */
public class MusicPlayerActivity extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_manage);
        lv = (ListView) findViewById(R.id.lv);
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, getMenuData(), R.layout.item, new String[]{"img", "tv_title"}, new int[]{R.id.img, R.id.tv_title});
        lv.setAdapter(simpleAdapter);
    }

    private List<Map<String, Object>> getMenuData() {
        List<Map<String, Object>> data = new ArrayList<>();
        Map<String, Object> item;

        item = new HashMap<>();
        item.put("tv_title", getString(R.string.music1));
        item.put("img", R.mipmap.img01);
        data.add(item);

        item = new HashMap<>();
        item.put("tv_title", getString(R.string.music2));
        item.put("img", R.mipmap.img02);
        data.add(item);

        item = new HashMap<>();
        item.put("tv_title", getString(R.string.music3));
        item.put("img", R.mipmap.img03);
        data.add(item);

        item = new HashMap<>();
        item.put("tv_title", getString(R.string.music4));
        item.put("img", R.mipmap.img04);
        data.add(item);

        item = new HashMap<>();
        item.put("tv_title", getString(R.string.music5));
        item.put("img", R.mipmap.img05);
        data.add(item);

        item = new HashMap<>();
        item.put("tv_title", getString(R.string.music6));
        item.put("img", R.mipmap.img06);
        data.add(item);

        item = new HashMap<>();
        item.put("tv_title", getString(R.string.music7));
        item.put("img", R.mipmap.img07);
        data.add(item);

        item = new HashMap<>();
        item.put("tv_title", getString(R.string.music8));
        item.put("img", R.mipmap.img08);
        data.add(item);

        item = new HashMap<>();
        item.put("tv_title", getString(R.string.music9));
        item.put("img", R.mipmap.img09);
        data.add(item);

        return data;
    }
}
