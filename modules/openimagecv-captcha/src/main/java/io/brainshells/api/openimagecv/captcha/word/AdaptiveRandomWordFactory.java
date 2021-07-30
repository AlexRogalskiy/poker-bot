package io.brainshells.api.openimagecv.captcha.word;

import java.util.Random;

public class AdaptiveRandomWordFactory extends RandomWordFactory {

    protected String wideCharacters;

    public void setWideCharacters(String wideCharacters) {
        this.wideCharacters = wideCharacters;
    }

    public AdaptiveRandomWordFactory() {
        characters = "absdegkmnopwx23456789";
        wideCharacters = "mw";
    }

    @Override
    public String getNextWord() {
        final Random rnd = new Random();
        final StringBuilder sb = new StringBuilder();
        final StringBuilder chars = new StringBuilder(characters);
        final int l = minLength + (maxLength > minLength ? rnd
            .nextInt(maxLength - minLength) : 0);

        for (int i = 0; i < l; i++) {
            int j = rnd.nextInt(chars.length());
            char c = chars.charAt(j);
            if (wideCharacters.indexOf(c) != -1) {
                for (int k = 0; k < wideCharacters.length(); k++) {
                    int idx = chars
                        .indexOf(String.valueOf(wideCharacters.charAt(k)));
                    if (idx != -1) {
                        chars.deleteCharAt(idx);
                    }
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }
}
