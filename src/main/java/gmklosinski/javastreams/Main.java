package gmklosinski.javastreams;

import edu.stanford.nlp.simple.Document;

import java.io.IOException;

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

        return "summary";
    }
}
