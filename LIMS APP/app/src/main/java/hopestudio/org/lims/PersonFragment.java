package hopestudio.org.lims;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hopestudio.org.lims.Controller.NewsAdapter;
import hopestudio.org.lims.Controller.PersonListAdapter;
import hopestudio.org.lims.Model.DataNewsModel;
import hopestudio.org.lims.Model.DataPersonListModel;

/**
 * Created by dengzhirong on 15.11.29.
 */
public class PersonFragment extends android.support.v4.app.Fragment {

    // 初始化用户名和密码
    private String userName = "admin";
    private String password = "admin";

    private String userNameInput;
    private String userpasswordInput;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View personView = inflater.inflate(R.layout.activity_person_login, container, false);

        // 获取用户名和密码的输入框
        final EditText userNameView = (EditText) personView.findViewById(R.id.login_name);
        final EditText passwordView = (EditText) personView.findViewById(R.id.login_password);

        final Button loginBtn = (Button) personView.findViewById(R.id.login_btn);
        Button registerBtn = (Button) personView.findViewById(R.id.login_register);

        // 点击登录事件
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginBtn.setText("点击成功");

                // 输入的用户名和密码
                userNameInput = userNameView.getText().toString();
                userpasswordInput = passwordView.getText().toString();

                // 获取用户名和密码
                if(userNameInput.equals(userName) && userpasswordInput.equals(password)) {
                    Toast.makeText(getActivity(), "Login Success.", Toast.LENGTH_LONG).show();

                    /*
                    * 登录成功后跳转至个人信息页
                    * */
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fm.beginTransaction();
                    fragmentTransaction.replace(R.id.layout_logined_place, new PersonFragmentLogined());
                    fragmentTransaction.commit();

                    // 隐藏未登录前的界面
                    LinearLayout loginPage = (LinearLayout) personView.findViewById(R.id.layout_login_place);
                    loginPage.setVisibility(View.GONE);


                } else {
                    Toast.makeText(getActivity(), "Login Fail.", Toast.LENGTH_LONG).show();
                }
            }
        });


        // 返回Fragment的View对象
        return personView;
    }

    // 验证输入用户名和密码是否正确
    public boolean checkLogin(String name, String userpassword) {
        if(userName == name && userpassword == password) {
            return true;
        }else {
            return false;
        }
    }

}