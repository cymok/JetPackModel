package cn.mozhx.databinding;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

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

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User("Mok", "Harry");
                EditText editText = (EditText) findViewById(R.id.et_msg);
                String s = editText.getText().toString().trim();
                if(TextUtils.isEmpty(s)){
                    s = editText.getHint().toString().trim();
                }
                user.setLastName(s);
                dataBinding.setUser(user);
            }
        });
    }

}
