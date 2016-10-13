# CircularIndicator

CircularIndicator for ViewPager.

## Screenshot
<img src="https://raw.githubusercontent.com/hearsilent/CircularIndicator/master/screenshots/screenrecord.gif" height="500">

<img src="https://raw.githubusercontent.com/hearsilent/CircularIndicator/master/screenshots/device-2016-10-13-150043.png" height="500">

## Usage

Just Clone and Build.

### Xml Layout
```xml
<com.github.hearsilent.circularindicator.CircularIndicator
    android:id="@+id/indicator"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_gravity="bottom"
    android:animateLayoutChanges="true"
    android:gravity="center"
    android:orientation="horizontal"
    android:padding="16dp"/>
```
### Java Code
```java
mAdapter = new PagerAdapter(getSupportFragmentManager());
mViewPager.setAdapter(mAdapter);
mCircularIndicator.setupWithViewPager(mViewPager);
```

## Compatibility

Android GINGERBREAD 4.0+

## Let me know!

I'd be really happy if you sent me links to your projects where you use my component. Just send an email to hear.silent1995@gmail.com And do let me know if you have any questions or suggestion regarding the example. 

## License

    Copyright 2016, HearSilent

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
