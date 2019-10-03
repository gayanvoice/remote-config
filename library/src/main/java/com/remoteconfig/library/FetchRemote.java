package com.remoteconfig.library;

import android.content.Context;
import com.remoteconfig.library.Network;
import com.remoteconfig.library.RequestQueue;
import com.remoteconfig.library.toolbox.BaseHttpStack;
import com.remoteconfig.library.toolbox.BasicNetwork;
import com.remoteconfig.library.toolbox.DiskBasedCache;
import com.remoteconfig.library.toolbox.HurlStack;

import java.io.File;

public class FetchRemote {

    private static final String DEFAULT_CACHE_DIR = "volley";

    // changed public -> private
    private static RequestQueue newRequestQueue(Context context, BaseHttpStack stack) {
        BasicNetwork network;
        if (stack == null) {
            network = new BasicNetwork(new HurlStack());
        } else {
            network = new BasicNetwork(stack);
        }
        return newRequestQueue(context, network);
    }

    private static RequestQueue newRequestQueue(Context context, Network network) {
        final Context appContext = context.getApplicationContext();
        DiskBasedCache.FileSupplier cacheSupplier =
                new DiskBasedCache.FileSupplier() {
                    private File cacheDir = null;

                    @Override
                    public File get() {
                        if (cacheDir == null) {
                            cacheDir = new File(appContext.getCacheDir(), DEFAULT_CACHE_DIR);
                        }
                        return cacheDir;
                    }
                };
        RequestQueue queue = new RequestQueue(new DiskBasedCache(cacheSupplier), network);
        queue.start();
        return queue;
    }

    public static RequestQueue newRequestQueue(Context context) {
        return newRequestQueue(context, (BaseHttpStack) null);
    }
}
