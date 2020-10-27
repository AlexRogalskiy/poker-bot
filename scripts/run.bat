@echo off

SetLocal
rem java path
IF ["%JAVA_HOME%"] EQU [""] (
	set JAVA=java
) ELSE (
	set JAVA="%JAVA_HOME%/bin/javaw"
)

rem java web service application options
set JAVA_OPTS=-Xms1024m -Xmx1024m

rem java web service application options
set JAVA_COMMAND=-jar ../modules/openimagecv-processor/.build/bin/io.brainshells.api.openimagecv.processor/io.brainshells.api-openimagecv-processor-0.1.0-SNAPSHOT.jar

rem java web service startup
start %JAVA% %JAVA_OPTS% %JAVA_COMMAND% %* 1>log.txt 2>err.txt
EndLocal
