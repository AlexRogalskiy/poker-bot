package io.brainshells.api.openimagecv.captcha.word;

@FunctionalInterface
public interface WordFactory {

    String getNextWord();
}
