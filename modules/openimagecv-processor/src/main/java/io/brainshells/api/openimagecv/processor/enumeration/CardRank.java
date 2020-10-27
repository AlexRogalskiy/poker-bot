package io.brainshells.api.openimagecv.processor.enumeration;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public enum CardRank implements Maskable<List<Pattern>> {
    DEUCE("2",
        "^B*W{81,87}B{3,9}W{25,31}B{7,13}W{22,28}B{9,15}W{20,26}B{2,8}W{0,6}B{3,9}W{18,24}B{2,8}W{3,9}B{1,7}W{20,26}BW{5,11}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{28,34}B{2,8}W{28,34}B{1,7}W{28,34}B{1,7}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{1,7}W{27,33}B{2,8}W{28,34}B{12,18}W{18,24}B{12,18}W{18,24}B{13,19}W{82,88}B*$",
        "^B*W{79,85}B{4,10}W{24,30}B{8,14}W{21,27}B{10,16}W{19,25}B{3,9}W{0,6}B{2,8}W{19,25}B{1,7}W{3,9}B{2,8}W{19,25}B{2,5}W{5,11}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{28,34}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{26,32}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{13,19}W{17,23}B{13,19}W{17,23}B{13,19}W{83,89}B*$",
        "^B*W{80,86}B{3,9}W{25,31}B{7,13}W{22,28}B{9,15}W{20,26}B{2,8}W{1,7}B{2,8}W{19,25}B{1,7}W{3,9}B{1,7}W{20,26}B{2,5}W{4,10}B{1,7}W{30,36}B{0,6}W{30,36}B{0,6}W{29,35}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{1,7}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{1,7}W{28,34}B{1,7}W{28,34}B{12,18}W{18,24}B{12,18}W{18,24}B{13,19}W{83,89}B*$",
        "^B*W{80,86}B{3,9}W{25,31}B{7,13}W{21,27}B{10,16}W{20,26}B{2,8}W{0,6}B{2,8}W{19,25}B{1,7}W{3,9}B{2,8}W{19,25}B{2,5}W{5,11}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{28,34}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{1,7}W{27,33}B{2,8}W{27,33}B{2,8}W{28,34}B{12,18}W{18,24}B{12,18}W{18,24}B{12,18}W{84,90}B*$"
    ),
    THREE("3",
        "^B*W{77,83}B{11,17}W{19,25}B{11,17}W{19,25}B{11,17}W{28,34}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{27,33}B{2,8}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{2,8}W{28,34}B{5,11}W{25,31}B{6,12}W{28,34}B{3,9}W{29,35}B{1,7}W{30,36}B{0,6}W{30,36}B{0,6}W{20,26}BW{6,12}B{0,6}W{19,25}B{0,6}W{4,10}B{1,7}W{18,24}B{3,9}W{1,7}B{2,8}W{19,25}B{10,16}W{21,27}B{8,14}W{24,30}B{5,11}W{86,92}B*$",
        "^B*W{77,83}B{11,17}W{19,25}B{11,17}W{19,25}B{11,17}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{2,8}W{28,34}B{5,11}W{26,32}B{5,11}W{29,35}B{2,8}W{30,36}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{18,24}B{0,6}W{5,11}B{1,7}W{17,23}B{3,9}W{2,8}B{1,7}W{19,25}B{11,17}W{21,27}B{8,14}W{24,30}B{4,10}W{87,93}B*$",
        "^B*W{76,82}B{11,17}W{19,25}B{11,17}W{19,25}B{11,17}W{28,34}B{2,8}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{1,7}W{28,34}B{2,8}W{28,34}B{5,11}W{25,31}B{6,12}W{29,35}B{2,8}W{29,35}B{1,7}W{30,36}B{1,7}W{29,35}B{1,7}W{19,25}BW{6,12}B{1,7}W{18,24}B{0,6}W{4,10}B{1,7}W{18,24}B{3,9}W{1,7}B{2,8}W{19,25}B{10,16}W{21,27}B{8,14}W{24,30}B{5,11}W{87,93}B*$"
    ),
    FOUR("4",
        "^B*W{32,38}BW{32,38}BW{14,20}B{1,7}W{11,17}BW{13,19}B{2,8}W{11,17}BW{12,18}B{3,9}W{11,17}BW{12,18}B{3,9}W{11,17}BW{11,17}B{4,10}W{11,17}BW{10,16}B{5,11}W{11,17}BW{9,15}B{1,7}WB{1,7}W{11,17}BW{8,14}B{1,7}W{2,5}B{1,7}W{11,17}BW{7,13}B{1,7}W{0,6}B{1,7}W{11,17}BW{6,12}B{1,7}W{1,7}B{1,7}W{11,17}BW{6,12}B{1,7}W{1,7}B{1,7}W{11,17}BW{5,11}B{1,7}W{2,8}B{1,7}W{11,17}BW{4,10}B{1,7}W{3,9}B{1,7}W{11,17}BW{3,9}B{1,7}W{4,10}B{1,7}W{11,17}BW{2,8}B{16,22}W{8,14}BW{3,9}B{15,21}W{8,14}BW{3,9}B{15,21}W{8,14}BW{14,20}B{1,7}W{11,17}BW{14,20}B{1,7}W{11,17}BW{14,20}B{1,7}W{11,17}BW{14,20}B{1,7}W{11,17}BW{14,20}B{1,7}W{11,17}BW{32,38}BW{32,38}B*$",
        "^B*W{87,93}B{0,6}W{29,35}B{1,7}W{28,34}B{2,8}W{27,33}B{3,9}W{26,32}B{4,10}W{26,32}B{0,6}WB{0,6}W{25,31}B{0,6}W{2,5}B{0,6}W{24,30}B{1,7}W{2,5}B{0,6}W{23,29}B{1,7}W{0,6}B{0,6}W{22,28}B{1,7}W{1,7}B{0,6}W{21,27}B{1,7}W{2,8}B{0,6}W{21,27}B{0,6}W{3,9}B{0,6}W{20,26}B{0,6}W{4,10}B{0,6}W{19,25}B{1,7}W{4,10}B{0,6}W{18,24}B{15,21}W{15,21}B{15,21}W{16,22}B{14,20}W{27,33}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{84,90}B*$",
        "^B*W{86,92}B{1,7}W{29,35}B{1,7}W{28,34}B{2,8}W{27,33}B{3,9}W{26,32}B{4,10}W{25,31}B{5,11}W{24,30}B{1,7}WB{1,7}W{23,29}B{1,7}W{2,5}B{1,7}W{23,29}B{0,6}W{0,6}B{1,7}W{22,28}B{1,7}W{0,6}B{1,7}W{21,27}B{1,7}W{1,7}B{1,7}W{20,26}B{1,7}W{2,8}B{1,7}W{19,25}B{1,7}W{3,9}B{1,7}W{18,24}B{1,7}W{4,10}B{1,7}W{18,24}B{15,21}W{15,21}B{15,21}W{15,21}B{15,21}W{26,32}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{84,90}B*$"
    ),
    FIVE("5",
        "^B*W{78,84}B{10,16}W{20,26}B{10,16}W{20,26}B{10,16}W{20,26}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}WB{2,8}W{23,29}B{9,15}W{21,27}B{10,16}W{21,27}B{1,7}W{0,6}B{3,9}W{29,35}B{1,7}W{30,36}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{18,24}B{0,6}W{4,10}B{1,7}W{18,24}B{3,9}W{1,7}B{2,8}W{18,24}B{11,17}W{21,27}B{8,14}W{24,30}B{4,10}W{87,93}B*$",
        "^B*W{78,84}B{9,15}W{20,26}B{10,16}W{20,26}B{10,16}W{20,26}B{1,7}W{29,35}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{2,5}B{1,7}W{24,30}B{9,15}W{21,27}B{10,16}W{21,27}B{0,6}W{1,7}B{2,8}W{30,36}B{1,7}W{29,35}B{1,7}W{30,36}B{0,6}W{30,36}B{0,6}W{29,35}B{1,7}W{19,25}B{2,5}W{5,11}B{1,7}W{18,24}B{2,8}W{1,7}B{2,8}W{19,25}B{11,17}W{20,26}B{9,15}W{24,30}B{4,10}W{87,93}B*$",
        "^B*W{77,83}B{10,16}W{20,26}B{10,16}W{20,26}B{10,16}W{20,26}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}WB{2,8}W{23,29}B{9,15}W{21,27}B{10,16}W{21,27}B{1,7}W{0,6}B{3,9}W{29,35}B{1,7}W{30,36}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{18,24}B{0,6}W{4,10}B{1,7}W{18,24}B{3,9}W{1,7}B{2,8}W{19,25}B{10,16}W{21,27}B{8,14}W{24,30}B{5,11}W{87,93}B*$",
        "^B*W{76,82}B{11,17}W{19,25}B{11,17}W{19,25}B{11,17}W{19,25}B{11,17}W{19,25}B{1,7}W{29,35}B{1,7}W{28,34}B{2,8}W{28,34}B{2,8}W{28,34}B{10,16}W{20,26}B{11,17}W{19,25}B{12,18}W{19,25}B{12,18}W{19,25}B{2,5}W{3,9}B{3,9}W{28,34}B{2,8}W{28,34}B{2,8}W{28,34}B{2,8}W{18,24}B{2,5}W{5,11}B{2,8}W{17,23}B{2,8}W{2,8}B{3,9}W{16,22}B{13,19}W{17,23}B{13,19}W{18,24}B{11,17}W{21,27}B{8,14}W{24,30}B{4,10}W{52,58}B*$",
        "^B*W{76,82}B{10,16}W{20,26}B{10,16}W{20,26}B{10,16}W{20,26}B{1,7}W{29,35}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}WB{2,8}W{24,30}B{8,14}W{22,28}B{10,16}W{21,27}B{0,6}W{0,6}B{3,9}W{29,35}B{2,8}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{19,25}BW{6,12}B{1,7}W{18,24}B{0,6}W{4,10}B{2,8}W{18,24}B{2,8}W{1,7}B{2,8}W{19,25}B{10,16}W{21,27}B{8,14}W{24,30}B{5,11}W{88,94}B*$",
        "^B*W{77,83}B{10,16}W{20,26}B{10,16}W{20,26}B{10,16}W{20,26}B{1,7}W{29,35}B{1,7}W{29,35}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{7,13}W{23,29}B{9,15}W{21,27}B{10,16}W{21,27}B{1,7}W{0,5}B{3,9}W{30,36}B{1,7}W{29,35}B{1,7}W{30,36}B{0,6}W{30,36}B{0,6}W{29,35}B{1,7}W{19,25}B{0,5}W{5,11}B{1,7}W{18,24}B{2,8}W{1,7}B{2,8}W{19,25}B{11,17}W{20,26}B{9,15}W{23,29}B{5,11}W{87,93}B*$"
    ),
    SIX("6",
        "^B*W{82,88}B{4,10}W{24,30}B{8,14}W{21,27}B{10,16}W{19,25}B{2,8}W{1,7}B{1,7}W{20,26}B{1,7}W{4,10}BW{20,26}B{1,7}W{29,35}B{1,7}W{29,35}B{0,6}W{29,35}B{1,7}W{0,6}B{2,8}W{21,27}B{1,7}WB{6,12}W{19,25}B{12,18}W{18,24}B{4,10}W{1,7}B{2,8}W{17,23}B{2,8}W{4,10}B{1,7}W{17,23}B{1,7}W{6,12}B{1,7}W{16,22}B{1,7}W{6,12}B{1,7}W{16,22}B{1,7}W{6,12}B{1,7}W{17,23}B{0,6}W{6,12}B{1,7}W{17,23}B{1,7}W{4,10}B{1,7}W{19,25}B{1,7}W{2,8}B{2,8}W{19,25}B{10,16}W{21,27}B{8,14}W{24,30}B{4,10}W{86,92}B*$",
        "^B*W{82,88}B{4,10}W{24,30}B{8,14}W{21,27}B{9,15}W{20,26}B{2,8}W{1,7}B{1,7}W{19,25}B{2,8}W{4,10}BW{20,26}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{2,5}B{3,9}W{21,27}B{1,7}WB{6,12}W{19,25}B{12,18}W{18,24}B{3,9}W{1,7}B{2,8}W{18,24}B{2,8}W{4,10}B{1,7}W{17,23}B{1,7}W{5,11}B{1,7}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{5,11}B{1,7}W{18,24}B{1,7}W{4,10}B{1,7}W{18,24}B{2,8}W{2,8}B{1,7}W{20,26}B{10,16}W{21,27}B{8,14}W{24,30}B{4,10}W{86,92}B*$",
        "^B*W{81,87}B{4,10}W{24,30}B{8,14}W{21,27}B{10,16}W{19,25}B{3,9}W{1,7}B{0,6}W{20,26}B{1,7}W{4,10}BW{20,26}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{0,6}W{0,6}B{2,8}W{21,27}B{1,7}WB{6,12}W{19,25}B{12,18}W{18,24}B{4,10}W{1,7}B{2,8}W{17,23}B{2,8}W{4,10}B{1,7}W{17,23}B{2,8}W{5,11}B{1,7}W{16,22}B{1,7}W{6,12}B{1,7}W{17,23}B{0,6}W{6,12}B{1,7}W{17,23}B{0,6}W{6,12}B{1,7}W{17,23}B{1,7}W{4,10}B{1,7}W{19,25}B{1,7}W{2,8}B{2,8}W{19,25}B{10,16}W{21,27}B{8,14}W{24,30}B{5,11}W{86,92}B*$",
        "^B*W{81,87}B{4,10}W{24,30}B{8,14}W{21,27}B{9,15}W{20,26}B{2,8}W{1,7}B{1,7}W{19,25}B{2,8}W{4,10}BW{20,26}B{1,7}W{29,35}B{0,6}W{29,35}B{1,7}W{29,35}B{1,7}W{0,6}B{2,8}W{21,27}B{1,7}WB{6,12}W{19,25}B{12,18}W{18,24}B{3,9}W{1,7}B{3,9}W{17,23}B{2,8}W{4,10}B{1,7}W{17,23}B{1,7}W{5,11}B{1,7}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{6,12}B{0,6}W{18,24}B{1,7}W{4,10}B{1,7}W{18,24}B{2,8}W{2,8}B{2,8}W{19,25}B{10,16}W{21,27}B{8,14}W{24,30}B{4,10}W{87,93}B*$"
    ),
    SEVEN("7",
        "^B*W{76,82}B{13,19}W{17,23}B{13,19}W{17,23}B{13,19}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{0,6}W{29,35}B{1,7}W{29,35}B{0,6}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{92,98}B*$",
        "^B*W{76,82}B{12,18}W{18,24}B{12,18}W{18,24}B{12,18}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{28,34}B{2,8}W{28,34}B{1,7}W{28,34}B{2,8}W{92,98}B*$",
        "^B*W{76,82}B{12,18}W{18,24}B{12,18}W{18,24}B{12,18}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{93,99}B*$",
        "^B*W{74,80}B{14,20}W{16,22}B{14,20}W{16,22}B{14,20}W{16,22}B{14,20}W{27,33}B{2,8}W{28,34}B{2,8}W{27,33}B{2,8}W{27,33}B{3,9}W{27,33}B{2,8}W{27,33}B{3,9}W{27,33}B{2,8}W{27,33}B{3,9}W{26,32}B{3,9}W{27,33}B{3,9}W{26,32}B{3,9}W{27,33}B{3,9}W{26,32}B{3,9}W{27,33}B{3,9}W{26,32}B{3,9}W{27,33}B{2,8}W{27,33}B{3,9}W{27,33}B{2,8}W{28,34}B{2,8}W{57,63}B*$"
    ),
    EIGHT("8",
        "^B*W{81,87}B{3,9}W{25,31}B{7,13}W{22,28}B{9,15}W{20,26}B{2,8}W{1,7}B{2,8}W{19,25}B{1,7}W{3,9}B{1,7}W{19,25}B{0,6}W{5,11}B{1,7}W{18,24}B{0,6}W{5,11}B{0,6}W{19,25}B{0,6}W{5,11}B{0,6}W{19,25}B{1,7}W{3,9}B{1,7}W{20,26}B{9,15}W{22,28}B{7,13}W{22,28}B{9,15}W{20,26}B{3,9}W{2,5}B{3,9}W{18,24}B{2,8}W{4,10}B{1,7}W{17,23}B{1,7}W{5,11}B{1,7}W{17,23}B{0,6}W{7,13}B{0,6}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{5,11}B{1,7}W{17,23}B{2,8}W{3,9}B{2,8}W{18,24}B{11,17}W{20,26}B{9,15}W{23,29}B{5,11}W{86,92}B*$",
        "^B*W{80,86}B{4,10}W{25,31}B{7,13}W{21,27}B{10,16}W{20,26}B{1,7}W{2,8}B{2,8}W{18,24}B{1,7}W{4,10}B{1,7}W{18,24}B{1,7}W{5,11}B{0,6}W{18,24}B{1,7}W{5,11}B{0,6}W{19,25}B{0,6}W{4,10}B{1,7}W{19,25}B{1,7}W{3,9}B{0,6}W{21,27}B{2,8}WB{2,8}W{23,29}B{6,12}W{23,29}B{8,14}W{21,27}B{2,8}W{1,7}B{1,7}W{19,25}B{1,7}W{4,10}B{1,7}W{18,24}B{0,6}W{6,12}B{1,7}W{17,23}B{0,6}W{6,12}B{1,7}W{17,23}B{0,6}W{6,12}B{1,7}W{17,23}B{1,7}W{5,11}B{1,7}W{17,23}B{2,8}W{3,9}B{1,7}W{19,25}B{11,17}W{20,26}B{8,14}W{24,30}B{4,10}W{87,93}B*$",
        "^B*W{80,86}B{3,9}W{25,31}B{7,13}W{22,28}B{9,15}W{20,26}B{2,8}W{2,8}B{1,7}W{19,25}B{1,7}W{4,10}B{0,6}W{19,25}B{0,6}W{5,11}B{1,7}W{18,24}B{0,6}W{5,11}B{0,6}W{19,25}B{1,7}W{4,10}B{0,6}W{20,26}B{0,6}W{3,9}B{1,7}W{21,27}B{2,8}WB{2,8}W{23,29}B{6,12}W{23,29}B{8,14}W{20,26}B{2,8}W{1,7}B{2,8}W{19,25}B{1,7}W{4,10}B{1,7}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{0,6}W{7,13}B{0,6}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{5,11}B{1,7}W{18,24}B{1,7}W{3,9}B{2,8}W{18,24}B{11,17}W{20,26}B{9,15}W{24,30}B{4,10}W{87,93}B*$",
        "^B*W{79,85}B{4,10}W{25,31}B{7,13}W{22,28}B{9,15}W{20,26}B{2,8}W{1,7}B{2,8}W{19,25}B{0,6}W{4,10}B{1,7}W{18,24}B{1,7}W{5,11}B{0,6}W{18,24}B{1,7}W{5,11}B{0,6}W{19,25}B{0,6}W{4,10}B{1,7}W{19,25}B{1,7}W{3,9}B{0,6}W{21,27}B{9,15}W{22,28}B{6,12}W{23,29}B{9,15}W{20,26}B{2,8}W{0,6}B{3,9}W{18,24}B{1,7}W{4,10}B{1,7}W{18,24}B{0,6}W{6,12}B{1,7}W{17,23}B{0,6}W{6,12}B{1,7}W{17,23}B{0,6}W{6,12}B{1,7}W{17,23}B{1,7}W{5,11}B{1,7}W{17,23}B{2,8}W{3,9}B{1,7}W{19,25}B{11,17}W{20,26}B{9,15}W{23,29}B{5,11}W{87,93}B*$",
        "^B*W{79,85}B{4,10}W{24,30}B{8,14}W{21,27}B{10,16}W{20,26}B{1,7}W{2,8}B{1,7}W{19,25}B{1,7}W{4,10}B{1,7}W{18,24}B{0,6}W{5,11}B{1,7}W{18,24}B{0,6}W{5,11}B{1,7}W{18,24}B{1,7}W{4,10}B{0,6}W{20,26}B{0,6}W{3,9}B{1,7}W{21,27}B{2,8}WB{2,8}W{23,29}B{6,12}W{23,29}B{8,14}W{21,27}B{1,7}W{1,7}B{2,8}W{19,25}B{1,7}W{4,10}B{1,7}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{5,11}B{1,7}W{18,24}B{2,8}W{2,8}B{2,8}W{19,25}B{10,16}W{21,27}B{8,14}W{24,30}B{4,10}W{88,94}B*$",
        "^B*W{79,85}B{4,10}W{24,30}B{8,14}W{21,27}B{10,16}W{19,25}B{2,8}W{2,8}B{1,7}W{19,25}B{1,7}W{4,10}B{1,7}W{18,24}B{1,7}W{4,10}B{1,7}W{18,24}B{0,6}W{5,11}B{1,7}W{18,24}B{1,7}W{4,10}B{1,7}W{19,25}B{1,7}W{2,8}B{1,7}W{21,27}B{8,14}W{23,29}B{6,12}W{23,29}B{8,14}W{20,26}B{3,9}W{0,6}B{2,8}W{19,25}B{1,7}W{4,10}B{1,7}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{6,12}B{1,7}W{16,22}B{1,7}W{6,12}B{1,7}W{16,22}B{1,7}W{5,11}B{1,7}W{18,24}B{2,8}W{2,8}B{2,8}W{18,24}B{11,17}W{21,27}B{8,14}W{23,29}B{5,11}W{88,94}B*$"
    ),
    NINE("9",
        "^B*W{32,38}BW{32,38}BW{8,14}B{4,10}W{14,20}BW{6,12}B{7,13}W{13,19}BW{5,11}B{9,15}W{12,18}BW{4,10}B{2,8}W{2,8}B{1,7}W{11,17}BW{4,10}B{1,7}W{4,10}B{1,7}W{10,16}BW{3,9}B{1,7}W{6,12}B{0,6}W{10,16}BW{3,9}B{1,7}W{6,12}B{0,6}W{10,16}BW{3,9}B{1,7}W{6,12}B{1,7}W{9,15}BW{3,9}B{1,7}W{6,12}B{1,7}W{9,15}BW{4,10}B{1,7}W{4,10}B{2,8}W{9,15}BW{4,10}B{2,8}W{2,8}B{3,9}W{9,15}BW{5,11}B{12,18}W{9,15}BW{6,12}B{6,12}WB{1,7}W{9,15}BW{7,13}B{4,10}W{2,5}B{0,6}W{10,16}BW{16,22}B{0,6}W{10,16}BW{15,21}B{1,7}W{10,16}BW{15,21}B{1,7}W{10,16}BW{5,11}BW{5,11}B{1,7}W{11,17}BW{5,11}B{0,6}W{2,8}B{2,8}W{11,17}BW{4,10}B{10,16}W{12,18}BW{5,11}B{8,14}W{13,19}BW{7,13}B{4,10}W{15,21}BW{32,38}BW{32,38}B*$",
        "^B*BW{79,85}B{4,10}W{25,31}B{7,13}W{21,27}B{10,16}W{20,26}B{2,8}W{1,7}B{2,8}W{18,24}B{1,7}W{4,10}B{1,7}W{18,24}B{1,7}W{5,11}B{1,7}W{17,23}B{0,6}W{6,12}B{1,7}W{17,23}B{0,6}W{6,12}B{1,7}W{17,23}B{1,7}W{5,11}B{1,7}W{17,23}B{1,7}W{5,11}B{1,7}W{17,23}B{2,8}W{2,8}B{3,9}W{18,24}B{12,18}W{19,25}B{7,13}WB{0,6}W{21,27}B{3,9}W{2,5}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{20,26}BW{5,11}B{1,7}W{19,25}B{1,7}W{1,7}B{2,8}W{19,25}B{10,16}W{21,27}B{8,14}W{24,30}B{5,11}W{87,93}B*$",
        "^B*W{80,86}B{4,10}W{24,30}B{8,14}W{21,27}B{10,16}W{19,25}B{2,8}W{2,8}B{1,7}W{19,25}B{1,7}W{4,10}B{1,7}W{18,24}B{0,6}W{6,12}B{0,6}W{18,24}B{0,6}W{6,12}B{0,6}W{17,23}B{1,7}W{6,12}B{1,7}W{17,23}B{0,6}W{6,12}B{1,7}W{17,23}B{1,7}W{4,10}B{2,8}W{17,23}B{2,8}W{2,8}B{3,9}W{18,24}B{12,18}W{19,25}B{6,12}WB{1,7}W{21,27}B{3,9}W{2,5}B{1,7}W{29,35}B{0,6}W{29,35}B{1,7}W{29,35}B{1,7}W{20,26}BW{4,10}B{1,7}W{20,26}B{0,6}W{2,8}B{2,8}W{19,25}B{10,16}W{21,27}B{8,14}W{24,30}B{4,10}W{88,94}B*$",
        "^B*W{79,85}B{5,11}W{24,30}B{7,13}W{22,28}B{9,15}W{20,26}B{2,8}W{1,7}B{2,8}W{18,24}B{2,8}W{4,10}B{0,6}W{18,24}B{1,7}W{5,11}B{1,7}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{6,12}B{0,6}W{17,23}B{1,7}W{5,11}B{1,7}W{17,23}B{1,7}W{5,11}B{2,8}W{17,23}B{2,8}W{2,8}B{3,9}W{17,23}B{12,18}W{19,25}B{7,13}WB{0,6}W{21,27}B{4,10}W{2,5}B{0,6}W{29,35}B{1,7}W{29,35}B{1,7}W{28,34}B{1,7}W{20,26}BW{5,11}B{1,7}W{19,25}B{1,7}W{1,7}B{2,8}W{20,26}B{10,16}W{21,27}B{8,14}W{23,29}B{5,11}W{88,94}B*$"
    ),
    TEN("10",
        "^B*W{76,82}B{1,7}W{5,11}B{4,10}W{11,17}B{4,10}W{3,9}B{7,13}W{9,15}B{5,11}W{2,8}B{10,16}W{7,13}B{5,11}W{1,7}B{2,8}W{1,7}B{2,8}W{8,14}BW{0,6}B{0,6}W{0,6}B{2,8}W{3,9}B{2,8}W{11,17}B{0,6}W{0,6}B{1,7}W{5,11}B{2,8}W{10,16}B{0,6}W{0,6}B{1,7}W{6,12}B{1,7}W{10,16}B{0,6}W{2,5}B{1,7}W{7,13}B{1,7}W{10,16}B{0,6}W{2,5}B{1,7}W{8,14}B{0,6}W{10,16}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{0,6}W{10,16}B{0,6}W{2,5}B{1,7}W{7,13}B{1,7}W{10,16}B{0,6}W{0,6}B{1,7}W{6,12}B{1,7}W{10,16}B{0,6}W{0,6}B{1,7}W{5,11}B{2,8}W{10,16}B{0,6}W{0,6}B{2,8}W{4,10}B{1,7}W{11,17}B{0,6}W{1,7}B{2,8}W{1,7}B{2,8}W{12,18}B{0,6}W{2,8}B{10,16}W{12,18}B{0,6}W{3,9}B{7,13}W{14,20}B{0,6}W{5,11}B{4,10}W{79,85}B*$",
        "^B*W{76,82}B{1,7}W{5,11}B{3,9}W{12,18}B{4,10}W{3,9}B{7,13}W{9,15}B{5,11}W{2,8}B{9,15}W{8,14}B{5,11}W{1,7}B{2,8}W{1,7}B{2,8}W{7,13}BW{0,6}B{1,7}W{0,6}B{1,7}W{4,10}B{1,7}W{11,17}B{1,7}W{0,6}B{1,7}W{5,11}B{1,7}W{10,16}B{1,7}W{2,5}B{1,7}W{7,13}B{0,6}W{10,16}B{1,7}W{2,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{2,5}B{0,6}W{8,14}B{1,7}W{9,15}B{1,7}W{2,5}B{0,6}W{8,14}B{1,7}W{9,15}B{1,7}W{2,5}B{0,6}W{8,14}B{1,7}W{9,15}B{1,7}W{2,5}B{0,6}W{9,15}B{0,6}W{9,15}B{1,7}W{2,5}B{0,6}W{8,14}B{1,7}W{9,15}B{1,7}W{2,5}B{0,6}W{8,14}B{1,7}W{9,15}B{1,7}W{2,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{2,5}B{1,7}W{7,13}B{0,6}W{10,16}B{1,7}W{0,6}B{1,7}W{5,11}B{1,7}W{10,16}B{1,7}W{0,6}B{1,7}W{4,10}B{2,8}W{10,16}B{1,7}W{1,7}B{2,8}W{1,7}B{2,8}W{11,17}B{1,7}W{2,8}B{9,15}W{12,18}B{1,7}W{3,9}B{7,13}W{13,19}B{1,7}W{5,11}B{3,9}W{80,86}B*$",
        "^B*W{76,82}B{0,6}W{5,11}B{4,10}W{11,17}B{4,10}W{3,9}B{7,13}W{9,15}B{5,11}W{2,8}B{10,16}W{8,14}B{4,10}W{1,7}B{2,8}W{1,7}B{2,8}W{8,14}BW{0,6}B{0,6}W{1,7}B{1,7}W{4,10}B{1,7}W{11,17}B{0,6}W{0,6}B{1,7}W{6,12}B{1,7}W{10,16}B{0,6}W{0,6}B{1,7}W{6,12}B{1,7}W{10,16}B{0,6}W{0,6}B{0,6}W{8,14}B{0,6}W{10,16}B{0,6}W{2,5}B{1,7}W{8,14}B{0,6}W{10,16}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{0,6}W{10,16}B{0,6}W{0,6}B{0,6}W{8,14}B{0,6}W{10,16}B{0,6}W{0,6}B{1,7}W{6,12}B{1,7}W{10,16}B{0,6}W{0,6}B{1,7}W{6,12}B{1,7}W{10,16}B{0,6}W{1,7}B{1,7}W{4,10}B{1,7}W{11,17}B{0,6}W{1,7}B{2,8}W{2,8}B{1,7}W{12,18}B{0,6}W{2,8}B{10,16}W{12,18}B{0,6}W{3,9}B{7,13}W{14,20}B{0,6}W{5,11}B{4,10}W{80,86}B*$",
        "^B*W{75,81}B{1,7}W{5,11}B{3,9}W{12,18}B{4,10}W{3,9}B{7,13}W{9,15}B{5,11}W{2,8}B{9,15}W{8,14}B{5,11}W{1,7}B{2,8}W{1,7}B{2,8}W{7,13}B{2,5}W{2,5}B{1,7}W{0,6}B{2,8}W{3,9}B{2,8}W{10,16}B{1,7}W{0,6}B{1,7}W{5,11}B{1,7}W{10,16}B{1,7}W{2,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{2,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{2,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{2,5}B{0,6}W{9,15}B{0,6}W{9,15}B{1,7}W{2,5}B{0,6}W{9,15}B{0,6}W{9,15}B{1,7}W{2,5}B{0,6}W{9,15}B{0,6}W{9,15}B{1,7}W{2,5}B{0,6}W{9,15}B{0,6}W{9,15}B{1,7}W{2,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{2,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{2,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{0,6}B{1,7}W{5,11}B{1,7}W{10,16}B{1,7}W{0,6}B{2,8}W{3,9}B{2,8}W{10,16}B{1,7}W{1,7}B{2,8}W{1,7}B{2,8}W{11,17}B{1,7}W{2,8}B{9,15}W{12,18}B{1,7}W{3,9}B{7,13}W{13,19}B{1,7}W{4,10}B{4,10}W{81,87}B*$",
        "^B*W{40,46}B{0,6}W{6,12}B{2,8}W{13,19}B{3,9}W{4,10}B{6,12}W{9,15}B{5,11}W{2,8}B{10,16}W{7,13}B{5,11}W{1,7}B{3,9}W{0,6}B{2,8}W{8,14}B{2,5}W{2,5}B{0,6}W{1,7}B{1,7}W{3,9}B{2,8}W{11,17}B{0,6}W{0,6}B{1,7}W{5,11}B{2,8}W{10,16}B{0,6}W{0,6}B{1,7}W{6,12}B{1,7}W{10,16}B{0,6}W{0,6}B{0,6}W{7,13}B{1,7}W{10,16}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{1,7}W{9,15}B{0,6}W{2,5}B{1,7}W{8,14}B{0,6}W{10,16}B{0,6}W{0,6}B{1,7}W{6,12}B{1,7}W{10,16}B{0,6}W{0,6}B{1,7}W{6,12}B{1,7}W{10,16}B{0,6}W{0,6}B{2,8}W{4,10}B{1,7}W{11,17}B{0,6}W{1,7}B{2,8}W{2,8}B{2,8}W{11,17}B{0,6}W{2,8}B{10,16}W{12,18}B{0,6}W{3,9}B{8,14}W{13,19}B{0,6}W{4,10}B{5,11}W{116,122}B*$",
        "^B*W{40,46}B{1,7}W{5,11}B{3,9}W{12,18}B{4,10}W{3,9}B{7,13}W{8,14}B{6,12}W{2,8}B{9,15}W{8,14}B{5,11}W{1,7}B{3,9}W{0,5}B{3,9}W{7,13}B{0,5}W{0,5}B{1,7}W{0,6}B{2,8}W{3,9}B{2,8}W{10,16}B{1,7}W{0,6}B{1,7}W{5,11}B{1,7}W{10,16}B{1,7}W{0,5}B{1,7}W{6,12}B{1,7}W{10,16}B{1,7}W{0,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{0,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{0,5}B{0,6}W{8,14}B{1,7}W{9,15}B{1,7}WB{1,7}W{8,14}B{1,7}W{9,15}B{1,7}WB{1,7}W{8,14}B{1,7}W{9,15}B{1,7}W{0,5}B{0,6}W{8,14}B{1,7}W{9,15}B{1,7}W{0,5}B{0,6}W{8,14}B{1,7}W{9,15}B{1,7}W{0,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{0,5}B{1,7}W{7,13}B{1,7}W{9,15}B{1,7}W{0,5}B{2,8}W{5,11}B{1,7}W{10,16}B{1,7}W{0,6}B{1,7}W{4,10}B{2,8}W{10,16}B{1,7}W{1,7}B{2,8}W{1,7}B{2,8}W{11,17}B{1,7}W{1,7}B{10,16}W{12,18}B{1,7}W{2,8}B{8,14}W{13,19}B{1,7}W{4,10}B{5,11}W{115,121}B*$"
    ),
    JACK("J",
        "^B*W{85,91}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{21,27}BW{4,10}B{1,7}W{20,26}B{0,6}W{2,8}B{2,8}W{19,25}B{2,8}W{0,6}B{2,8}W{21,27}B{9,15}W{22,28}B{7,13}W{25,31}B{3,9}W{89,95}B*$",
        "^B*W{85,91}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{1,7}W{29,35}B{0,6}W{21,27}B{2,5}W{3,9}B{1,7}W{20,26}B{2,8}W{0,6}B{2,8}W{20,26}B{9,15}W{22,28}B{7,13}W{25,31}B{4,10}W{89,95}B*$",
        "^B*W{85,91}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{30,36}B{0,6}W{29,35}B{1,7}W{29,35}B{1,7}W{20,26}B{0,6}W{3,9}B{1,7}W{19,25}B{2,8}W{0,6}B{2,8}W{21,27}B{9,15}W{22,28}B{7,13}W{25,31}B{3,9}W{90,96}B*$",
        "^B*W{32,38}BW{32,38}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{12,18}B{1,7}W{13,19}BW{3,9}B{0,5}W{4,10}B{1,7}W{13,19}BW{2,8}B{2,8}W{0,6}B{2,8}W{14,20}BW{3,9}B{9,15}W{14,20}BW{4,10}B{7,13}W{15,21}BW{6,12}B{3,9}W{17,23}BW{32,38}BW{32,38}B*$"
    ),
    QUEEN("Q",
        "^B*W{84,90}B{4,10}W{24,30}B{8,14}W{20,26}B{12,18}W{17,23}B{3,9}W{2,8}B{3,9}W{15,21}B{2,8}W{6,12}B{2,8}W{14,20}B{1,7}W{8,14}B{1,7}W{13,19}B{1,7}W{10,16}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{12,18}B{0,6}W{12,18}B{0,6}W{11,17}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{7,13}BW{1,7}B{1,7}W{10,16}B{1,7}W{6,12}B{0,6}W{0,6}B{0,6}W{12,18}B{1,7}W{4,10}B{2,8}WB{1,7}W{12,18}B{1,7}W{5,11}B{6,12}W{13,19}B{1,7}W{5,11}B{4,10}W{14,20}B{2,8}W{5,11}B{3,9}W{15,21}B{3,9}W{2,8}B{4,10}W{16,22}B{16,22}W{15,21}B{9,15}W{2,5}B{0,6}W{19,25}B{4,10}W{2,8}B{2,5}W{76,82}B*$",
        "^B*W{83,89}B{5,11}W{23,29}B{9,15}W{20,26}B{12,18}W{17,23}B{3,9}W{1,7}B{4,10}W{15,21}B{2,8}W{5,11}B{2,8}W{14,20}B{2,8}W{7,13}B{2,8}W{13,19}B{1,7}W{9,15}B{1,7}W{12,18}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{6,12}BW{1,7}B{1,7}W{11,17}B{1,7}W{5,11}B{0,6}W{0,6}B{1,7}W{11,17}B{1,7}W{4,10}B{2,8}W{2,5}B{1,7}W{12,18}B{1,7}W{4,10}B{6,12}W{13,19}B{2,8}W{4,10}B{5,11}W{14,20}B{2,8}W{5,11}B{2,8}W{15,21}B{4,10}W{1,7}B{5,11}W{15,21}B{16,22}W{16,22}B{9,15}WB{1,7}W{18,24}B{5,11}W{1,7}B{2,5}W{77,83}B*$",
        "^B*W{83,89}B{5,11}W{23,29}B{9,15}W{19,25}B{12,18}W{17,23}B{3,9}W{2,8}B{3,9}W{15,21}B{2,8}W{6,12}B{2,8}W{14,20}B{1,7}W{8,14}B{2,8}W{12,18}B{2,8}W{9,15}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{12,18}B{1,7}W{11,17}B{1,7}W{10,16}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{7,13}BW{1,7}B{1,7}W{11,17}B{1,7}W{5,11}B{0,6}W{0,6}B{1,7}W{11,17}B{1,7}W{4,10}B{2,8}WB{1,7}W{12,18}B{1,7}W{5,11}B{6,12}W{13,19}B{1,7}W{5,11}B{5,11}W{13,19}B{2,8}W{5,11}B{3,9}W{15,21}B{3,9}W{2,8}B{5,11}W{15,21}B{16,22}W{15,21}B{10,16}WB{1,7}W{17,23}B{6,12}W{1,7}B{2,5}W{77,83}B*$",
        "^B*W{82,88}B{5,11}W{23,29}B{9,15}W{20,26}B{12,18}W{17,23}B{3,9}W{1,7}B{4,10}W{15,21}B{2,8}W{5,11}B{3,9}W{13,19}B{2,8}W{8,14}B{1,7}W{13,19}B{1,7}W{9,15}B{2,8}W{12,18}B{1,7}W{10,16}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{12,18}B{0,6}W{11,17}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{6,12}BW{2,8}B{0,6}W{11,17}B{1,7}W{5,11}B{0,6}W{0,6}B{1,7}W{11,17}B{2,8}W{4,10}B{2,8}WB{1,7}W{12,18}B{1,7}W{4,10}B{7,13}W{12,18}B{2,8}W{5,11}B{4,10}W{14,20}B{2,8}W{5,11}B{2,8}W{16,22}B{3,9}W{1,7}B{5,11}W{16,22}B{15,21}W{16,22}B{9,15}WB{1,7}W{18,24}B{5,11}W{1,7}B{2,5}W{78,84}B*$",
        "^B*W{82,88}B{5,11}W{23,29}B{9,15}W{19,25}B{12,18}W{17,23}B{4,10}W{1,7}B{3,9}W{16,22}B{2,8}W{5,11}B{2,8}W{14,20}B{1,7}W{8,14}B{2,8}W{12,18}B{2,8}W{9,15}B{1,7}W{12,18}B{1,7}W{10,16}B{2,8}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{0,6}W{12,18}B{1,7}W{11,17}B{0,6}W{12,18}B{1,7}W{11,17}B{0,6}W{12,18}B{1,7}W{11,17}B{0,6}W{7,13}BW{1,7}B{1,7}W{11,17}B{1,7}W{5,11}B{0,6}W{0,6}B{1,7}W{11,17}B{1,7}W{4,10}B{2,8}WB{2,8}W{11,17}B{2,8}W{4,10}B{6,12}W{13,19}B{1,7}W{5,11}B{5,11}W{13,19}B{3,9}W{4,10}B{3,9}W{15,21}B{4,10}W{1,7}B{5,11}W{15,21}B{16,22}W{16,22}B{9,15}WB{1,7}W{18,24}B{5,11}W{1,7}B{2,5}W{78,84}B*$",
        "^B*W{84,90}B{4,10}W{23,29}B{10,16}W{19,25}B{12,18}W{17,23}B{3,9}W{2,8}B{3,9}W{15,21}B{2,8}W{6,12}B{2,8}W{14,20}B{1,7}W{8,14}B{1,7}W{13,19}B{1,7}W{10,16}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{12,18}B{1,7}W{10,16}B{1,7}W{6,12}B{0,5}W{1,7}B{1,7}W{10,16}B{1,7}W{6,12}B{0,6}W{0,6}B{0,6}W{12,18}B{1,7}W{4,10}B{2,8}WB{1,7}W{12,18}B{1,7}W{5,11}B{6,12}W{12,18}B{2,8}W{5,11}B{4,10}W{14,20}B{2,8}W{5,11}B{3,9}W{15,21}B{3,9}W{2,8}B{4,10}W{16,22}B{16,22}W{15,21}B{14,20}W{18,24}B{6,12}W{1,7}B{0,5}W{76,82}B*$"
    ),
    KING("K",
        "^B*W{77,83}B{1,7}W{7,13}B{1,7}W{15,21}B{1,7}W{6,12}B{1,7}W{16,22}B{1,7}W{5,11}B{1,7}W{17,23}B{1,7}W{4,10}B{1,7}W{18,24}B{1,7}W{3,9}B{2,8}W{18,24}B{1,7}W{2,8}B{2,8}W{19,25}B{1,7}W{1,7}B{2,8}W{20,26}B{1,7}W{1,7}B{1,7}W{21,27}B{1,7}W{0,6}B{1,7}W{22,28}B{1,7}W{2,5}B{1,7}W{23,29}B{1,7}WB{2,8}W{23,29}B{8,14}W{22,28}B{4,10}WB{1,7}W{21,27}B{3,9}W{0,6}B{1,7}W{20,26}B{2,8}W{1,7}B{1,7}W{20,26}B{1,7}W{3,9}B{1,7}W{19,25}B{1,7}W{4,10}B{1,7}W{18,24}B{1,7}W{5,11}B{1,7}W{17,23}B{1,7}W{5,11}B{2,8}W{16,22}B{1,7}W{6,12}B{1,7}W{16,22}B{1,7}W{7,13}B{1,7}W{15,21}B{1,7}W{8,14}B{1,7}W{78,84}B*$",
        "^B*W{77,83}B{0,6}W{8,14}B{1,7}W{15,21}B{0,6}W{7,13}B{1,7}W{16,22}B{0,6}W{6,12}B{1,7}W{17,23}B{0,6}W{5,11}B{1,7}W{18,24}B{0,6}W{4,10}B{1,7}W{19,25}B{0,6}W{3,9}B{1,7}W{20,26}B{0,6}W{2,8}B{1,7}W{21,27}B{0,6}W{1,7}B{1,7}W{22,28}B{0,6}W{0,6}B{1,7}W{23,29}B{0,6}W{2,5}B{1,7}W{24,30}B{0,6}WB{3,9}W{23,29}B{8,14}W{22,28}B{3,9}WB{2,8}W{21,27}B{2,8}W{0,6}B{1,7}W{21,27}B{1,7}W{2,8}B{1,7}W{20,26}B{0,6}W{4,10}B{1,7}W{19,25}B{0,6}W{4,10}B{2,8}W{18,24}B{0,6}W{5,11}B{1,7}W{18,24}B{0,6}W{6,12}B{1,7}W{17,23}B{0,6}W{7,13}B{1,7}W{16,22}B{0,6}W{7,13}B{2,8}W{15,21}B{0,6}W{8,14}B{1,7}W{79,85}B*$",
        "^B*W{76,82}B{1,7}W{7,13}B{2,8}W{14,20}B{1,7}W{6,12}B{2,8}W{15,21}B{1,7}W{5,11}B{2,8}W{16,22}B{1,7}W{4,10}B{2,8}W{17,23}B{1,7}W{3,9}B{2,8}W{18,24}B{1,7}W{2,8}B{2,8}W{19,25}B{1,7}W{1,7}B{2,8}W{20,26}B{1,7}W{1,7}B{1,7}W{21,27}B{1,7}W{0,6}B{1,7}W{22,28}B{1,7}W{2,5}B{1,7}W{23,29}B{1,7}WB{3,9}W{22,28}B{8,14}W{22,28}B{4,10}WB{1,7}W{21,27}B{3,9}W{0,6}B{1,7}W{20,26}B{2,8}W{1,7}B{2,8}W{19,25}B{1,7}W{3,9}B{1,7}W{19,25}B{1,7}W{4,10}B{1,7}W{18,24}B{1,7}W{5,11}B{1,7}W{17,23}B{1,7}W{5,11}B{2,8}W{16,22}B{1,7}W{6,12}B{2,8}W{15,21}B{1,7}W{7,13}B{1,7}W{15,21}B{1,7}W{8,14}B{1,7}W{79,85}B*$",
        "^B*W{76,82}B{1,7}W{7,13}B{1,7}W{15,21}B{1,7}W{6,12}B{1,7}W{16,22}B{1,7}W{5,11}B{1,7}W{17,23}B{1,7}W{4,10}B{1,7}W{18,24}B{1,7}W{3,9}B{1,7}W{19,25}B{1,7}W{2,8}B{1,7}W{20,26}B{1,7}W{1,7}B{1,7}W{21,27}B{1,7}W{0,6}B{1,7}W{22,28}B{1,7}W{2,5}B{1,7}W{23,29}B{1,7}WB{2,8}W{23,29}B{7,13}W{23,29}B{8,14}W{22,28}B{9,15}W{21,27}B{3,9}W{2,5}B{2,8}W{20,26}B{2,8}W{1,7}B{1,7}W{20,26}B{1,7}W{3,9}B{1,7}W{19,25}B{1,7}W{3,9}B{2,8}W{18,24}B{1,7}W{4,10}B{2,8}W{17,23}B{1,7}W{5,11}B{1,7}W{17,23}B{1,7}W{6,12}B{1,7}W{16,22}B{1,7}W{6,12}B{2,8}W{15,21}B{1,7}W{7,13}B{2,8}W{79,85}B*$",
        "^B*W{75,81}B{1,7}W{7,13}B{2,8}W{14,20}B{1,7}W{6,12}B{2,8}W{15,21}B{1,7}W{5,11}B{2,8}W{16,22}B{1,7}W{4,10}B{2,8}W{17,23}B{1,7}W{4,10}B{1,7}W{18,24}B{1,7}W{3,9}B{1,7}W{19,25}B{1,7}W{2,8}B{1,7}W{20,26}B{1,7}W{1,7}B{1,7}W{21,27}B{1,7}W{0,6}B{1,7}W{22,28}B{1,7}W{2,5}B{1,7}W{23,29}B{1,7}WB{3,9}W{22,28}B{9,15}W{21,27}B{4,10}WB{1,7}W{21,27}B{3,9}W{0,6}B{1,7}W{20,26}B{2,8}W{1,7}B{2,8}W{19,25}B{1,7}W{3,9}B{2,8}W{18,24}B{1,7}W{4,10}B{1,7}W{18,24}B{1,7}W{5,11}B{1,7}W{17,23}B{1,7}W{5,11}B{2,8}W{16,22}B{1,7}W{6,12}B{2,8}W{15,21}B{1,7}W{7,13}B{2,8}W{14,20}B{1,7}W{8,14}B{1,7}W{80,86}B*$",
        "^B*W{32,38}BW{32,38}BW{4,10}B{1,7}W{7,13}B{1,7}W{7,13}BW{4,10}B{1,7}W{6,12}B{2,8}W{7,13}BW{4,10}B{1,7}W{5,11}B{2,8}W{8,14}BW{4,10}B{1,7}W{4,10}B{2,8}W{9,15}BW{4,10}B{1,7}W{3,9}B{2,8}W{10,16}BW{4,10}B{1,7}W{2,8}B{2,8}W{11,17}BW{4,10}B{1,7}W{1,7}B{2,8}W{12,18}BW{4,10}B{1,7}W{0,6}B{2,8}W{13,19}BW{4,10}B{1,7}W{0,5}B{2,8}W{14,20}BW{4,10}B{1,7}WB{2,8}W{15,21}BW{4,10}B{1,7}WB{3,9}W{14,20}BW{4,10}B{8,14}W{14,20}BW{4,10}B{4,10}WB{1,7}W{13,19}BW{4,10}B{3,9}W{0,5}B{2,8}W{12,18}BW{4,10}B{2,8}W{1,7}B{2,8}W{11,17}BW{4,10}B{1,7}W{3,9}B{1,7}W{11,17}BW{4,10}B{1,7}W{4,10}B{1,7}W{10,16}BW{4,10}B{1,7}W{4,10}B{2,8}W{9,15}BW{4,10}B{1,7}W{5,11}B{2,8}W{8,14}BW{4,10}B{1,7}W{6,12}B{1,7}W{8,14}BW{4,10}B{1,7}W{7,13}B{1,7}W{7,13}BW{4,10}B{1,7}W{7,13}B{2,8}W{6,12}BW{32,38}BW{32,38}B*$",
        "^B*W{77,83}B{1,7}W{7,13}B{1,7}W{15,21}B{1,7}W{6,12}B{2,8}W{15,21}B{1,7}W{5,11}B{2,8}W{16,22}B{1,7}W{4,10}B{2,8}W{17,23}B{1,7}W{3,9}B{2,8}W{18,24}B{1,7}W{2,8}B{2,8}W{19,25}B{1,7}W{1,7}B{2,8}W{20,26}B{1,7}W{0,6}B{2,8}W{21,27}B{1,7}W{0,5}B{2,8}W{22,28}B{1,7}WB{2,8}W{23,29}B{1,7}WB{3,9}W{22,28}B{8,14}W{22,28}B{4,10}WB{1,7}W{21,27}B{3,9}W{0,5}B{2,8}W{20,26}B{2,8}W{1,7}B{2,8}W{19,25}B{1,7}W{3,9}B{1,7}W{19,25}B{1,7}W{4,10}B{1,7}W{18,24}B{1,7}W{4,10}B{2,8}W{17,23}B{1,7}W{5,11}B{2,8}W{16,22}B{1,7}W{6,12}B{1,7}W{16,22}B{1,7}W{7,13}B{1,7}W{15,21}B{1,7}W{7,13}B{2,8}W{78,84}B*$",
        "^B*W{32,38}BW{32,38}BW{4,10}B{1,7}W{7,13}B{1,7}W{7,13}BW{4,10}B{1,7}W{6,12}B{1,7}W{8,14}BW{4,10}B{1,7}W{5,11}B{1,7}W{9,15}BW{4,10}B{1,7}W{4,10}B{1,7}W{10,16}BW{4,10}B{1,7}W{3,9}B{2,8}W{10,16}BW{4,10}B{1,7}W{2,8}B{2,8}W{11,17}BW{4,10}B{1,7}W{1,7}B{2,8}W{12,18}BW{4,10}B{1,7}W{1,7}B{1,7}W{13,19}BW{4,10}B{1,7}W{0,6}B{1,7}W{14,20}BW{4,10}B{1,7}W{0,5}B{1,7}W{15,21}BW{4,10}B{1,7}WB{2,8}W{15,21}BW{4,10}B{8,14}W{14,20}BW{4,10}B{4,10}WB{1,7}W{13,19}BW{4,10}B{3,9}W{0,6}B{1,7}W{12,18}BW{4,10}B{2,8}W{1,7}B{1,7}W{12,18}BW{4,10}B{1,7}W{3,9}B{1,7}W{11,17}BW{4,10}B{1,7}W{4,10}B{1,7}W{10,16}BW{4,10}B{1,7}W{5,11}B{1,7}W{9,15}BW{4,10}B{1,7}W{5,11}B{2,8}W{8,14}BW{4,10}B{1,7}W{6,12}B{1,7}W{8,14}BW{4,10}B{1,7}W{7,13}B{1,7}W{7,13}BW{4,10}B{1,7}W{8,14}B{1,7}W{6,12}BW{32,38}BW{32,38}B*$"
    ),
    ACE("A",
        "^B*W{82,88}B{1,7}W{29,35}B{1,7}W{28,34}B{3,9}W{27,33}B{3,9}W{27,33}B{4,10}W{25,31}B{0,6}W{2,5}B{0,6}W{25,31}B{0,6}W{2,5}B{1,7}W{23,29}B{1,7}W{0,6}B{0,6}W{23,29}B{0,6}W{1,7}B{0,6}W{22,28}B{1,7}W{1,7}B{1,7}W{21,27}B{0,6}W{3,9}B{0,6}W{20,26}B{1,7}W{3,9}B{1,7}W{19,25}B{0,6}W{5,11}B{0,6}W{19,25}B{12,18}W{17,23}B{13,19}W{17,23}B{13,19}W{16,22}B{15,21}W{15,21}B{0,6}W{9,15}B{0,6}W{14,20}B{1,7}W{9,15}B{1,7}W{13,19}B{0,6}W{11,17}B{0,6}W{12,18}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{79,85}B*$",
        "^B*W{117,123}B{1,7}W{29,35}B{1,7}W{28,34}B{3,9}W{27,33}B{3,9}W{26,32}B{5,11}W{25,31}B{0,6}WB{1,7}W{24,30}B{1,7}W{2,5}B{0,6}W{24,30}B{0,6}W{0,6}B{1,7}W{22,28}B{1,7}W{1,7}B{0,6}W{22,28}B{0,6}W{2,8}B{1,7}W{21,27}B{0,6}W{3,9}B{0,6}W{20,26}B{1,7}W{3,9}B{1,7}W{19,25}B{0,6}W{4,10}B{1,7}W{18,24}B{12,18}W{18,24}B{13,19}W{16,22}B{14,20}W{16,22}B{1,7}W{7,13}B{1,7}W{14,20}B{1,7}W{9,15}B{0,6}W{14,20}B{1,7}W{9,15}B{1,7}W{13,19}B{0,6}W{10,16}B{1,7}W{12,18}B{1,7}W{11,17}B{0,6}W{12,18}B{0,6}W{12,18}B{1,7}W{44,50}B*$",
        "^B*W{117,123}B{0,6}W{29,35}B{2,8}W{28,34}B{2,8}W{27,33}B{4,10}W{26,32}B{4,10}W{25,31}B{1,7}WB{1,7}W{24,30}B{0,6}W{2,5}B{1,7}W{24,30}B{0,6}W{0,6}B{0,6}W{23,29}B{0,6}W{1,7}B{1,7}W{22,28}B{0,6}W{2,8}B{0,6}W{21,27}B{1,7}W{2,8}B{1,7}W{20,26}B{0,6}W{4,10}B{0,6}W{19,25}B{1,7}W{4,10}B{1,7}W{18,24}B{12,18}W{17,23}B{13,19}W{17,23}B{14,20}W{16,22}B{0,6}W{8,14}B{0,6}W{15,21}B{1,7}W{8,14}B{1,7}W{14,20}B{0,6}W{10,16}B{0,6}W{13,19}B{1,7}W{10,16}B{1,7}W{12,18}B{0,6}W{11,17}B{1,7}W{11,17}B{1,7}W{12,18}B{0,6}W{45,51}B*$",
        "^B*W{116,122}B{1,7}W{29,35}B{1,7}W{28,34}B{3,9}W{27,33}B{3,9}W{26,32}B{5,11}W{25,31}B{0,6}W{2,5}B{0,6}W{25,31}B{0,6}W{2,5}B{1,7}W{23,29}B{0,6}W{0,6}B{1,7}W{23,29}B{0,6}W{1,7}B{0,6}W{22,28}B{1,7}W{1,7}B{1,7}W{21,27}B{0,6}W{3,9}B{0,6}W{20,26}B{1,7}W{3,9}B{1,7}W{19,25}B{0,6}W{5,11}B{0,6}W{18,24}B{13,19}W{17,23}B{13,19}W{17,23}B{13,19}W{16,22}B{1,7}W{7,13}B{1,7}W{15,21}B{0,6}W{9,15}B{0,6}W{14,20}B{1,7}W{9,15}B{1,7}W{13,19}B{0,6}W{11,17}B{0,6}W{12,18}B{1,7}W{11,17}B{1,7}W{11,17}B{0,6}W{12,18}B{1,7}W{45,51}B*$",
        "^B*W{81,87}B{1,7}W{29,35}B{2,8}W{27,33}B{3,9}W{27,33}B{3,9}W{27,33}B{4,10}W{25,31}B{1,7}WB{0,6}W{25,31}B{0,6}W{0,5}B{1,7}W{23,29}B{1,7}W{0,6}B{0,6}W{23,29}B{0,6}W{1,7}B{1,7}W{21,27}B{1,7}W{1,7}B{1,7}W{21,27}B{1,7}W{2,8}B{1,7}W{20,26}B{0,6}W{3,9}B{1,7}W{19,25}B{1,7}W{4,10}B{0,6}W{19,25}B{12,18}W{17,23}B{13,19}W{17,23}B{14,20}W{15,21}B{15,21}W{15,21}B{1,7}W{8,14}B{1,7}W{13,19}B{1,7}W{9,15}B{1,7}W{13,19}B{1,7}W{10,16}B{0,6}W{13,19}B{0,6}W{11,17}B{1,7}W{11,17}B{1,7}W{11,17}B{1,7}W{80,86}B*$"
    );

    /**
     * Card rank
     */
    private final String value;
    /**
     * Collection of card patterns
     */
    private final List<Pattern> patterns;

    /**
     * Card rank constructor by input parameters
     *
     * @param value    initial input {@link String} card rank
     * @param patterns initial input array of {@link String} card rank patterns
     */
    CardRank(final String value, final String... patterns) {
        this.value = value;
        this.patterns = Arrays.stream(patterns).map(Pattern::compile).collect(Collectors.toList());
    }

    /**
     * Returns {@link String} representation of card rank
     *
     * @return card rank display name
     */
    @Override
    public String toString() {
        return this.getValue();
    }

    /**
     * Returns rank {@link Pattern}s
     *
     * @return collection of rank card patterns
     */
    @Override
    public List<Pattern> getMask() {
        return this.getPatterns();
    }
}
