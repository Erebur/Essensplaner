package com.dvspla.database

import io.realm.RealmObject

open class Einkaufsliste(var amount: Int = 0, var name: String = "", var description: String = "", var brand: String = "") : RealmObject()


