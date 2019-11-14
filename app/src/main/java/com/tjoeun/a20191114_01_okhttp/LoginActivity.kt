package com.tjoeun.a20191114_01_okhttp

import android.os.Bundle
import com.tjoeun.a20191114_01_okhttp.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setupEvents()
        setValues()

        ServerUtil.postRequestLogin(mContext, "cho881020", "qlalfqjsgh!", "null")
    }

    override fun setupEvents() {
        loginBtn.setOnClickListener {
            var inputId = userIdEdt.text.toString()
            var inputPw = userPwEdt.text.toString()
            ServerUtil.postRequestLogin(mContext, inputId, inputPw, null)
        }

    }

    override fun setValues() {

    }


}
