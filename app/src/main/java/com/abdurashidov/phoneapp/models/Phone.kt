package com.abdurashidov.phoneapp.models

class Phone{
    var phoneType:String =""
    var phoneName:String =""
    var phoneInfo:String =""

    constructor(phoneType: String, phoneName: String, phoneInfo: String) {
        this.phoneType = phoneType
        this.phoneName = phoneName
        this.phoneInfo = phoneInfo
    }

    constructor()
}
