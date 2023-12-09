package com.example.artgallery

interface  example{
    var Artist : String
    var photo : Int
    var Year: String
    var Title : String
}

object Art1 : example
 {
    override var Artist: String = " Max"
    override var photo: Int= R.drawable.photo1
     override var Year: String="2012"
    override var Title: String="Pink Phone"
}
object Art2 : example
{
    override var Artist: String = " Maks"
    override var photo: Int=R.drawable.photo2
    override var Year: String="1992"
    override var Title: String="Black Phone"

}
object Art3 : example
{
    override var Artist: String = " Max"
    override var photo: Int=R.drawable.photo3
    override var Year: String="2018"
    override var Title: String="Gray Phone"

}

val ArtList  = listOf(Art1,Art2,Art3)