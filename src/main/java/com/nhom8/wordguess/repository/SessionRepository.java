package com.nhom8.wordguess.repository;

import com.nhom8.wordguess.model.Session;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * Repository để tương tác với collection phiên chơi trong MongoDB
 */
@Repository
public interface SessionRepository extends MongoRepository<Session, String> {
    // Tìm phiên chơi theo trạng thái
    List<Session> findByStatus(String status);
    
    // Tìm phiên chơi theo người chơi
    List<Session> findByPlayerId(String playerId);
} 