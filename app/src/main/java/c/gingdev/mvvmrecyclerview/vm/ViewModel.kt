package c.gingdev.mvvmrecyclerview.vm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import c.gingdev.mvvmrecyclerview.data.DataModel

class ViewModel: ViewModel() {
    val items = MutableLiveData<List<DataModel>>()

    init {
        items.postValue(getDatas())
    }

    fun getDatas(): List<DataModel> {
        val items = ArrayList<DataModel>()
        items.add(DataModel("index : 1", "say Hello~"))
        items.add(DataModel("index : 2", "say Hello~"))
        items.add(DataModel("index : 3", "say Hello~"))
        items.add(DataModel("index : 4", "say Hello~"))
        items.add(DataModel("index : 5", "say Hello~"))
        items.add(DataModel("index : 6", "say Hello~"))
        items.add(DataModel("index : 7", "say Hello~"))
        items.add(DataModel("index : 8", "say Hello~"))
        items.add(DataModel("index : 9", "say Hello~"))
        items.add(DataModel("index : 10", "say Hello~"))

        return items.toList()
    }

}