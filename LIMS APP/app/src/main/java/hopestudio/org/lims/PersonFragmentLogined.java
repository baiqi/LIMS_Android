package hopestudio.org.lims;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by dengzhirong on 15.11.29.
 */
public class PersonFragmentLogined extends android.support.v4.app.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View personView = inflater.inflate(R.layout.activity_person_logined, container, false);

        // 返回Fragment的View对象
        return personView;
    }
}