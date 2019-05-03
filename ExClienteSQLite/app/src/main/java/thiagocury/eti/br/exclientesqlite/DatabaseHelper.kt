package thiagocury.eti.br.exclientesqlite

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, "cliente.db", null, 1) {

    companion object {
        val TB_CLIENTE : String = "tb_cliente"
        val TB_CLIENTE_ID : String = "id_cliente"
        val TB_CLIENTE_NOME : String = "nome"
        val TB_CLIENTE_IDADE : String = "idade"
        val TB_CLIENTE_RENDA : String = "renda"

        val TB_CLIENTE_COLUNAS = arrayOf(
            TB_CLIENTE_ID,
            TB_CLIENTE_NOME,
            TB_CLIENTE_IDADE,
            TB_CLIENTE_RENDA
        )
    }

    //DDL Creating table CLIENTE
    val CREATE_TB_CLIENTE =
        "CREATE TABLE if not exists " + TB_CLIENTE + " (" +
                "${TB_CLIENTE_ID} integer PRIMARY KEY autoincrement," +
                "${TB_CLIENTE_NOME} text," +
                "${TB_CLIENTE_IDADE} int," +
                "${TB_CLIENTE_RENDA} double" +
                ")"

    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL(CREATE_TB_CLIENTE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }
}