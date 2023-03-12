package basicwordle;

import java.util.Random;

public class Words {

    private final String[] words = {"about", "above", "actor", "acute", "admit",
            "adult", "after", "again", "agent", "agree", "ahead", "blade", "blank",
            "blast", "blind", "block", "blood", "board", "bonus", "choir", "chose",
            "chuck", "cisco", "civic", "civil", "claim", "clash", "class", "clean"};


    String getRandom() {
        Random random = new Random();
        return words[random.nextInt(29)];
    }

}
