package cn.mozhx.viewmodel.ui.main;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

import cn.mozhx.viewmodel.R;
import cn.mozhx.viewmodel.pojo.User;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //在ViewModelProviders.of()传入的是同一对象接收的ViewModel引用才是指向同一对象 同对象之间才可以监听数据
        mViewModel = ViewModelProviders.of(getActivity()).get(MainViewModel.class);
        // TODO: Use the ViewModel
        final TextView tv = getView().findViewById(R.id.message);

        //这里是
        mViewModel.getLiveData().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                tv.setText(user.getLastName() + "·" + user.getFirstName());
            }
        });

        //点击时 data变化
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int i = random.nextInt(100);
                User user = mViewModel.getLiveData().getValue();
                user.setFirstName("Mok" + i);
                user.setLastName("Harry" + i);
                mViewModel.getLiveData().setValue(user);
            }
        });

    }

}
