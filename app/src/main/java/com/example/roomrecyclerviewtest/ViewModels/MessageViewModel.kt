package com.example.roomrecyclerviewtest.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.roomrecyclerviewtest.Models.Message
import com.example.roomrecyclerviewtest.Reposetories.MessageRepository

class MessageViewModel (application: Application) : AndroidViewModel(application) {

    private var repository: MessageRepository = MessageRepository(application)

    fun getMessages() = repository.getMessages()

    fun setMessage(message: Message) { repository.setMessage(message)}
    fun deleteAllMessage() { repository.deleteAllMessages()}

}