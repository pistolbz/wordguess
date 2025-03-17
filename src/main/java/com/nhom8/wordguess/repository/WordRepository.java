package com.nhom8.wordguess.repository;

import com.nhom8.wordguess.model.Word;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository để tương tác với collection từ vựng trong MongoDB
 */
@Repository
public interface WordRepository extends MongoRepository<Word, String> {
    // Tìm từ chứa một chuỗi ký tự
    List<Word> findByWordContaining(String keyword);
} 