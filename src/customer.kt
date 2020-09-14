fun customer() {
    loop@ while (true) {
        println("1.Display Customer details\n2.New Purchase\n3.CUSTOMER PAY DETAILS\n4.Payment\n5.GO BACK")
        when (readLine()) {
            "1" -> displaycustomers()
            "2" -> addcustomer()
            "3" -> customerpaydetails()
            "5" -> break@loop
            else -> println("ENTER A VALID CHOICE")
        }
    }
}

fun customerdetails() {
    if (customerlist.size == 0) println("YOUR CUSTOMER LIST IS EMPTY")
    for (i in customerlist) {
        println("CUSTOMER ID:${i.custid}  NAME:${i.name}  ITEM:${i.item}  QUANDITY:${i.quandity}  GOLD WEIGHT:${i.weightingm}  AMOUNT:${i.Totalamount} Total Bill:${i.totalbill}")
    }
}

fun custpaydetails() {
    if (custpaylist.size == 0) println("YOUR PAYMENT LIST IS EMPTY")
    for (i in custpaylist) {
        println("CUSTOMER ID:${i.custid}  PAID AMOUNT:${i.amount}  WEIGHT OF OLD GOLD:${i.weight}")
    }
}

fun displaycustomers() {
    loop@ while (true) {
        println("1.DISPLAY CUSTOMER DETAILS\n2.DISPLAY CUSTOMER PAYMENT DETAILS\n3.GO BACK")
        when (readLine()) {
            "1" -> customerdetails()
            "2" -> custpaydetails()
            "3" -> break@loop
            else -> println("ENTER A VALID CHOICE")
        }
    }

}

fun addcustomer() {
    if (itemslist.size == 0) {
        println("YOUR STOCK LIST IS EMPTY, PLEASE PURCHASE SOME ITEMS\n")
    } else {
        print("ENTER GOLD RATE AT THAT TIME:")
        val goldrate = s.nextInt()
        print("ENTER CUSTOMER ID:")
        val custid = readLine()
        print("ENTER CUSTOMER NAME:")
        val name = readLine()
        for (i in itemslist) {
            println("Id:${i.itemid}\nName:${i.itemname}\nQuantity:${i.quandity}\nWeight:${i.weightingm}")
        }
        var noofitems=0
        while (true) {
            print("ENTER ITEM ID: ")
            val itemid = readLine()
            print("ENTER ITEM QUANDITY:")
            val quandity = s.nextInt()
            val q = Pur("$custid", "$itemid", quandity)
            purlist.add(q)
            noofitems+=1
            println("Press any other key to add more items, press 'Enter' key for billing")
            if (readLine() == "") {
                break
            }

        }
        var billamount = 0F
        var items = ""
        var q = " "
        var wg = " "
        var to = ""
        for (k in purlist) {
            for (i in itemslist) {
                if (i.itemid == k.id && i.quandity > k.quantity) {
                    noofitems-=1
                    val weightingm = i.weightingm
                    val totalamount = (goldrate * weightingm * k.quantity)
                    billamount += totalamount
                    items += "${i.itemname}, "
                    q += "${k.quantity}, "
                    wg += "${i.weightingm}, "
                    to += "$totalamount, "
                    i.quandity = i.quandity - k.quantity

                }

            }

        }
        if(noofitems==0){
            val p2 = Customer("$custid", "$name", "($items)", "($q)", "($wg)", "($to)",billamount)
            customerlist.add(p2)
            println("Total : $billamount")
            print(customerlist)

        }
        else(
                println("Invalid!!")
                )
        purlist.clear()

    }
}

fun customerpaydetails() {
    if (customerlist.size == 0) println("YOU DON'T HAVE ANY CUSTOMER\n")
    else {
        var flag = 1
        println(customerlist)
        print("ENTER CUSTOMER ID:")
        val custid = readLine()
        for (i in customerlist) {
            if (i.custid == custid) {
                flag = 0
                println("TOTAL AMOUNT OF CUSTOMER ${i.custid} IS ${i.totalbill}")
                print("ENTER AMOUNT OF CUSTOMER PAID:")
                val amount = s.nextFloat()
                print("ENTER THE WEIGHT OF CUSTOMER OLD GOLD:")
                val weight = s.nextFloat()
                if (weight > 0) {
                    println("THE CONVERSION OF OLD GOLD TO MONEY IS")
                    print("ENTER OLD GOLD RATE PER GRAM:")
                    val oldgoldrate = s.nextFloat()
                    val oldtomoney = oldgoldrate * weight
                    println("THE CONVERSION OF OLD GOLD TO MONEY IS $oldtomoney")
                    val total = amount + oldtomoney
                    val p1 = Paydetails("$custid", amount, weight)
                    custpaylist.add(p1)
                    println(custpaylist)
                    if ((i.totalbill) == total) {
                        println("THE CUSTOMER ${i.custid} IS CLEARED ALL ")
                    } else {
                        val balance = i.totalbill - total
                        println("THE BALANCE OF AMOUNT CUSTOMER ID ${i.custid} IS $balance")
                    }
                    profit += total
                    totalcash += profit
                } else {
                    val p1 = Paydetails("$custid", amount, weight)
                    custpaylist.add(p1)
                    println(custpaylist)
                    if ((i.totalbill) == amount) {
                        println("THE CUSTOMER ${i.custid} IS CLEARED ALL ")
                    } else {
                        val balance = (i.totalbill) - amount
                        println("THE BALANCE OF AMOUNT CUSTOMER ID ${i.custid} IS $balance")
                    }
                    profit += amount
                    totalcash += profit
                }
            }
        }
        if (flag == 1) {
            println("ENTER A VALID DATA")
        }
    }
}


