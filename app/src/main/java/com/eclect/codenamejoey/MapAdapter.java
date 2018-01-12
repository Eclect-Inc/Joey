package com.eclect.codenamejoey;

import android.content.Context;

import com.hypertrack.lib.HyperTrackMapAdapter;
import com.hypertrack.lib.MapFragmentCallback;
import com.hypertrack.lib.models.Place;

/**
 * Created by shawdotion on 1/12/18.
 */

public class MapAdapter extends HyperTrackMapAdapter{

    private Context context;

    MapAdapter(Context mContext) {
        super(mContext);
        context = mContext;
    }

    @Override
    public boolean showPlaceSelectorView() {
        return true;
    }

    private MapFragmentCallback mapFragmentCallback = new MapFragmentCallback() {

        @Override
        public void onExpectedPlaceSelected(Place expectedPlace) {
            super.onExpectedPlaceSelected(expectedPlace);
            if (expectedPlace != null) {
                // Use this place
            }
        }

    };


}
