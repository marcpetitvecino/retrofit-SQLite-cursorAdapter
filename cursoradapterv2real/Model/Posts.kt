package com.example.cursoradapterv2real.Model

public class Posts {

    // Aquesta classe és pels getters i setters
    
    // EDIT 05/02/2020 -> En kotlin es pot crear amb una linea = data class Posts(userid: Int, id: Int, title: String, body: String)

    private var userId: Int =  0
    private var id: Int = 0
    private var title: String = ""
    private var body: String = ""

    fun getUserId(): Int {

        return userId

    }

    fun getId(): Int {

        return id

    }

    fun getTitle(): String {

        return title

    }

    fun getBody(): String {

        return body

    }

//    fun setUserId(newUserId: Int) {
//
//        this.userId = newUserId
//
//    }
//
//    fun setId(newId: Int) {
//
//        this.id = newId
//
//    }
//
//    fun setTitle(newTitle: String) {
//
//        this.title = newTitle
//
//    }
//
//    fun setBody(newBody: String) {
//
//        this.body = newBody
//
//    }

}
