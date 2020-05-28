package dev.jolas.newsy.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jolas.sdk.kn.newsycore.RemoteRepository
import com.jolas.sdk.kn.newsycore.LocalRepository

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        val remote = RemoteRepository()
        remote.fetchItem(itemId = 121003, onSuccess = {
            print("item: $it")
            val localRepository = LocalRepository()
            localRepository.insertItem(item = it)
            val dbItem = localRepository.getItem(itemId = 121003)
            print("item from db: $dbItem")
        }, onFailure = {
            print("failure")
        })
    }
}
