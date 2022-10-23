package com.example.shoe.viewmodel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoe.model.Shoe

class AppViewModel:ViewModel() {
    var shoes :MutableLiveData<MutableList<Shoe>> = MutableLiveData()
    fun shoesGetter (): LiveData<MutableList<Shoe>?> {
        return shoes
    }
    var myShoe :Shoe= Shoe(
        "",
        0.0,"",""
    )
    fun initialize(){
    shoes.value = ArrayList()
}
    fun createNewShoe (){
    shoes.value?.add(myShoe)
    shoes.value = shoes.value
    }

    fun deleteShoeOnCancel (){
        myShoe  = Shoe(
            "",
            0.0,"",""
        )
        shoes.value = shoes.value
    }
}