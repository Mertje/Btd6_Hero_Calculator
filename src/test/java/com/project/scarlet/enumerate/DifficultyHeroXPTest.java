package com.project.scarlet.enumerate;

import com.project.scarlet.DummyHero;
import com.project.scarlet.exception.InvalidFieldException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class DifficultyHeroXPTest {


    @Test
    public void receiveErrorIfHeroXPNotExisting() {
        Exception exception = assertThrows(InvalidFieldException.class, DummyHero::heroXPAndDifficultyError);

        String expectedMessage = "The given difficulty can't be find";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

}
