package site.yoonsang.instaclone.src.main.profile.edit

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.yoonsang.instaclone.config.ApplicationClass
import site.yoonsang.instaclone.src.main.profile.edit.models.UserInfoResponse

class ProfileEditService(val view: ProfileEditView) {

    fun tryGetUserInfo(userId: Int) {
        val profileEditRetrofitInterface =
            ApplicationClass.sRetrofit.create(ProfileEditRetrofitInterface::class.java)
        profileEditRetrofitInterface.getUserInfo(userId)
            .enqueue(object : Callback<UserInfoResponse> {
                override fun onResponse(
                    call: Call<UserInfoResponse>,
                    response: Response<UserInfoResponse>
                ) {
                    if (response.body() != null) {
                        view.onGetUserInfoSuccess(response.body() as UserInfoResponse)
                    } else {
                        view.onGetUserInfoFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<UserInfoResponse>, t: Throwable) {
                    view.onGetUserInfoFailure(t.message ?: "통신 오류")
                }
            })
    }
}