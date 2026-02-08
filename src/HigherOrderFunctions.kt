data class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Печенье с шоколадом",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Ванильный крем",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Шоколадно-арахисовое масло",
        softBaked = false,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Нуга ореховая",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Сникерс",
        softBaked = true,
        hasFilling = true,
        price = 1.39
    ),
    Cookie(
        name = "Черничный пирог",
        softBaked = true,
        hasFilling = false,
        price = 1.79
    ),
    Cookie(
        name = "Сахар и посыпка",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    cookies.forEach {
        println("${it.name} - $${it.price}")
    }
    println()
    val menuItems = cookies.map {
        "${it.name} - $${"%.2f".format(it.price)}"
    }
    menuItems.forEach { println(it) }
    println()
    val softCookies = cookies.filter { it.softBaked }
    println("Мягкое печенье:")
    softCookies.forEach {
        println("  ${it.name} - $${it.price}")
    }
    println()
    val groupedMenu = cookies.groupBy { it.softBaked }
    val softBakedMenu = groupedMenu[true] ?: emptyList()
    val crunchyMenu = groupedMenu[false] ?: emptyList()
    println("Soft cookies:")
    softBakedMenu.forEach {
        println("  ${it.name} - $${it.price}")
    }
    println("\nCrunchy cookies:")
    crunchyMenu.forEach {
        println("  ${it.name} - $${it.price}")
    }

    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }
    println("Total price: $${"%.2f".format(totalPrice)}")

    println("Меню в алфавитном порядке:")
    val alphabeticalMenu = cookies.sortedBy { it.name }
    alphabeticalMenu.forEach {
        println(it.name)
    }
    println()

}