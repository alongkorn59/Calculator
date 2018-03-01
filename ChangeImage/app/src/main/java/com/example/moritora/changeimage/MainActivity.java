package com.example.moritora.changeimage;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;


public class MainActivity extends AppCompatActivity {

    ImageSwitcher switchImage;
    Button nextImageButton;

    int storeImages[] = {R.drawable.a1 , R.drawable.a2, R.drawable.a3,
            R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9};

    int switchingImage = storeImages.length;
    int counter = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        switchImage = (ImageSwitcher) findViewById(R.id.imageSwitcher);
        nextImageButton = (Button) findViewById(R.id.nextImage);

        switchImage.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub

                ImageView imageViewSwitch = new ImageView(getApplicationContext());
                imageViewSwitch.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageViewSwitch.setLayoutParams(new ImageSwitcher.LayoutParams(ActionBar.LayoutParams.MATCH_PARENT, ActionBar.LayoutParams.MATCH_PARENT));
                imageViewSwitch.setImageResource(R.drawable.image1);
                return imageViewSwitch;
            }
        });

        //Android default animation. No additional animation file require.
        Animation animationOut = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);
        Animation animationIn = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);

        switchImage.setOutAnimation(animationOut);
        switchImage.setInAnimation(animationIn);
    }

    public void nextImageButton(View view) {
        counter++;
        if (counter == switchingImage)
            counter = 0;
        switchImage.setImageResource(storeImages[counter]);
    }
}
