package site.yoonsang.instaclone.src.main.profile

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.yoonsang.instaclone.config.ApplicationClass
import site.yoonsang.instaclone.src.main.profile.models.MyProfileResponse


class ProfileService(val view: ProfileFragmentView) {

    fun tryGetMyProfile(userId: Int) {
        val myProfileRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProfileRetrofitInterface::class.java)
        myProfileRetrofitInterface.getMyProfile(userId)
            .enqueue(object : Callback<MyProfileResponse> {
                override fun onResponse(
                    call: Call<MyProfileResponse>,
                    response: Response<MyProfileResponse>
                ) {
                    if (response.body() != null) {
                        view.onGetMyProfileSuccess(response.body() as MyProfileResponse)
                    } else {
                        view.onGetMyProfileFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<MyProfileResponse>, t: Throwable) {
                    view.onGetMyProfileFailure(t.message ?: "통신 오류")
                }
            })
    }
}