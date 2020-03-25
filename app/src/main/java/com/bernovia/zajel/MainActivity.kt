package com.bernovia.zajel

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.bernovia.zajel.addBook.AddBookFragment
import com.bernovia.zajel.bookList.ui.BookListFragment
import com.bernovia.zajel.databinding.ActivityMainBinding
import com.bernovia.zajel.helpers.FragmentSwitcher
import com.bernovia.zajel.helpers.FragmentSwitcher.replaceFragmentWithNoAnimation
import com.bernovia.zajel.requests.ui.RequestsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.addBookFAB.setOnClickListener {
            FragmentSwitcher.addFragment(supportFragmentManager, R.id.added_FrameLayout, AddBookFragment.newInstance(), FragmentSwitcher.AnimationType.PUSH)

        }


        val navigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener = object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.navigation_home -> {
                        replaceFragmentWithNoAnimation(supportFragmentManager, R.id.main_content_frameLayout, BookListFragment.newInstance())

                        return true
                    }
                    R.id.navigation_requests -> {
                        replaceFragmentWithNoAnimation(supportFragmentManager, R.id.main_content_frameLayout, RequestsFragment.newInstance())

                        return true
                    }
                    R.id.navigation_wishlist -> {

                        return true
                    }
                    R.id.navigation_profile -> {

                        return true
                    }

                }
                return false
            }
        }
        binding.bottomNavigation.setOnNavigationItemSelectedListener(navigationItemSelectedListener)

    }


}
