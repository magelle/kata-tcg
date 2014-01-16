package de.kimminich.kata.tcg.strategy;

import de.kimminich.kata.tcg.Card;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

public class ConsoleInputStrategyTest {

    Strategy strategy;

    @Rule
    public TextFromStandardInputStream consoleInput = emptyStandardInputStream();

    @Test
    public void manualInputStrategyShouldPlayCardsSelectedOnSystemConsole() {
        strategy = new ConsoleInputStrategy();
        consoleInput.provideText("2\n");

        assertThat(strategy.nextCard(3, Card.list(0, 2, 3)), is(card(2)));
    }

    private Optional<Card> card(int card) {
        return Optional.of(new Card(card));
    }

    private Optional<Card> noCard() {
        return Optional.empty();
    }

}