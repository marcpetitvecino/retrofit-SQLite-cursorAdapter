package com.example.cursoradapterv2real

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.cursoradapterv2real.Model.Posts

val DATABASE_NAME = "MyDB"
val TABLE_NAME = "Posts"
val COL_USERID = "userid"
val COL_ID = "_id"
val COL_TITLE = "title"
val COL_BODY = "body"


class DataBaseHandler(var context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, 1) { // Crida al SQLiteOpenHelper per crear la BDD

    override fun onCreate(db: SQLiteDatabase?) {

        val createTable = "CREATE TABLE " + TABLE_NAME +" (" +
                COL_USERID +" INTEGER," +
                COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL_TITLE + " VARCHAR(80)," +
                COL_BODY + " TEXT)";

        db?.execSQL(createTable) // Comanda per crear la taula (buida)

    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(post: Posts) {


        var db = this.writableDatabase
        var cv = ContentValues()

        cv.put(COL_USERID, post.getUserId())
        cv.put(COL_ID, post.getId())
        cv.put(COL_TITLE, post.getTitle())
        cv.put(COL_BODY, post.getBody())

        db.insert(TABLE_NAME, null, cv) // Insercció de les dades de la API a la BDD

    }

    fun getDataCursor(): Cursor {

        var db = this.readableDatabase
        var query = "SELECT * FROM $TABLE_NAME"

        var result = db.rawQuery(query, null) // Obtenció del crsor a partir d'una consulta

        return result


    }

}
