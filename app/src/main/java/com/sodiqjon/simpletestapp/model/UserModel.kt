package com.sodiqjon.simpletestapp.model


import io.realm.RealmModel
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import io.realm.annotations.Required

@RealmClass
open class UserModel : RealmModel {
    @PrimaryKey
    var id: String? = ""

    @Required
    var locationId: String? = ""
    var dateIn: String? = ""
    var timeIn: String? = ""
    var timeOut: String? = ""
    var dateOut: String? = ""
    var customerId: String? = ""
}
