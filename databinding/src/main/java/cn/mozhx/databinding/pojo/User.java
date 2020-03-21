package cn.mozhx.databinding.pojo;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * @author @Harry
 * @date 2018-12-29
 */
public class User extends BaseObservable {

    private String firstName;

    //需要使用对属性或属性的getter使用注解@Bindable 否则BR不会生成对应属性
    @Bindable
    private String lastName;

    public User() {
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        notifyPropertyChanged(cn.mozhx.databinding.BR.lastName);
    }

    @Override
    public String toString() {
        return "{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
