package com.wikitude.samples.plugin.zxing;

import android.util.Log;

import com.wikitude.architect.ArchitectView;
import com.wikitude.common.plugins.Plugin;
import com.wikitude.common.tracking.Frame;
import com.wikitude.common.tracking.RecognizedTarget;


public class SampleZXingPlugin extends Plugin {

    private final ZXingResultListener resultListener;

    public SampleZXingPlugin(String identifier, ZXingResultListener resultListener) {
        super(identifier);
        this.resultListener = resultListener;
    }

    @Override
    public void cameraFrameAvailable(Frame cameraFrame) {
        new ZXingDecodeTask(resultListener).execute(cameraFrame);
    }

    @Override
    public void update(RecognizedTarget[] recognizedTargets) {
        if (recognizedTargets != null) {
            Log.e(this.getClass().getName(), "Plugin.update");
        }
    }
}