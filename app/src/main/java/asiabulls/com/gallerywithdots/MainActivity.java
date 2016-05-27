package asiabulls.com.gallerywithdots;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Gallery;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity
{
    static TextView mDotsText[];
    private int mDotsCount;
    private LinearLayout mDotsLayout;
    Gallery gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState)    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //here we create the gallery and set our adapter created before
        gallery = (Gallery)findViewById(R.id.gallery);
        gallery.setAdapter(new AddImageAdapter(this));

        mDotsLayout = (LinearLayout)findViewById(R.id.image_count);
        //here we count the number of images we have to know how many dots we need
        mDotsCount = gallery.getAdapter().getCount();

        //here we create the dots
        //as you can see the dots are nothing but "."  of large size
        mDotsText = new TextView[mDotsCount];

        //here we set the dots
        for (int i = 0; i < mDotsCount; i++) {
            mDotsText[i] = new TextView(this);
            mDotsText[i].setText(".");
            mDotsText[i].setTextSize(45);
            mDotsText[i].setTypeface(null, Typeface.BOLD);
            mDotsText[i].setTextColor(android.graphics.Color.GRAY);
            mDotsLayout.addView(mDotsText[i]);
        }

        //when we scroll the images we have to set the dot that corresponds to the image to White and the others
        //will be Gray
        gallery.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapterView, View view, int pos, long l) {

                for (int i = 0; i < mDotsCount; i++) {
                    MainActivity.mDotsText[i].setTextColor(Color.GRAY);
                }

                MainActivity.mDotsText[pos].setTextColor(Color.WHITE);
            }

            @Override
            public void onNothingSelected(AdapterView adapterView) {

            }
        });
    }
}