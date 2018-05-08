package m.castellan.animations;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.Explode;
import android.transition.Scene;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ViewGroup root;
    private ImageView img;
    private Scene cena1, cena2;
    private boolean cena = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        root = findViewById(R.id.root);
        cena1 = Scene.getSceneForLayout(root, R.layout.activity_main, this);
        cena2 = Scene.getSceneForLayout(root, R.layout.activity_main2, this);
        img = findViewById(R.id.imageView);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this).toBundle();
                Intent intent = new Intent(MainActivity.this,TesteAct.class);
                startActivity(intent,bundle);
            }
        });

    }

    public void click(View v) {
        TransitionManager.beginDelayedTransition(root, new Explode());
        img.setVisibility((img.getVisibility() == View.VISIBLE) ? View.INVISIBLE : View.VISIBLE);
    }

    public void trocaCena(View v) {
        Transition trans = TransitionInflater.from(this).inflateTransition(R.transition.custom);
        if (cena) {
            TransitionManager.go(cena2,trans);
        } else {
            TransitionManager.go(cena1, trans);
        }
        cena = !cena;
    }
}
