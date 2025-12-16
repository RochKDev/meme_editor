package rochkdev.meme_editor

import android.app.Application
import org.koin.android.ext.koin.androidContext
import rochkdev.meme_editor.di.initKoin

class MemeCreatorApplication: Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidContext(this@MemeCreatorApplication)
        }
    }
}