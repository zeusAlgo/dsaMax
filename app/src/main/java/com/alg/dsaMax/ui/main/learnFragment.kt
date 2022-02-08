package com.alg.dsaMax.ui.main
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import com.alg.dsaMax.R
class learnFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        return inflater.inflate(R.layout.fragment_learn,
//            container, false)
        val view = inflater.inflate(R.layout.fragment_learn, container, false)

        val cardd = view.findViewById<CardView>(R.id.card0)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        @JvmStatic fun newInstance() = learnFragment()
    }
}