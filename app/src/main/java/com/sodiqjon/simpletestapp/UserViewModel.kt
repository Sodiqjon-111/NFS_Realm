package com.sodiqjon.simpletestapp

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.realm.Realm
import java.util.UUID

class UserViewModel : ViewModel() {
    private val realm = Realm.getDefaultInstance()

    val allUser by lazy { MutableLiveData<List<UserModel>>() }

    fun addUser(
        locationId: String,
        dateIn: String,
        timeIn: String,
        timeOut: String,
        dateOut: String,
        customerId: String
    ) {
        realm.executeTransaction {
            val user = it.createObject(UserModel::class.java, UUID.randomUUID().toString())
            user.locationId = locationId
            user.dateIn = dateIn
            user.timeIn = timeIn
            user.dateOut = dateOut
            user.customerId = customerId
            user.timeOut = timeOut
            Log.d(TAG, "-----------------")
            realm.insertOrUpdate(user)

        }
    }

    fun getUser() {
        val users = realm.where(UserModel::class.java).findAll()
        allUser.value=realm.copyFromRealm(users)

    }
}