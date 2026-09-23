package gmklosinski.javastreams;

import edu.stanford.nlp.simple.Document;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        var document = new Document(new String(System.in.readAllBytes()));

        var firstWord = getFirstWord(document);

        IO.println(firstWord);
    }

    private static String getFirstWord(Document document) {
        var firstWord = document.sentences().get(0).words().get(0);
        return firstWord;
    }
}
