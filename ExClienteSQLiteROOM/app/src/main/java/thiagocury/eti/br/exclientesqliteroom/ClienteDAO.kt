package thiagocury.eti.br.exclientesqliteroom

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ClienteDAO {

    @Query("SELECT * FROM cliente limit 1")
    fun get(): Cliente

    @Query("SELECT * FROM cliente")
    fun getAll(): List<Cliente>

    @Insert
    fun add(vararg cliente: Cliente)

    @Query("delete FROM cliente")
    fun delete()
}