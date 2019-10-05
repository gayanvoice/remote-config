# Android Remote Config Library

[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/gayankuruppu/android-remote-config-library.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/gayankuruppu/android-remote-config-library/context:java) [![Build Status](https://travis-ci.org/gayankuruppu/android-remote-config-library.svg?branch=master)](https://travis-ci.org/gayankuruppu/android-remote-config-library) [![Total alerts](https://img.shields.io/lgtm/alerts/g/gayankuruppu/android-remote-config-library.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/gayankuruppu/android-remote-config-library/alerts/) [![](https://jitpack.io/v/gayankuruppu/android-remote-config-library.svg)](https://jitpack.io/#gayankuruppu/android-remote-config-library) [![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14) ![GitHub code size in bytes](https://img.shields.io/github/languages/code-size/gayankuruppu/android-remote-config-library)

A cool alternative for Google firebase remote-config library! Remote config the variables, appearance and the behavior of your app without publishing an app update. The library is based on Google Volley library.

<img width="360" alt="Android View Animations in Java" src="https://raw.githubusercontent.com/gayankuruppu/android-remote-config-library/master/remote-configure-app.gif">

Library retrieves the JSON file from https://github.com/gayankuruppu/android-remote-config-library/blob/master/remote-config.json.
To configure the data in the JSON file, you can `fork` the library and change the data in the JSON file.

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
#### Set internet permission
```groovy
<uses-permission android:name="android.permission.INTERNET" />
```
### Java
#### Import remote config library

```java
import com.remoteconfig.library.*;
```
#### Set request
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
### Kotlin
#### Import remote config library
```java
import com.remoteconfig.library.*
```
#### Set request
```kotlin
// set request
val queue = FetchRemote.newRequestQueue(this@MainActivity)

// url of the json file
val url = "https://raw.githubusercontent.com/gayankuruppu/android-remote-config-library/master/remote-config.json"

// request the json file
val remoteConfig = RemoteConfig(this@MainActivity, url,
	Response.Listener<String> {
		// json file retrieved

		// declare remote param
		val remoteParams = RemoteParams(this@MainActivity)

		// get String value
		val stringValue = remoteParams.getString("short_text", "default_text")

		// get int values
		val intValue = remoteParams.getInt("number", 200)

		// get JSON Object
		val jsonObject = remoteParams.getJSONObject("json_object")

		// get JSON Array
		val jsonArray = remoteParams.getJSONArray("json_array")

		// get boolean value
		val booleanValue = remoteParams.getBoolean("boolean", false)
		},
		Response.ErrorListener {
		    // json file retrieve error
	}
)

// clear cache
remoteConfig.setShouldCache(false)
queue.add(remoteConfig)
```
## Develop the library

1. Select `Git` from `Check out project from Version Control` in your Android Studio
2. Paste the repository url and click `Clone` button
3. Click `Yes` to open the repository
4. `Build` using the latest `Gradle` version

Go to https://github.com/gayankuruppu/android-vpn-client-ics-openvpn#develop see the steps
