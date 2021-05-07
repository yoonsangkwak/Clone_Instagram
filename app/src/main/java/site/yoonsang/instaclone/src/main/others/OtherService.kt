package site.yoonsang.instaclone.src.main.others

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.yoonsang.instaclone.config.ApplicationClass
import site.yoonsang.instaclone.src.main.others.models.FollowResponse
import site.yoonsang.instaclone.src.main.others.models.OtherProfileResponse

class OtherService(val view: OtherProfileView) {

    fun tryPostFollow(from: Int, to: Int) {
        val otherRetrofitInterface =
            ApplicationClass.sRetrofit.create(OtherRetrofitInterface::class.java)
        otherRetrofitInterface.postFollow(from, to).enqueue(object : Callback<FollowResponse> {
            override fun onResponse(
                call: Call<FollowResponse>,
                response: Response<FollowResponse>
            ) {
                if (response.body() != null) {
                    view.onPostFollowSuccess(response.body() as FollowResponse)
                } else {
                    view.onPostFollowFailure(response.message())
                }
            }

            override fun onFailure(call: Call<FollowResponse>, t: Throwable) {
                view.onPostFollowFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryPostUnFollow(from: Int, to: Int) {
        val otherRetrofitInterface =
            ApplicationClass.sRetrofit.create(OtherRetrofitInterface::class.java)
        otherRetrofitInterface.postUnFollow(from, to).enqueue(object : Callback<FollowResponse> {
            override fun onResponse(
                call: Call<FollowResponse>,
                response: Response<FollowResponse>
            ) {
                if (response.body() != null) {
                    view.onPostUnFollowSuccess(response.body() as FollowResponse)
                } else {
                    view.onPostFollowFailure(response.message())
                }
            }

            override fun onFailure(call: Call<FollowResponse>, t: Throwable) {
                view.onPostUnFollowFailure(t.message ?: "통신 오류")
            }
        })
    }

    fun tryGetOtherProfile(userId: Int, otherId: Int) {
        val otherRetrofitInterface =
            ApplicationClass.sRetrofit.create(OtherRetrofitInterface::class.java)
        otherRetrofitInterface.getOtherProfile(userId, otherId)
            .enqueue(object : Callback<OtherProfileResponse> {
                override fun onResponse(
                    call: Call<OtherProfileResponse>,
                    response: Response<OtherProfileResponse>
                ) {
                    if (response.body() != null) {
                        view.onGetOtherProfileSuccess(response.body() as OtherProfileResponse)
                    } else {
                        view.onGetOtherProfileFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<OtherProfileResponse>, t: Throwable) {
                    view.onGetOtherProfileFailure(t.message ?: "통신 오류")
                }
            })
    }
}