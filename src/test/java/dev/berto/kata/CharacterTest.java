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

    @Test
    @DisplayName("Edge case 2: Test limits of the character's level")
    public void testCharacterLevelLimits() {
        Character character = new Character();
        assertEquals(1, character.getLevel());

        character.setLevel(-1);
        assertTrue(character.getLevel() >= 1);

        character.setLevel(1001);
        assertTrue(character.getLevel() <= 30);
    }

    @Test
    @DisplayName("Edge case 3: Test that the character is alive or dead")
    public void testCharacterStatus() {
        Character character = new Character();
        assertTrue(character.isAlive());

        character.setHealth(0);
        assertFalse(character.isAlive());
    }
    @Test
    @DisplayName("Test that the character can deal damage to another character")
    public void testDealDamage() {
        Character attacker = new Character();
        Character target = new Character();

        attacker.dealDamage(target, 200);
        assertEquals(800, target.getHealth());
    }

    @Test
    @DisplayName("Test that the character can heal another character")
    public void testHeal() {
        Character healer = new Character();
        Character target = new Character();

        healer.dealDamage(target, 200);
        healer.heallife(target, 100);
        assertEquals(800, target.getHealth());

        healer.heallife(target,200);
        assertEquals(800, target.getHealth());
    }

    @Test
    @DisplayName("Test that the character cannot deal damage to itself")
    public void testCannotDealDamageToSelf() {
        Character character = new Character();
        character.dealDamage(character, 100);
        assertEquals(1000, character.getHealth());
    }

    @Test
    @DisplayName("Test that the character cannot heal itself")
    public void testOnlyHealSelf() {
        Character character1 = new Character();
        Character character2 = new Character();
        character1.dealDamage(character2, 200);
        character1.heallife(character2, 100);
        assertEquals(800, character2.getHealth());
    }

    @Test
    @DisplayName("Test that the character's damage is adjusted by their level")
    public void testDamageAdjustmentByLevel() {
    Character lowLevelChar = new Character();
    lowLevelChar.setLevel(1);
    Character highLevelChar = new Character();
    highLevelChar.setLevel(6);

    lowLevelChar.dealDamage(highLevelChar, 100);
    assertEquals(950, highLevelChar.getHealth());

    highLevelChar.dealDamage(lowLevelChar, 100);
    assertEquals(850, lowLevelChar.getHealth());
}
@Test
    @DisplayName("Test that the character's damage is adjusted by their attack range")
    public void testDamageInRange() {
        Character meleeChar = new Character();
        meleeChar.setAttackRange(2);
        Character rangedChar = new Character();
        rangedChar.setAttackRange(20);

        meleeChar.dealDamage(rangedChar, 100, 1);
        assertEquals(900, rangedChar.getHealth());

        meleeChar.dealDamage(rangedChar, 100, 3);
        assertEquals(900, rangedChar.getHealth());

        rangedChar.dealDamage(meleeChar, 100, 15);
        assertEquals(900, meleeChar.getHealth());
    }

    @Test
    @DisplayName("Test that the character's damage is adjusted by their ally status")
    public void testAllyBehavior() {
        Character char1 = new Character();
        Character char2 = new Character();
        char1.joinFactionCombat("Guild");
        char2.joinFactionCombat("Guild");

        char1.dealDamage(char2, 100, 1);
        assertEquals(900, char2.getHealth());

        char1.heallife(char2, 100);
        assertEquals(900, char2.getHealth());
    }




}
