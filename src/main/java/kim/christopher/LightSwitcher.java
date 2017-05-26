package kim.christopher;

import java.util.BitSet;

public class LightSwitcher {

    public static BitSet turnOnSwitches(BitSet switches, BitSet switchesToTurnOn) {
        BitSet result = (BitSet) switches.clone();
        result.or(switchesToTurnOn);
        return result;
    }

    public static BitSet turnOnAllSwitches(BitSet switches) {
        BitSet result = (BitSet) switches.clone();
        result.or(fromString("11111111"));
        return result;
    }

    public static BitSet turnOffSwitches(BitSet switches, BitSet switchesToTurnOff) {
        BitSet result = (BitSet) switches.clone();
        result.andNot(switchesToTurnOff);
        return result;
    }

    public static BitSet turnOffAllSwitches(BitSet switches) {
        return new BitSet();
    }


    public static BitSet flipSwitches(BitSet switches, BitSet switchesToFlip) {
        BitSet result = (BitSet) switches.clone();
        for (int i = 0; i < 8; i++) {
            if (switchesToFlip.get(i))
                result.flip(i);
        }
        return result;
    }

    public static BitSet flipAllSwitches(BitSet switches) {
        BitSet result = (BitSet) switches.clone();
        for (int i = 0; i < 8; i++)
            result.flip(i);
        return result;
    }

    public static int getSwitchPositionAt(BitSet switches, int position) {
        return switches.get(position)? 1 : 0;
    }

    public static BitSet moveRightBy(BitSet switches, int count) {
        BitSet result = (BitSet) switches.clone();
        for(int i = 0; i < count; i++){
            for(int j = 1; j < 9; j++){
                if(result.get(j))
                    result.set(j - 1);
                else result.set(j - 1, false);
            }
        }
        return result;
    }

    public static BitSet moveLeftBy(BitSet switches, int count) {
        BitSet result = (BitSet) switches.clone();
        for(int i = 0; i < count; i++){
            for(int j = 6; j >= 0; j--){
                if(result.get(j))
                    result.set(j + 1);
                else result.set(j + 1, false);
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

    public static int leftShiftSteps(BitSet bs){
        int count = 0;
        int result = 0;
        for(int i = 7; i >= 0; i--){
            if(bs.get(i))
                result += count;
            else count++;
        }
        return result;
    }

    public static int rightShiftSteps(BitSet bs){
        int count = 0;
        int result = 0;
        for(int i = 0; i < 8; i++){
            if(bs.get(i))
                result += count;
            else count++;
        }
        return result;
    }
}