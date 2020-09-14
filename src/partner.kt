fun partner() {
    loop@ while (true) {
        println("\n1.display partners\n2.Add partner\n3.Edit partner details\n4.Go Back")
        when (s.nextInt()) {
            1 -> pdisplay()
            2 -> add()
            3 -> edit()
            4 -> break@loop
        }
    }
}

fun pdisplay() {
    for (i in plist) {
        println("\nID: ${i.pid}\nName:${i.name}\nInvest:${i.invest}")
    }
}

fun add() {
    println("Enter partner name:")
    val name = readLine()
    println("Enter investment:")
    val invest = s.nextInt()
    val p1 = Partner("$pid", "$name", invest)
    pid += 1
    plist.add(p1)
    println("successfully added the partner")
    totalinvest += invest
    totalcash += invest
    println("total investment is $totalinvest")
}

fun edit() {
    if (plist.size != 0) {
        println("\n1.change partner name\n2.change in investment\n3.Go Back")
        when (s.nextInt()) {
            1 -> changename()
            2 -> changeinvest()
            3 -> partner()
        }
    } else {
        println("No partners!")
    }
}

fun changename() {
    var f = 0
    println(plist)
    println("Enter parner id:")
    val id = readLine()
    for (i in plist) {
        if (id == i.pid) {
            f = 1
            println("Enter new name:")
            val pname = readLine()
            pname?.let { i.name = pname }
            break
        }
    }
    if (f == 0) println("Enter a valid id!")
}

fun changeinvest() {
    var f = 0
    println(plist)
    print("Enter parner id:")
    val id = readLine()
    for (i in plist) {
        if (id == i.pid) {
            print("Enter new invest:")
            val pinvest = s.nextInt()
            i.invest = pinvest
            f = 1
            break
        }
        if (f == 0) println("Enter a valid id!")

    }

}