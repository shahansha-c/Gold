fun smith() {
    loop@ while (true) {
        println("\n1.DISPLAY SMITH\n2.GOLD TO SMITH\n3.ITEM FROM SMITH\n4.BALANCE FROM SMITH\n5.PAYMENT TO SMITH\n6.GO BACK")
        when (readLine()) {
            "1" -> smithdisplay()
            "2" -> tosmith()
            "3" -> resmith()
            "4" -> balancegfromsmith()
            "5" -> smithpaydetails()
            "6" -> break@loop
            else -> println("ENTER A VALID CHOICE \n")
        }
    }
}

fun smithdisplay() {
    if (smithlist.size == 0) println("YOUR SMITH LIST IS EMPTY")
    for (i in smithlist) {
        println("ID:${i.smithid}\nNAME:${i.smname}\nGOLD TO SMITH:${i.gtosmith}\nGOLD FROM SMITH:${i.ftosmith}\nCASH TO SMITH:${i.cashtosmith}")
    }
}

fun tosmith() {
    var gtosmith:Float
    var flag = 1
    print("ENTER SMITH NAME :")
    val smname:String = readLine().toString()

    for (i in smithlist) {
        if (i.smname == smname) {
            print("ENTER THE AMOUNT OG GOLD TO SENT IN GRAM:")
            gtosmith = s.nextFloat()
            if (gtosmith > purchasedgweight) {
                println("YOU DON'T HAVE THAT MUCH GOLD")
            } else {
                i.gtosmith = i.gtosmith + gtosmith
            }
            flag = 0
            break
        }
    }
    if (flag == 1) {

        print("ENTER THE AMOUNT OG GOLD TO SENT IN GRAM:")
        gtosmith = s.nextFloat()
        if (gtosmith > purchasedgweight) {
            println("YOU DON'T HAVE THAT MUCH GOLD")
        } else {
            val s1 = Smith("$smithid", smname, gtosmith)
            smithlist.add(s1)
            smithid+=1
            purchasedgweight -= gtosmith
            goldtosmith += gtosmith
        }
    }
}

fun resmith() {
    if (goldtosmith > 0) {
        var flag = 1
        var f = 1
        val gfromsmith: Float
        print("ENTER SMITH ID:")
        val smid = readLine()
        print("ENTER ITEM NAME:")
        val itemname = readLine()
        print("ENTER ITEM QUANTITY:")
        val quandity = s.nextInt()
        print("ENTER WEIGHT IN GRAM:")
        val weightingm = s.nextFloat()
        print("ENTER TOUCH PER GRAM:")
        val touchrate = s.nextFloat()
        gfromsmith = weightingm * quandity
        val cash = gfromsmith * touchrate
        for (i in smithlist) {
            if (i.smithid == smid) {
                flag = 0
                for (x in itemslist) {
                    if (x.itemname == itemname) {
                        if (x.weightingm == weightingm) {
                            if (gfromsmith <= i.gtosmith) {
                                f = 0
                                x.quandity += quandity
                                i.ftosmith = i.ftosmith + gfromsmith
                                i.gtosmith = i.gtosmith - gfromsmith
                                i.cashtosmith = i.cashtosmith + cash
                                println("GOLD FROM SMITH IS $gfromsmith GRAM")
                                println("CASH TO PAY SMITH IS $cash")
                                break
                            } else {
                                println("YOU DIDN'T GIVE THAT MUCH GOLD TO SMITH")
                            }
                        }
                    }


                }
                if (f == 1) {
                    if (gfromsmith <= i.gtosmith) {
                        i.ftosmith = i.ftosmith + gfromsmith
                        i.gtosmith = i.gtosmith - gfromsmith
                        i.cashtosmith = i.cashtosmith + cash
                        println("GOLD FROM SMITH IS $gfromsmith GRAM")
                        println("CASH TO PAY SMITH IS $cash")
                        val p3 = Stock("$itemid", "$itemname", quandity, weightingm)
                        itemid += 1
                        itemslist.add(p3)
                    }
                    else {
                        println("YOU DIDN'T GIVE THAT MUCH GOLD TO SMITH")
                    }

                }

            }

        }
        if (flag == 1) {
            println("ENTER A VALID SMITH ID")
        }
    }
}


fun balancegfromsmith() {

    for (i in smithlist) {
        println("BALANCE GOLD FROM SMITH ID ${i.smithid} is ${i.gtosmith} GRAM")
    }

}

fun smithpaydetails() {
    var flag = 1
    print("ENTER SMITH ID:")
    val smid = readLine()
    for (i in smithlist) {
        if (i.smithid == smid) {
            flag = 0
            println("TOTAL AMOUNT TO SMITH IS ${i.cashtosmith}")
            print("ENTER THE AMOUNT TO PAY SMITH IS:")
            val smithpay = s.nextFloat()
            i.cashtosmith = i.cashtosmith - smithpay
            totalcash -= smithpay
        }
    }
    if (flag == 1) {
        println("ENTER A VALID ID")
    }
}