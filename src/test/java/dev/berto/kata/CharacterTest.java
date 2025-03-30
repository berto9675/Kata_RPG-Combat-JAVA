package dev.berto.kata;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CharacterTest {
    
     @Test
    @DisplayName("Test that the character is created wit the expected characteristics")
    public void testCharacterCreatedAsExpected() {
        Character character = new Character();
        assertEquals(1000, character.getHealth());
        assertEquals(1, character.getLevel());
        assertTrue(character.isAlive());
    }

     @Test
    @DisplayName("Edge case 1: Test limits of the character's health")
    public void testCharacterHealthLimits() {
        Character character = new Character();
        character.setHealth(0);
        assertEquals(0, character.getHealth());
        assertFalse(character.isAlive());

        character.setHealth(1001);
        assertEquals(1000, character.getHealth());

        character.setHealth(-10);
        assertTrue(character.getHealth() >= 0);
    }


}
