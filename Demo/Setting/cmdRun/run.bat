@echo off
set CLASSPATH=.;.\jar\dom4j-1.6.1.jar;.\jar\jaxen-1.1.1.jar;.\jar\log4j-1.2.16.jar;.\jar\Setting.jar;
echo %CLASSPATH%

java -Xmx256m org.jetsennet.Setting

echo 【按任意键退出】
pause>nul
exit
