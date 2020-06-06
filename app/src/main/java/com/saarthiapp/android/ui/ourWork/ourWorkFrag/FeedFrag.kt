package com.saarthiapp.android.ui.ourWork.ourWorkFrag

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
import com.saarthiapp.android.databinding.FragmentFeedBinding
import com.saarthiapp.android.model.feed.FeedPost

class FeedFrag : Fragment() {

    private lateinit var fragFeedBinding:FragmentFeedBinding
    private lateinit var navController:NavController
    private var feedPostList:ArrayList<FeedPost> ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fragFeedBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_feed, container, false)

        setFeedStaticData()
        setUpRecyclerView()
        return fragFeedBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
    }

    private fun setUpRecyclerView(){
        val layoutManagerFeed = LinearLayoutManager(requireContext())
        val feedAdapter = FeedPostAdapter(requireContext(), feedPostList!!)
        fragFeedBinding.recViewFeedPost.apply {
            layoutManager = layoutManagerFeed
            itemAnimator = DefaultItemAnimator()
            hasFixedSize()
            adapter = feedAdapter
            smoothScrollToPosition(0)
        }
    }

    private fun setFeedStaticData(){
        feedPostList = ArrayList()
        feedPostList?.add(FeedPost("John Abraham", "Bangalore", "image", "https://projects.adsandurl.com/notebook-dev/public/uploads/Banner/twm6JBslide1.jpg", "","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))

        feedPostList?.add(FeedPost("Tony Walker", "United States", "image", "https://projects.adsandurl.com/notebook-dev/public/uploads/Banner/eChnmtslider2.jpg", "","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))

        feedPostList?.add(FeedPost("Kiku Balana", "Karnatak", "video", "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4", "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.png","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))

        feedPostList?.add(FeedPost("Jennie Loffer", "France", "image", "https://projects.adsandurl.com/notebook-dev/public/uploads/Banner/97zcuFbanner-1.jpg", "","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))

        feedPostList?.add(FeedPost("Kiku Balana", "Karnatak", "video", "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API+Retrofit+MVVM+Course+Summary.mp4", "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API%2C+Retrofit2%2C+MVVM+Course+SUMMARY.png","Lorem ipsum dolor sit amet, consectetur adipiscing elit. In consectetur sit feugiat turpis elit. Cras duis euismod at vitae risus penatibus amet a, ut..."))
    }

}


/*public static final MediaObject[] MEDIA_OBJECTS = {
            new MediaObject("Sending Data to a New Activity with Intent Extras",
                    "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.mp4",
                    "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Sending+Data+to+a+New+Activity+with+Intent+Extras.png",
                    "Description for media object #1"),
            new MediaObject("REST API, Retrofit2, MVVM Course SUMMARY",
                    "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API+Retrofit+MVVM+Course+Summary.mp4",
                    "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/REST+API%2C+Retrofit2%2C+MVVM+Course+SUMMARY.png",
                    "Description for media object #2"),
            new MediaObject("MVVM and LiveData",
                    "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/MVVM+and+LiveData+for+youtube.mp4",
                    "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/mvvm+and+livedata.png",
                    "Description for media object #3"),
            new MediaObject("Swiping Views with a ViewPager",
                    "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/SwipingViewPager+Tutorial.mp4",
                    "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Swiping+Views+with+a+ViewPager.png",
                    "Description for media object #4"),
            new MediaObject("Database Cache, MVVM, Retrofit, REST API demo for upcoming course",
                    "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Rest+api+teaser+video.mp4",
                    "https://s3.ca-central-1.amazonaws.com/codingwithmitch/media/VideoPlayerRecyclerView/Rest+API+Integration+with+MVVM.png",
                    "Description for media object #5"),
    };*/