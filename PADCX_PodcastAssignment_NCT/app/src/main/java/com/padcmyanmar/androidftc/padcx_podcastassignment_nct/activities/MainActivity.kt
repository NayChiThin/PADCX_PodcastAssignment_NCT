package com.padcmyanmar.androidftc.padcx_podcastassignment_nct.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.R
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments.BlankFragment
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments.DownloadFragment
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments.HomeFragment
import com.padcmyanmar.androidftc.padcx_podcastassignment_nct.fragments.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : com.padcmyanmar.androidftc.shared.activities.BaseActivity() {

    val homeFragment : Fragment = HomeFragment()
    val searchFragment : Fragment = SearchFragment()
    val downloadFragment : Fragment = DownloadFragment()
    val blankFragment : Fragment = BlankFragment()
    val fm : FragmentManager = supportFragmentManager
    var active : Fragment = homeFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        arrangeFragments()

        bottomNavigation.setOnNavigationItemSelectedListener(object :BottomNavigationView.OnNavigationItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when(item.itemId) {
                    R.id.action_home -> {
                        fm.beginTransaction().hide(active).show(homeFragment).commit()
                        active = homeFragment
                        /*supportFragmentManager.beginTransaction()
                            .replace(R.id.flBottomNavigationContainer,HomeFragment())
                            .commit()*/
                        return true
                    }
                    R.id.action_search -> {
                        fm.beginTransaction().hide(active).show(searchFragment).commit()
                        active = searchFragment
                        return true
                    }
                    R.id.action_download -> {
                        fm.beginTransaction().hide(active).show(downloadFragment).commit()
                        active = downloadFragment
                        return true
                    }
                    R.id.action_profile -> {
                        fm.beginTransaction().hide(active).show(blankFragment).commit()
                        active = blankFragment
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
    private fun arrangeFragments() {
        fm.beginTransaction().add(R.id.flBottomNavigationContainer,searchFragment,"Search Fragment").hide(searchFragment).commit()
        fm.beginTransaction().add(R.id.flBottomNavigationContainer,downloadFragment,"Download Fragment").hide(downloadFragment).commit()
        fm.beginTransaction().add(R.id.flBottomNavigationContainer,blankFragment,"Blank Fragment").hide(blankFragment).commit()
        fm.beginTransaction().add(R.id.flBottomNavigationContainer,homeFragment).commit()
    }
}
