# viewbinder for Android

[![Build Status](https://app.bitrise.io/app/5576398801c9399c/status.svg?token=_HS5QG9xmb52Q7Et0LDzAw&branch=dev)](https://app.bitrise.io/app/5576398801c9399c)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.dmitryborodin/viewbinder-android/badge.svg?style=plastic)](https://maven-badges.herokuapp.com/maven-central/com.dmitryborodin/viewbinder-android)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Viewbinder-green.svg?style=flat )]( https://android-arsenal.com/details/1/7819 )

View binding without an annotation processing and with just a few methods added to your dex.

## Usage:
```
private val recycler by bindView<RecyclerView>(R.id.my_view_id)
```

## Add to your project:

The library is hosted in the central repository.
```
     repositories {
        <...>
        mavenCentral()
    }
```

Add gradle dependency:
```
api "com.dmitryborodin:viewbinder:2.1.0"
```
Or just copy code from sources to your project. This library is very slim and was written in idea that you'll copy few functions instead of adding dependency. 

#### Fragments

If you are using Fragments, add the following code to your base Fragment:
```
private val resetter = BindingResetter()
fun<T> Fragment.bindView(@IdRes id: Int): ResettableLazy<T> = abstractBind(id, resetter)
```

And in onStop() implement
```
 override fun onStop() {
        super.onStop()
        resetter.reset()
    }
```
For non-Fragments no extra code is needed. Just bind your views.

Examples is in samples folder.

#### Note:
DialogFragment is a Fragment;
Same for SupportLibrary

If your view is optional - just mark is as nullable

```
private val recycler by bindView<RecyclerView?>(R.id.my_view_id)
or
private val recycler : RecyclerView?  by bindView<RecyclerView?>(R.id.my_view_id)
```

## Requirements:
1. Kotlin
2. Build tools or support library version > 26

## Migration from ButterKnife
In Android studio run "Replace in path"
 
search for
```@BindView\((.*)\) internal lateinit var (.*): (.*)```
 
replace with
```private val $2 by bindView<$3>($1)```

-----

#### Similar to [KotterKnife](https://github.com/JakeWharton/kotterknife), but:
* Available in jcenter and bintray
* Less abstractions/code/methods - simpler to copy code without maven dependencies 

### Library is based on kotlin delegated properties
#### Pros:
1. No annotation processing involved -> fast compile time.
2. Just a few methods in the library -> good for dex limit
3. Clear and managable declaration of binded views -> good for you
4. XML naming conventions are still independent from view names in code.

#### Cons:
1. Works only with Kotlin
2. You have to add two lines to your parent Fragments
3. No easy way to set click listeners with meta programming
4. If you have kotlin-reflect library if your module available, unnecessary reflection calls will happen on each kotlin delegation creation (in out case for each view binding)
 
