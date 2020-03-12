package com.example.roomrecyclerviewtest.Reposetories

import android.app.Application
import com.example.roomrecyclerviewtest.Dao.MessageDao
import com.example.roomrecyclerviewtest.DataBase.MessageDataBase
import com.example.roomrecyclerviewtest.Models.Message
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MessageRepository(application: Application) : CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main

    private var messageDao: MessageDao?


    init {
        val db = MessageDataBase.getDataBase(application)
        messageDao = db?.messageDao()

    }

    fun getMessages() = messageDao?.getMessages()

    fun deleteAllMessages() {
        launch { deleteAllMessageBG() }

    }

    fun setMessage(message: Message) {
        launch { setMessageBG(message) }

    }

    private suspend fun setMessageBG(message: Message) {
        withContext(Dispatchers.IO) {
            messageDao?.setMessage(message)

        }

    }

    private suspend fun deleteAllMessageBG() {
        withContext(Dispatchers.IO) {
            messageDao?.deleteAll()

        }

    }


}