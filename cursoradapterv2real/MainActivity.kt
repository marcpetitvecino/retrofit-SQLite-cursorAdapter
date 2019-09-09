package com.example.cursoradapterv2real

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.TextView
import com.example.cursoradapterv2real.Interfaces.JsonPlaceHolderApi
import com.example.cursoradapterv2real.Model.Posts
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val context = this
    private var db = DataBaseHandler(context) // Creació de la connexió amb la BDD

    private lateinit var resultview: TextView
    private lateinit var listView: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        resultview = findViewById(R.id.result)
        listView = findViewById(R.id.postslist) // Vinculacio de variable listView amb element del XML

        getPosts() // Funció que obté les dades d'una API usant Retrofit

        val adapter = MyCursorAdapter(context, DataBaseHandler(context).getDataCursor()) // Creació del adapter del cursor

        listView.adapter = adapter // Afegim el adapter a el listView
    }

    private fun getPosts() {

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi::class.java)

        var call: Call<List<Posts>> = jsonPlaceHolderApi.getPosts() // Crida a la interficie placeholder

        call.enqueue(object: Callback<List<Posts>> {


            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {

                if (!response.isSuccessful) {

//                    resultview.text = "Codigo: " + response.code()
                    return

                }

                var postsList: List<Posts>? = response.body()

                if (postsList != null) {

                    for (post in postsList) {

                        db.insertData(post) // S'insereixen les dades a la BDD

                    }

                }

            }

            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {

                resultview.text = t.message

            }

        })

    }

}
