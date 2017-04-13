package com.wikitude.samples.plugin;

import com.wikitude.common.plugins.Plugin;
import com.wikitude.common.tracking.Frame;
import com.wikitude.common.tracking.RecognizedTarget;

import android.util.Log;

public class SamplePlugin extends Plugin {

    public SamplePlugin(String identifier) {
        super(identifier);
    }

    @Override
    protected void initialize() {
        Log.e(this.getClass().getName(), "Plugin.init");
    }

    @Override
    protected void pause() {
        Log.e(this.getClass().getName(), "Plugin.pause");
    }

    @Override
    protected void resume(long pausedTime) {
        Log.e(this.getClass().getName(), "Plugin.resume");
    }

    @Override
    protected void destroy() {
        Log.e(this.getClass().getName(), "Plugin.destroy");
    }

    @Override
    public void cameraFrameAvailable(final Frame cameraFrame) {
        Log.e(this.getClass().getName(), "Plugin.cameraFrameAvailable");
    }

    @Override
    public void update(RecognizedTarget[] recognizedTargets) {
        Log.e(this.getClass().getName(), "Plugin.update");
    }

}
