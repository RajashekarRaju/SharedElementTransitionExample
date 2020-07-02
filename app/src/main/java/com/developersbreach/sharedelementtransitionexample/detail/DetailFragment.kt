package com.developersbreach.sharedelementtransitionexample.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.transition.TransitionInflater
import com.developersbreach.sharedelementtransitionexample.databinding.FragmentDetailBinding
import java.util.concurrent.TimeUnit


class DetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentDetailBinding.inflate(inflater)

        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        postponeEnterTransition(250, TimeUnit.MILLISECONDS)

        binding.sports = DetailFragmentArgs.fromBundle(requireArguments()).modelArgs
        return binding.root
    }
}