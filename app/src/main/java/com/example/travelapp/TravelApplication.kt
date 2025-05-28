package com.example.travelapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp // Annotation quan trọng để kích hoạt Hilt code generation
class TravelApplication : Application() {

    override fun onCreate() {
        super.onCreate()

    }

    // Bạn có thể thêm các hàm hoặc thuộc tính tùy chỉnh khác nếu cần,
    // nhưng hãy cẩn thận để không lạm dụng lớp Application cho những thứ
    // nên được quản lý bởi Dependency Injection hoặc các thành phần kiến trúc khác.
}