package c.gingdev.mvvmrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import c.gingdev.mvvmrecyclerview.data.DataModel
import c.gingdev.mvvmrecyclerview.databinding.ActivityMainBinding
import c.gingdev.mvvmrecyclerview.databinding.ItemViewBinding
import c.gingdev.mvvmrecyclerview.recycler.baseRecyclerView
import c.gingdev.mvvmrecyclerview.vm.ViewModel

class MainActivity : AppCompatActivity() {

//    val binding by lazy {
//        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.run {
            lifecycleOwner = this@MainActivity
            vm = ViewModelProviders.of(this@MainActivity)[ViewModel::class.java]
            recycler.adapter = object : baseRecyclerView.baseAdapter<DataModel, ItemViewBinding>(
                layoutResId = R.layout.item_view,
                bindingVariableId = BR.dataModel
            ) {}
        }
    }
}
