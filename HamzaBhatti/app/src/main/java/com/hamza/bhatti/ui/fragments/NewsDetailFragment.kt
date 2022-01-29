package com.hamza.bhatti.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.navArgs
import com.hamza.bhatti.R
import com.hamza.bhatti.databinding.FragmentNewsDetailBinding
import com.hamza.bhatti.models.News
import com.hamza.bhatti.ui.activities.MainActivity

class NewsDetailFragment : Fragment() {
    lateinit var binding: FragmentNewsDetailBinding
    val args: NewsDetailFragmentArgs by navArgs()
    var newsModel : News? =  News()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_news_detail, container, false)
        init()
        return binding.root

    }
    private fun init(){
        newsModel = args.newsModel
        binding.model = newsModel

        binding.layHeader.tvSource.text = newsModel!!.source
        binding.layHeader.btnBack.setOnClickListener {
            (activity as MainActivity).onBackPressed()
        }

    }

}