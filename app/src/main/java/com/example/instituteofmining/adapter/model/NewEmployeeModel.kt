package com.example.instituteofmining.adapter.model

import java.io.Serializable

class NewEmployeeModel : Serializable {
    val id: String
    val person: String
    val name: String
    val patronymic: String
    val surname: String
    val education:String
    val graduated: String
    val experience: String
    val degree: String
    val title: String
    var list: ArrayList<EmployeeModel>?
    constructor():this("","","","","","","","","","",null){
    }
    constructor(
        id: String,
        person: String,
        name: String,
        surname: String,
        education: String,
        patronymic: String,
        graduated: String,
        experience: String,
        degree: String,
        title: String,
        list: ArrayList<EmployeeModel>?
    ) {
        this.id = id
        this.person = person
        this.name = name
        this.surname = surname
        this.patronymic = patronymic
        this.education = education
        this.graduated= graduated
        this.experience = experience
        this.degree = degree
        this.title = title
        this.list = list
    }
}