package com.example.drcafe.utils

import androidx.navigation.NamedNavArgument


interface NavigationSetter {

    val ROUTE: String

    val ARGUMENTS : List<NamedNavArgument>
}

object Home: NavigationSetter{

    override val ROUTE: String = "home"
    override val ARGUMENTS: List<NamedNavArgument> = emptyList()
}
object AddQuestion: NavigationSetter{

    override val ROUTE: String = "addQuestion"
    override val ARGUMENTS: List<NamedNavArgument> = emptyList()
}

object DatabaseManager: NavigationSetter{

    override val ROUTE: String = "databaseManager"
    override val ARGUMENTS: List<NamedNavArgument> = emptyList()
}

object AddAnswer: NavigationSetter{

    override val ROUTE: String = "addAnswer"
    override val ARGUMENTS: List<NamedNavArgument> = emptyList()
}