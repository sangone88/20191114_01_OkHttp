package com.tjoeun.a20191114_01_okhttp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.tjoeun.a20191114_01_okhttp.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_sign_up.*
import org.json.JSONObject

class SignUpActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        signUpBtn.setOnClickListener {
            ServerUtil.putRequestSignUp(mContext, userIdEdt.text.toString(), userPwEdt.text.toString(),
                userNameEdt.text.toString(), userNameEdt.text.toString(), object : ServerUtil.JasonResponseHandler{
                    override fun onResponse(json: JSONObject) {
                        Log.d("서버응답", json.toString())

                        runOnUiThread {
                            val code = json.getInt("code")
                            if (code == 200) {
                                Toast.makeText(mContext, "회원가입 성공", Toast.LENGTH_SHORT).show()
                            }
                            else {
                                Toast.makeText(mContext, "회원가입 실패", Toast.LENGTH_SHORT).show()
                            }

                        }
                    }

                })

        }
    }

    override fun setValues() {

    }


}
