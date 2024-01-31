package com.example.countrynews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.countrynews.frags.BusinessFragment
import com.example.countrynews.frags.GeneralFragment
import com.example.countrynews.frags.SportFragment
import com.example.countrynews.frags.TechnologyFragment
import java.lang.IllegalArgumentException

class ViewPagerAdapter(supportFragmentManager: FragmentActivity) :
    FragmentStateAdapter(supportFragmentManager) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GeneralFragment()
            1 -> BusinessFragment()
            2 -> SportFragment()
            3 -> TechnologyFragment()
            else -> throw IllegalArgumentException("Invalid position: $position")
        }
    }
}