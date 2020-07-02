package com.developersbreach.sharedelementtransitionexample.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.transition.TransitionInflater
import com.developersbreach.sharedelementtransitionexample.R
import com.developersbreach.sharedelementtransitionexample.list.Sports
import java.util.concurrent.TimeUnit


class DetailFragment : Fragment() {

    private lateinit var sportsArgs: Sports

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val args = requireArguments()
        sportsArgs = DetailFragmentArgs.fromBundle(args).modelArgs
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        sharedElementEnterTransition =
            TransitionInflater.from(context).inflateTransition(android.R.transition.move)
        postponeEnterTransition(250, TimeUnit.MILLISECONDS)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val banner: ImageView = view.findViewById(R.id.detail_image_view)
        val title: TextView = view.findViewById(R.id.title_detail_text_view)
        val about: TextView = view.findViewById(R.id.about_detail_text_view)

        banner.setImageResource(sportsArgs.banner)
        title.text = sportsArgs.title
        about.text = sportsArgs.about

        banner.transitionName = sportsArgs.banner.toString()
        title.transitionName = sportsArgs.title
    }
}