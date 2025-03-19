db.createCollection("sessions", {
   validator: {
      $jsonSchema: {
         bsonType: "object",
         required: ["player_id", "status", "score", "round", "remaining_guesses", "start_time", "current_word_id", "current_word_hint", "char_missing"],
         properties: {
            _id: {
               bsonType: "string",
               description: "ID của phiên chơi - required"
            },
            player_id: {
               bsonType: "string",
               description: "ID người chơi - required"
            },
            player_name: {
               bsonType: "string",
               description: "Tên người chơi - required"
            },
            status: {
               bsonType: "string",
               enum: ["WAITING", "PLAYING", "FINISHED"],
               description: "Trạng thái phiên chơi - required"
            },
            score: {
               bsonType: "int",
               minimum: 0,
               description: "Điểm số - required"
            },
            round: {
               bsonType: "int",
               minimum: 0,
               description: "Vòng chơi hiện tại - required"
            },
            remaining_guesses: {
               bsonType: "int",
               minimum: 0,
               description: "Số lượt đoán còn lại - required"
            },
            start_time: {
               bsonType: "date",
               description: "Thời gian bắt đầu phiên chơi"
            },
            end_time: {
               bsonType: "date",
               description: "Thời gian kết thúc phiên chơi"
            },
            current_word_id: {
               bsonType: "string",
               description: "ID của từ vựng đang chơi"
            },
            current_word_hint: {
               bsonType: "string",
               description: "Gợi ý của từ vựng đang chơi"
            },
            char_missing: {
               bsonType: "string",
               description: "Tiến độ đoán từ"
            }
         }
      }
   }
})
