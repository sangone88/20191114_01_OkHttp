package com.tjoeun.a20191114_01_okhttp.utils

import android.content.Context
import android.util.Log
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class ServerUtil {

    interface JasonResponseHandler {
        fun onResponse(json: JSONObject)
    }

    companion object {

//        어느 서버에 접속할지 서버 주소를 저장하는 변수.
        var BASE_URL = "http://192.168.0.26"
        
        fun postRequestLogin(context: Context, loginId:String, loginPw:String, handler:JasonResponseHandler?) {

//            우리가 만드는 앱을 클라이언트 역할로 동작하게 해주는 클래스
            var client = OkHttpClient()

//            기능 주소와 서버 주소를 조합해서 실제 요청 주소 완성
            var url = "${BASE_URL}/auth"

//            POST 메쏘드에서 요구하는 파라미터를 FormBody에 담아줌
            var formBody = FormBody.Builder()
                .add("login_Id", loginId)
                .add("password", loginPw)
                .build()

//            실제로 날아갈 요청(request)을 생성.
            var request = Request.Builder()
                .url(url)
                .post(formBody)
                .build()

            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
//                    실패
                    Log.e("서버통신에러", e.localizedMessage)
                }

                override fun onResponse(call: Call, response: Response) {
//                    성공
                    var body = response.body!!.string()

                    Log.d("서버응답내용", body)
                }

            })
        }

        fun postRequestLogin(context: Context, loginId: String, loginPw: String, handler: String) {

        }

    }
}