package org.elastic.index;

public class JamoParser implements Parser {

    private final char[] base1Array = {'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ',
            'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ',
            'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};
    //private final char[] base2Array = {'ㅏ', 'ㅐ', 'ㅑ',
    // 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ',
    // 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ',
    // 'ㅢ', 'ㅣ'};
    private final char[] base3Array = {'ㄱ', 'ㄱ', 'ㄲ', 'ㄳ', 'ㄴ',
            'ㄵ', 'ㄶ', 'ㄷ', 'ㄹ', 'ㄺ', 'ㄻ',
            'ㄼ', 'ㄽ', 'ㄾ', 'ㄿ', 'ㅀ', 'ㅁ',
            'ㅂ', 'ㅄ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ',
            'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'};


    @Override
    public String parser(String token) {
        StringBuilder stringBuilder = new StringBuilder();
        char base = 0xAC00;
        if (token.length() > 0) {
            for (char c : token.toCharArray()) {
                if (c <= 10 || c == 32) {
                    stringBuilder.append(c);
                } else {

                    int choInt = (c - base) / 28 / 21;
                    int jungInt = ((c - base) / 28) % 21;
                    int jongInt = (c - base) % 28;

                    stringBuilder.append(base1Array[choInt])
                            .append((char)('ㅏ' + jungInt));

                    if (jongInt != 0) stringBuilder.append(base3Array[jongInt]);

                }
            }
        }

        return stringBuilder.toString();
    }
}
