package hopestudio.org.lims;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by dengzhirong on 15.11.29.
 */
public class LessonFragment extends android.support.v4.app.Fragment {

//    private TextView text;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
/*        View orderedView = inflater.inflate(R.layout.activity_ordered, container, false);
        text = (TextView) orderedView.findViewById(R.id.ordered_layout_text);
        Button btn = (Button) orderedView.findViewById(R.id.ordered_layout_btn);*/

/*        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text.setText("哈哈，you click on me!");
            }
        });
        return orderedView;*/

        return inflater.inflate(R.layout.activity_lesson, container, false);
    }

}
