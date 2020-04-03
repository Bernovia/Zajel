package com.bernovia.zajel.addBook.updateBook

import androidx.lifecycle.LiveData
import com.bernovia.zajel.helpers.UpdateValuesResponseBody
import com.bernovia.zajel.helpers.base.BaseViewModelWithBody
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response


@Suppress("UNCHECKED_CAST") class UpdateBookViewModel(private val repository: UpdateBookRepository) : BaseViewModelWithBody<UpdateValuesResponseBody, Map<String, RequestBody>>() {

    fun setBookIdAndImage(bookId: Int, image: MultipartBody.Part?) {
        repository.bookId = bookId
        repository.image = image
    }

    private lateinit var responseBody: LiveData<Response<UpdateValuesResponseBody>>

    override fun getDataFromRetrofit(body: Map<String, RequestBody>): LiveData<Response<UpdateValuesResponseBody>> {
        responseBody = repository.loadData(body) as LiveData<Response<UpdateValuesResponseBody>>

        return responseBody
    }
}