package com.example.android.pheramor

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter

class RegistrationPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> return EmailPasswordFragment()
            1 -> return NameZipcodeHeightFragment()
            2 -> return GenderDOBFragment()
            3 -> return GenderAgeFragment()
            4 -> return RaceReligionFragment()
            5 -> return ProfilePictureFragment()
            6 -> return SummaryFragment()
        }

        return EmailPasswordFragment()
    }

    companion object {
        const val ITEM_COUNT = 7
    }

}
