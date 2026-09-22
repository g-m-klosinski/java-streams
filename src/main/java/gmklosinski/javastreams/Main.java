package gmklosinski.javastreams;

import edu.stanford.nlp.simple.Sentence;

public class Main {
    static void main() {
        var sentence = new Sentence("I like volleyball!");

        var volleyballPosTag = sentence.posTag(2);

        IO.println("Volleyball is " + volleyballPosTag);
    }
}
