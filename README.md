# [Travel App] - Travel Companion App

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.9.22-blue.svg)](https://kotlinlang.org)
[![Compose Version](https://img.shields.io/badge/Jetpack%20Compose-1.6.2-brightgreen.svg)](https://developer.android.com/jetpack/compose)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
<!-- Thêm các badges khác nếu có (ví dụ: CI/CD status, code coverage) -->

## Giới thiệu

**[Travel App]** là một ứng dụng di động Android hiện đại được xây dựng hoàn toàn bằng Jetpack Compose, được thiết kế để trở thành người bạn đồng hành du lịch đáng tin cậy của bạn. Ứng dụng cung cấp một nền tảng trực quan và hấp dẫn để người dùng khám phá các điểm đến mới, lên kế hoạch chi tiết cho các chuyến đi, quản lý đặt chỗ và chia sẻ những khoảnh khắc đáng nhớ trong hành trình của họ.

Mục tiêu của chúng tôi là mang đến một trải nghiệm người dùng liền mạch, hiệu suất cao và thẩm mỹ, tận dụng sức mạnh của kiến trúc khai báo trong Jetpack Compose.

## Mục lục

- [Tính năng](#tính-năng)
- [Ảnh chụp màn hình (Demo)](#ảnh-chụp-màn-hình-demo)
- [Công nghệ và Kiến trúc](#công-nghệ-và-kiến-trúc)
    - [Ngôn ngữ và UI](#ngôn-ngữ-và-ui)
    - [Kiến trúc](#kiến-trúc)
    - [Thư viện chính](#thư-viện-chính)
- [Cấu trúc Thư mục](#cấu-trúc-thư-mục)
- [Thiết lập Dự án](#thiết-lập-dự-án)
    - [Điều kiện tiên quyết](#điều-kiện-tiên-quyết)
    - [Các bước cài đặt](#các-bước-cài-đặt)
- [Hướng dẫn Build](#hướng-dẫn-build)
    - [Build Variants](#build-variants)
    - [Ký ứng dụng (Signing)](#ký-ứng-dụng-signing)
- [Đóng góp](#đóng-góp)
- [Giấy phép](#giấy-phép)
- [Liên hệ](#liên-hệ)

## Tính năng

✨ **Khám phá Điểm đến:**
- Duyệt và tìm kiếm hàng ngàn địa điểm du lịch trên toàn thế giới.
- Xem thông tin chi tiết: mô tả, hình ảnh chất lượng cao, bản đồ, đánh giá từ người dùng.
- Lọc địa điểm theo danh mục, sở thích, ngân sách.

✈️ **Lập kế hoạch Chuyến đi Thông minh:**
- Tạo lịch trình chi tiết cho từng ngày trong chuyến đi.
- Thêm các hoạt động, địa điểm tham quan, ghi chú vào lịch trình.
- Tính năng gợi ý dựa trên sở thích và các chuyến đi trước đó.

🗺️ **Bản đồ Tương tác:**
- Tích hợp bản đồ để dễ dàng xem vị trí các địa điểm, khách sạn, nhà hàng.
- Chỉ đường và điều hướng.

🗓️ **Quản lý Đặt chỗ:**
- Lưu trữ thông tin đặt vé máy bay, khách sạn, tour du lịch.
- Nhận thông báo nhắc nhở về các đặt chỗ sắp tới.

📸 **Nhật ký Hành trình & Chia sẻ:**
- Ghi lại những khoảnh khắc đáng nhớ bằng hình ảnh và ghi chú.
- Chia sẻ trải nghiệm du lịch với bạn bè và cộng đồng.

👤 **Tài khoản Người dùng Cá nhân hóa:**
- Đăng ký, đăng nhập an toàn.
- Quản lý hồ sơ, sở thích du lịch, các chuyến đi đã lưu.
- Đồng bộ hóa dữ liệu trên nhiều thiết bị.

🌙 **Giao diện Tối (Dark Mode):**
- Hỗ trợ giao diện tối để mang lại trải nghiệm xem thoải mái trong điều kiện ánh sáng yếu.

## Ảnh chụp màn hình (Demo)

*(Đây là nơi bạn nên chèn một vài ảnh chụp màn hình hoặc GIF demo ứng dụng của mình. Bạn có thể lưu trữ chúng trong một thư mục `assets/screenshots` trong repo và liên kết đến chúng.)*

| Màn hình chính                                 | Chi tiết Địa điểm                             | Lập kế hoạch Chuyến đi                       |
| :--------------------------------------------: | :-------------------------------------------: | :-------------------------------------------: |
| ![Main Screen](assets/screenshots/main.png)    | ![Details Screen](assets/screenshots/details.png) | ![Planner Screen](assets/screenshots/planner.png) |

<!-- Thay thế các đường dẫn file ảnh trên bằng đường dẫn thực tế -->

## Công nghệ và Kiến trúc

### Ngôn ngữ và UI

- **[Kotlin](https://kotlinlang.org/):** Ngôn ngữ lập trình chính, hiện đại và an toàn.
- **[Jetpack Compose](https://developer.android.com/jetpack/compose):** Bộ công cụ giao diện người dùng khai báo hiện đại để xây dựng UI gốc cho Android.

### Kiến trúc

Ứng dụng này tuân theo kiến trúc **MVVM (Model-View-ViewModel)** kết hợp với các nguyên tắc của **Clean Architecture** để đảm bảo tính module, khả năng kiểm thử và bảo trì.

- **UI Layer (View):** Được xây dựng bằng Jetpack Compose. Các Composable functions chịu trách nhiệm hiển thị dữ liệu và gửi các sự kiện người dùng đến ViewModel.
- **ViewModel Layer:** Chứa logic UI, chuẩn bị và quản lý dữ liệu cho UI. Sử dụng Kotlin Coroutines và Flow để xử lý các tác vụ bất đồng bộ.
- **Domain Layer (Tùy chọn nhưng khuyến khích):** Chứa các Use Cases (Trường hợp sử dụng) và business logic cốt lõi, độc lập với Android Framework.
- **Data Layer:** Chịu trách nhiệm cung cấp dữ liệu cho ứng dụng. Bao gồm Repositories, Data Sources (Remote API, Local Database).

### Thư viện chính

- **[Jetpack Compose](https://developer.android.com/jetpack/compose):**
    - `compose.ui`, `compose.material3`, `compose.foundation`, `compose.animation`
- **[Navigation Compose](https://developer.android.com/jetpack/compose/navigation):** Để xử lý việc điều hướng giữa các màn hình Composable.
- **[Hilt](https://dagger.dev/hilt/):** Cho Dependency Injection (Quản lý Phụ thuộc).
- **[Kotlin Coroutines & Flow](https://kotlinlang.org/docs/coroutines-guide.html):** Để quản lý các tác vụ bất đồng bộ và luồng dữ liệu.
- **[Retrofit](https://square.github.io/retrofit/) / [Ktor Client](https://ktor.io/docs/client.html):** Để thực hiện các yêu cầu mạng (API calls).
- **[OkHttp](https://square.github.io/okhttp/):** (Thường đi kèm với Retrofit) HTTP client.
- **[Gson](https://github.com/google/gson) / [Kotlinx Serialization](https://github.com/Kotlin/kotlinx.serialization):** Để phân tích cú pháp JSON.
- **[Room](https://developer.android.com/training/data-storage/room):** Để lưu trữ dữ liệu cục bộ (SQLite).
- **[Coil](https://coil-kt.github.io/coil/) / [Glide](https://bumptech.github.io/glide/):** Để tải và hiển thị hình ảnh.
- **[ViewModel Compose](https://developer.android.com/jetpack/compose/state#viewmodel-state):** Tích hợp ViewModel với Compose.
- **[DataStore](https://developer.android.com/topic/libraries/architecture/datastore):** Để lưu trữ dữ liệu key-value đơn giản hoặc đối tượng có kiểu.
- **[JUnit](https://junit.org/junit5/):** Cho Unit Testing.