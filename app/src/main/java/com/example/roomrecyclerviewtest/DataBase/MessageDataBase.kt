package com.example.roomrecyclerviewtest.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomrecyclerviewtest.Dao.MessageDao
import com.example.roomrecyclerviewtest.Models.Message


@Database(entities = [Message::class], version = 1, exportSchema = false)
abstract class MessageDataBase : RoomDatabase() {

    abstract fun messageDao(): MessageDao

    companion object {

        @Volatile
        private var INSTANCE: MessageDataBase? = null

        fun getDataBase(context: Context): MessageDataBase? {
            if (INSTANCE == null) {

                synchronized(MessageDataBase::class.java) {
                    if (INSTANCE == null) {

                        INSTANCE= Room.databaseBuilder(
                            context.applicationContext,
                            MessageDataBase::class.java, "message_database"
                        )
                            .build()
                    }

                }
            }

            return INSTANCE
        }
    }

}