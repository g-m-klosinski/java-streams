package gmklosinski.javastreams;

import edu.stanford.nlp.simple.Document;
import edu.stanford.nlp.simple.Sentence;

import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    static void main() throws IOException {
        var document = new Document(new String(System.in.readAllBytes()));

        var summary = sumUp(document);

        IO.println(summary);
    }

    static String sumUp(Document document) {
        if (document.sentences().isEmpty()) {
            return "";
        }

        var nouns = document.sentences().stream()
                .flatMap(Main::sentenceNouns)
                .toList();

        return String.join(" ", nouns);
    }

    static Stream<String> sentenceNouns(Sentence sentence) {
        return IntStream.range(0, sentence.words().size())
                .filter(i -> sentence.posTag(i).startsWith("NN"))
                .mapToObj(sentence::word);
    }
}
