# viewbinder for Android

[ ![Download](https://api.bintray.com/packages/dmitrii/viewbinder/viewbinder/images/download.svg) ](https://bintray.com//dmitrii/viewbinder/viewbinder/_latestVersion) 
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

View binding without an annotation processing and with just a few methods added to your dex.

## Usage:
```
private val recycler by bindView<RecyclerView>(R.id.my_view_id)
```

## Getting Started:

Add gradle dependency:
```
api "com.viewbinder:viewbinder:0.3.1"
```
Or just copy code from sources to your project

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

Examples is in  samples folder.

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


### Library is based on kotlin delegated properties
#### Pros:
1. No annotation processing involved -> fast compile time.
2. Just a few methods in the library -> good for dex limit
3. Clear and managable declaration of binded views -> good for you

#### Cons:
1. Works only with Kotlin
2. You have to add two lines to your parent Fragments
3. No easy way to set click listeners with meta programming
