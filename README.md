Dagger Play
==

Dagger Play is a small set of reusable classes for [Dagger](https://github.com/square/dagger) injection. There many ways to implement Dagger into your project. Unfortunately memory leaks can occur easily if you implement it without attention.

Dagger Play just do the "step by step" for you and provides a minimum and necessary interface to inject and install Dagger into your project. So forget those tutorials and a lot of poor code snippets and start injecting!

- [Dagger Play](#dagger-play)
  - [Installation](#installation)
  - [Using](#using)
  - [Important Details](#important-details)
    - [@WithActivity & @WithApplication](#@withactivity-&-@withapplication)
    - [Default Injections](#default-injections)
  - [License](#license)

## Installation

It's very simple with gradle ;)

Add `mavenCentral` as repository source:

```gradle
repositories {
  mavenCentral()
}
```

And finnaly add this line inside `dependencies { }` section:

```gradle
compile 'com.squareup.dagger:dagger:1.2.+'
compile 'com.squareup.dagger:dagger-compiler:1.2.+'
compile 'com.github.fernandodev.daggerplay:daggerplay:+'
```

The `+` symbol indicates to gradle to get the latest version.

* See the sample if there are any doubts.

## Using

Like Dagger, you need to create a Module for your Android Project. Generally <AppName>Module. See the sample below:

```java
@Module(
    injects = {
        MainActivity.class    //THE INJECTABLE CLASSES
    },
    library = true,
    complete = false,
    overrides = false
)
public class SampleModule {

  @Provides UsefulHelper provideUsefulHelper(@WithActivity Context context) {
    return new UsefulHelper(context);
  }
}
```

Now, you have your main module [(you can create how many modules as you want)](http://square.github.io/dagger/), so you need to register it
and finally install Dagger into your application.

Extends android.app.Application and in `onCreate` just register your module and install Dagger.

```java
public class Samplepplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    DaggerPlay.registerModules(new SampleModule());
    DaggerPlay.install(this);
  }
}
```

* Call install after register all your modules.

Now you are ready to use your injections!

There are special methods in DaggerPlay class for `Activity`, `Fragment`, `Support Fragment` and `IntentService` injections.

```java
public static void injectActivity(Activity activity);

public static void injectFragment(Activity activity, Fragment fragment);

public static void injectSupportFragment(Activity activity, android.support.v4.app.Fragment fragment);

public static void injectService(IntentService service);
```

So, in `onCreate` callback, just call `DaggerPlay.injectActivity(this);` and everything will work like a charm.

## Important Details

### @WithActivity & @WithApplication

This is a especial annotation to distinguish `Context` provided by Application or Activity. So, if you want a `Context` from `Activity` use this annotation.

### Default Injections

With DaggerPlay you get default injections for your application

1. `@Inject @WithActivity Context`
2. `@Inject Resources`
3. `@Inject Application`
4. `@Inject Activity`
5. `@Inject @WithApplication Context`

## License

The MIT License (MIT)

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.