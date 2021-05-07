package site.yoonsang.instaclone.src.main.profile.follow.follower

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.yoonsang.instaclone.config.ApplicationClass
import site.yoonsang.instaclone.src.main.profile.follow.follower.models.ProfileFollowerResponse

class ProfileFollowerService(val view: ProfileFollowerFragmentView) {

    fun tryGetFollower(userId: Int) {
        val profileFollowerRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProfileFollowerRetrofitInterface::class.java)
        profileFollowerRetrofitInterface.getFollower(userId)
            .enqueue(object : Callback<ProfileFollowerResponse> {
                override fun onResponse(
                    call: Call<ProfileFollowerResponse>,
                    response: Response<ProfileFollowerResponse>
                ) {
                    if (response.body() != null) {
                        view.onGetFollowerSuccess(response.body() as ProfileFollowerResponse)
                    } else {
                        view.onGetFollowerFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<ProfileFollowerResponse>, t: Throwable) {
                    view.onGetFollowerFailure(t.message ?: "통신 오류")
                }
            })
    }
}