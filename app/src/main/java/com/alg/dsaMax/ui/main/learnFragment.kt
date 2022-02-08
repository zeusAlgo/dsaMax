package com.alg.dsaMax.ui.main
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
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
        return inflater.inflate(R.layout.fragment_learn, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val card = view.findViewById<CardView>(R.id.card0)
        val cardTV = view.findViewById<TextView>(R.id.cardTV)


        val hashmap : HashMap<Int, Array<Any>> = HashMap()
        hashmap[0] = arrayOf("Breadth First Search",
            "Traverse a Tree(Graph) Level by Level using a queue to " +
                    "note the nodes on that level.\n")

        cardTV.text = hashmap[0]!![0].toString()
        card.setOnClickListener {
            val txA = hashmap[0]!![0]
            val txB = hashmap[0]!![1]
            if (cardTV.text == txA) {
                cardTV.text = txB.toString()
            } else {
                cardTV.text = txA.toString()
            }
        }
    }

    companion object {
        @JvmStatic fun newInstance() = learnFragment()
    }
}