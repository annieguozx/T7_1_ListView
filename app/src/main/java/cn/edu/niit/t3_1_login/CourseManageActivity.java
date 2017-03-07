package cn.edu.niit.t3_1_login;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * Created by xsl on 2016/6/9.
 */
public class CourseManageActivity extends Activity {
    private ListView lv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.course_manage);
        lv = (ListView) findViewById(R.id.lv);
        String[] data = getResources().getStringArray(R.array.classes);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, data);
        lv.setAdapter(arrayAdapter);
    }
}
