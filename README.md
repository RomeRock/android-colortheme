[![mm_header.jpg](https://s16.postimg.org/674mqlohx/mm_header.jpg)](https://postimg.org/image/dzvaikugx/)

# android-colortheme
Android app example integration for use diferent themes in your app. Free themes and theme for full version. 
## Dependencies
[Butter Knife](http://jakewharton.github.io/butterknife/) Field and method binding for Android views which uses annotation processing to generate boilerplate code for you.
```swift
Gradle
//Butterknife Field and method binding for Android views which uses annotation processing to generate boilerplate code for you. (Not necessary)
compile 'com.jakewharton:butterknife:8.5.1'
annotationProcessor 'com.jakewharton:butterknife-compiler:8.5.1'

```

### Plugins
This example use extended with the following plugins. Instructions on how to use them in your own application are linked below.
 
| Plugin | README | DESCRIPTION
| ------ | ------ | ------ |
| ButterKnifeZelezny |[butterknife-zelezny/]( https://github.com/avast/android-butterknife-zelezny/)  | Simple plug-in for Android Studio/IDEA that allows one-click creation of Butterknife view injections.


## Installation and configuration
- Clone the project
- Change color or add more schemas  
```swift
// color.xml file
<color name="colorPrimary">#17B0EF</color>
<color name="colorPrimaryDark">#1976d2</color>
<color name="colorAccent">#0288D1</color>
```
For each schema for use, have colorPrimary, colorPrimaryDark and colorAccent in your color.xml file.

When change schema  with  **setTheme(getThemePreferences(getApplication()));**  you set the three color. Example for Orange theme the style will be:
```swift
<style name="Orange" parent="Theme.AppCompat.Light.DarkActionBar">
        <item name="colorPrimary">@color/colorPrimaryOrange</item>
        <item name="colorPrimaryDark">@color/colorPrimaryDarkOrange</item>
        <item name="colorAccent">@color/colorAccentOrange</item>
        <item name="windowActionBar">false</item>
        <item name="windowNoTitle">true</item>
    </style>
```
**getThemePreferences** is afunction to get the color saved in Preferences file that return int value of the resource

The module simulates the pro version to unlock other themes to use in the app.

[![specialThemes.gif](https://s25.postimg.org/ut1kfrdvj/special_Themes.gif)](https://postimg.org/image/q75g7escb/)

There is an indicator if the pro version is active or deactivated. If activated it, we can use all the themes for the application and at any time we can return to the initial values

## License

This project is is available under the MIT License, Version 2.0 e. See the LICENSE file for more info. Attribution by linking to the [project page](https://github.com/RomeRock/ios-calculator) is appreciated.


<div>
<a href="http://romerock.com"> <img style="max-width: 100%; margin:7" src="https://avatars3.githubusercontent.com/u/23345883?v=3&s=200=true" alt="Google Play" height="50px" /> </a>
<a href="https://www.facebook.com/romerockapps/?ref=page_internal"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/6sjokzpd5/facebook_icon.png=true" alt="Google Play" height="50px" /> </a>
<a href="https://twitter.com/romerock_apps"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/w2eg82w4p/twitter_icon.png=true" alt="Google Play" height="50px" /></a>
<a href="https://play.google.com/store/apps/dev?id=5841338539930209563"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/n29unw015/android_icon.png=true" alt="Google Play" height="50px" /></a>
<a href="https://itunes.apple.com/us/developer/rome-rock-llc/id1190244007"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/leap98m5l/ios_icon.png=true" alt="Google Play" height="50px" /></a>
<a href="https://github.com/RomeRock"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/wpdcxlt0p/github_icon.png=true" alt="Google Play" height="50px" /></a>
<a href="https://www.youtube.com/channel/UCcSLNuTYC7qJhOKQ4CpseRA"> <img style="max-width: 100%; margin:7" src="https://s18.postimg.org/w4ybuwzs9/youtube_icon.png=true" alt="Google Play" height="50px" /></a>
</div>
