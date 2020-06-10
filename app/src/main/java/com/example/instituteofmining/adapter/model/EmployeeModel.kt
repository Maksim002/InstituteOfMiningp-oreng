package com.example.instituteofmining.adapter.model

class EmployeeModel{
    val id: Int
    var beginning: String
    var ending: String
    var type_of_qualification: String
    var topic: String
    var laboriousness: String
    var venue: String
    var certificate: String
    var reward: String
    var issued_by_whom: String
    var issued: String
    constructor(): this(0, "", "", "", "", "", "", "", "", "","")
    constructor(
        id: Int,
        beginning: String,
        ending: String,
        type_of_qualification: String,
        topic: String,
        laboriousness: String,
        venue: String,
        certificate: String,
        reward: String,
        issued_by_whom: String,
        issued: String
    ){
        this.id = id
        this.beginning = beginning
        this.ending = ending
        this.type_of_qualification = type_of_qualification
        this.topic = topic
        this.laboriousness = laboriousness
        this.venue = venue
        this.certificate = certificate
        this.reward = reward
        this.issued_by_whom = issued_by_whom
        this.issued = issued
    }
}