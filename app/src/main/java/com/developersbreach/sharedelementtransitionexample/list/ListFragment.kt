package com.developersbreach.sharedelementtransitionexample.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.developersbreach.sharedelementtransitionexample.R


class ListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.sports_recycler_view)
        val list = Sports.sportsList(requireContext())
        val adapter = SportsAdapter(list, sportsItemListener)
        recyclerView.adapter = adapter
    }

    private val sportsItemListener = SportsAdapter.OnClickListener { sports ->
        val direction: NavDirections =
            ListFragmentDirections.listToDetailFragment(sports)
        findNavController().navigate(direction)
    }
}