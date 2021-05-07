package site.yoonsang.instaclone.src.main.home.feedAdapter

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.yoonsang.instaclone.config.ApplicationClass
import site.yoonsang.instaclone.src.main.home.feedAdapter.models.FeedLikeResponse

class FeedAdapterService(val view: FeedAdapterView) {

    fun tryPostFeedLike(userId: Int, feedId: Int, holder: HomeFeedAdapter.ViewHolder) {
        val feedRetrofitInterface =
            ApplicationClass.sRetrofit.create(FeedAdapterRetrofitInterface::class.java)
        feedRetrofitInterface.postFeedLike(userId, feedId).enqueue(object :
            Callback<FeedLikeResponse> {
            override fun onResponse(
                call: Call<FeedLikeResponse>,
                response: Response<FeedLikeResponse>
            ) {
                if (response.body() != null) {
                    view.onPostFeedLikeSuccess(response.body() as FeedLikeResponse, holder)
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