package kim.christopher;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LightSwitcherTest {
    private int baseByte = 0b10101010;
    private int flippedBaseByte = 0b01010101;

    @Test
    public void testTurnOnSwitches() {
        int result1 = LightSwitcher.turnOnSwitches(baseByte, 0b11110000);
        int expected1 = 0b11111010;
        int result2 = LightSwitcher.turnOnSwitches(flippedBaseByte, 0b11110000);
        int expected2 = 0b11110101;
        int result3 = LightSwitcher.turnOnSwitches(baseByte, 0b00001111);
        int expected3 = 0b10101111;
        int result4 = LightSwitcher.turnOnSwitches(flippedBaseByte, 0b00001111);
        int expected4 = 0b01011111;
        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
        assertEquals(result3, expected3);
        assertEquals(result4, expected4);
    }

    @Test
    public void testTurnOnAllSwitches() {
        int result1 = LightSwitcher.turnOnAllSwitches(baseByte);
        int result2 = LightSwitcher.turnOnAllSwitches(flippedBaseByte);
        int result3 = LightSwitcher.turnOnAllSwitches(0b11111111);
        int result4 = LightSwitcher.turnOnAllSwitches(0b00000000);
        assertEquals(result1, 0b11111111);
        assertEquals(result2, 0b11111111);
        assertEquals(result3, 0b11111111);
        assertEquals(result4, 0b11111111);
    }

    @Test
    public void testTurnOffSwitches() {
        int result1 = LightSwitcher.turnOffSwitches(baseByte, 0b11110000);
        int expected1 = 0b00001010;
        int result2 = LightSwitcher.turnOffSwitches(flippedBaseByte, 0b11110000);
        int expected2 = 0b00000101;
        int result3 = LightSwitcher.turnOffSwitches(baseByte, 0b00001111);
        int expected3 = 0b10100000;
        int result4 = LightSwitcher.turnOffSwitches(flippedBaseByte, 0b00001111);
        int expected4 = 0b01010000;
        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
        assertEquals(result3, expected3);
        assertEquals(result4, expected4);
    }

    @Test
    public void testTurnOffAllSwitches() {
        int result1 = LightSwitcher.turnOffAllSwitches(baseByte);
        int result2 = LightSwitcher.turnOffAllSwitches(flippedBaseByte);
        int result3 = LightSwitcher.turnOffAllSwitches(0b11111111);
        int result4 = LightSwitcher.turnOffAllSwitches(0b00000000);
        assertEquals(result1, 0b00000000);
        assertEquals(result2, 0b00000000);
        assertEquals(result3, 0b00000000);
        assertEquals(result4, 0b00000000);
    }

    @Test
    public void testFlipSwitches() {
        int result1 = LightSwitcher.flipSwitches(baseByte, 0b11110000);
        int expected1 = 0b01011010;
        int result2 = LightSwitcher.flipSwitches(flippedBaseByte, 0b11110000);
        int expected2 = 0b10100101;
        int result3 = LightSwitcher.flipSwitches(baseByte, 0b00001111);
        int expected3 = 0b10100101;
        int result4 = LightSwitcher.flipSwitches(flippedBaseByte, 0b00001111);
        int expected4 = 0b01011010;
        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
        assertEquals(result3, expected3);
        assertEquals(result4, expected4);
    }

    @Test
    public void testFlipAllSwitches() {
        int result1 = LightSwitcher.flipAllSwitches(baseByte);
        int result2 = LightSwitcher.flipAllSwitches(flippedBaseByte);
        int result3 = LightSwitcher.flipAllSwitches(0b11111111);
        int result4 = LightSwitcher.flipAllSwitches(0b00000000);
        assertEquals(result1, 0b01010101);
        assertEquals(result2, 0b10101010);
        assertEquals(result3, 0b00000000);
        assertEquals(result4, 0b11111111);
    }

    @Test
    public void testGetSwitchPositionAt() {
        for(int i = 0; i < 8; i++) {
            assertEquals(i%2, LightSwitcher.getSwitchPositionAt(baseByte, i));
        }
        for(int i = 0; i < 8; i++) {
            assertEquals((i + 1) % 2, LightSwitcher.getSwitchPositionAt(flippedBaseByte, i));
        }
        assertEquals(0, LightSwitcher.getSwitchPositionAt(0b11111110, 0));
        assertEquals(1, LightSwitcher.getSwitchPositionAt(0b11111110, 1));
        assertEquals(1, LightSwitcher.getSwitchPositionAt(0b11111110, 7));
    }

    @Test
    public void testMoveRightBy() {
        int result1 = LightSwitcher.moveRightBy(baseByte, 1);
        int result2 = LightSwitcher.moveRightBy(baseByte, 2);
        int result3 = LightSwitcher.moveRightBy(baseByte, 3);
        int result4 = LightSwitcher.moveRightBy(baseByte, 4);
        int result5 = LightSwitcher.moveRightBy(baseByte, 5);
        int result6 = LightSwitcher.moveRightBy(baseByte, 6);
        int result7 = LightSwitcher.moveRightBy(baseByte, 7);
        int result8 = LightSwitcher.moveRightBy(baseByte, 8);
        int expected1 = 0b01010101;
        int expected2 = 0b00101010;
        int expected3 = 0b00010101;
        int expected4 = 0b00001010;
        int expected5 = 0b00000101;
        int expected6 = 0b00000010;
        int expected7 = 0b00000001;
        int expected8 = 0b00000000;
        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
        assertEquals(result3, expected3);
        assertEquals(result4, expected4);
        assertEquals(result5, expected5);
        assertEquals(result6, expected6);
        assertEquals(result7, expected7);
        assertEquals(result8, expected8);
    }

    @Test
    public void testMoveLeftBy() {
        int result1 = LightSwitcher.moveLeftBy(baseByte, 1);
        int result2 = LightSwitcher.moveLeftBy(baseByte, 2);
        int result3 = LightSwitcher.moveLeftBy(baseByte, 3);
        int result4 = LightSwitcher.moveLeftBy(baseByte, 4);
        int result5 = LightSwitcher.moveLeftBy(baseByte, 5);
        int result6 = LightSwitcher.moveLeftBy(baseByte, 6);
        int result7 = LightSwitcher.moveLeftBy(baseByte, 7);
        int result8 = LightSwitcher.moveLeftBy(baseByte, 8);
        int expected1 = 0b01010100;
        int expected2 = 0b10101000;
        int expected3 = 0b01010000;
        int expected4 = 0b10100000;
        int expected5 = 0b01000000;
        int expected6 = 0b10000000;
        int expected7 = 0b00000000;
        int expected8 = 0b00000000;
        assertEquals(result1, expected1);
        assertEquals(result2, expected2);
        assertEquals(result3, expected3);
        assertEquals(result4, expected4);
        assertEquals(result5, expected5);
        assertEquals(result6, expected6);
        assertEquals(result7, expected7);
        assertEquals(result8, expected8);
    }

    @Test
    public void testViewSwitches() {
        assertEquals("11111111", LightSwitcher.viewSwitches(0b111111111111));
        assertEquals("00000000", LightSwitcher.viewSwitches(0));
        assertEquals("01010101", LightSwitcher.viewSwitches(0b111101010101));
    }

}