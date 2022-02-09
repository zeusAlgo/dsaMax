package com.alg.dsaMax.ui.main
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
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
        val cardTv = view.findViewById<TextView>(R.id.cardTV)
        val hashmap : HashMap<Int, Array<Any>> = HashMap()
        hashmap[0] = arrayOf("Breadth First Search",
            "Traverse a Tree(Graph) Level by Level using a queue to " +
                    "note the nodes on that level.\n")
        hashmap[1] = arrayOf("Depth First Search",
            "Use recursion or stack for iteration to track parent nodes")
        hashmap[2] = arrayOf("Binary Search", "Divide Array, Matrix or Linked List" +
                " into 2 until target located")
        hashmap[3] = arrayOf("Bitwise XOR", "Exclusive Logical OR to solve" +
                " problems pertaining to bit manipulation of integers")
        hashmap[4] = arrayOf("2 Pointers", " Dual Pointers to iterate through" +
                " a data structure until a certain condition is met")
        hashmap[5] = arrayOf("2 Heaps", "Desire to know smallest & largest elements" +
                        "in a set")
        hashmap[6] = arrayOf("Subsets", "Use DFS to find all permutations"
                                + "or combinations in a set")
        hashmap[7] = arrayOf("Top 'K' Elements", "Use heap to locate top k, " +
                                " k smallest, k largest, k most frequent elements")
        hashmap[8] = arrayOf("Sliding Window", "Fixed or Dynamic Window performs operations"
                             + " on an array, linked list, or string to find longest, shortest"
                             + " subarray or desired value")
        hashmap[9] = arrayOf("Fast & Slow Pointers", "Hare and Tortoise Algorithm whereby"
                             + "one pointer is faster than the other slow pointer.")
        hashmap[10] = arrayOf("Merge Intervals", "Produce mutually exclusive intervals")
        // TODO: ADD REMAINING STRATS

        val key = randomInt(hashmap)
        val keyStack = mutableListOf<Int>()
        keyStack.add(key)

        cardTv.text = hashmap[key]!![0].toString()
        card.setOnClickListener { flipCard(cardTv, card, hashmap, key) }

        val nxtBtn = view.findViewById<Button>(R.id.nxtBtn)
        val prevBtn = view.findViewById<Button>(R.id.prevBtn)
        nxtBtn.setOnClickListener { nextCard(cardTv, card, hashmap, keyStack) }
        prevBtn.setOnClickListener { prevCard(cardTv, card, hashmap, keyStack) }
    }

    private fun prevCard(cardTv: TextView, card: View, hashmap: HashMap<Int, Array<Any>>,
                         keyStack: MutableList<Int>) {

        if (keyStack.size <= 1) {
            toast("Not Allowed")
        } else {
            keyStack.removeLast()
            val key = keyStack.last()
            cardTv.text = hashmap[key]!![0].toString()

            card.setOnClickListener { flipCard(cardTv, card, hashmap, key) }
        }
    }
    private fun nextCard(cardTv: TextView, card: View, hashmap: HashMap<Int, Array<Any>>,
                         keyStack: MutableList<Int>) {
        val key = genDistinctCard(hashmap, keyStack)
        cardTv.text = hashmap[key]!![0].toString()
        keyStack.add(key)

        card.setOnClickListener { flipCard(cardTv, card, hashmap, key) }
    }

    private fun flipCard(cardTv: TextView, card: View,
                         hashmap: HashMap<Int, Array<Any>>, key: Int) {
        val txA = hashmap[key]!![0]
        val txB = hashmap[key]!![1]
        if (cardTv.text == txA) {
            cardTv.text = txB.toString()
        } else {
            cardTv.text = txA.toString()
        }
    }

    private fun randomInt(hashmap: HashMap<Int, Array<Any>>) : Int {
        return Random.nextInt(0, hashmap.size)
    }

    private fun genDistinctCard(hashmap: HashMap<Int, Array<Any>>,
                                keyStack: MutableList<Int>): Int {
        val key = randomInt(hashmap)
        return if (key == keyStack.last()) {
            genDistinctCard(hashmap, keyStack)
        } else {
            return key
        }
    }

    companion object { @JvmStatic fun newInstance() = learnFragment() }

    private fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}