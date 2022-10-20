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
//    var myShoe :Shoe= Shoe(
//    )
    fun initialize(){
    shoes.value = ArrayList()
}
    fun createNewShoe (shoe: Shoe){
        shoes.value?.add(shoe)
    shoes.value = shoes.value
}
//    fun deleteShoeOnCancel (){
//        myShoe = Shoe()
//    }
}