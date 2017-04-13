package com.wikitude.samples;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;

public class MarkerTrackingPluginActivity extends SampleCamActivity {

    @Override
    protected void onPostCreate(final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        this.architectView.registerNativePlugins("wikitudePlugins", "markertracking");

        initNative();

        if (isCameraLandscape()) {
            setDefaultDeviceOrientationLandscape(true);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    public boolean isCameraLandscape(){
        final Display display = ((WindowManager)getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay();
        final DisplayMetrics dm = new DisplayMetrics();
        final int rotation = display.getRotation();

        display.getMetrics(dm);

        final boolean is90off = rotation == Surface.ROTATION_90 || rotation == Surface.ROTATION_270;
        final boolean isLandscape = dm.widthPixels > dm.heightPixels;

        return is90off ^ isLandscape;
    }

    private native void initNative();
    private native void setDefaultDeviceOrientationLandscape(boolean isLandscape);
}
