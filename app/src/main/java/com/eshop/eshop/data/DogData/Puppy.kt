package com.eshopp.pets.ui.theme.data

import java.io.Serializable

 data class Puppy(
    val id: Int,
    val title:String,
    val sex:String,
    val age:Int,
    val description:String,
    val puppyImageId:Int=0



):Serializable

