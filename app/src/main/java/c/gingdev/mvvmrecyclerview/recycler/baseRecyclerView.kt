package c.gingdev.mvvmrecyclerview.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import java.lang.Exception

/**
 * ITEM : itemClass
 * BINDING : ViewHolder 의 Layout에 해당하는 DataBinding Class
 *
 * */

abstract class baseRecyclerView {
    abstract class baseAdapter<ITEM: Any, BINDING: ViewDataBinding>(
        @LayoutRes private val layoutResId: Int,
        private val bindingVariableId: Int? = null)
        : RecyclerView.Adapter<baseViewHolder<BINDING>>() {
        private val items = mutableListOf<ITEM>()

        fun replaceAll(items: List<ITEM>?) {
            items?.let {
                this.items.run {
                    clear()
                    addAll(it)
                }
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): baseViewHolder<BINDING> =
                object : baseViewHolder<BINDING>(
                    layoutResId = layoutResId,
                    parent = parent,
                    bindingVariableId = bindingVariableId
                ) {}

        override fun getItemCount(): Int = items.size

        override fun onBindViewHolder(holder: baseViewHolder<BINDING>, position: Int) {
            holder.bind(items[position])
        }
    }

    abstract class baseViewHolder<BINDING: ViewDataBinding>(
        @LayoutRes layoutResId: Int,
        parent: ViewGroup,
        private val bindingVariableId: Int?)
        :RecyclerView.ViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(layoutResId, parent, false)) {
        protected val binding: BINDING = DataBindingUtil.bind(itemView)!!

        fun bind(item: Any?) {
            try {
                bindingVariableId?.let {
                    binding.setVariable(it, item)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

}