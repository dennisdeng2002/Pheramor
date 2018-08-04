package com.example.android.pheramor

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_registration.*

class RegistrationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        setSupportActionBar(toolbar)
        setup()
    }

    private fun setup() {
        pager.adapter = RegistrationPagerAdapter(supportFragmentManager)
        previous_text_view.setOnClickListener { navigate(true) }
        next_text_view.setOnClickListener { navigate(false) }
        pager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                toggleNavigationButtons(position)
            }
        })
    }

    private fun toggleNavigationButtons(position: Int) {
        previous_text_view.visibility = View.VISIBLE
        next_text_view.visibility = View.VISIBLE

        if (position == 0) previous_text_view.visibility = View.GONE
        else if (position == RegistrationPagerAdapter.ITEM_COUNT - 1) next_text_view.visibility = View.GONE
    }

    private fun navigate(previous: Boolean) {
        val fragment = pager.adapter!!.instantiateItem(pager, pager.currentItem) as BaseFragment
        when {
            previous -> pager.currentItem = pager.currentItem - 1 % pager.childCount
            fragment.isValid() -> pager.currentItem = pager.currentItem + 1 % pager.childCount
            else -> Toast.makeText(this, "Please fill out necessary fields", Toast.LENGTH_SHORT).show()
        }
    }

}
