import java.util.Scanner

var s = Scanner(System.`in`)

data class Partner(var pid: String, var name: String, var invest: Int)
data class Customer(var custid: String, var name: String, var item: String, var quandity: String, var weightingm: String, var Totalamount: String,var totalbill:Float)
data class Stock(var itemid: String, var itemname: String, var quandity: Int, var weightingm: Float)
data class Paydetails(var custid: String, var amount: Float, var weight: Float)
data class Smith(var smithid: String, var smname: String, var gtosmith: Float, var ftosmith: Float = 0F, var cashtosmith: Float = 0F)
data class Pur(var cusid:String, var id:String, var quantity: Int)

var plist = arrayListOf<Partner>()
var totalinvest: Float = 0F
var profit: Float = 0F
var totalcash: Float = 0F
var purchasedgweight: Float = 0F
var customerlist = arrayListOf<Customer>()
var custpaylist = arrayListOf<Paydetails>()
var smithlist = arrayListOf<Smith>()
var purlist = arrayListOf<Pur>()
var pid = 1
var goldtosmith = 0F
var itemid = 1
var smithid = 1
var itemslist = arrayListOf<Stock>()

fun main() {
    loop@ while (true) {
        println("1.Partners\n2.Wholesale\n3.Smith\n4.Stock\n5.Customer\n6.Profit details\n7.Exit\nEnter an option: ")
        when (s.nextInt()) {
            1 -> partner()
            2 -> wholesale()
            3 -> smith()
            4 -> stock()
            5 -> customer()
            6 -> prdetails()
            7 -> break@loop
            else -> println("Invalid")
        }
    }
}


