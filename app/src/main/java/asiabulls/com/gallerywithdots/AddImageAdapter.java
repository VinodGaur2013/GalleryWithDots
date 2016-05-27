package asiabulls.com.gallerywithdots;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * Created by Vinod on 16-Mar-16.
 */
public class AddImageAdapter extends BaseAdapter
{
    Context mycontext = null;
    int galitembg = 0;

    public int[] IMAGE_IDS = { R.drawable.first, R.drawable.second,
            R.drawable.third, R.drawable.forth,
            R.drawable.first, R.drawable.second,
            R.drawable.third, R.drawable.forth,
            R.drawable.first, R.drawable.second};


    public AddImageAdapter (Context c){
        mycontext = c;
    }

    @Override
    public int getCount() {
        return IMAGE_IDS.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView = new ImageView(mycontext);

        imageView.setImageResource(IMAGE_IDS[i]);
        imageView.setLayoutParams(new Gallery.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        return imageView;
    }
}