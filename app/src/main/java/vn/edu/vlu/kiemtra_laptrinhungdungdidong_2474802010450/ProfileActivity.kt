package vn.edu.vlu.kiemtra_laptrinhungdungdidong_2474802010450


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvEmail: TextView
    private lateinit var btnLogout: Button
    private lateinit var listViewSkills: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Ánh xạ giao diện
        tvEmail = findViewById(R.id.tvEmail)
        btnLogout = findViewById(R.id.btnLogout)
        listViewSkills = findViewById(R.id.listViewSkills)

        // Nhận Email từ LoginActivity
        val email = intent.getStringExtra("EMAIL") ?: ""
        tvEmail.text = "Email: $email"

        // Xử lý nút Đăng xuất
        btnLogout.setOnClickListener {
            finish()
        }

        // Danh sách 5 môn học / kỹ năng
        val skills = arrayOf(
            "Lập trình Kotlin",
            "Thiết kế Layout XML",
            "Quản lý Git/GitHub",
            "Xử lý Intent",
            "Kiến trúc Android"
        )

        // Tạo ArrayAdapter
        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1,
            skills
        )

        // Gắn Adapter vào ListView
        listViewSkills.adapter = adapter

        // Xử lý khi nhấn vào một phần tử
        listViewSkills.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(
                this,
                skills[position],
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
