package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.activities

import android.os.Bundle
import android.view.MenuItem
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.R
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments.BlankFragment
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments.DownloadFragment
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments.HomeFragment
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : com.padcmyanmar.androidftc.shared.activities.BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigation.setOnNavigationItemSelectedListener(object :BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId) {
                    R.id.action_home -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.flBottomNavigationContainer,HomeFragment())
                            .commit()
                        return true
                    }
                    R.id.action_search -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.flBottomNavigationContainer,SearchFragment())
                            .commit()
                        return true
                    }
                    R.id.action_download -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.flBottomNavigationContainer,DownloadFragment())
                            .commit()
                        return true
                    }
                    R.id.action_profile -> {
                        supportFragmentManager.beginTransaction()
                            .replace(R.id.flBottomNavigationContainer,BlankFragment())
                            .commit()
                        return true
                    }
                }
                return false
            }
        })
        if(savedInstanceState == null) {
            bottomNavigation.selectedItemId =
                R.id.action_home
        }
    }
}
