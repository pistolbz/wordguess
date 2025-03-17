package com.nhom8.wordguess.service;

import com.nhom8.wordguess.model.Word;
import com.nhom8.wordguess.repository.WordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.stereotype.Service;
import java.util.Optional;

/**
 * Service xử lý logic từ vựng
 */
@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    //Lấy một từ ngẫu nhiên từ database
    public Word getRandomWord() {
        // Sử dụng MongoDB $sample để lấy ngẫu nhiên một từ từ cơ sở dữ liệu
        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.sample(1)
        );
        
        // Thực hiện truy vấn và lấy kết quả
        AggregationResults<Word> results = mongoTemplate.aggregate(
            aggregation, "words", Word.class
        );
        
        // Trả về từ ngẫu nhiên
        return results.getUniqueMappedResult();
    }

    //Tìm từ vựng theo ID
    public Optional<Word> findById(String id) {
        return wordRepository.findById(id);
    }
} 