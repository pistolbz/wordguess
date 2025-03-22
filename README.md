# Word Guessing Game - Công nghệ sử dụng

## 🛠 Tech Stack

### Backend
- **Spring Boot 3.4.3**: Framework chính để xây dựng ứng dụng
  - Spring WebSocket: Hỗ trợ giao tiếp realtime giữa client và server
  - Spring Data MongoDB: Tương tác với cơ sở dữ liệu MongoDB
  - Spring MVC: Xử lý các request HTTP và routing
  - Thymeleaf: Template engine cho phần view

### Frontend
- **HTML5/JavaScript**: Xây dựng giao diện người dùng
- **TailwindCSS**: Framework CSS để tạo giao diện đẹp và responsive
- **WebSocket**: 
  - SockJS: Thư viện client cho WebSocket
  - STOMP: Giao thức messaging cho WebSocket

### Database
- **MongoDB**: Cơ sở dữ liệu NoSQL
  - Lưu trữ thông tin về:
    - Sessions (phiên chơi game)
    - Words (từ vựng và gợi ý)
    - Leaderboard (bảng xếp hạng)

### Kiến trúc
- **MVC Pattern**: Tổ chức code theo mô hình Model-View-Controller
- **WebSocket Architecture**: Cho phép giao tiếp hai chiều realtime
- **RESTful API**: Cho các tính năng như leaderboard

## 🔧 Cấu trúc dự án

```
wordguess/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com.nhom8.wordguess/
│   │   │       ├── config/        # Cấu hình WebSocket
│   │   │       ├── controller/    # Routing
│   │   │       ├── model/         # Model/entity
│   │   │       ├── repository/    # Tương tác DB
│   │   │       ├── service/       # Thiết kế logic
│   │   │       └── dto/           # Xử lý Leaderboard
│   │   └── resources/
│   │       ├── static/           
│   │       ├── templates/       
│   │       └── application.properties
└── pom.xml                      # Maven config
```

## 🔒 Môi trường phát triển yêu cầu
- Java 17+
- MongoDB

## 🚀 Hướng dẫn cài đặt

### Clone repository
```bash
git clone https://github.com/your-username/wordguess.git
cd wordguess
```

### Cấu hình MongoDB
1. Cài đặt MongoDB
2. Tạo database mới tên "wordguess"
3. Cập nhật thông tin kết nối trong `application.properties`

### Chạy ứng dụng
```bash
# Build project với Maven
mvn clean install

# Chạy ứng dụng
mvn spring-boot:run
```

Truy cập ứng dụng tại `http://localhost:8089`