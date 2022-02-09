package com.alg.dsaMax.ui.main
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.cardview.widget.CardView
import com.alg.dsaMax.R
import kotlin.random.Random

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
        hashmap[1] = arrayOf("Depth First Search",
            "Use recursion or stack for iteration to track parent nodes")
        hashmap[2] = arrayOf("Binary Search", "Divide Array, Matrix or Linked List" +
                "into 2 until target located")
        hashmap[3] = arrayOf("Bitwise XOR", "Exclusive Logical OR to solve" +
                "problems pertaining to bit manipulation of integers")
        hashmap[4] = arrayOf("Two Pointers", " Dual Pointers to iterate through" +
                "a data structure until a certain condition is met")

        var rand = Random.nextInt(0, 4)
        cardTV.text = hashmap[rand]!![0].toString()
        card.setOnClickListener {
            val txA = hashmap[rand]!![0]
            val txB = hashmap[rand]!![1]
            if (cardTV.text == txA) {
                cardTV.text = txB.toString()
            } else {
                cardTV.text = txA.toString()
            }
        }

        val nxtBtn = view.findViewById<Button>(R.id.nxtBtn)
        val prevBtn = view.findViewById<Button>(R.id.prevBtn)
        nxtBtn.setOnClickListener {
            nextCard(cardTV, card, hashmap)
        }
    }

    companion object {
        @JvmStatic fun newInstance() = learnFragment()
    }

    private fun nextCard(tv: TextView, view2: View, hashmap: HashMap<Int, Array<Any>>,) {
        var rand = Random.nextInt(0, 4)
        tv.text = hashmap[rand]!![0].toString()
        view2.setOnClickListener {
            val txA = hashmap[rand]!![0]
            val txB = hashmap[rand]!![1]
            if (tv.text == txA) {
                tv.text = txB.toString()
            } else {
                tv.text = txA.toString()
            }
        }
    }
}