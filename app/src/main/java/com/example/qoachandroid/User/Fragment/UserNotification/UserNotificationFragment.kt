package com.example.qoachandroid.User.Fragment.UserNotification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.qoachandroid.R
import com.example.qoachandroid.databinding.FragmentUserNotificationBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserNotificationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserNotificationFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentUserNotificationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentUserNotificationBinding.inflate(inflater)


        onClick()
        loadFragment(UserRecentNotificationFragment())


        return binding.root
    }

    private fun onClick() {
        binding.txtRecent.setOnClickListener{
            binding.txtRecent.setTextColor(ContextCompat.getColor(requireContext(), R.color.green_color))
            binding.txtEarlier.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey_light_color))
            binding.txtArchieved.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey_light_color))

            loadFragment(UserRecentNotificationFragment())
        }
        binding.txtEarlier.setOnClickListener{
            binding.txtRecent.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey_light_color))
            binding.txtEarlier.setTextColor(ContextCompat.getColor(requireContext(), R.color.green_color))
            binding.txtArchieved.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey_light_color))

            loadFragment(UserEarlierNotificationFragment())
        }
        binding.txtArchieved.setOnClickListener{
            binding.txtRecent.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey_light_color))
            binding.txtEarlier.setTextColor(ContextCompat.getColor(requireContext(), R.color.grey_light_color))
            binding.txtArchieved.setTextColor(ContextCompat.getColor(requireContext(), R.color.green_color))

            loadFragment(UserArchievedNotificationFragment())
        }
    }


    private fun loadFragment(fragment: Fragment) {
        val transaction = parentFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_user_recent_notification_container, fragment)
        transaction.commit()
        val currentFragment = parentFragmentManager.findFragmentById(R.id.fragment_user_recent_notification_container)


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserRecentNotificationFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserNotificationFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}