package site.yoonsang.instaclone.src.signup.phone

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.yoonsang.instaclone.config.ApplicationClass
import site.yoonsang.instaclone.src.signup.phone.models.PhoneSignUpResponse
import site.yoonsang.instaclone.src.signup.phone.models.PostPhoneSignUp

class PhoneService(val view: PhoneFragmentView) {

    fun tryPostPhoneSignUp(postPhoneSignUp: PostPhoneSignUp) {
        val phoneRetrofitInterface =
            ApplicationClass.sRetrofit.create(PhoneRetrofitInterface::class.java)
        phoneRetrofitInterface.postPhoneSignUp(postPhoneSignUp)
            .enqueue(object : Callback<PhoneSignUpResponse> {
                override fun onResponse(
                    call: Call<PhoneSignUpResponse>,
                    response: Response<PhoneSignUpResponse>
                ) {
                    if (response.body() != null) {
                        view.onPostPhoneSignUpSuccess(response.body() as PhoneSignUpResponse)
                    } else {
                        view.onPostPhoneSignUpFailure(response.message())
                    }
                }

                override fun onFailure(call: Call<PhoneSignUpResponse>, t: Throwable) {
                    view.onPostPhoneSignUpFailure(t.message ?: "통신 오류")
                }
            })
    }
}