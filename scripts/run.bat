@echo off

SetLocal
rem java path
IF ["%JAVA_HOME%"] EQU [""] (
	set JAVA=java
) ELSE (
	set JAVA="%JAVA_HOME%/bin/java"
)

rem java application options
set JAVA_OPTS=-Xms1024m -Xmx1024m

rem java application command
set JAVA_COMMAND=-jar ../modules/openimagecv-processor/.build/bin/io.brainshells.api.openimagecv.processor/io.brainshells.api-openimagecv-processor-0.1.0-SNAPSHOT-jar-with-dependencies.jar

rem java application startup
%JAVA% %JAVA_OPTS% %JAVA_COMMAND% %* 2>err.txt
EndLocal
