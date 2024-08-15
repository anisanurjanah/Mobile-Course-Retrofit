package com.anisanurjanah.fahrameducationcourse

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.anisanurjanah.fahrameducationcourse.course.CourseFragment
import com.anisanurjanah.fahrameducationcourse.databinding.ActivityMainBinding
import com.anisanurjanah.fahrameducationcourse.home.HomeFragment
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolbar()
        setupNavigation()

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, HomeFragment())
                .commit()
            supportActionBar?.title = getString(R.string.app_name)
        }
    }

    private fun setupNavigation() {
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout,
            binding.appBarMain.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        binding.navView.setNavigationItemSelectedListener(this)
    }

    private fun setupToolbar() {
        setSupportActionBar(binding.appBarMain.toolbar)
        binding.appBarMain.toolbar.inflateMenu(R.menu.option_menu)
        binding.appBarMain.toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_favorite -> {
                    val uri = Uri.parse("fahrameducationcourse://favorite")
                    startActivity(Intent(Intent.ACTION_VIEW, uri))
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option_menu, menu)
        return true
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        var title = getString(R.string.app_name)

        when (item.itemId) {
            R.id.nav_home -> {
                fragment = HomeFragment()
                title = getString(R.string.app_name)
            }
            R.id.nav_course -> {
                fragment = CourseFragment()
                title = getString(R.string.course)
            }
            R.id.nav_task -> {
                Toast.makeText(this@MainActivity,
                    getString(R.string.coming_soon), Toast.LENGTH_SHORT).show()
            }
            R.id.nav_article -> {
//                fragment = ArticleFragment()
//                title = getString(R.string.article)
                Toast.makeText(this@MainActivity,
                    getString(R.string.coming_soon), Toast.LENGTH_SHORT).show()
            }
        }

        if (fragment != null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment, fragment)
                .commit()
        }
        supportActionBar?.title = title

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}