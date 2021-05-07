package site.yoonsang.instaclone.src.main.home.post.feed.photosEdit.upload

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import site.yoonsang.instaclone.config.ApplicationClass
import site.yoonsang.instaclone.src.main.home.post.feed.photosEdit.upload.models.PostFeedUploadRequest
import site.yoonsang.instaclone.src.main.home.post.feed.photosEdit.upload.models.PostFeedUploadResponse

class UploadService(val view: UploadFeedView) {

    fun tryPostFeedCreate(postFeedUploadRequest: PostFeedUploadRequest) {
        val postFeedInterface =
            ApplicationClass.sRetrofit.create(UploadRetrofitInterface::class.java)
        postFeedInterface.createFeed(
            ApplicationClass.sSharedPreferences.getInt(
                ApplicationClass.USER_ID,
                0
            ), postFeedUploadRequest
        ).enqueue(object : Callback<PostFeedUploadResponse> {
            override fun onResponse(
                call: Call<PostFeedUploadResponse>,
                response: Response<PostFeedUploadResponse>
            ) {
                if (response.body() != null) {
                    view.onPostFeedCreateSuccess(response.body() as PostFeedUploadResponse)
                } else {
                    view.onPostFeedCreateFailure(response.message())
                }
            }

            override fun onFailure(call: Call<PostFeedUploadResponse>, t: Throwable) {
                view.onPostFeedCreateFailure(t.message ?: "통신 오류")
            }
        })
    }
}