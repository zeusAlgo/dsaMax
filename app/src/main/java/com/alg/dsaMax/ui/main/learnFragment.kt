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
                "into 2 until target located")
        hashmap[3] = arrayOf("Bitwise XOR", "Exclusive Logical OR to solve" +
                "problems pertaining to bit manipulation of integers")
        hashmap[4] = arrayOf("Two Pointers", " Dual Pointers to iterate through" +
                "a data structure until a certain condition is met")
        hashmap[5] = arrayOf("2 Heaps", "Desire to know smallest & largest elements" +
                        "in a set")
        hashmap[6] = arrayOf("Subsets", "Use DFS to find all permutations"
                                + "or combinations in a set")
        hashmap[7] = arrayOf("Top 'K' Elements", "Use heap to locate top k, " +
                                "top k smallest, k largest, k most frequent elements")
        // TODO: ADD REMAINING STRATS

        val keyStack = mutableListOf<Int>()

        val key = randomInt(hashmap)
        cardTv.text = hashmap[key]!![0].toString()

        keyStack.add(key)

        card.setOnClickListener { flipCard(cardTv, card, hashmap, key) }

        val nxtBtn = view.findViewById<Button>(R.id.nxtBtn)
        val prevBtn = view.findViewById<Button>(R.id.prevBtn)
        nxtBtn.setOnClickListener { nextCard(cardTv, card, hashmap, keyStack) }
        prevBtn.setOnClickListener { prevCard(cardTv, card, hashmap, keyStack) }
    }

    companion object {
        @JvmStatic fun newInstance() = learnFragment()
    }

    private fun prevCard(cardTv: TextView, card: View,
                         hashmap: HashMap<Int, Array<Any>>,
                         keyStack: MutableList<Int>) {

        val len = keyStack.size
        if (len <= 1) {
            toast("Not Allowed")
        } else {
            keyStack.removeLast()
            val key = keyStack.last()
            cardTv.text = hashmap[key]!![0].toString()

            card.setOnClickListener { flipCard(cardTv, card, hashmap, key) }
        }
    }
    private fun nextCard(cardTv: TextView, card: View,
                         hashmap: HashMap<Int, Array<Any>>,
                         stack: MutableList<Int>) {
//        val rand = randomInt(hashmap)

        val rand = genDistinctCard(hashmap, stack)
        cardTv.text = hashmap[rand]!![0].toString()
        stack.add(rand)

        card.setOnClickListener { flipCard(cardTv, card, hashmap, rand) }
    }

    private fun flipCard(cardTv: TextView, card: View,
                         hashmap: HashMap<Int, Array<Any>>, rand: Int) {
        val txA = hashmap[rand]!![0]
        val txB = hashmap[rand]!![1]
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
                                stack: MutableList<Int>) : Int {
        val rand = randomInt(hashmap)
        if (rand == stack.last()) {
            genDistinctCard(hashmap, stack)
        }
        return rand
    }

    private fun toast(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}