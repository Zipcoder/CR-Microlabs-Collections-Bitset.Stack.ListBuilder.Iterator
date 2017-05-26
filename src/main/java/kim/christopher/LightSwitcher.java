package kim.christopher;

import sun.jvm.hotspot.utilities.Bits;

import java.util.BitSet;

/**
 * This lab is just a practice in bitwise operations.  Though all of the return and arg types are BitSets,
 * pretend that they're bytes.  That is, all of the tests are passing in values that are only 8 bits.
 * Use only bitwise operations (&, |, ^, ~, >>>, >>, <<) and return.  Nothing else.
 * <p>
 * The tests are written for you, so look at those for inspiration on how to solve these.  All you need to do is write
 * the functions to make the tests pass.
 */
public class LightSwitcher {

    /**
     * Take a given input of switches, and the switches to turn on, and return the new state of the switches.
     * NOTE: If the initial state of a switch is already turned on, do not turn it off.
     */
    public static BitSet turnOnSwitches(BitSet switches, BitSet switchesToTurnOn) {
        BitSet result = (BitSet) switches.clone();
        result.or(switchesToTurnOn);
        return result;
    }

    /**
     * Take a given input of switches and turn them all to on.
     * Remember to use bit notation (0bxxxxxxxx) and a bit operator.
     */
    public static BitSet turnOnAllSwitches(BitSet switches) {
        BitSet result = (BitSet) switches.clone();
        result.or(fromString("11111111"));
        return result;
    }

    /**
     * Take a given input of switches and the switches to turn off, and return the new state of the switches.
     * NOTE: If a switch is already off, do not turn it on.
     * And a '1' in a position in 'switchesToTurnOff' means to turn that switch to off.
     */
    public static BitSet turnOffSwitches(BitSet switches, BitSet switchesToTurnOff) {
        BitSet result = (BitSet) switches.clone();
        result.andNot(switchesToTurnOff);
        return result;
    }

    /**
     * Take a given input of switches and turn them all off.
     * Remember to use bit notation and a bit operator.
     */
    public static BitSet turnOffAllSwitches(BitSet switches) {
        return new BitSet();
    }

    /**
     * Take a given input of switches and the switches to flip, and return the new state of the switches.
     * NOTE: Wherever there is a '1' in switchesToFlip, flip the state of that switch in switches.
     * I.E switches = 1 0 1 and switchesToFlip = 1 1 0 should return 0 1 1.
     */
    public static BitSet flipSwitches(BitSet switches, BitSet switchesToFlip) {
        BitSet result = (BitSet) switches.clone();
        for (int i = 0; i < 8; i++) {
            if (switchesToFlip.get(i)) {
                result.flip(i);
            }
        }
        return result;
    }

    /**
     * Take a given input of switches and flip them all.
     * NOTE: An BitSeteger has more than 8 bits, so find a way to only return the rightmost 8 bits.
     */
    public static BitSet flipAllSwitches(BitSet switches) {
        BitSet result = (BitSet) switches.clone();
        for (int i = 0; i < 8; i++) {
            result.flip(i);
        }
        return result;
    }

    /**
     * Return the state of a switch in a given position.
     * Count switches from 0, and from right to left.
     * So, a byte reads 76543210
     */
    public static int getSwitchPositionAt(BitSet switches, int position) {
        return switches.get(position)? 1 : 0;
    }

    /**
     * Move all the the bits to the right `count` places.
     */
    public static BitSet moveRightBy(BitSet switches, int count) {
        BitSet result = (BitSet) switches.clone();
        for(int i = 0; i < count; i++){
            for(int j = 1; j < 9; j++){
                if(result.get(j)){
                    result.set(j - 1);
                } else result.set(j - 1, false);
            }
        }
        return result;
    }

    /**
     * Move all the the bits to the left `count` places.
     * NOTE: An BitSeteger has more than 8 bits, so find a way to only return the rightmost 8 bits.
     */
    public static BitSet moveLeftBy(BitSet switches, int count) {
        BitSet result = (BitSet) switches.clone();
        for(int i = 0; i < count; i++){
            for(int j = 6; j >= 0; j--){
                if(result.get(j)){
                    result.set(j + 1);
                } else result.set(j + 1, false);
            }
            result.set(0, false);
        }
        return result;
    }

    public static String viewSwitches(int switches) {
        return String.format("%8s", Integer.toBinaryString((switches & 0b11111111))).replace(' ', '0');
    }

    public static BitSet fromString(final String s) {
        return BitSet.valueOf(new long[]{Long.parseLong(s, 2)});
    }

    public static String toString(BitSet bs) {
        return Long.toString(bs.toLongArray()[0], 2);
    }

    public static int leftShiftSteps(BitSet bs){
        return 0;
    }

    public static int rightShiftSteps(BitSet bs){
        return 0;
    }



}