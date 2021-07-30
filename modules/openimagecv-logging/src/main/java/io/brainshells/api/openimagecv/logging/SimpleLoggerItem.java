package io.brainshells.api.openimagecv.logging;

import java.util.ArrayList;

/**
 * Logger item
 *
 * @author biezhi
 * @date 2018/3/28
 */
public class SimpleLoggerItem {

    String logFileName = "";
    String logPath = "";
    String lastWriteDate = "";
    long size = 0;
    long nextWriteTime = 0;
    long cacheSize = 0;
    char currLogBuff = 'A';

    final ArrayList<StringBuffer> alLogBufA = new ArrayList<>();
    final ArrayList<StringBuffer> alLogBufB = new ArrayList<>();
}
