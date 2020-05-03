package com.example.sharedtransitiontest

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.navigation.NavOptions
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import androidx.transition.TransitionInflater
import kotlinx.android.synthetic.main.fragment_second.*
import kotlinx.android.synthetic.main.fragment_second.dayStringFull
import kotlinx.android.synthetic.main.fragment_second.endTime
import kotlinx.android.synthetic.main.fragment_second.startTime
import kotlinx.android.synthetic.main.fragment_second.textViewEnd
import kotlinx.android.synthetic.main.fragment_second.textViewStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        postponeEnterTransition(150, TimeUnit.MILLISECONDS)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<CardView>(R.id.cardView).setOnClickListener {
            val extras = FragmentNavigatorExtras(
                cardViewConstraint to "cardViewConstraint", dayStringFull to "dayStringFull",
                textViewStart to "textViewStart", textViewEnd to "textViewEnd",
                startTime to "startTime", endTime to "endTime")
            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment, null, null,extras)
        }
    }
}
