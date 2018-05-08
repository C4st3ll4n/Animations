package m.castellan.animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Slide;
import android.view.Gravity;

public class TesteAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teste);
        Slide slide = new Slide(Gravity.BOTTOM);
        getWindow().setEnterTransition(slide);
    }
}
