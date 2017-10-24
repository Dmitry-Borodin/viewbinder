View binding without an annotation processing and with just a few mathods.

Usage:
private val recycler by bindView<RecyclerView>(R.id.my_view_id)


Preparation:

add gradle dependencie

If you are using Fragments, add the following code to your base Fragment:

private val lazyManager = ResettableLazyManager()
fun<T> Fragment.bindView(@IdRes id: Int): ResettableLazy<T> = abstractBind(id, lazyManager)

note: DialogFragment is a Fragment
Same for SupportFragment and SupportDialogFragment

If your view is optional - just mark is as nullable
private val recycler by bindView<RecyclerView?>(R.id.my_view_id)
or
private val recycler : RecyclerView?  by bindView<RecyclerView?>(R.id.my_view_id)

Library is based on kotlin delegate properties
Pros: 
No annotation processing involved -> fast compile time.
Just a few methods in the library -> good for dex limit

Cons: 
Works only with Kotlin
You have to add two lines to your parent Fragments