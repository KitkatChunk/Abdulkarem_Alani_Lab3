package abdulkarem.alani.s300993768;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import static android.graphics.Color.BLACK;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;

public class AbdulkaremMainActivity extends AppCompatActivity {

    private CanvasView customCanvas;
    private Button updateButton;

    private ImageView imageView;
    private Button startButton, stopButton;
    private AnimationDrawable animationDrawable=null;
    Button btnStart;
    ImageView iV_moon;
    ImageView iV_earth;

    private Button clearButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.abdulkarem_activity);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        btnStart = findViewById(R.id.startMoonBtn);
        iV_moon =findViewById(R.id.moon);
        iV_earth=findViewById(R.id.earth);

       clearButton = (Button) findViewById(R.id.abdulClearbtn);

        customCanvas = (CanvasView) findViewById(R.id.canvasView);


        // CLick button just crashes the app.
//        findViewById(R.id.startAnimBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startDisplaying(view);
//            }
//        });

        // CLick button just crashes the app.
//        findViewById(R.id.abdulClearbtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                setContentView(R.layout.abdulkarem_fragment_home);
//            }
//        });

//        findViewById(R.id.startMoonBtn).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startmoonAnim(view);
//            }
//        });




    }

    public void startDisplaying(View view){
        BitmapDrawable frame1= (BitmapDrawable) getResources().getDrawable(R.drawable.anim1);
        BitmapDrawable frame2=(BitmapDrawable) getResources().getDrawable(R.drawable.anim2);
        BitmapDrawable frame3=(BitmapDrawable) getResources().getDrawable(R.drawable.anim3);
        BitmapDrawable frame4=(BitmapDrawable) getResources().getDrawable(R.drawable.anim4);
        BitmapDrawable frame5=(BitmapDrawable) getResources().getDrawable(R.drawable.anim5);


        animationDrawable = new AnimationDrawable();
        animationDrawable.addFrame(frame1,220);
        animationDrawable.addFrame(frame2,220);
        animationDrawable.addFrame(frame3,220);
        animationDrawable.addFrame(frame4,220);
        animationDrawable.addFrame(frame5,220);

        imageView.setImageDrawable(animationDrawable);
        animationDrawable.start();

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {

            case R.id.smallSizeRbtn:
                if (checked)
                customCanvas.mPaint.setStrokeWidth(5f);
                    break;
            case R.id.medSizeRbtn:
                if (checked)
                    customCanvas.mPaint.setStrokeWidth(15f);
                    break;
            case R.id.largeSizeRbtn:
                if (checked)
                    customCanvas.mPaint.setStrokeWidth(30f);
                    break;
        }

        switch(view.getId()) {

            case R.id.redRbtn:
                if (checked)
                    customCanvas.mPaint.setColor(RED);
                    break;
            case R.id.blackRbtn:
                if (checked)
                    customCanvas.mPaint.setColor(BLACK);
                    break;
            case R.id.greenRbtn:
                if (checked)
                    customCanvas.mPaint.setColor(GREEN);
                    break;
        }
    }

    public void startmoonAnim(View view)
    {
        Animation moonAnimation = AnimationUtils.loadAnimation(this,R.anim.moon_movment);
        Animation earthAnimation = AnimationUtils.loadAnimation(this,R.anim.spin_around);

        iV_earth.startAnimation(earthAnimation);
        iV_moon.startAnimation(moonAnimation);

    }




}
