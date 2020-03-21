package cn.mozhx.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import cn.mozhx.databinding.databinding.ActivityMainBinding;
import cn.mozhx.databinding.pojo.User;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        setContentView(R.layout.activity_main);
        //用 DatabindingUtil.setContentView() 来替换掉 setContentView()

        //[pkg].databinding.* 不会自动导入?
        final ActivityMainBinding dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        //初始化data 还没有初始化时dataBinding的data还是空的
        User user = new User();
        user.setLastName("init");
        dataBinding.setUser(user);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("Mok", "Harry");
                user.setLastName("Harry" + (++tmp));
                dataBinding.setUser(user);
            }
        });

        findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = dataBinding.getUser();
                Toast.makeText(MainActivity.this, user.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    int tmp;

}
