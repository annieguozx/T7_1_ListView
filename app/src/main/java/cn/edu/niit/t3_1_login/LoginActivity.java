package cn.edu.niit.t3_1_login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login, btn_exit;
    private EditText ev_userName, ev_password;
    private CheckBox cb_isSave;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ev_userName = (EditText) findViewById(R.id.ev_userName);
        ev_password = (EditText) findViewById(R.id.ev_password);
        btn_login = (Button) findViewById(R.id.btn_login);
        btn_exit = (Button) findViewById(R.id.btn_exit);
        cb_isSave = (CheckBox) findViewById(R.id.cb_isSave);
        preferences = getSharedPreferences("isSave", MODE_PRIVATE);
        editor = preferences.edit();

        //是否保存用户名信息
        cb_isSave.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb_isSave.isChecked()) {
                    editor.putBoolean("ISCHECK", true);
                    editor.commit();

                }
            }
        });
        if (preferences.getBoolean("ISCHECK", false)) {
            cb_isSave.setChecked(true);
            String name = preferences.getString("userName", "");
            ev_userName.setText(name);
        }
        //登陆
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(ev_userName.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "用户名不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                if (TextUtils.isEmpty(ev_password.getText().toString())) {
                    Toast.makeText(LoginActivity.this, "密码不能为空", Toast.LENGTH_LONG).show();
                    return;
                }
                editor.putString("userName", ev_userName.getText().toString());
                editor.commit();
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("name", ev_userName.getText().toString());
                startActivity(intent);


            }
        });
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder quitDia = new AlertDialog.Builder(LoginActivity.this);
                quitDia.setIcon(R.mipmap.ic_launcher);
                quitDia.setTitle("提示");
                quitDia.setMessage("退出？");
                quitDia.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                quitDia.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                quitDia.create().show();
            }
        });
    }
}
