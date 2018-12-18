package ru.androidacademy.ateam.db.dao

import androidx.room.*
import io.reactivex.Single
import ru.androidacademy.ateam.model.tables.Deck


@Dao
interface DeckDao {

    @get:Query("SELECT * FROM deck")
    val getAll: Single<List<Deck>>

    @get:Query("SELECT COUNT(*) FROM deck")
    val allDeckCount: Int

    @Query("SELECT * FROM deck WHERE id = :deckId")
    fun getDeckById(deckId: Long): Single<List<Deck>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(deck: Deck)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDeckList(decks: List<Deck>)

    @Update
    fun update(deck: Deck)

    @Delete
    fun delete(deck: Deck)
}