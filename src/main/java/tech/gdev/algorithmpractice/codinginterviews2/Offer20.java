package tech.gdev.algorithmpractice.codinginterviews2;

import java.util.HashMap;
import java.util.Map;

/**
 * 20
 * Medium
 *
 * @author gdev
 * @date 2022/5/27 15:51
 */
public class Offer20 {

    private static class Solution1 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param s -
         * @return -
         */
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) {return false;}
            this.s = s;
            this.index = 0;
            while (hasNext() && s.charAt(index) == ' ') {
                index++;
            }
            boolean numeric = scanInteger();
            if (hasNext() && s.charAt(index) == '.') {
                index++;
                numeric = scanUnsignedInteger() || numeric;
            }
            if (hasNext() && (s.charAt(index) == 'e' || s.charAt(index) == 'E')) {
                index++;
                numeric = scanInteger() && numeric;
            }
            while (hasNext() && s.charAt(index) == ' ') {
                index++;
            }
            numeric = numeric && (!hasNext());
            return numeric;
        }

        private String s;
        private int index;

        private boolean hasNext() {
            return index < s.length();
        }

        private boolean scanInteger() {
            if (!hasNext()) {return false;}
            if (s.charAt(index) == '+' || s.charAt(index) == '-') {index++;}
            return scanUnsignedInteger();
        }

        private boolean scanUnsignedInteger() {
            int cur = index;
            while (hasNext() && s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                index++;
            }
            return index > cur;
        }
    }

    private static class Solution2 {
        /**
         * time: O(N)
         * space: O(1)
         *
         * @param s -
         * @return -
         */
        public boolean isNumber(String s) {
            if (s == null || s.length() == 0) {
                return false;
            }

            int size = s.length();
            this.s = s;
            if (s.charAt(0) == ' ') {this.allowHeadBlank = true;}
            if (s.charAt(size-1) == ' ') {this.allowTailBlank = true;}
            this.allowDot = true;
            this.allowE = false;
            this.containsE = false;
            this.needDigit = true;

            for (int i = 0; i < s.length(); i++) {
                boolean valid;
                switch (s.charAt(i)) {
                    case ' ' : valid = validateBlank(i); break;
                    case '.' : valid = validateDot(i); allowDot = false; break;
                    case 'e' : ;
                    case 'E' : valid = validateE(i); allowDot = false; containsE = true; needDigit = true; break;
                    case '+' : ;
                    case '-' : valid = validatePositiveNegativeSign(i); break;
                    default: valid = validateDigit(i); allowE = true; needDigit = false;
                }
                if (!valid) {return false;}
            }
            if (needDigit) {return false;}
            return true;
        }

        /** number string */
        private String s;
        /** allow blank char before all no-blank chars */
        private boolean allowHeadBlank;
        /** allow blank char after all no-blank chars */
        private boolean allowTailBlank;
        /** allow dot char before e/E char */
        private boolean allowDot;
        /** allow e/E after a digit **/
        private boolean allowE;
        /** allow at most one e/E **/
        private boolean containsE;
        /** need a digit after e/E */
        private boolean needDigit;

        private boolean isDigit(int i) {
            if (i < 0 || i > s.length()-1) {return false;}
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {return false;}
            return true;
        }

        private boolean validateBlank(int i) {
            if (s.charAt(i) != ' ') {return false;}
            if (allowHeadBlank) {
                if (i == s.length()-1 || s.charAt(i+1) != ' ') {
                    allowHeadBlank = false;
                }
            } else if (allowTailBlank){
                for (; i < s.length(); i++) {
                    if (s.charAt(i) != ' ') {return false;}
                }
            } else {
                return false;
            }
            return true;
        }

        private boolean validateDot(int i) {
            if (s.charAt(i) != '.') {return false;}
            if (!allowDot) {return false;}
            if ((!isDigit(i-1)) && (!isDigit(i+1))) {return false;}
            return true;
        }

        private boolean validateE(int i) {
            if (s.charAt(i) != 'e' && s.charAt(i) != 'E') {return false;}
            if (!allowE) {return false;}
            if (containsE) {return false;}
            return true;
        }

        private boolean validatePositiveNegativeSign(int i) {
            if (s.charAt(i) != '+' && s.charAt(i) != '-') {return false;}
            if (i > 0) {
                char c = s.charAt(i-1);
                if (c == ' ' || c == 'e' || c == 'E') {
                    return true;
                } else {
                    return false;
                }
            }
            if (i == s.length()-1) {return false;}
            if (isDigit(i+1)) {return true;}
            if (s.charAt(i+1) == '.' && validateDot(i+1)) {return true;}
            return false;
        }

        private boolean validateDigit(int i) {
            if (!isDigit(i)) {return false;}
            return true;
        }
    }

    private static class Solution3 {
        Map<State, Map<CharType, State>> transfer = new HashMap<State, Map<CharType, State>>();
        {
            Map<CharType, State> initialMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_SPACE, State.STATE_INITIAL);
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
                put(CharType.CHAR_SIGN, State.STATE_INT_SIGN);
            }};
            transfer.put(State.STATE_INITIAL, initialMap);
            Map<CharType, State> intSignMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_POINT, State.STATE_POINT_WITHOUT_INT);
            }};
            transfer.put(State.STATE_INT_SIGN, intSignMap);
            Map<CharType, State> integerMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_INTEGER);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_POINT, State.STATE_POINT);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_INTEGER, integerMap);
            Map<CharType, State> pointMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_POINT, pointMap);
            Map<CharType, State> pointWithoutIntMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
            }};
            transfer.put(State.STATE_POINT_WITHOUT_INT, pointWithoutIntMap);
            Map<CharType, State> fractionMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_FRACTION);
                put(CharType.CHAR_EXP, State.STATE_EXP);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_FRACTION, fractionMap);
            Map<CharType, State> expMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
                put(CharType.CHAR_SIGN, State.STATE_EXP_SIGN);
            }};
            transfer.put(State.STATE_EXP, expMap);
            Map<CharType, State> expSignMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
            }};
            transfer.put(State.STATE_EXP_SIGN, expSignMap);
            Map<CharType, State> expNumberMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_NUMBER, State.STATE_EXP_NUMBER);
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_EXP_NUMBER, expNumberMap);
            Map<CharType, State> endMap = new HashMap<CharType, State>() {{
                put(CharType.CHAR_SPACE, State.STATE_END);
            }};
            transfer.put(State.STATE_END, endMap);
        }

        /**
         * time: O(N)
         * space: O(1)
         *
         * @param s -
         * @return -
         */
        public boolean isNumber(String s) {
            int length = s.length();
            State state = State.STATE_INITIAL;
            for (int i = 0; i < length; i++) {
                CharType type = toCharType(s.charAt(i));
                if (!transfer.get(state).containsKey(type)) {
                    return false;
                } else {
                    state = transfer.get(state).get(type);
                }
            }
            return state == State.STATE_INTEGER || state == State.STATE_POINT || state == State.STATE_FRACTION || state == State.STATE_EXP_NUMBER || state == State.STATE_END;
        }

        public CharType toCharType(char ch) {
            if (ch >= '0' && ch <= '9') {
                return CharType.CHAR_NUMBER;
            } else if (ch == 'e' || ch == 'E') {
                return CharType.CHAR_EXP;
            } else if (ch == '.') {
                return CharType.CHAR_POINT;
            } else if (ch == '+' || ch == '-') {
                return CharType.CHAR_SIGN;
            } else if (ch == ' ') {
                return CharType.CHAR_SPACE;
            } else {
                return CharType.CHAR_ILLEGAL;
            }
        }

        enum State {
            STATE_INITIAL, // blank in the head
            STATE_INT_SIGN, // +-
            STATE_INTEGER, // integer
            STATE_POINT, // . after integer
            STATE_POINT_WITHOUT_INT, // . without integer before
            STATE_FRACTION, // integer after .
            STATE_EXP, // e/E
            STATE_EXP_SIGN, // +- after e/E
            STATE_EXP_NUMBER, // integer after e/E
            STATE_END // blank in the tail
        }

        enum CharType {
            CHAR_NUMBER, // digit
            CHAR_EXP, // e/E
            CHAR_POINT, // .
            CHAR_SIGN, // +-
            CHAR_SPACE, // blank
            CHAR_ILLEGAL // illegal
        }
    }
}
