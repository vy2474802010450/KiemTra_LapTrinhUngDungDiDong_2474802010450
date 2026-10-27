package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010450


import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

import android.content.Intent
class LoginActivity : AppCompatActivity() {

    private lateinit var etEmail: EditText
    private lateinit var etPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvStatus: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Ánh xạ giao diện bằng findViewById
        etEmail = findViewById(R.id.etEmail)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        tvStatus = findViewById(R.id.tvStatus)

        // Xử lý khi nhấn nút Đăng nhập
        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString()

            when {
                email.isEmpty() -> {
                    tvStatus.text = "Vui lòng nhập Email!"
                }

                password.isEmpty() -> {
                    tvStatus.text = "Vui lòng nhập mật khẩu!"
                }

                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    tvStatus.text = "Email không đúng định dạng!"
                }

                password.length < 6 -> {
                    tvStatus.text = "Mật khẩu phải có ít nhất 6 ký tự!"
                }


                else -> {
                    tvStatus.text = "Xác thực thành công!"

                    // Tạo Intent chuyển sang ProfileActivity
                    val intent = Intent(this, ProfileActivity::class.java)

                    // Truyền Email sang ProfileActivity
                    intent.putExtra("EMAIL", email)

                    // Mở màn hình ProfileActivity
                    startActivity(intent)
                }

            }
        }
    }
}
