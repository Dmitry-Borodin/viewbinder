# viewbinder for Android

[ ![Download](https://api.bintray.com/packages/dmitrii/viewbinder/viewbinder/images/download.svg) ](https://bintray.com//dmitrii/viewbinder/viewbinder/_latestVersion)

View binding without an annotation processing and with just a few methods added to your dex.

##Usage:
```
private val recycler by bindView<RecyclerView>(R.id.my_view_id)
```

##Getting Started:

add gradle dependency
```compile 'com.krenvpravo.viewbinder:viewbinder:0.1'
```
Or just copy code from sources to your project

If you are using Fragments, add the following code to your base Fragment:
```private val lazyManager = ResettableLazyManager()
fun<T> Fragment.bindView(@IdRes id: Int): ResettableLazy<T> = abstractBind(id, lazyManager)
```

note: DialogFragment is a Fragment
Same for SupportLibrary

If your view is optional - just mark is as nullable

```private val recycler by bindView<RecyclerView?>(R.id.my_view_id)
or
private val recycler : RecyclerView?  by bindView<RecyclerView?>(R.id.my_view_id)
```

##Requirements:
1. Kotlin
2. Build tools or support library version > 26


Library is based on kotlin delegated properties
####Pros:
No annotation processing involved -> fast compile time.
Just a few methods in the library -> good for dex limit
Clear and

####Cons:
Works only with Kotlin
You have to add two lines to your parent Fragments
No easy way to set click listeners with meta programming
