package site.yoonsang.instaclone.src.main.profile.myfeed.detail

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.yoonsang.instaclone.config.ApplicationClass
import site.yoonsang.instaclone.src.main.home.feedAdapter.models.FeedLikeResponse
import site.yoonsang.instaclone.src.main.profile.myfeed.detail.models.FeedDetailResponse

class MyFeedDetailService(val view: MyFeedDetailFragmentView) {

    fun tryGetFeedDetail(userId: Int, feedId: Int) {
        val myFeedDetailRetrofitInterface =
            ApplicationClass.sRetrofit.create(MyFeedDetailRetrofitInterface::class.java)
        myFeedDetailRetrofitInterface.getFeedDetail(userId, feedId)
            .enqueue(object : Callback<FeedDetailResponse> {
                override fun onResponse(
                    call: Call<FeedDetailResponse>,
                    response: Response<FeedDetailResponse>
                ) {
                    if (response.body() != null) {
                        view.onGetFeedDetailSuccess(response.body() as FeedDetailResponse)
                    } else {
                        view.onGetFeedDetailFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<FeedDetailResponse>, t: Throwable) {
                    view.onGetFeedDetailFailure(t.message ?: "통신 오류")
                }
            })
    }

    fun tryPostFeedLike(userId: Int, feedId: Int) {
        val myFeedDetailRetrofitInterface =
            ApplicationClass.sRetrofit.create(MyFeedDetailRetrofitInterface::class.java)
        myFeedDetailRetrofitInterface.postFeedLike(userId, feedId)
            .enqueue(object : Callback<FeedLikeResponse> {
                override fun onResponse(
                    call: Call<FeedLikeResponse>,
                    response: Response<FeedLikeResponse>
                ) {
                    if (response.body() != null) {
                        view.onPostFeedLikeSuccess(response.body() as FeedLikeResponse)
                    } else {
                        view.onPostFeedLikeFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<FeedLikeResponse>, t: Throwable) {
                    view.onPostFeedLikeFailure(t.message ?: "통신 오류")
                }
            })
    }
}