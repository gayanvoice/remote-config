package com.remoteconfig.library;

class RemoteConfig {
    /*
    FirebaseRemoteConfig mFirebaseRemoteConfig;
    FirebaseRemoteConfigSettings configSettings;
    long cacheExpiration = 43200;
    String imgUrl = "";

    public FirebaseConfig() {
        mFirebaseRemoteConfig = FirebaseRemoteConfig.getInstance();
        configSettings = new FirebaseRemoteConfigSettings.Builder()
                .setDeveloperModeEnabled(BuildConfig.DEBUG)
                .build();
        mFirebaseRemoteConfig.setConfigSettings(configSettings);
        mFirebaseRemoteConfig.setDefaults(R.xml.remote_config_defaults);
    }

    public String fetchNewImage(Context context){
        mFirebaseRemoteConfig.fetch(getCacheExpiration())
                .addOnCompleteListener((Activity) context, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
// If is successful, activated fetched
                        if (task.isSuccessful()) {
                            mFirebaseRemoteConfig.activateFetched();
                        } else {
                            Log.d("","");
                        }
                        imgUrl = mFirebaseRemoteConfig.getString("new_image");
                    }
                });
        return imgUrl;
    }
    public long getCacheExpiration() {
// If is developer mode, cache expiration set to 0, in order to test
        if (mFirebaseRemoteConfig.getInfo().getConfigSettings().isDeveloperModeEnabled()) {
            cacheExpiration = 0;
        }
        return cacheExpiration;
    }

*/
}
