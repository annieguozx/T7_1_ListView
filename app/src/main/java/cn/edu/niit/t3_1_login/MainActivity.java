package cn.edu.niit.t3_1_login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView tv_name;
    private ImageButton imgBtn_course, imgBtn_toolBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_name = (TextView) findViewById(R.id.tv_name);
        imgBtn_course = (ImageButton) findViewById(R.id.imgBtn_course);
        imgBtn_toolBox = (ImageButton) findViewById(R.id.imgBtn_toolBox);

        final Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tv_name.setText("欢迎" + name + "来到您的空间");

        imgBtn_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, CourseManageActivity.class);
                startActivity(intent1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_info_maintain:
                Toast.makeText(MainActivity.this, "个人信息维护", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_setting:
                Toast.makeText(MainActivity.this, "设置", Toast.LENGTH_SHORT).show();
                break;

            case R.id.item_questionnaire:
                Toast.makeText(MainActivity.this, "问卷调查", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item_about:
                Toast.makeText(MainActivity.this, "关于", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
