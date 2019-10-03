# android-remote-config-library

[![](https://jitpack.io/v/gayankuruppu/android-remote-config-library.svg)](https://jitpack.io/#gayankuruppu/android-remote-config-library)

Remote config the appearance and the behavior of your app, without, publishing an app update.

## Get

### Gradle

1. Add this to `build.gradle` of project gradle dependency

```groovy
allprojects {
	repositories {
		...
 		maven { url 'https://jitpack.io' }
	}
}
```

2. Add this to `build.gradle` of app gradle dependency

```groovy
dependencies {
	implementation 'com.github.gayankuruppu:android-remote-config-library:1.0.0'
}
```

### Or

### Maven

1. Add this to `build.gradle` of project gradle dependency

```xml
<repositories>
	<repository>
		<id>jitpack.io</id>
	    	<url>https://jitpack.io</url>
	</repository>
</repositories>
```

2. Add this to `build.gradle` of module gradle dependency

```xml
<dependency>
	<groupId>com.github.gayankuruppu</groupId>
	<artifactId>android-remote-config-library</artifactId>
	<version>1.0.0</version>
</dependency>
```
## Usage
### Import Remote Config Library

```java
import com.remoteconfig.library.*;
```

### Set request

```java
// set request
RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

// url of the json file
String mUrl ="https://raw.githubusercontent.com/gayankuruppu/android-remote-config-library/master/remote-config.json";

// request the json file
RemoteConfig remoteConfig = new RemoteConfig(MainActivity.this, mUrl,
        new Response.Listener<String>() {
            @Override
            public void onComplete() {
                // json file retrieved
                RemoteParams remoteParams = new RemoteParams(MainActivity.this);
                textView.setText(remoteParams.getString("short_text", "some_text"));

                textStatus.setText(R.string.app_response);
            }
        },
        new Response.ErrorListener() {
            @Override
            public void onError(RemoteError error) {
                // json file retrieve error
                textView.setText(error.toString());
                textStatus.setText(R.string.app_error);
            }
        }
);

// clear cache
remoteConfig.setShouldCache(false);
queue.add(remoteConfig);
```
