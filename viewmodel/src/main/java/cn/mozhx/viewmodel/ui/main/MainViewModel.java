package cn.mozhx.viewmodel.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import cn.mozhx.viewmodel.pojo.User;

public class MainViewModel extends ViewModel {
    // TODO: Implement the ViewModel
    private MutableLiveData<User> mLiveData;

    public MutableLiveData<User> getLiveData() {
        if (mLiveData == null) {
            mLiveData = new MutableLiveData<>();
            loadLiveData();
        }
        return mLiveData;
    }

    // 异步获取数据
    private void loadLiveData() {
        // TODO: 2018-12-29
        User user = new User("firstName", "lastName");
        mLiveData.setValue(user);
    }

}
