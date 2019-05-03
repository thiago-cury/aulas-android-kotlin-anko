package thiagocury.eti.br.exclientesqlite

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase

class ClienteDAO {

    var db : SQLiteDatabase? = null
    var dbHelper : DatabaseHelper? = null

    constructor(context : Context) {
        this.dbHelper = DatabaseHelper(context)
    }

    public fun abrirDB(){
        db = this.dbHelper?.writableDatabase
    }

    public fun fecharDB(){
        this.dbHelper?.close()
    }

    public fun inserirCliente(c: Cliente?): Long {
        val values = ContentValues()
        values.put(DatabaseHelper.TB_CLIENTE_NOME, c?.nome)
        values.put(DatabaseHelper.TB_CLIENTE_IDADE, c?.idade)
        values.put(DatabaseHelper.TB_CLIENTE_RENDA, c?.renda)

        val long = db!!.insert(DatabaseHelper.TB_CLIENTE, null, values)

        return long
    }

    public fun buscarClientes(): MutableList<Cliente> {
        val clientesList: MutableList<Cliente> = mutableListOf<Cliente>()
        val cursor: Cursor = db!!.query(
            DatabaseHelper.TB_CLIENTE,
            DatabaseHelper.TB_CLIENTE_COLUNAS,
            null,null,null,null,null)

        try{
            while(cursor.moveToNext()){
                val c = Cliente(
                    cursor.getInt(cursor.getColumnIndex(DatabaseHelper.TB_CLIENTE_ID)),
                    cursor.getString(cursor.getColumnIndex(DatabaseHelper.TB_CLIENTE_NOME)),
                    cursor.getInt(cursor.getColumnIndex(DatabaseHelper.TB_CLIENTE_IDADE)),
                    cursor.getDouble(cursor.getColumnIndex(DatabaseHelper.TB_CLIENTE_RENDA))
                )
                clientesList.add(c)
            }
        }finally {
            cursor.close()
        }
        return clientesList
    }
}