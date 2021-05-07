package site.yoonsang.instaclone.src.main.home

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.yoonsang.instaclone.config.ApplicationClass
import site.yoonsang.instaclone.src.main.home.feedAdapter.models.FeedLikeResponse
import site.yoonsang.instaclone.src.main.home.models.GetFeedsResponse

class HomeFeedService(val view: HomeFeedView) {

    fun tryGetFeeds(userId: Int) {
        val feedRetrofitInterface =
            ApplicationClass.sRetrofit.create(HomeFeedRetrofitInterface::class.java)
        feedRetrofitInterface.getFeeds(userId).enqueue(object : Callback<GetFeedsResponse> {
            override fun onResponse(
                call: Call<GetFeedsResponse>,
                response: Response<GetFeedsResponse>
            ) {
                if (response.body() != null) {
                    view.onGetFeedsSuccess(response.body() as GetFeedsResponse)
                } else {
                    view.onGetFeedsFailure(response.message())
                }
            }

            override fun onFailure(call: Call<GetFeedsResponse>, t: Throwable) {
                view.onGetFeedsFailure(t.message ?: "통신 오류")
            }
        })
    }
}