package gmklosinski.javastreams;

import edu.stanford.nlp.simple.Document;

public class Main {
    static void main() {
        var document = new Document("""
                Roses are red.
                Violets are blue.
                """
        );

        for (var sentence : document.sentences()) {
            IO.println(sentence);
            IO.println("POS tags: " + sentence.posTags());
        }
    }
}
