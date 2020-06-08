package com.saarthiapp.android.ui.profile.frag

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.saarthiapp.android.R
import com.saarthiapp.android.adapter.feed.FeedPostAdapter
import com.saarthiapp.android.databinding.FragmentMyStoriesBinding
import com.saarthiapp.android.model.feed.FeedPost

class MyStories : Fragment() {

    private lateinit var fragMyStoryBinding:FragmentMyStoriesBinding
    private lateinit var navController: NavController
    private var feedPostList:ArrayList<FeedPost> ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragMyStoryBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_my_stories, container, false)
        return fragMyStoryBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        setFeedStaticData()
        setUpRecyclerView()
    }

    private fun setFeedStaticData(){
        feedPostList = ArrayList()
        feedPostList?.add(FeedPost("John Abraham", "Bangalore", "image", "https://projects.adsandurl.com/notebook-dev/public/uploads/Banner/twm6JBslide1.jpg", "","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))

        feedPostList?.add(FeedPost("Tony Walker", "United States", "image", "https://projects.adsandurl.com/notebook-dev/public/uploads/Banner/eChnmtslider2.jpg", "","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))

        feedPostList?.add(FeedPost("Kiku Balana", "Karnatak", "video", "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4", "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.png","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))

        feedPostList?.add(FeedPost("Jennie Loffer", "France", "image", "https://projects.adsandurl.com/notebook-dev/public/uploads/Banner/97zcuFbanner-1.jpg", "","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))

        feedPostList?.add(FeedPost("Kiku Balana", "Karnatak", "video", "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API+Retrofit+MVVM+Course+Summary.mp4", "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API%2C+Retrofit2%2C+MVVM+Course+SUMMARY.png","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))

        feedPostList?.add(FeedPost("Kiku Balana", "Karnatak", "video", "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4", "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.png","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))

        feedPostList?.add(FeedPost("Jennie Loffer", "France", "image", "https://projects.adsandurl.com/notebook-dev/public/uploads/Banner/97zcuFbanner-1.jpg", "","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))

        feedPostList?.add(FeedPost("Kiku Balana", "Karnatak", "video", "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API+Retrofit+MVVM+Course+Summary.mp4", "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API%2C+Retrofit2%2C+MVVM+Course+SUMMARY.png","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))
    }

    private fun setUpRecyclerView(){
        val layoutManagerFeed = LinearLayoutManager(requireContext())
        val feedAdapter = FeedPostAdapter(requireContext(), feedPostList!!)
        fragMyStoryBinding.recViewMyStories.apply {
            layoutManager = layoutManagerFeed
            itemAnimator = DefaultItemAnimator()
            hasFixedSize()
            adapter = feedAdapter
            smoothScrollToPosition(0)
        }
    }
}