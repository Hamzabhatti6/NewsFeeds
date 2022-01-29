package com.hamza.bhatti.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hamza.bhatti.R
import com.hamza.bhatti.databinding.FragmentHomeBinding
import com.hamza.bhatti.enums.Status
import com.hamza.bhatti.ui.activities.MainActivity
import com.hamza.bhatti.utilities.Constants
import com.hamza.bhatti.utilities.UtilityFunctions
import com.hamza.bhatti.viewModels.MainViewModel

class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate( inflater,R.layout.fragment_home, container, false)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        init()
        return binding.root
    }

    private fun init(){

        binding.layHeader.tvSource.text = "News"
        binding.layHeader.btnBack.visibility = View.GONE

        callGetNews()
    }

    private fun callGetNews() {
        (activity as MainActivity).showLoaderDialog()
        viewModel.getNews(Constants().session,Constants().period,Constants().api_key).observe(viewLifecycleOwner, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {

                        val response = resource.response!!.body()!!

                        if (response.results.size > 0) {
                            UtilityFunctions().genericAdapter(binding.rvNews,response.results,R.layout.item_news,"news")
                        }
                        (activity as MainActivity).hideLoaderDialog()

                    }
                    Status.ERROR -> {
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                        (activity as MainActivity).hideLoaderDialog()

                    }
                    Status.LOADING -> {
                    }
                }
            }
        })

    }
}