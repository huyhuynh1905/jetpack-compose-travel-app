package com.example.travelapp.domain.model

class SelectAccountModel{
    var id: Int = 0

    var name: String


    var email: String


    var phone: String


    var avatarUrl: String



    constructor(
        id: Int,
        name: String,
        email: String,
        phone: String,
        avatarUrl: String
    ) {
        this.name = name
        this.id = id
        this.email = email
        this.phone = phone
        this.avatarUrl = avatarUrl
    }

    override fun equals(other: Any?): Boolean {
        if (other is SelectAccountModel) {
            return id == other.id && name == other.name
        }
        return false
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + phone.hashCode()
        result = 31 * result + avatarUrl.hashCode()
        return result
    }

    override fun toString(): String {
        return "SelectAccountModel(name='$name', id=$id, email='$email', phone='$phone', avatarUrl='$avatarUrl')"
    }


}