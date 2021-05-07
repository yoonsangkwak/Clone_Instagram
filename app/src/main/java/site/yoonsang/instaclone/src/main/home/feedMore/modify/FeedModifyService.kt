package site.yoonsang.instaclone.src.main.home.feedMore.modify

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.yoonsang.instaclone.config.ApplicationClass
import site.yoonsang.instaclone.src.main.home.feedMore.modify.models.FeedModifyResponse

class FeedModifyService(val view: FeedModifyView) {

    fun tryPatchFeedModify(userId: Int, feedId: Int) {
        val feedModifyRetrofitInterface =
            ApplicationClass.sRetrofit.create(FeedModifyRetrofitInterface::class.java)
        feedModifyRetrofitInterface.patchFeedModify(userId, feedId)
            .enqueue(object : Callback<FeedModifyResponse> {
                override fun onResponse(
                    call: Call<FeedModifyResponse>,
                    response: Response<FeedModifyResponse>
                ) {
                    if (response.body() != null) {
                        view.onPatchFeedModifySuccess(response.body() as FeedModifyResponse)
                    } else {
                        view.onPatchFeedModifyFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<FeedModifyResponse>, t: Throwable) {
                    view.onPatchFeedModifyFailure(t.message ?: "통신 오류")
                }
            })
    }
}