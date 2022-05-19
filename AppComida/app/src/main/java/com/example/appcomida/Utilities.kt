package com.example.appcomida

import android.content.Context
import android.view.Menu
import android.widget.Toast
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore

object Utilities {
    lateinit var usersRef: CollectionReference
    lateinit var restaurantsRef: CollectionReference
    lateinit var categoriesRef: CollectionReference
    lateinit var selectedRestaurant: Restaurant
    lateinit var selectedMenuItem: MenuItem
    lateinit var userID: String
    val userCart = userCart()

    fun initReferences(){
        val db = FirebaseFirestore.getInstance()
        usersRef = db.collection("Users")
        restaurantsRef = db.collection("Restaurants")
        categoriesRef = db.collection("Categories")
    }

    fun getDocumentRef(collection: CollectionReference, document: String): DocumentReference{
        return collection.document(document)
    }

    fun Subtotal(): Int{
        var subtotal: Int = 0

        userCart.items.forEach {
            subtotal += it.item!!.price!! * it.quantity!!
        }
        return subtotal
    }

    fun displayShortToast(message: String, baseContext: Context){
        Toast.makeText(baseContext, message, Toast.LENGTH_SHORT).show()
    }
    fun displayLongToast(message: String, baseContext: Context){
        Toast.makeText(baseContext, message, Toast.LENGTH_LONG).show()
    }
    fun buildRestaurant(){
        /*val cats:
                MutableList<String>? = arrayListOf()
        cats!!.add("Burger")
        cats!!.add("Fast food")
        var restaurant: Restaurant = Restaurant("Burger King",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2FbugerKing.jpg?alt=media&token=00dbd8a6-b297-4968-b568-40819eb59e99",
            "7am",
            "11pm",
            4.2,
            null,
            cats)
        val restaurants: MutableMap<String?, Restaurant?> = mutableMapOf()
        restaurants[null] = (Restaurant("Burger King",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2FbugerKing.jpg?alt=media&token=00dbd8a6-b297-4968-b568-40819eb59e99",
            "7am",
            "11pm",
            4.2,
            null,
            arrayListOf("Burger", "Fast food")))


        restaurants[""] = (Restaurant("Krispy Kreme",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/krispykreme%2Fkrispykreme.jpeg?alt=media&token=26f8d4de-0503-4b2f-b1d8-6b30854675d4",
            "5am",
            "11pm",
            4.8,
            null,
            arrayListOf("Desserts, Donuts")))

        restaurantsRef.add(Restaurant("Krispy Kreme",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/krispykreme%2Fkrispykreme.jpeg?alt=media&token=26f8d4de-0503-4b2f-b1d8-6b30854675d4",
            "5am",
            "11pm",
            4.8,
            null,
            arrayListOf("Desserts, Donuts")))

        restaurantsRef.add(Restaurant("Burger King",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2FbugerKing.jpg?alt=media&token=00dbd8a6-b297-4968-b568-40819eb59e99",
            "7am",
            "11pm",
            4.2,
            null,
            arrayListOf("Burger", "Fast food")))

        restaurantsRef.add(Restaurant("Le Fate",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/leFate%2Flefate.jpg?alt=media&token=b41f2d35-edff-45f7-8c5a-d85689d6f2a1",
            "1:30pm",
            "10pm",
            5.0,
            null,
            arrayListOf("Italian", "Pizza", "Pasta")))
        restaurantsRef.add(Restaurant("Wazzabi",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/Wazzabi%2Fwazzabi.jpeg?alt=media&token=ed9e23f0-924e-49d5-9d5c-f2e42cd535ef",
            "1pm",
            "10pm",
            4.8,
            null,
            arrayListOf("Sushi", "Japanese", "Asian")))
        restaurantsRef.add(Restaurant("Panda Express",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/PandaExpress%2Fpandaexpress.jpeg?alt=media&token=d509a294-570b-495e-80d6-ceb4570e5b64",
            "10am",
            "11pm",
            4.5,
            null,
            arrayListOf("Chinese", "Asian")))
        restaurantsRef.add(Restaurant("Taqueria Leo",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/TacosLeo%2Ftacosleo.jpeg?alt=media&token=b88f862e-f64e-4922-b20d-f481a6ebe692",
            "5pm",
            "3am",
            4.9,
            null,
            arrayListOf("Mexican", "Tacos")))
        restaurantsRef.add(Restaurant("Mc Donald's",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/McDonalds%2Fmcdonalds.jpg?alt=media&token=06355542-f51b-47c7-9e68-d25def438dc9",
            "7am",
            "11pm",
            3.9,
            null,
            arrayListOf("Fast food", "Burger")))
        restaurantsRef.add(Restaurant("Domino's Pizza",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/Dominos%2Fdominos.jpeg?alt=media&token=02a35f80-2836-4918-9449-9fad54d2db23",
            "11am",
            "11pm",
            5.0,
            null,
            arrayListOf("Pizza", "Italian", "Fast food")))*/
        /*restaurantsRef.add(Restaurant("",
            "",
            "",
            "",
            ,
            null,
            arrayListOf("")))*/

    }
    fun populateMenu(){

        /*Little Caesars
        val id = "08PS1qHo4wYMqOjUvZ5B"
        val items: MutableList<MenuItem> = arrayListOf()
        items.add(MenuItem("Cheese Pizza", "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/LittleCaesars%2Fmenu%2FcheesePizza.webp?alt=media&token=e9f5f12b-eed2-4b90-b4e5-8681e32111f5", "30cm of delicious handmade bread with dough made this very same day and the most delicious and homemade flavourful tomato sauce with the best quality mozzarella cheese", 79.0))
        items.add(MenuItem("BBQ Wings", "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/LittleCaesars%2Fmenu%2FBBQWings.jpg?alt=media&token=436a1fe5-789f-42b4-994d-4aadd85fef29", "El sabor dulce de la salsa BBQ tradicional, con un picante perfecto", 119.0))
        items.add(MenuItem("Batman Pizza", "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/LittleCaesars%2Fmenu%2FbatmanPizza.png?alt=media&token=9a21dce7-99b8-433a-9b27-66ceb275cfb2", "Una pizza de batman", 99.0))
        items.add(MenuItem("Italian Cheese Bread", "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/LittleCaesars%2Fmenu%2FcheeseBread.png?alt=media&token=e1849d14-505d-4062-a7f6-ebd0d0b45a21", "Diez porciones de pan fresco horneado de masa crujiente cubierta de queso con condimentos italianos", 99.0))
        items.add(MenuItem("Cinnamon Roll Bites", "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/LittleCaesars%2Fmenu%2FcinammonRollBites.webp?alt=media&token=553b8ee7-adfb-451d-97dd-aab81ca4d977", "Cinnamon Roll Bite", 89.0))
        items.add(MenuItem("Deep Dish Pepperoni Pizza", "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/LittleCaesars%2Fmenu%2FdeepDishPizza.png?alt=media&token=97d84c92-00aa-475c-b8b2-2d78ce2a96e5", "Pizza grande y gruesa al estilo Detroit con pepperoni", 179.0))
        items.add(MenuItem("Hula Hawaiian Pizza", "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/LittleCaesars%2Fmenu%2FhawaiianPizza.jpg?alt=media&token=1738954e-0d4e-4395-9f38-3b4b387edee2", "UN MONTÓN DE INGREDIENTES CRAZY!CRAZY!™ AL MEJOR PRECIO DEL PAÍS** Pizza grande redonda con jamón ahumado y piña", 140.0))
        items.add(MenuItem("Brownie de chocolate con M&MS", "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/LittleCaesars%2Fmenu%2FmnmBrownie.jpg?alt=media&token=cc4e015a-5f9b-4f19-b741-48ab7769af31", "Brownie recubierto con cobertura de masa de galletas y caramelos de chocolate M&MS MINIS | pedido de 4 unidades", 65.0))
        items.add(MenuItem("Veggie Pizza", "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/LittleCaesars%2Fmenu%2FveggiePizza.png?alt=media&token=30740f82-d562-46a3-9999-57a58d7ac13e", "UN MONTÓN DE INGREDIENTES CRAZY!CRAZY!™ AL MEJOR PRECIO DEL PAÍS** Pizza grande redonda de pimientos verdes, cebollas, champiñones, aceitunas negras y condimentos italianos", 140.0))
        //items.add(MenuItem("", "", "", 0.0))
        items.forEach {

            restaurantsRef.document(id).collection("menu").document().set(it)
        }*/

        //BurgerKing()
        /*dominos()
        wazzabi()
        mcdonalds()
        taqueriaLeo()
        lefate()
        pandaExpress()
        krispyKreme()*/

    }
    private fun wazzabi(){
        val id = "PkHXchXySUklSX7U4Q4d"
        val wz: MutableList<MenuItem> = arrayListOf()
        wz.add(MenuItem("Sashimi corte fino atin",
            "",
            "Sahimi corte fino atun con 220 grms.",
        207))
        wz.add(MenuItem("Tekka don",
            "",
            "Sashimi de atun y aguacate con peso aprox 240 grms.",
        205))
        wz.add(MenuItem("Toridon",
            "",
            "Pollo con salsa teriyaki sobre cama de arroz con peso aprox 230 grms.",
            153))
        wz.add(MenuItem("Mango tampico roll",
            "",
            "Por dentro camaron pepino y queso por fuera queso mango y aguacate con peso aprox 200 grms.",
        144))
        wz.add(MenuItem("Banana roll",
            "",
            "Por dentro queso aguacate y pepino por fuera platano frito con salsa de anguila encima salsa spicy masago y camaron empanizado con peso total aprox 200 grms.",
        143))
        wz.add(MenuItem("Komaki",
            "",
            "Por dentro salmon pepino aguacate y queso crema por fuera zanahoria tempurizada con aderezos spicy.",
        129))
        wz.add(MenuItem("Karma",
            "",
            "Por dentro camaron capeado queso aguacate y pepino por fuera platano frito con sals de anguila con peso total aprox 200 grms.",
        116))
        wz.add(MenuItem("Vegetariano",
            "",
            "Por dentro lechuga aguacate pepino zanahoria y alfalfa por fuera alga con peso aprox 180 grms.",
        99))

            //items.add(MenuItem("", "", "", 0.0))
            wz.forEach {

                restaurantsRef.document(id).collection("menu").document().set(it)
            }
    }
    private fun taqueriaLeo(){
        val id = "lSAydECkMT5U3FoFP3LE"
        val leo: MutableList<MenuItem> = arrayListOf()
        leo.add(MenuItem("Torta Bistec de Res con Queso ",
            "",
            "",
        40))
        leo.add(MenuItem("Sopes de Bistec",
            "",
            "",
        22))
        leo.add(MenuItem("Agua de Horchata 1L",
            "",
            "",
        30))
        leo.add(MenuItem("Quesadilla de Bistec",
            "",
            "",
        23))
        leo.add(MenuItem("Agua de Jamaica 1L",
            "",
            "",
        30))
        leo.add(MenuItem("Taco de Tinga",
            "",
            "Con tortilla de harina o tortilla normal, se sirven con cebolla y cilantro. ",
        13))
        leo.add(MenuItem("Taco al Pastor ",
            "",
            "Con tortilla de harina o tortilla normal, se sirven con cebolla y cilantro. ",
        15))
        leo.add(MenuItem("Gringa al Pastor ",
            "",
            "Se sirve con cebolla, cilantro y piña.",
        42))

            //items.add(MenuItem("", "", "", 0.0))
            leo.forEach {

                restaurantsRef.document(id).collection("menu").document().set(it)
            }
    }
    private fun krispyKreme(){
        val id = "0a12GK1yaLetO29BrCVc"
        val kk: MutableList<MenuItem> = arrayListOf()
        kk.add(MenuItem("Dona Glaseada Original",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/krispykreme%2Fmenu%2FGlaseada.png?alt=media&token=35fd6de7-9b90-45d4-9562-fd6be8b976e1",
            "Nuestro producto insignia. Elaborada con nuestra receta secreta desde 1937, es la dona que nos hace únicos en el mundo. Recuerda, si visitas nuestros Teatros de Donas y ves el Hot Now encendido, no olvides probar una Glaseada Original® calientita recién salida de la línea de producción. ¡Será inolvidable!",
        18))
        kk.add(MenuItem("Dona Bee Friendly",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/krispykreme%2Fmenu%2Fdonas-beefriendly.png?alt=media&token=d707e160-d7f2-4df3-8a1c-dc455149d021",
            "Delicioso ring glaseado cubierto de betún y decorado con una grandiosa abeja",
        20))
        kk.add(MenuItem("Bubulubu",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/krispykreme%2Fmenu%2Fbubulubu-ricolino.png?alt=media&token=24bfbe0d-3d87-4a1b-af08-b15416a41109",
            "Exquisito ring de chocolate cubierto de más chocolate con un delicioso relleno de frambuesa y decorado con un Bubulubu.",
        22))
        kk.add(MenuItem("Brownie",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/krispykreme%2Fmenu%2FDonaBrownie.png?alt=media&token=205d1812-090e-498c-9732-3ba0d74dd3d8",
            "Amarás esta dona. Suave pastelillo hecho de chocolate y cubierto con una capa de nuestro Glaseado Original.",
        20))
        kk.add(MenuItem("Duvalin",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/krispykreme%2Fmenu%2FDuvalin.png?alt=media&token=da157c25-2b4c-4816-b4d1-d9cffe866035",
            "Suave ring de chocolate con cobertura de Duvalin de vainilla, avellana y fresa",
        22))
        kk.add(MenuItem("Krispy Bites",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/krispykreme%2Fmenu%2Fkrispykreme-bites.png?alt=media&token=1341a148-7347-40a5-9ed8-17587a946cfe",
            "Bocados de nuestra Dona Glaseada Original que se derriten en la boca.",
        30))
        kk.add(MenuItem("Shell Manzana Canela",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/krispykreme%2Fmenu%2FShellManzanaCanela.png?alt=media&token=b78aaaa5-16b4-47ff-9fb3-146b460cbae8",
            "Delicioso shell relleno de manzana ¡No podrás resistirte!",
        35))
        kk.add(MenuItem("Rellena de Cajeta",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/krispykreme%2Fmenu%2FRellenaCajeta.png?alt=media&token=5db41200-b972-4db9-a7b5-bd3daf8960d3",
            "Dona rellena de cajeta y cubierta con una capa de azúcar glass. No podrás resistirte a probarla.",
        22))


            //items.add(MenuItem("", "", "", 0.0))
            kk.forEach {

                restaurantsRef.document(id).collection("menu").document().set(it)
            }
    }
    private fun pandaExpress(){
        val id = "7rmWy43gKptwVmhqRgAi"
        val pe: MutableList<MenuItem> = arrayListOf()
            /*pe.add(MenuItem("",
                "",
                "",
                ))*/
        pe.add(MenuItem("Orange Chicken",
            "",
            "Crujiente pollo sazonado con nuestra salsa agridulce y picante de naranja.",
        120))
        pe.add(MenuItem("Kung Pao Chicken",
            "",
            "Pollo marinado con cacahuate, pimiento rojo, calabaza y chile de árbol.",
        145))
        pe.add(MenuItem("Broccoli Beef",
            "",
            "Res marinada con brócoli, salsa de soya y jengibre.",
        130))
        pe.add(MenuItem("Beijing Beef",
            "",
            "Trozos de carne de res empanizados, pimientos rojos y cebolla en salsa agridulce",
        155))
        pe.add(MenuItem("Dumplings",
            "",
            "Dumplings a la sartén, rellenos de pollo, repollo y cebolla.",
        65))
        pe.add(MenuItem("Rangoons",
            "",
            "Wontons rellenos de queso crema servidos con salsa agridulce. ",
        88))
        pe.add(MenuItem("Camarones Crispy",
            "",
            "Crisp-golden butterflied shrimp.",
        70))
        pe.add(MenuItem("Rollos Primavera",
            "",
            "Repollo, apio, zanahorias, cebolla y fideos chinos en una envoltura crujiente de wonton.",
        55))

            //items.add(MenuItem("", "", "", 0.0))
            pe.forEach {

                restaurantsRef.document(id).collection("menu").document().set(it)
            }
    }
    private fun lefate(){
        val id = "6bQ34UrLyYgo6qh7nDzi"
        val lf: MutableList<MenuItem> = arrayListOf()
        lf.add(MenuItem("Fettuccine Negro con Mariscos",
            "",
            "Fettuccine elaborado a mano con tinta natural de calamar,salteado con mariscos mixtos, sazonados con ajo dorado, receta especial de la casa, jitomates cherry, en una reducción de vino blanco y mantequilla. Incluye pan de ajo.",
        226))
        lf.add(MenuItem("Lasaña ",
            "",
            "Exquisita lasaña elaborada de manera artesanal y horneada a la leña, rellena con carne molida de sirloin a la boloñesa y bañada con salsa de tomate casera. Incluye pan de ajo.",
        220))
        lf.add(MenuItem("Pizza Patrón ",
            "",
            "Pizza de 13\" hecha en horno a la leña, bañada con salsa de tomate, mozzarella al pesto y camarones salteados con mantequilla y ajo.",
        252))
        lf.add(MenuItem("Carpaccio de Salmón ",
            "",
            "Finas rebanadas de salmón fresco aderezado con vinagreta de la casa, servido sobre una cama de espinacas finamente picadas, acompañada con limón y arugula fresca. Incluye pan de ajo.",
        178))
        lf.add(MenuItem("Pizza Ghost Buster",
            "",
            "Pizza de 13\" hecha en horno a la leña, bañada con salsa de tomate, mozzarella, jamón cocido y queso crema",
        214))

        //items.add(MenuItem("", "", "", 0.0))
        lf.forEach {

            restaurantsRef.document(id).collection("menu").document().set(it)
        }
    }
    private fun mcdonalds(){
        val id = "P9mmTW5mKN3dS6G5sY2D"
        val mc: MutableList<MenuItem> = arrayListOf()
        mc.add(MenuItem("Big Mac",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/McDonalds%2Fmenu%2FBigMac.png?alt=media&token=07270ed1-8d70-430f-afb3-c4a295e14b68",
            "La perfección hecha hamburguesa que te hace agua la boca comienza con dos patties de 100% carne y la salsa Big Mac®, todo dentro de un pan con semillas de ajonjolí. Viene cubierta con pepinillos, crujiente lechuga, cebollas y queso americano para lograr ese sabor único de la hamburguesa 100% de carne.",
        50))
        mc.add(MenuItem("McNífica",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/McDonalds%2Fmenu%2FMcNifica-SinRef.png?alt=media&token=921fa922-a052-4079-bb14-7dd24f10dd69",
            "Es una hamburguesa con una jugosa carne 100% de res, queso tipo americano, lechuga, pepinillos, cebolla y dos rebanadas de fresco jitomate. Aderezada con mayonesa, catsup y mostaza, en un esponjadito pan cubierto de ajonjolí.",
        65))
        mc.add(MenuItem("10 Nuggets",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/McDonalds%2Fmenu%2FMcNuggets.png?alt=media&token=34a20c21-1e55-4638-97b8-16f6c75819d8",
            "Tiernos y jugosos trocitos 100% de pechuga de pollo con una capa de empanizado doradito que, aderezados con salsa agridulce, te harán pedir más. Los McNuggets saben mejor con tus papas y refresco favoritos. Puedes pedirlos en presentación de 10 ó 20 piezas.",
        89))
        mc.add(MenuItem("McPatatas",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/McDonalds%2Fmenu%2FMcPatatas-SinRef.png?alt=media&token=d9ef8b6b-e816-4764-8b84-50d8c08b48c7",
            "Deliciosas papas 100% naturales, cortadas en gajos, crujientes y sazonadas por completo. Las puedes aderezar con nuestra famosa salsa McQueso que les dará un exquisito sabor.",
        68))
        mc.add(MenuItem("McFlurry Oreo",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/McDonalds%2Fmenu%2Fmcflurry-oreo.png?alt=media&token=df834aa5-4550-493c-9fae-34ff1881c53e",
            "Si las galletas Oreo® te gustan por sí solas ¡imagínate acompañarlas con nuestra deliciosa mezcla de helado 100% de leche!",
        35))
        mc.add(MenuItem("Cono de Vainilla",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/McDonalds%2Fmenu%2Fcono-vainilla.png?alt=media&token=fed361df-fa05-4af4-b088-68a38bbfa2a7",
            "Prueba nuestro delicioso helado preparado con 100% leche de vaca. ¡Disfrútalo!",
            12))
        mc.add(MenuItem("Pay de Queso",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/McDonalds%2Fmenu%2FPayQueso.png?alt=media&token=6f1b38a5-11d3-4a60-ae5b-3aa61c01e278",
            "Deliciosos trozos de fruta envueltas con una cubierta crujiente para darle un delicioso sabor a tu paladar, todo el tiempo calientitos y listos para disfrutar. Elije tu favorito: manzana o queso.",
            35))


        //items.add(MenuItem("", "", "", 0.0))
        mc.forEach {

            restaurantsRef.document(id).collection("menu").document().set(it)
        }
    }
    private fun dominos(){
        val id = "nkcAtM87CmS0GoLaQMeX"
        val dominos: MutableList<MenuItem> = arrayListOf()
        dominos.add(MenuItem("Hawaiian",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/Dominos%2Fmenu%2FHawaiiana.png?alt=media&token=a05d28a2-7a85-4141-9082-c29446737dc6",
            "La pizza que unos cuestionan pero todos aman. ",
            220))
        dominos.add(MenuItem("Mexicana",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/Dominos%2Fmenu%2FMexicana.png?alt=media&token=e3bb160f-265f-4e2d-86ee-4450f5c261d3",
            "La pizza con los sabores auténticos de nuestro país. Chorizo, carne molida, jalapeño, cebolla. ",
            220))
        dominos.add(MenuItem("Carnes Frías",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/Dominos%2Fmenu%2FCarnesFrias.png?alt=media&token=e159e302-7ba9-436d-8054-ca673f887951",
            "La pizza para los amantes de la carne. Salami, pepperoni, jamón, finas hierbas. ",
            250))
        dominos.add(MenuItem("Volcan de Oreo",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/Dominos%2Fmenu%2FVOLCAN.png?alt=media&token=9d370194-51db-459c-b7e5-d24afa5e181d",
            "Volcan de Chocolate con Oreo por debajo",
            89))
        dominos.add(MenuItem("Chicken Hawaiian",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/Dominos%2Fmenu%2FChickenHawaiian.png?alt=media&token=28e439fc-96f9-476b-a1a7-c36f1bb8e2b6",
            "La pizza más tropical que tenemos. Pollo, tocino, piña, salsa mango habanero. ",
            235))

        //items.add(MenuItem("", "", "", 0.0))
        dominos.forEach {

            restaurantsRef.document(id).collection("menu").document().set(it)
        }
    }
    private fun BurgerKing(){
        val id = "7JGscl27kcUeF5bBL193"
        val bk: MutableList<MenuItem> = arrayListOf()
        bk.add(MenuItem("Fans King",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2Fmenu%2FfansKing.png?alt=media&token=2311c60a-f94a-4f49-bc0e-b9c89e20cd4c",
            "Doble carne de res a la parrilla, queso americano, tocino crujiente, salsa sabor queso, cebollita caramelizada, jalapeños picositos y suave pan brioche.\n" +
                    "\n" +
                    "¡La primera hamburguesa creada por nuestros fans!\n",
            150))
        bk.add(MenuItem("WHOPPER Angry",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2Fmenu%2FWhopperAngry.png?alt=media&token=7c87c5f9-ea23-4ae3-939f-f11fe5e9a152",
            "Nuestra WHOPPER® Angry lleva una carne de res a la parrilla, preparada con deliciosas tiras de tocino, jugosos tomates, lechuga recién cortada, mayonesa, jalapeños y cebollitas angry, sobre un pan suave con ajonjolí. ¡Pídela en COMBO con papas a la francesa y refresco frío!",
            180))
        bk.add(MenuItem("Stacker King",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2Fmenu%2FStackerKing.png?alt=media&token=1f0c75fa-6c80-45c7-8ca8-08dbcee61225",
            "¡Se come a dos manos!\n" +
                    "\n" +
                    "La hamburguesa más grande de todos los tiempos llega a tus dos manos.Con tocino crujiente, queso derretido, salsa Stacker y con 1, 2, 3 o, ¡hasta 4 carnes! Pidela a tu manera.",
            175))
        bk.add(MenuItem("Long Rodeo",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2Fmenu%2FLongRodeo.png?alt=media&token=9a6872bb-44ab-4152-a010-4f9b280b4700",
            "Carne de res a la parrilla, queso americano, aros de cebolla crujientes, salsa BBQ ¿ya se te antojó, verdad? ¡Pídela en COMBO con papas a la francesa y refresco frío!",
            145))
        bk.add(MenuItem("Pepsi",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2Fmenu%2FPepsi.png?alt=media&token=9e88e0b2-b701-421e-a642-3d94f142104c",
            "Acompaña tus COMBOS con un refresco grande del sabor que tú quieras!",
            22))
        bk.add(MenuItem("Papas Hashbrown",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2Fmenu%2FHashbrown.png?alt=media&token=5d0f6ca7-5413-4a95-bfda-936e75d8154d",
            "La mejor manera de comer papas – en forma de croqueta.",
            33))
        bk.add(MenuItem("Aros de Cebolla",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2Fmenu%2FArosCebolla.png?alt=media&token=c157e5ce-2d3e-4448-91a0-4cb9f8705e8f",
            "Recién hechos y crujientes, nuestros aros de cebolla son el regalo perfecto para sumergirse con alguna de nuestras deliciosas salsas.",
            45))
        bk.add(MenuItem("Papas Supremas",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2Fmenu%2FPapasSupremas.png?alt=media&token=29893ae0-d887-472b-8921-1da548d5cc72",
            "Descubre las nuevas papas supremas bañadas en salsa sabor a queso con trocitos sabor tocino y cebollitas crujientes!",
            55))
        bk.add(MenuItem("Cono",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2Fmenu%2FCono.png?alt=media&token=87a5b754-4abc-4d82-81d6-31569e9aabed",
            "¡Un postre clásico y dulce! Chocolate, vainilla o combinado.",
            12))
        bk.add(MenuItem("Pay Hershey",
            "https://firebasestorage.googleapis.com/v0/b/appcomida-a4f6a.appspot.com/o/BurgerKing%2Fmenu%2FPayHershey.png?alt=media&token=63be6626-00fa-4834-a287-53caac727780",
            "Da la bienvenida a nuestro Pay HERSHEY'S® Primero, una corteza de chocolate crujiente y una parte de relleno cremoso de chocolate, adornado con un delicioso relleno de chocolate HERSHEY'S® y chispas de chocolate. La marca HERSHEY'S® se utiliza bajo licencia de Burger King Corporation",
            38))
        /*bk.add(MenuItem("",
            "",
            "",
            ))*/

        //items.add(MenuItem("", "", "", 0.0))
        bk.forEach {

            restaurantsRef.document(id).collection("menu").document().set(it)
        }
    }
}