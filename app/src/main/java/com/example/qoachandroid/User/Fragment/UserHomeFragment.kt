package com.example.qoachandroid.User.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qoachandroid.R
import com.example.qoachandroid.User.Adapter.UserHomeExploreCategoryAdapter
import com.example.qoachandroid.User.Adapter.UserHomePopularCoachAdapter
import com.example.qoachandroid.User.Adapter.UserHomeTopLayoutAdapter
import com.example.qoachandroid.User.Adapter.UserRecentNotificationAdapter
import com.example.qoachandroid.User.Model.UserRecentNotificationModel
import com.example.qoachandroid.databinding.FragmentUserHomeBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserHomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserHomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var binding: FragmentUserHomeBinding

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

        binding = FragmentUserHomeBinding.inflate(inflater)

        callInit()


        return binding.root
    }

    private fun callInit() {

// **************** for home top layout
        binding.rcvHomeTop.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val homeTopData = ArrayList<UserRecentNotificationModel>()
        for (i in 1..5) {
            homeTopData.add(UserRecentNotificationModel(R.drawable.img_profile, "Super Offer " + i))
        }
        val homeTopAdapter = UserHomeTopLayoutAdapter(homeTopData)
        binding.rcvHomeTop.adapter = homeTopAdapter


// **************** for Explore CAtegory

        binding.rcvExploreCategory.layoutManager = GridLayoutManager(requireContext(), 2)
        val exploreCatData = ArrayList<UserRecentNotificationModel>()
        for (i in 1..4) {
            exploreCatData.add(UserRecentNotificationModel(R.drawable.img_profile, "Super Offer " + i))
        }
        val exploreCatAdapter = UserHomeExploreCategoryAdapter(exploreCatData)
        binding.rcvExploreCategory.adapter = exploreCatAdapter



// **************** for Popular Coaches

        binding.rcvAllPopularCoaches.layoutManager = LinearLayoutManager(requireContext())
        val popularCoachData = ArrayList<UserRecentNotificationModel>()
        for (i in 1..3) {
            popularCoachData.add(UserRecentNotificationModel(R.drawable.img_profile, "Super Offer " + i))
        }
        val popularCoachAdapter = UserHomePopularCoachAdapter(popularCoachData)
        binding.rcvAllPopularCoaches.adapter = popularCoachAdapter

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserHomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserHomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}