package gmklosinski.javastreams;

import edu.stanford.nlp.simple.Document;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mockStatic;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {
    @Test
    void mainReadsTextFromStandardInputAndPrintsTheSummary() throws Exception {
        var input = new ByteArrayInputStream("input text".getBytes(StandardCharsets.UTF_8));
        var output = new ByteArrayOutputStream();
        var originalInput = System.in;
        var originalOutput = System.out;

        try {
            System.setIn(input);
            System.setOut(new PrintStream(output, true, StandardCharsets.UTF_8));

            try (var main = mockStatic(Main.class, CALLS_REAL_METHODS)) {
                main.when(() -> Main.sumUp(any(Document.class)))
                        .thenReturn("mocked summary");

                Main.main();

                assertEquals("mocked summary" + System.lineSeparator(),
                        output.toString(StandardCharsets.UTF_8));
                main.verify(() -> Main.sumUp(any(Document.class)));
            }
        } finally {
            System.setIn(originalInput);
            System.setOut(originalOutput);
        }
    }

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
