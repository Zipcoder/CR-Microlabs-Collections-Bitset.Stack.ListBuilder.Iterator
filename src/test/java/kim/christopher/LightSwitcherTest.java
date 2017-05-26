package kim.christopher;

import org.junit.Before;
import org.junit.Test;

import java.util.BitSet;

import static kim.christopher.LightSwitcher.*;
import static org.junit.Assert.assertEquals;

public class LightSwitcherTest {
    private BitSet baseByte;
    private BitSet flippedBaseByte;
    private BitSet allOnes;
    private BitSet allZeros;
    
    @Before
    public void initialize() {
        baseByte = fromString("10101010");
        flippedBaseByte = fromString("01010101");
        allOnes = fromString("11111111");
        allZeros = fromString("00000000");
    }

    @Test
    public void testTurnOnSwitches() {
        BitSet result1 = turnOnSwitches(baseByte, fromString("11110000"));
        BitSet expected1 = fromString("11111010");
        BitSet result2 = turnOnSwitches(flippedBaseByte, fromString("11110000"));
        BitSet expected2 = fromString("11110101");
        BitSet result3 = turnOnSwitches(baseByte, fromString("00001111"));
        BitSet expected3 = fromString("10101111");
        BitSet result4 = turnOnSwitches(flippedBaseByte, fromString("00001111"));
        BitSet expected4 = fromString("01011111");
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
        assertEquals(expected4, result4);
    }

    @Test
    public void testTurnOnAllSwitches() {
        BitSet result1 = turnOnAllSwitches(baseByte);
        BitSet result2 = turnOnAllSwitches(flippedBaseByte);
        BitSet result3 = turnOnAllSwitches(allOnes);
        BitSet result4 = turnOnAllSwitches(allZeros);
        assertEquals(allOnes, result1);
        assertEquals(allOnes, result2);
        assertEquals(allOnes, result3);
        assertEquals(allOnes, result4);
    }

    @Test
    public void testTurnOffSwitches() {
        BitSet result1 = turnOffSwitches(baseByte, fromString("11110000"));
        BitSet expected1 = fromString("00001010");
        BitSet result2 = turnOffSwitches(flippedBaseByte, fromString("11110000"));
        BitSet expected2 = fromString("00000101");
        BitSet result3 = turnOffSwitches(baseByte, fromString("00001111"));
        BitSet expected3 = fromString("10100000");
        BitSet result4 = turnOffSwitches(flippedBaseByte, fromString("00001111"));
        BitSet expected4 = fromString("01010000");
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
        assertEquals(expected4, result4);
    }

    @Test
    public void testTurnOffAllSwitches() {
        BitSet result1 = turnOffAllSwitches(baseByte);
        BitSet result2 = turnOffAllSwitches(flippedBaseByte);
        BitSet result3 = turnOffAllSwitches(allOnes);
        BitSet result4 = turnOffAllSwitches(allZeros);
        assertEquals(allZeros, result1);
        assertEquals(allZeros, result2);
        assertEquals(allZeros, result3);
        assertEquals(allZeros, result4);
    }

    @Test
    public void testFlipSwitches() {
        BitSet result1 = flipSwitches(baseByte, fromString("11110000"));
        BitSet expected1 = fromString("01011010");
        BitSet result2 = flipSwitches(flippedBaseByte, fromString("11110000"));
        BitSet expected2 = fromString("10100101");
        BitSet result3 = flipSwitches(baseByte, fromString("00001111"));
        BitSet expected3 = fromString("10100101");
        BitSet result4 = flipSwitches(flippedBaseByte, fromString("00001111"));
        BitSet expected4 = fromString("01011010");
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
        assertEquals(expected4, result4);
    }

    @Test
    public void testFlipAllSwitches() {
        BitSet result1 = flipAllSwitches(baseByte);
        BitSet result2 = flipAllSwitches(flippedBaseByte);
        BitSet result3 = flipAllSwitches(allOnes);
        BitSet result4 = flipAllSwitches(allZeros);
        assertEquals(flippedBaseByte, result1);
        assertEquals(baseByte, result2);
        assertEquals(allZeros, result3);
        assertEquals(allOnes, result4);
    }

    @Test
    public void testGetSwitchPositionAt() {
        for(int i = 0; i < 8; i++) {
            assertEquals(i%2, getSwitchPositionAt(baseByte, i));
        }
        for(int i = 0; i < 8; i++) {
            assertEquals((i + 1) % 2, getSwitchPositionAt(flippedBaseByte, i));
        }
        assertEquals(0, getSwitchPositionAt(fromString("11111110"), 0));
        assertEquals(1, getSwitchPositionAt(fromString("11111110"), 1));
        assertEquals(1, getSwitchPositionAt(fromString("11111110"), 7));
    }

    @Test
    public void testMoveRightBy() {
        BitSet result1 = moveRightBy(baseByte, 1);
        BitSet result2 = moveRightBy(baseByte, 2);
        BitSet result3 = moveRightBy(baseByte, 3);
        BitSet result4 = moveRightBy(baseByte, 4);
        BitSet result5 = moveRightBy(baseByte, 5);
        BitSet result6 = moveRightBy(baseByte, 6);
        BitSet result7 = moveRightBy(baseByte, 7);
        BitSet result8 = moveRightBy(baseByte, 8);
        BitSet expected1 = fromString("01010101");
        BitSet expected2 = fromString("00101010");
        BitSet expected3 = fromString("00010101");
        BitSet expected4 = fromString("00001010");
        BitSet expected5 = fromString("00000101");
        BitSet expected6 = fromString("00000010");
        BitSet expected7 = fromString("00000001");
        BitSet expected8 = fromString("00000000");
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
        assertEquals(expected4, result4);
        assertEquals(expected5, result5);
        assertEquals(expected6, result6);
        assertEquals(expected7, result7);
        assertEquals(expected8, result8);
    }

    @Test
    public void testMoveLeftBy() {
        BitSet result1 = moveLeftBy(baseByte, 1);
        BitSet result2 = moveLeftBy(baseByte, 2);
        BitSet result3 = moveLeftBy(baseByte, 3);
        BitSet result4 = moveLeftBy(baseByte, 4);
        BitSet result5 = moveLeftBy(baseByte, 5);
        BitSet result6 = moveLeftBy(baseByte, 6);
        BitSet result7 = moveLeftBy(baseByte, 7);
        BitSet result8 = moveLeftBy(baseByte, 8);
        BitSet expected1 = fromString("01010100");
        BitSet expected2 = fromString("10101000");
        BitSet expected3 = fromString("01010000");
        BitSet expected4 = fromString("10100000");
        BitSet expected5 = fromString("01000000");
        BitSet expected6 = fromString("10000000");
        BitSet expected7 = fromString("00000000");
        BitSet expected8 = fromString("00000000");
        assertEquals(expected1, result1);
        assertEquals(expected2, result2);
        assertEquals(expected3, result3);
        assertEquals(expected4, result4);
        assertEquals(expected5, result5);
        assertEquals(expected6, result6);
        assertEquals(expected7, result7);
        assertEquals(expected8, result8);
    }

    @Test
    public void testViewSwitches() {
        assertEquals("11111111", LightSwitcher.viewSwitches(0b111111111111));
        assertEquals("00000000", LightSwitcher.viewSwitches(0));
        assertEquals("01010101", LightSwitcher.viewSwitches(0b111101010101));
    }

    @Test
    public void leftShiftStepsTest(){
        //Given
        int expected1 = 6;
        int expected2 = 10;
        int expected3 = 12;
        int expected4 = 4;
        int expected5 = 16;
        int expected6 = 8;

        //When
        int actual1 = leftShiftSteps(baseByte);
        int actual2 = leftShiftSteps(flippedBaseByte);
        int actual3 = leftShiftSteps(fromString("00110011"));
        int actual4 = leftShiftSteps(fromString("11001100"));
        int actual5 = leftShiftSteps(fromString("00001111"));
        int actual6 = leftShiftSteps(fromString("00111100"));

        //Then
        assertEquals("Number of steps should be 6", expected1, actual1);
        assertEquals("Number of steps should be 10", expected1, actual1);
        assertEquals("Number of steps should be 12", expected1, actual1);
        assertEquals("Number of steps should be 4", expected1, actual1);
        assertEquals("Number of steps should be 16", expected1, actual1);
        assertEquals("Number of steps should be 8", expected1, actual1);

    }

    @Test
    public void rightShiftStepsTest(){
        //Given
        int expected1 = 10;
        int expected2 = 6;
        int expected3 = 4;
        int expected4 = 12;
        int expected5 = 0;
        int expected6 = 8;

        //When
        int actual1 = rightShiftSteps(baseByte);
        int actual2 = rightShiftSteps(flippedBaseByte);
        int actual3 = rightShiftSteps(fromString("00110011"));
        int actual4 = rightShiftSteps(fromString("11001100"));
        int actual5 = rightShiftSteps(fromString("00001111"));
        int actual6 = rightShiftSteps(fromString("00111100"));

        //Then
        assertEquals("Number of steps should be 10", expected1, actual1);
        assertEquals("Number of steps should be 6", expected1, actual1);
        assertEquals("Number of steps should be 4", expected1, actual1);
        assertEquals("Number of steps should be 12", expected1, actual1);
        assertEquals("Number of steps should be 0", expected1, actual1);
        assertEquals("Number of steps should be 8", expected1, actual1);
    }

}