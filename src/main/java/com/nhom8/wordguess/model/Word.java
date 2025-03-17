package com.nhom8.wordguess.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Model đại diện cho một từ vựng trong trò chơi
 */
@Document(collection = "words")
public class Word {
    // ID của từ vựng
    @Id
    private String id;

    // Từ vựng
    @Field("word")
    private String word;

    // Gợi ý
    @Field("hint")
    private String hint;

// Constructors
    public Word() {
    }

    public Word(String id, String word, String hint) {
        this.id = id;
        this.word = word;
        this.hint = hint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    @Override
    public String toString() {
        return this.word;
    }
}
