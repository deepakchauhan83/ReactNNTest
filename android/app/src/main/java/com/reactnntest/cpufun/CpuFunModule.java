package com.reactnntest.cpufun;

import android.content.Context;
import android.util.Base64;
import android.os.AsyncTask;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;

import java.lang.IllegalArgumentException;
import java.net.MalformedURLException;

class CpuFunModule extends ReactContextBaseJavaModule {
    
    private Context context;

    public CpuFunModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.context = reactContext;
    }

    @Override
    public String getName() {
        return "CpuFunModule";
    }

    @ReactMethod
    public void performCpuFun(final Promise promise) {

        new AsyncTask<String, String, String>() {
                @Override
                protected String doInBackground(String... params) {
                    long sum =0;
                    for (int i = 0; i < 1000; i++) {
                        for (int j = 0; j < 1000; j++) {
                            for (int k = 0; k < 1000; k++) {
                                sum = sum + i + j + k;
                            }
                        }
                    }
                    return String.valueOf(sum);
                }

                @Override
                protected void onPostExecute(String result) {
                    promise.resolve(result);
                }
                @Override
                protected void onPreExecute() {}
                @Override
                protected void onProgressUpdate(String... text) {}
        }.execute();
    }
}