package c.gingdev.mvvmrecyclerview.recycler

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

//스테틱으로 지정해줘야핢.
@BindingAdapter("replaceAll")
fun RecyclerView.replaceAll(list: List<Any>?) {
    (this.adapter as? baseRecyclerView.baseAdapter<Any, *>)?.run {
        replaceAll(list)
        notifyDataSetChanged()
    }
}