package org.sopt.dosopttemplate

import android.app.Application

class MyApplication : Application()
{
    companion object
    {
        lateinit var prefs: PreferenceUtil
            private set
    }

    override fun onCreate()
    {
        super.onCreate()
        prefs = PreferenceUtil(applicationContext)

    }
}