# Android Remote Config Library

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
	implementation 'com.github.gayankuruppu:android-remote-config-library:1.0.3'
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
	<version>1.0.3</version>
</dependency>
```
## Usage
### Set internet permission

```groovy
<uses-permission android:name="android.permission.INTERNET" />
```

### Import remote config library

```java
import com.remoteconfig.library.*;
```

### Set request

```java
// set request
RequestQueue queue = FetchRemote.newRequestQueue(MainActivity.this);

// url of the json file
String url ="https://raw.githubusercontent.com/gayankuruppu/android-remote-config-library/master/remote-config.json";

// request the json file
RemoteConfig remoteConfig = new RemoteConfig(MainActivity.this, url,
	new Response.Listener<String>() {
		@Override
		public void onComplete() {
			// json file retrieved
			
			// declare remote param
			RemoteParams remoteParams = new RemoteParams(MainActivity.this);
			
			// get String value
			String stringValue = remoteParams.getString("short_text", "default_text");
			
			// get int values
			int intValue = remoteParams.getInt("number", 200);
			
			// get JSON Object
			JSONObject jsonObject = remoteParams.getJSONObject("json_object");
			
			// get JSON Array
			JSONArray jsonArray = remoteParams.getJSONArray("json_array");
			
			// get boolean value
			boolean booleanValue = remoteParams.getBoolean("boolean", false);
		}
	},
	new Response.ErrorListener() {
		@Override
		public void onError(RemoteError error) {
			// json file retrieve error
		}
	}
);

// clear cache
remoteConfig.setShouldCache(false);
queue.add(remoteConfig);
```
