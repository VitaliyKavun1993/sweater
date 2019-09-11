package sweater.repos;

import org.springframework.data.repository.CrudRepository;
import sweater.domain.Word;

import java.util.List;

public interface WordRepo extends CrudRepository<Word, Long> {
    List<Word> findByWord(String word);
    List<Word> findByTranslation(String translation);
}
