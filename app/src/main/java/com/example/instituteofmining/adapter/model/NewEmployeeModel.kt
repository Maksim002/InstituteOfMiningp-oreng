package com.example.instituteofmining.adapter.model

import kotlin.math.exp

class NewEmployeeModel {
    val id: String
    val person: String
    val name: String
    val surname: String
    val age: String
    val education:String
    val graduated: String
    val experience: String
    val degree: String
    val title: String
    var list: MutableList<EmployeeModel>?
    constructor():this("","","","","","","","","","",null){

    }
    constructor(
        id: String,
        person: String,
        name: String,
        surname: String,
        age: String,
        education: String,
        graduated: String,
        experience: String,
        degree: String,
        title: String,
        list: MutableList<EmployeeModel>?
    ) {
        this.id = id
        this.person = person
        this.name = name
        this.surname = surname
        this.age = age
        this.education = education
        this.graduated= graduated
        this.experience = experience
        this.degree = degree
        this.title = title
        this.list = list
    }


}