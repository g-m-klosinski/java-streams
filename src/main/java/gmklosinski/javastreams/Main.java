package gmklosinski.javastreams;

import edu.stanford.nlp.simple.Document;

import java.io.IOException;

public class Main {
    static void main() throws IOException {
        var document = new Document(new String(System.in.readAllBytes()));

        for (var sentence : document.sentences()) {
            IO.println(sentence);
            IO.println("POS tags: " + sentence.posTags());
        }
    }
}
