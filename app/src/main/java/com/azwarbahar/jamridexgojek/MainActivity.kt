package com.azwarbahar.jamridexgojek

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import com.azwarbahar.jamridexgojek.adapter.TabPagerAdapter
import com.azwarbahar.jamridexgojek.fragment.MainChatFragment
import com.azwarbahar.jamridexgojek.fragment.MainHomeFragment
import com.azwarbahar.jamridexgojek.fragment.MainPromosFragment
import com.azwarbahar.jamridexgojek.fragment.MainServicesFragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_tab_layout.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.statusBarColor = Color.WHITE
        }

        jamride.setOnClickListener {
            startActivity(Intent(this, FoodActivity::class.java))
        }

        val adapter = TabPagerAdapter(
            this,
            arrayListOf(
                MainPromosFragment(),
                MainHomeFragment(),
                MainChatFragment(),
            )
        )
        pager.adapter = adapter
        TabLayoutMediator(tab, pager) { tab, position ->
            when (position) {
                0 -> {
                    tab.customView = getTabLayout("Promos", R.drawable.ic_promos)
                }
                1 -> {
                    tab.customView = getTabLayout("Home", R.drawable.ic_home)
                }
                2 -> {
                    tab.customView = getTabLayout("Chats", R.drawable.ic_chat)
                }
            }
        }.attach()
        pager.setCurrentItem(1, false)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.favoriteContainer, MainServicesFragment(), "")
            commit()
        }
    }

    override fun onPause() {
        super.onPause()
        motion.transitionToStart()
    }

    fun getTabLayout(title: String, icon: Int): View {
        val tab = LayoutInflater.from(this).inflate(R.layout.main_tab_layout, null, false)
        tab.title.text = title
        tab.icon.setImageResource(icon)
        return tab
    }
}