package gmklosinski.javastreams;

import edu.stanford.nlp.simple.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void sumUpReturnsFirstWordOfFirstSentence() {
        var document = new Document("Hello world. Another sentence follows.");

        var result = Main.sumUp(document);

        assertEquals("Hello", result);
    }
}
