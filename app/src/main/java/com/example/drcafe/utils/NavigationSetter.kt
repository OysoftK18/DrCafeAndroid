package com.example.drcafe.utils


interface NavigationSetter {

    val ROUTE: String
}

object Home: NavigationSetter{

    override val ROUTE: String = "home"
}
object AddQuestion: NavigationSetter{

    override val ROUTE: String = "addQuestion"
}

object DatabaseManager: NavigationSetter{

    override val ROUTE: String = "databaseManager"
}