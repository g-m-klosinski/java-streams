package gmklosinski.javastreams;

import edu.stanford.nlp.simple.Document;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void sumUpIsAnIdentityFunctionForAnEmptyText() {
        var document = new Document("");

        var result = Main.sumUp(document);

        assertEquals("", result);
    }

    @Test
    void sumUpKeepsTheOnlyWordIfItIsNoun() {
        var document = new Document("dog");

        var result = Main.sumUp(document);

        assertEquals("dog", result);
    }

    @Test
    void sumUpRemovesTheOnlyWordIfItIsVerb() {
        var document = new Document("persuade");

        var result = Main.sumUp(document);

        assertEquals("", result);
    }
}
