package io.brainshells.api.openimagecv.processor.enumeration;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Getter
public enum CardSuit implements Maskable<List<Pattern>> {
    CLUB("c",
        "^B*W{94,100}B{1,7}W{20,26}B{3,9}W{19,25}B{3,9}W{19,25}B{3,9}W{19,25}B{3,9}W{19,25}B{2,8}WBW{15,21}B{9,15}W{13,19}B{9,15}W{13,19}B{10,16}W{12,18}B{9,15}W{13,19}B{9,15}W{14,20}B{0,6}W{1,7}B{0,6}W{19,25}B{2,5}W{22,28}B{1,7}W{8,14}B*$",
        "^B*W{93,99}B{1,7}W{20,26}B{2,8}W{20,26}B{3,9}W{19,25}B{3,9}W{19,25}B{2,8}W{20,26}B{2,8}WBW{15,21}B{8,14}W{14,20}B{9,15}W{12,18}B{10,16}W{12,18}B{10,16}W{13,19}B{9,15}W{14,20}B{0,6}WBW{2,5}B{0,6}W{19,25}B{2,5}W{22,28}B{1,7}W{9,15}B*$",
        "^B*W{94,100}B{1,7}W{20,26}B{3,9}W{19,25}B{3,9}W{19,25}B{3,9}W{19,25}B{3,9}W{19,25}B{2,8}WBW{15,21}B{9,15}W{13,19}B{9,15}W{13,19}B{10,16}W{12,18}B{9,15}W{13,19}B{9,15}W{14,20}B{0,6}W{1,7}B{0,6}W{19,25}B{2,5}W{22,28}B{1,7}W{8,14}B*$",
        "^B*W{94,100}B{0,6}W{21,27}B{2,8}W{19,25}B{3,9}W{19,25}B{4,10}W{19,25}B{2,8}W{20,26}B{2,8}W{17,23}B{8,14}W{13,19}B{10,16}W{12,18}B{10,16}W{12,18}B{10,16}W{13,19}B{9,15}W{14,20}B{0,6}WBWB{1,7}W{19,25}BW{23,29}B{0,6}W{9,15}B*$",
        "^B*W{93,99}B{1,7}W{20,26}B{3,9}W{19,25}B{3,9}W{19,25}B{3,9}W{19,25}B{3,9}W{19,25}B{2,8}WBW{16,22}B{8,14}W{13,19}B{9,15}W{13,19}B{10,16}W{12,18}B{10,16}W{12,18}B{9,15}W{14,20}B{0,6}W{2,5}BWB{0,6}W{19,25}B{2,5}W{22,28}B{1,7}W{9,15}B*$",
        "^B*W{94,100}B{0,6}W{21,27}B{2,8}W{19,25}B{4,10}W{18,24}B{4,10}W{19,25}B{2,8}W{20,26}B{2,8}W{17,23}B{8,14}W{13,19}B{10,16}W{12,18}B{10,16}W{12,18}B{10,16}W{13,19}B{9,15}W{14,20}B{0,6}WBWB{1,7}W{19,25}B{0,5}W{22,28}B{0,6}W{9,15}B*$"
    ),
    DIAMOND("d",
        "^B*W{67,73}BW{23,29}B{0,6}W{21,27}B{1,7}W{20,26}B{3,9}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{9,15}W{13,19}B{9,15}W{14,20}B{8,14}W{15,21}B{6,12}W{17,23}B{4,10}W{19,25}B{2,8}W{21,27}B{0,6}W{22,28}B{2,5}W{38,44}B*$",
        "^B*W{94,100}B{2,5}W{22,28}B{1,7}W{20,26}B{3,9}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{9,15}W{13,19}B{9,15}W{13,19}B{8,14}W{15,21}B{6,12}W{17,23}B{4,10}W{19,25}B{2,8}W{21,27}B{1,7}W{22,28}B{2,5}W{38,44}B*$",
        "^B*W{66,72}BW{23,29}B{0,6}W{21,27}B{2,8}W{19,25}B{4,10}W{17,23}B{5,11}W{17,23}B{6,12}W{15,21}B{8,14}W{13,19}B{10,16}W{13,19}B{8,14}W{15,21}B{6,12}W{17,23}B{4,10}W{19,25}B{2,8}W{21,27}B{0,6}W{23,29}BW{39,45}B*$",
        "^B*W{93,99}B{2,5}W{22,28}B{1,7}W{20,26}B{3,9}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{9,15}W{13,19}B{9,15}W{14,20}B{7,13}W{16,22}B{5,11}W{17,23}B{5,11}W{18,24}B{3,9}W{20,26}B{1,7}W{22,28}B{2,5}W{39,45}B*$",
        "^B*W{70,76}BW{23,29}B{0,6}W{21,27}B{2,8}W{19,25}B{4,10}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{8,14}W{13,19}B{10,16}W{13,19}B{8,14}W{15,21}B{6,12}W{17,23}B{4,10}W{19,25}B{2,8}W{21,27}B{0,6}W{23,29}BW{35,41}B*$",
        "^B*W{98,104}B{0,5}W{22,28}B{1,7}W{20,26}B{3,9}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{9,15}W{13,19}B{9,15}W{14,20}B{7,13}W{16,22}B{5,11}W{17,23}B{4,10}W{19,25}B{3,9}W{20,26}B{1,7}W{22,28}B{0,5}W{34,40}B*$"
    ),
    HEART("h",
        "^B*W{149,155}B{2,8}W{2,5}B{2,8}W{13,19}B{9,15}W{12,18}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{12,18}B{9,15}W{13,19}B{9,15}W{14,20}B{7,13}W{16,22}B{5,11}W{18,24}B{3,9}W{20,26}B{1,7}W{33,39}B*$",
        "^B*W{146,152}B{1,7}W{2,5}B{2,8}W{13,19}B{10,16}W{12,18}B{10,16}W{11,17}B{11,17}W{12,18}B{10,16}W{12,18}B{10,16}W{13,19}B{8,14}W{15,21}B{6,12}W{17,23}B{4,10}W{19,25}B{2,8}W{21,27}B{0,6}W{23,29}BW{10,16}B*$",
        "^B*W{148,154}B{0,6}W{0,6}B{0,6}W{14,20}B{3,9}WB{3,9}W{12,18}B{10,16}W{12,18}B{10,16}W{12,18}B{10,16}W{12,18}B{10,16}W{12,18}B{10,16}W{13,19}B{8,14}W{15,21}B{6,12}W{17,23}B{4,10}W{19,25}B{2,8}W{22,28}B{2,5}W{8,14}B*$",
        "^B*W{144,150}B{2,8}W{2,5}B{1,7}W{13,19}B{10,16}W{12,18}B{10,16}W{12,18}B{10,16}W{12,18}B{10,16}W{12,18}B{10,16}W{13,19}B{8,14}W{15,21}B{6,12}W{17,23}B{4,10}W{19,25}B{2,8}W{21,27}B{0,6}W{23,29}BW{12,18}B*$",
        "^B*W{144,150}B{2,8}W{2,5}B{2,8}W{13,19}B{9,15}W{12,18}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{12,18}B{9,15}W{13,19}B{9,15}W{14,20}B{7,13}W{16,22}B{5,11}W{18,24}B{3,9}W{20,26}B{1,7}W{38,44}B*$",
        "^B*W{24,30}BW{24,30}BW{24,30}BW{24,30}BW{24,30}BW{6,12}B{2,8}W{0,5}B{1,7}W{4,10}BW{5,11}B{10,16}W{3,9}BW{5,11}B{10,16}W{3,9}BW{5,11}B{10,16}W{3,9}BW{5,11}B{10,16}W{3,9}BW{5,11}B{10,16}W{3,9}BW{6,12}B{8,14}W{4,10}BW{7,13}B{6,12}W{5,11}BW{8,14}B{4,10}W{6,12}BW{9,15}B{2,8}W{7,13}BW{10,16}B{0,6}W{8,14}BW{11,17}BW{9,15}B*$",
        "^B*W{24,30}BW{24,30}BW{24,30}BW{24,30}BW{24,30}BW{9,15}B{0,5}W{1,7}B{0,6}W{3,9}BW{7,13}B{3,9}WB{2,8}W{2,8}BW{7,13}B{10,16}W{1,7}BW{6,12}B{11,17}W{1,7}BW{6,12}B{11,17}W{1,7}BW{7,13}B{10,16}W{1,7}BW{7,13}B{9,15}W{2,8}BW{8,14}B{7,13}W{3,9}BW{9,15}B{5,11}W{4,10}BW{10,16}B{3,9}W{5,11}BW{11,17}B{1,7}W{6,12}BW{12,18}B{0,5}W{7,13}B*$",
        "^B*W{24,30}BW{24,30}BW{24,30}BW{24,30}BW{24,30}BW{4,10}B{1,7}W{0,5}B{2,8}W{6,12}BW{3,9}B{9,15}W{6,12}BW{2,8}B{11,17}W{5,11}BW{2,8}B{11,17}W{5,11}BW{2,8}B{11,17}W{5,11}BW{3,9}B{9,15}W{6,12}BW{3,9}B{9,15}W{6,12}BW{4,10}B{7,13}W{7,13}BW{5,11}B{5,11}W{8,14}BW{6,12}B{3,9}W{9,15}BW{8,14}B{0,6}W{10,16}BW{24,30}B*$"
    ),
    SPADE("s",
        "^B*W{96,102}BW{23,29}B{0,6}W{21,27}B{2,8}W{19,25}B{4,10}W{17,23}B{6,12}W{15,21}B{8,14}W{13,19}B{10,16}W{12,18}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{11,17}B{10,16}W{13,19}B{1,7}WBWB{1,7}W{19,25}BW{23,29}B{0,6}W{8,14}B*$",
        "^B*W{99,105}BW{23,29}B{0,6}W{21,27}B{2,8}W{19,25}B{4,10}W{17,23}B{6,12}W{15,21}B{8,14}W{13,19}B{10,16}W{12,18}B{10,16}W{11,17}B{12,18}W{11,17}B{10,16}W{12,18}B{10,16}W{13,19}B{1,7}WBWB{1,7}W{19,25}BW{23,29}B{0,6}W{5,11}B*$",
        "^B*W{98,104}BW{23,29}B{0,6}W{21,27}B{2,8}W{19,25}B{4,10}W{16,22}B{7,13}W{14,20}B{9,15}W{13,19}B{10,16}W{11,17}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{12,18}B{2,8}WB{4,10}W{13,19}B{1,7}WBWB{1,7}W{19,25}BW{23,29}B{0,6}W{6,12}B*$",
        "^B*W{94,100}BW{23,29}B{0,6}W{21,27}B{2,8}W{19,25}B{4,10}W{17,23}B{6,12}W{15,21}B{8,14}W{13,19}B{10,16}W{12,18}B{10,16}W{12,18}B{11,17}W{11,17}B{11,17}W{11,17}B{10,16}W{13,19}B{1,7}WBWB{1,7}W{19,25}BW{23,29}B{0,6}W{10,16}B*$",
        "^B*W{93,99}B{2,5}W{22,28}B{1,7}W{20,26}B{3,9}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{9,15}W{13,19}B{10,16}W{11,17}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{12,18}B{2,8}WB{4,10}W{12,18}B{1,7}W{2,5}BWB{1,7}W{18,24}B{2,5}W{23,29}B{2,5}W{11,17}B*$",
        "^B*W{94,100}B{2,5}W{22,28}B{1,7}W{20,26}B{3,9}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{9,15}W{12,18}B{10,16}W{12,18}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{12,18}B{1,7}W{1,7}B{1,7}W{18,24}B{2,5}W{23,29}B{2,5}W{10,16}B*$",
        "^B*W{95,101}B{2,5}W{22,28}B{1,7}W{20,26}B{3,9}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{9,15}W{12,18}B{10,16}W{12,18}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{11,17}B{10,16}W{13,19}B{1,7}WBW{2,5}B{1,7}W{18,24}BW{24,30}B{2,5}W{9,15}B*$",
        "^B*W{99,105}B{0,5}W{22,28}B{1,7}W{20,26}B{3,9}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{9,15}W{12,18}B{10,16}W{12,18}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{12,18}B{1,7}WBW{0,5}B{1,7}W{18,24}B{0,5}W{23,29}B{0,5}W{5,11}B*$",
        "^B*W{95,101}B{0,5}W{22,28}B{1,7}W{20,26}B{3,9}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{9,15}W{12,18}B{10,16}W{12,18}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{11,17}B{4,10}WB{2,8}W{13,19}B{1,7}WBW{0,5}B{1,7}W{18,24}BW{24,30}B{0,5}W{9,15}B*$",
        "^B*W{93,99}B{0,5}W{22,28}B{1,7}W{20,26}B{3,9}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{9,15}W{13,19}B{10,16}W{11,17}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{12,18}B{10,16}W{12,18}B{1,7}W{0,5}BWB{1,7}W{19,25}BW{23,29}B{0,5}W{11,17}B*$",
        "^B*W{24,30}BW{24,30}BW{24,30}BW{10,16}B{0,5}W{9,15}BW{9,15}B{1,7}W{8,14}BW{8,14}B{3,9}W{7,13}BW{7,13}B{5,11}W{6,12}BW{6,12}B{7,13}W{5,11}BW{5,11}B{9,15}W{4,10}BW{4,10}B{10,16}W{4,10}BW{4,10}B{11,17}W{3,9}BW{4,10}B{11,17}W{3,9}BW{4,10}B{11,17}W{3,9}BW{4,10}B{10,16}W{4,10}BW{5,11}B{1,7}WBW{0,5}B{1,7}W{4,10}BW{10,16}BW{10,16}BW{10,16}B{0,5}W{9,15}B*$",
        "^B*W{96,102}B{0,5}W{22,28}B{1,7}W{20,26}B{3,9}W{18,24}B{5,11}W{16,22}B{7,13}W{14,20}B{9,15}W{13,19}B{10,16}W{11,17}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{11,17}B{11,17}W{12,18}B{1,7}W{0,5}BWB{1,7}W{18,24}B{0,5}W{23,29}B{0,5}W{8,14}B*$"
    );

    /**
     * Card suit
     */
    private final String value;
    /**
     * Collection of card patterns
     */
    private final List<Pattern> patterns;

    /**
     * Card suit constructor by input parameters
     *
     * @param value    initial input {@link String} card rank
     * @param patterns initial input array of {@link String} card rank patterns
     */
    CardSuit(final String value, final String... patterns) {
        this.value = value;
        this.patterns = Arrays.stream(patterns).map(Pattern::compile).collect(Collectors.toList());
    }

    /**
     * Returns {@link String} representation of card suit
     *
     * @return card suit display name
     */
    @Override
    public String toString() {
        return this.getValue();
    }

    /**
     * Returns suit {@link CardPattern}s
     *
     * @return collection of suit card patterns
     */
    @Override
    public List<Pattern> getMask() {
        return this.getPatterns();
    }
}
