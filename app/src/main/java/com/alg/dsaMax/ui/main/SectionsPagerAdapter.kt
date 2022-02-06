package com.alg.dsaMax.ui.main
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.alg.dsaMax.R
private val TAB_TITLES = arrayOf(R.string.Learn, R.string.Play, R.string.Settings)
class SectionsPagerAdapter(private val context: Context, fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        when (position) {
            0 -> {
                return learnFragment.newInstance()
            }
            1 -> {
                return PlaceholderFragment.newInstance(
                    position + 1
                )
            }
            2 -> {
                return learnFragment.newInstance()
            }

            else -> {
                return PlaceholderFragment.newInstance(1)
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 3
    }
}