
fun stock() {
    if (itemslist.size==0)
    {
        println("No stock!\n")

    }
    else {
        for (i in itemslist) {
            println("Id:${i.itemid}\nName:${i.itemname}\nQuantity:${i.quandity}\nWeight:${i.weightingm}")
        }
    }
}

