package hopestudio.org.lims.Device;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hopestudio.org.lims.R;

/**
 * Created by dengzhirong on 15.12.18.
 */
public class StarFragment extends android.support.v4.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_device_star, container, false);
    }
}