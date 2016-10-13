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

MIT License

    Copyright (c) 2016 HearSilent

    Permission is hereby granted, free of charge, to any person obtaining a copy
    of this software and associated documentation files (the "Software"), to deal
    in the Software without restriction, including without limitation the rights
    to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
    copies of the Software, and to permit persons to whom the Software is
    furnished to do so, subject to the following conditions:

    The above copyright notice and this permission notice shall be included in all
    copies or substantial portions of the Software.

    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
    AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
    LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
    OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
    SOFTWARE.
