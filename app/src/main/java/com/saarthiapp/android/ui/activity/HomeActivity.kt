package com.saarthiapp.android.ui.activity

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.saarthiapp.android.R
import com.saarthiapp.android.databinding.ActivityHomeBinding
import com.saarthiapp.android.ui.utils.Constants.Companion.MEOW_CHAT_BOTTOM_NAVIGATION
import com.saarthiapp.android.ui.utils.Constants.Companion.MEOW_HOME_BOTTOM_NAVIGATION
import com.saarthiapp.android.ui.utils.Constants.Companion.MEOW_OUT_WORK_BOTTOM_NAVIGATION
import com.saarthiapp.android.ui.utils.Constants.Companion.MEOW_PROFILE_BOTTOM_NAVIGATION

class HomeActivity : AppCompatActivity(), NavController.OnDestinationChangedListener,
    View.OnClickListener {

    private lateinit var actHomeBinding:ActivityHomeBinding
    private val navController: NavController by lazy {
        Navigation.findNavController(this, R.id.homeNavHostContainer)
    }
    private lateinit var homeToolbar: Toolbar
    private lateinit var OtherToolbar: Toolbar
    private lateinit var ProfileToolbar: Toolbar

    private var currentBottomMenuID:Int ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        actHomeBinding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        setBottomNavMenu()
        setupCardDrawer()
        setupHeaderView()

        homeToolbar = findViewById<ConstraintLayout>(R.id.include_toolbarRed).findViewById(R.id.toolbarRed)
        OtherToolbar = findViewById<ConstraintLayout>(R.id.include_toolbarBlue).findViewById(R.id.toolbarBlue)
        ProfileToolbar = findViewById<ConstraintLayout>(R.id.include_toolbarProfile).findViewById(R.id.toolbarProfile)

        val toggle =  ActionBarDrawerToggle(
            this, actHomeBinding.mainDrawerLayout, homeToolbar,
            R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        actHomeBinding.mainDrawerLayout.addDrawerListener(toggle)
        toggle.syncState()
//        toggle.drawerArrowDrawable =
        toggle.setHomeAsUpIndicator(R.drawable.ic_navigation_menu)
        setupActionBar()

        // Add Listeners
        navController.addOnDestinationChangedListener(this)
    }

    private fun setupCardDrawer(){
        actHomeBinding.mainDrawerLayout.useCustomBehavior(Gravity.START)
        actHomeBinding.mainDrawerLayout.setViewScale(Gravity.START, 0.90f) //set height scale for main view (0f to 1f)
        actHomeBinding.mainDrawerLayout.setViewElevation(Gravity.START, 20f)//set main view elevation when drawer open (dimension)
        /*Color.parseColor("#00B2FF")*/
        actHomeBinding.mainDrawerLayout.setViewScrimColor(Gravity.START, Color.TRANSPARENT)//set drawer overlay color (color)
        actHomeBinding.mainDrawerLayout.setRadius(Gravity.START, 25f)//set end container's corner radius (dimension)
    }

    private fun setupHeaderView(){
        actHomeBinding.includedCustomNavView.tvDrawerHome.setOnClickListener(this)
        actHomeBinding.includedCustomNavView.tvDrawerCommunity.setOnClickListener(this)
        actHomeBinding.includedCustomNavView.tvDrawerDonate.setOnClickListener(this)
        actHomeBinding.includedCustomNavView.tvDrawerEvent.setOnClickListener(this)
        actHomeBinding.includedCustomNavView.tvDrawerNotification.setOnClickListener(this)
        actHomeBinding.includedCustomNavView.tvDrawerLogout.setOnClickListener(this)
        actHomeBinding.includedCustomNavView.tvDrawerFeedback.setOnClickListener(this)
        actHomeBinding.includedCustomNavView.clDrawerProfileLayout.setOnClickListener(this)
        actHomeBinding.includedCustomNavView.imgCloseMenu.setOnClickListener(this)
    }

    private fun setupActionBar() {
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.saarthiHome, R.id.ourWork,
            R.id.chatHome, R.id.myProfile), actHomeBinding.mainDrawerLayout)
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)

        if (actHomeBinding.includeToolbarRed.visibility == View.VISIBLE) {
            setSupportActionBar(homeToolbar)
            homeToolbar.setupWithNavController(navController,appBarConfiguration)

        } else if (actHomeBinding.includeToolbarBlue.visibility == View.VISIBLE) {
            setSupportActionBar(OtherToolbar)
            OtherToolbar.setupWithNavController(navController,appBarConfiguration)

        }else if (actHomeBinding.includeToolbarProfile.visibility == View.VISIBLE) {
            setSupportActionBar(ProfileToolbar)
            ProfileToolbar.setupWithNavController(navController,appBarConfiguration)
        }
    }

    private fun setBottomNavMenu(){
        actHomeBinding.mbnBottomNav.add(MeowBottomNavigation.Model(MEOW_HOME_BOTTOM_NAVIGATION, R.drawable.ic_home))
        actHomeBinding.mbnBottomNav.add(MeowBottomNavigation.Model(MEOW_OUT_WORK_BOTTOM_NAVIGATION, R.drawable.ic_our_work))
        actHomeBinding.mbnBottomNav.add(MeowBottomNavigation.Model(MEOW_CHAT_BOTTOM_NAVIGATION, R.drawable.ic_chat))
        actHomeBinding.mbnBottomNav.add(MeowBottomNavigation.Model(MEOW_PROFILE_BOTTOM_NAVIGATION, R.drawable.ic_profile_user))

        actHomeBinding.mbnBottomNav.show(MEOW_HOME_BOTTOM_NAVIGATION, true)
        actHomeBinding.mbnBottomNav.countTypeface = Typeface.createFromAsset(assets, "fonts/SourceSansPro-Regular.ttf")
        actHomeBinding.mbnBottomNav.setOnShowListener {
            val name = when(it.id){
                MEOW_HOME_BOTTOM_NAVIGATION -> "Home"
                MEOW_OUT_WORK_BOTTOM_NAVIGATION -> "Our Work"
                MEOW_CHAT_BOTTOM_NAVIGATION -> "Chat"
                MEOW_PROFILE_BOTTOM_NAVIGATION -> "Profile"
                else -> ""
            }
        }

        actHomeBinding.mbnBottomNav.setOnClickMenuListener {
            when(it.id){
                MEOW_HOME_BOTTOM_NAVIGATION -> {
                    navController.navigate(R.id.saarthiHome)
                    currentBottomMenuID = MEOW_HOME_BOTTOM_NAVIGATION
                }
                MEOW_OUT_WORK_BOTTOM_NAVIGATION -> {
                    navController.navigate(R.id.ourWork)
                    currentBottomMenuID = MEOW_OUT_WORK_BOTTOM_NAVIGATION
                }

                MEOW_CHAT_BOTTOM_NAVIGATION -> {
                    navController.navigate(R.id.chatHome)
                    currentBottomMenuID = MEOW_CHAT_BOTTOM_NAVIGATION
                }
                MEOW_PROFILE_BOTTOM_NAVIGATION -> {
                    navController.navigate(R.id.myProfile)
                    currentBottomMenuID = MEOW_PROFILE_BOTTOM_NAVIGATION
                }
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
            actHomeBinding.includeToolbarProfile.visibility = View.GONE
            actHomeBinding.includeToolbarRed.visibility = View.VISIBLE
            actHomeBinding.mbnBottomNav.visibility = View.VISIBLE
            drawerToggleDelegate!!
                .setActionBarUpIndicator(
                    ContextCompat.getDrawable(
                        this,
                        R.drawable.ic_navigation_menu
                    ),
                    androidx.navigation.ui.R.string.nav_app_bar_open_drawer_description
                )
        }else  if (destination.id == R.id.myProfile) {
            actHomeBinding.includeToolbarProfile.visibility = View.VISIBLE
            actHomeBinding.includeToolbarBlue.visibility = View.GONE
            actHomeBinding.includeToolbarRed.visibility = View.GONE
            actHomeBinding.mbnBottomNav.visibility = View.VISIBLE
        }else  if (destination.id == R.id.searchVolunteerFrag) {
            actHomeBinding.includeToolbarProfile.visibility = View.GONE
            actHomeBinding.includeToolbarBlue.visibility = View.GONE
            actHomeBinding.includeToolbarRed.visibility = View.GONE
            actHomeBinding.mbnBottomNav.visibility = View.GONE
        }else  if (destination.id == R.id.editProfileFrag) {
            actHomeBinding.includeToolbarProfile.visibility = View.VISIBLE
            actHomeBinding.includeToolbarBlue.visibility = View.GONE
            actHomeBinding.includeToolbarRed.visibility = View.GONE
            actHomeBinding.mbnBottomNav.visibility = View.GONE
        } else {
            actHomeBinding.includeToolbarBlue.visibility = View.VISIBLE
            actHomeBinding.includeToolbarRed.visibility = View.GONE
            actHomeBinding.includeToolbarProfile.visibility = View.GONE
            actHomeBinding.mbnBottomNav.visibility = View.VISIBLE
        }

        setupActionBar()
    }

    override fun onSupportNavigateUp(): Boolean {
        navController.navigateUp()
        return super.onSupportNavigateUp()
    }

    override fun onBackPressed() {
        if (actHomeBinding.mainDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            actHomeBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
        } else if(currentBottomMenuID == MEOW_HOME_BOTTOM_NAVIGATION){
            finishAffinity()
            super.onBackPressed()
        }else if(currentBottomMenuID == MEOW_CHAT_BOTTOM_NAVIGATION){
            navController.popBackStack(R.id.saarthiHome, false)
            actHomeBinding.mbnBottomNav.show(MEOW_HOME_BOTTOM_NAVIGATION, true)
        }else if(currentBottomMenuID == MEOW_PROFILE_BOTTOM_NAVIGATION){
            actHomeBinding.mbnBottomNav.show(MEOW_HOME_BOTTOM_NAVIGATION, true)
            navController.popBackStack(R.id.saarthiHome, false)
        }else if(currentBottomMenuID == MEOW_OUT_WORK_BOTTOM_NAVIGATION){
            actHomeBinding.mbnBottomNav.show(MEOW_HOME_BOTTOM_NAVIGATION, true)
            navController.popBackStack(R.id.saarthiHome, false)
        } else {
            super.onBackPressed()
        }
    }

    override fun onClick(p0: View?) {
        when(p0){

            actHomeBinding.includedCustomNavView.imgCloseMenu -> {
                actHomeBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
            }

            actHomeBinding.includedCustomNavView.clDrawerProfileLayout -> {
                actHomeBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
            }

            actHomeBinding.includedCustomNavView.tvDrawerHome -> {
                actHomeBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
            }

            actHomeBinding.includedCustomNavView.tvDrawerCommunity -> {
                actHomeBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
            }

            actHomeBinding.includedCustomNavView.tvDrawerDonate -> {
                navController.navigate(R.id.donateSaarthi)
                actHomeBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
            }

            actHomeBinding.includedCustomNavView.tvDrawerEvent -> {
                actHomeBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
            }

            actHomeBinding.includedCustomNavView.tvDrawerFeedback -> {
                navController.navigate(R.id.rateOurApp)
                actHomeBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
            }

            actHomeBinding.includedCustomNavView.tvDrawerNotification -> {
                actHomeBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
            }

            actHomeBinding.includedCustomNavView.tvDrawerLogout -> {
                actHomeBinding.mainDrawerLayout.closeDrawer(GravityCompat.START)
            }
        }
    }
}