import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TextProcessor {
    private String text;

    public TextProcessor(String text) {
        this.text = text;
    }

    public String processText() {
        StringBuilder processedText = new StringBuilder();

        // Разделение текста на предложения
        String[] sentences = text.split("[.!?]+");

        // Обработка каждого предложения
        for (String sentence : sentences) {
            Sentence processedSentence = processSentence(sentence);
            processedText.append(processedSentence.toString()).append(" ");
        }

        return processedText.toString().trim();
    }

    private Sentence processSentence(String sentence) {
        List<Word> words = new ArrayList<>();

        // Разделение предложения на слова
        String[] sentenceWords = sentence.split("\\s+");

        // Добавление слов в список
        for (String word : sentenceWords) {
            words.add(new Word(word));
        }

        // Фильтрация и сортировка слов, начинающихся с гласных букв
        List<Word> vowelWords = filterVowelWords(words);
        Collections.sort(vowelWords, (w1, w2) -> {
            char firstConsonant1 = findFirstConsonant(w1);
            char firstConsonant2 = findFirstConsonant(w2);
            return Character.compare(firstConsonant1, firstConsonant2);
        });

        // Замена отфильтрованных слов в предложении
        int vowelWordIndex = 0;
        for (int i = 0; i < words.size(); i++) {
            Word word = words.get(i);
            if (vowelWords.contains(word)) {
                Word vowelWord = vowelWords.get(vowelWordIndex);
                words.set(i, vowelWord);
                vowelWordIndex++;
            }
        }

        return new Sentence(words);
    }

    private List<Word> filterVowelWords(List<Word> words) {
        List<Word> vowelWords = new ArrayList<>();
        for (Word word : words) {
            if (startsWithVowel(word)) {
                vowelWords.add(word);
            }
        }
        return vowelWords;
    }

    private boolean startsWithVowel(Word word) {
        char firstChar = Character.toLowerCase(word.toString().charAt(0));
        return firstChar == 'а' || firstChar == 'о' || firstChar == 'и' || firstChar == 'ы' || firstChar == 'у'|| firstChar == 'э';
    }

    private char findFirstConsonant(Word word) {
        String str = word.toString();
        for (int i = 0; i < str.length(); i++) {
            char ch = Character.toLowerCase(str.charAt(i));
            if (!(ch == 'а' || ch == 'о' || ch == 'и' || ch == 'ы' || ch == 'у' || ch == 'э')) {
                return ch;
            }
        }
        return 'z';
    }
}
