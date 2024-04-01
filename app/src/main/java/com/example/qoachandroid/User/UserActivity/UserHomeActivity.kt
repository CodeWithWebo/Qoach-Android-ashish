package com.example.qoachandroid.User.UserActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.qoachandroid.R
import com.example.qoachandroid.User.Fragment.UserActivityFragment
import com.example.qoachandroid.User.Fragment.UserCalenderFragment
import com.example.qoachandroid.User.Fragment.UserChatFragment
import com.example.qoachandroid.User.Fragment.UserHomeFragment
import com.example.qoachandroid.User.Fragment.UserNotification.UserNotificationFragment
import com.example.qoachandroid.databinding.ActivityUserHomeBinding
import de.hdodenhof.circleimageview.CircleImageView
import nl.psdcompany.duonavigationdrawer.widgets.DuoDrawerToggle

class UserHomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_home)

        callDrawer()
        callHome()
        clickLisner()
    }


    private fun clickLisner() {

        binding.imgToolbarNotification.setOnClickListener() {

            Toast.makeText(this, "All Notification", Toast.LENGTH_SHORT).show()
//            val intent = Intent(this@UserHomeActivity, NotificationActivity::class.java)
//            startActivity(intent)
        }
        binding.homeLinear.setOnClickListener() {
            callHome()
        }
        binding.calenderLinear.setOnClickListener() {
            callCalender()
        }
        binding.searchLinear.setOnClickListener() {
//            callSearch()
        }
        binding.activityLinear.setOnClickListener() {
            callActivitty()
        }
        binding.chatLinear.setOnClickListener() {
            callChat()
        }
    }

    private fun callHome() {

        loadFragment(UserHomeFragment())
        binding.txtToolbarTitle.text = "Alex Beth"
        binding.iconHome.setColorFilter(ContextCompat.getColor(this, R.color.green_color))
        binding.iconCalender.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconActivity.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconChat.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))

        binding.txtHome.setTextColor(ContextCompat.getColor(this, R.color.green_color))
        binding.txtCalender.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtActivity.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtChat.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))

    }

    private fun callCalender() {

        loadFragment(UserCalenderFragment())
        binding.txtToolbarTitle.text = "Calender"
        binding.iconHome.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconCalender.setColorFilter(ContextCompat.getColor(this, R.color.green_color))
        binding.iconActivity.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconChat.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))

        binding.txtHome.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtCalender.setTextColor(ContextCompat.getColor(this, R.color.green_color))
        binding.txtActivity.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtChat.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))

    }

    private fun callActivitty() {

        loadFragment(UserActivityFragment())
        binding.txtToolbarTitle.text = "Activity Streaming"
        binding.iconHome.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconCalender.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconActivity.setColorFilter(ContextCompat.getColor(this, R.color.green_color))
        binding.iconChat.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))

        binding.txtHome.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtCalender.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtActivity.setTextColor(ContextCompat.getColor(this, R.color.green_color))
        binding.txtChat.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))

    }

    private fun callChat() {

        loadFragment(UserChatFragment())
        binding.txtToolbarTitle.text = "Chat"
        binding.iconHome.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconCalender.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconActivity.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconChat.setColorFilter(ContextCompat.getColor(this, R.color.green_color))

        binding.txtHome.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtCalender.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtActivity.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtChat.setTextColor(ContextCompat.getColor(this, R.color.green_color))

    }


    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_user_home_container, fragment)
        transaction.commit()
        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_user_home_container)

        if (fragment is UserNotificationFragment) {
            binding.txtToolbarTitle.text = "Notifications"
            binding.imgToolbarNotification.visibility = View.GONE
            binding.txtToolbarNotificationCancel.visibility = View.VISIBLE
          bottomNavigationDesign()

        }
        else {
            binding.imgToolbarNotification.visibility = View.VISIBLE
            binding.txtToolbarNotificationCancel.visibility = View.GONE

        }

    }

    private fun bottomNavigationDesign() {
        binding.iconHome.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconCalender.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconActivity.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.iconChat.setColorFilter(ContextCompat.getColor(this, R.color.grey_light_color))

        binding.txtHome.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtCalender.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtActivity.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
        binding.txtChat.setTextColor(ContextCompat.getColor(this, R.color.grey_light_color))
    }

    private fun callDrawer() {
        binding.toolbar.title = ""
        setSupportActionBar(binding.toolbar)
        val drawerToggle = DuoDrawerToggle(
            this, binding.drawer, binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        binding.drawer.setDrawerListener(drawerToggle)
        drawerToggle.syncState()
//        val conentview: View = binding.drawer.contentView
        val menuView: View = binding.drawer.getMenuView()
        binding.toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.img_profile))

        val profile_img = menuView.findViewById<CircleImageView>(R.id.drawer_profile_image)
        val homeLayout = menuView.findViewById<LinearLayout>(R.id.home_layout)
        val dashboardLayout = menuView.findViewById<LinearLayout>(R.id.dashboard_layout)
        val notificationLayout = menuView.findViewById<LinearLayout>(R.id.notification_layout)

        profile_img.setOnClickListener(){

            Toast.makeText(this, "User Image", Toast.LENGTH_SHORT).show()
            if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.closeDrawer(GravityCompat.START)
            }
        }
        homeLayout.setOnClickListener(){

            Toast.makeText(this, "Home layout", Toast.LENGTH_SHORT).show()
            if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.closeDrawer(GravityCompat.START)
            }
            callHome()
        }
        dashboardLayout.setOnClickListener(){

            Toast.makeText(this, "Dashboard layout", Toast.LENGTH_SHORT).show()
            if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.closeDrawer(GravityCompat.START)
            }
//            loadFragment(UserHomeFragment())
        }
        notificationLayout.setOnClickListener(){

            loadFragment(UserNotificationFragment())
            Toast.makeText(this, "Notification layout", Toast.LENGTH_SHORT).show()
            if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
                binding.drawer.closeDrawer(GravityCompat.START)
            }
        }
//        linear_transaction.setOnClickListener(){
//            binding.bottomcard.visibility=View.GONE
//            binding.linearTransaction.background=ContextCompat.getDrawable(this@HomeActivity,R.drawable.menu_selected_bg)
//
//            if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
//                binding.drawer.closeDrawer(GravityCompat.START)
//            }
//            binding.toolbar.title="Transaction history"
//            callTransactionHistory()
//        }
        /*
         user_name = menuView.findViewById<TextView>(R.id.user_name)

         val Rl_logout = menuView.findViewById<RelativeLayout>(R.id.logout)
         val message = menuView.findViewById<RelativeLayout>(R.id.Rl_Message)

         val rl_profile = menuView.findViewById<RelativeLayout>(R.id.rl_profile)
         val RlSetting=menuView.findViewById<RelativeLayout>(R.id.RlSetting)
         val share=menuView.findViewById<RelativeLayout>(R.id.share)


         message.setOnClickListener(){
             if (binding.drawer.isDrawerOpen(GravityCompat.START)) {
                 binding.drawer.closeDrawer(GravityCompat.START)
             }
             binding.line2.visibility= View.VISIBLE
             binding.line1.visibility= View.INVISIBLE
             binding.line3.visibility= View.INVISIBLE
             binding.line4.visibility= View.INVISIBLE
             binding.line5.visibility= View.INVISIBLE
             binding.image1.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.menu1))
             binding.image2.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.fillmenu2))
             binding.image4.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.menu3))
             binding.image5.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.menu4))
             loadFragment(ChatFragment())

         }



         rl_profile.setOnClickListener(){
             binding.drawer.setDrawerListener(drawerToggle)
             val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
             startActivity(intent)
         }
         RlSetting.setOnClickListener(){
             binding.drawer.setDrawerListener(drawerToggle)
             val intent = Intent(this@HomeActivity, SettingActivity::class.java)
             startActivity(intent)
         }

         user_name.setOnClickListener(){
             binding.drawer.setDrawerListener(drawerToggle)
             val intent = Intent(this@HomeActivity, ProfileActivity::class.java)
             startActivity(intent)
         }

         Rl_logout.setOnClickListener(){
             LogOutBottomSheet()

         }
         share.setOnClickListener(){
             shareBottomSheet()

         }*/
    }

//    override fun onBackPressed() {
//        super.onBackPressed()
//        val currentFragment = supportFragmentManager.findFragmentById(R.id.fragment_user_home_container)
//
//        if (currentFragment is UserHomeFragment) {
//            callTrade()
//            binding.bottomcard.visibility=View.VISIBLE
//
//        } else {
//            binding.bottomcard.visibility=View.VISIBLE
//
//        }
//    }


}