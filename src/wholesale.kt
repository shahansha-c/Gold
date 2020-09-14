fun wholesale() {
    loop@ while (true) {
        println("\n1.DISPLAY PURCHASED GOLD\n2.PURCHASE GOLD\n3.PURCHASE ITEM\n4.GO BACK")
        when (s.nextInt()) {
            1 -> goldpurchasedisplay()
            2 -> goldpurchase()
            3 -> itempurchase()
            4 -> break@loop

        }
    }
}

fun goldpurchasedisplay() {
    println("PURCHASED GOLD IS $purchasedgweight GRAM")
}

fun goldpurchase() {
    print("ENTER HOWMANY GOLD YOU WANT TO PURCHASE IN GRAM:")
    val pweight = s.nextFloat()
    print("ENTER THE GOLD RATE PER GRAM:")
    val grate = s.nextFloat()
    val totalamount = pweight * grate
    if (totalamount > totalinvest) {
        println("YOU DON'T HAVE THE ENOUGH MONEY")
    } else {
        println("GOLD PURCHASED SUCCESSFULLY \n")
        println("TOTAL AMOUNT IS $totalamount")
        purchasedgweight += pweight
        totalcash -= totalamount
    }
}

fun itempurchase() {
    var f = 0
    print("ENTER ITEM NAME:")
    val itemname = readLine()
    print("ENTER THE GOLD RATE PER GRAM:")
    val rate = s.nextFloat()
    print("ENTER ITEM QUANDITY:")
    val quandity = s.nextInt()
    print("ENTER WEIGHT OF ITEM IN GRAM:")
    val weightingm = s.nextFloat()
    val amount = rate * quandity * weightingm
    if (amount > totalcash) {
        println("YOU DON'T HAVE THE ENOUGH MONEY")
        println("THE TOTAL CASH IS $totalcash")
    } else {


        for (i in itemslist) {
            if (i.itemname == itemname) {
                if (i.weightingm == weightingm) {
                    i.quandity += quandity
                    f = 1
                    println("ITEM PURCHASED SUCCESSFULLY \n")
                    println("TOTAL AMOUNT IS $amount")
                    totalcash -= amount
                    break

                }
            }
        }
        if (f == 0) {
            val p3 = Stock("$itemid", "$itemname", quandity, weightingm)
            itemslist.add(p3)
            itemid += 1
            println("ITEM PURCHASED SUCCESSFULLY \n")
            println("TOTAL AMOUNT IS $amount")
            totalcash -= amount
        }

        for (i in itemslist) {
            println("Id:${i.itemid}\nName:${i.itemname}\nQuantity:${i.quandity}\nWeight:${i.weightingm}")
        }
    }
}