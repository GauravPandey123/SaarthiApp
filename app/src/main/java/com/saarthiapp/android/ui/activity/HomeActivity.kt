package com.saarthiapp.android.ui.activity

import android.graphics.Typeface
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.google.android.gms.maps.GoogleMap
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.ActivityHomeBinding
import com.saarthiapp.android.ui.utils.Constants.Companion.MEOW_HOME_BOTTOM_NAVIGATION
import com.saarthiapp.android.ui.utils.Constants.Companion.MEOW_NEED_HELP_BOTTOM_NAVIGATION
import com.saarthiapp.android.ui.utils.Constants.Companion.MEOW_OUT_WORK_BOTTOM_NAVIGATION
import com.saarthiapp.android.ui.utils.Constants.Companion.MEOW_PROFILE_BOTTOM_NAVIGATION

class HomeActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var actHomeBinding:ActivityHomeBinding
    private lateinit var navController: NavController
    private lateinit var homeToolbar: Toolbar
    private lateinit var OtherToolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        navController = Navigation.findNavController(this, R.id.homeNavHostContainer)
        setBottomNavMenu()

        homeToolbar = findViewById<ConstraintLayout>(R.id.include_toolbarRed).findViewById(R.id.toolbarRed)
        OtherToolbar = findViewById<ConstraintLayout>(R.id.include_toolbarBlue).findViewById(R.id.toolbarBlue)
        setupActionBar()

        // Add Listeners
        navController.addOnDestinationChangedListener(this)
    }

    private fun setupActionBar() {
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.saarthiHome, R.id.ourWork,
            R.id.needHelp, R.id.myProfile), actHomeBinding.mainDrawerLayout)

        if (actHomeBinding.includeToolbarRed.visibility == View.VISIBLE) {
            setSupportActionBar(homeToolbar)
            homeToolbar.setupWithNavController(navController,appBarConfiguration)

        } else if (actHomeBinding.includeToolbarBlue.visibility == View.VISIBLE) {
            setSupportActionBar(OtherToolbar)
            OtherToolbar.setupWithNavController(navController,appBarConfiguration)
        }
    }

    private fun setBottomNavMenu(){
        actHomeBinding.mbnBottomNav.add(MeowBottomNavigation.Model(MEOW_HOME_BOTTOM_NAVIGATION, R.drawable.ic_home))
        actHomeBinding.mbnBottomNav.add(MeowBottomNavigation.Model(MEOW_OUT_WORK_BOTTOM_NAVIGATION, R.drawable.ic_our_work))
        actHomeBinding.mbnBottomNav.add(MeowBottomNavigation.Model(MEOW_NEED_HELP_BOTTOM_NAVIGATION, R.drawable.ic_need_help))
        actHomeBinding.mbnBottomNav.add(MeowBottomNavigation.Model(MEOW_PROFILE_BOTTOM_NAVIGATION, R.drawable.ic_profile_user))

        actHomeBinding.mbnBottomNav.show(MEOW_HOME_BOTTOM_NAVIGATION, true)
        actHomeBinding.mbnBottomNav.countTypeface = Typeface.createFromAsset(assets, "fonts/SourceSansPro-Regular.ttf")
        actHomeBinding.mbnBottomNav.setOnShowListener {
            val name = when(it.id){
                MEOW_HOME_BOTTOM_NAVIGATION -> "Home"
                MEOW_OUT_WORK_BOTTOM_NAVIGATION -> "Our Work"
                MEOW_NEED_HELP_BOTTOM_NAVIGATION -> "Need Help"
                MEOW_PROFILE_BOTTOM_NAVIGATION -> "Profile"
                else -> ""
            }
        }

        actHomeBinding.mbnBottomNav.setOnClickMenuListener {
            when(it.id){
                MEOW_HOME_BOTTOM_NAVIGATION -> navController.navigate(R.id.saarthiHome)
                MEOW_OUT_WORK_BOTTOM_NAVIGATION -> navController.navigate(R.id.ourWork)
                MEOW_NEED_HELP_BOTTOM_NAVIGATION -> navController.navigate(R.id.needHelp)
                MEOW_PROFILE_BOTTOM_NAVIGATION -> navController.navigate(R.id.myProfile)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    override fun onDestinationChanged(controller: NavController, destination: NavDestination, arguments: Bundle?) {

        if (destination.id == R.id.saarthiHome) {
            actHomeBinding.includeToolbarBlue.visibility = View.GONE
            actHomeBinding.includeToolbarRed.visibility = View.VISIBLE
        } else {
            actHomeBinding.includeToolbarBlue.visibility = View.VISIBLE
            actHomeBinding.includeToolbarRed.visibility = View.GONE
        }

        setupActionBar()
    }

    override fun onBackPressed() {
        if (actHomeBinding.mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            actHomeBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
        } /*else if(){

        }*/ else {
            super.onBackPressed()
        }
    }
}