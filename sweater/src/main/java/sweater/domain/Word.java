package sweater.domain;

import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.persistence.*;

@Entity
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String word;
    private String translation;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public Word() {
    }

    public Word(String word, String translation, User user) {
        this.author = user;
        this.word = word;
        this.translation = translation;
    }


    public String getAuthorName(){
        return author != null ? author.getUserName() : "<none>";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

}
