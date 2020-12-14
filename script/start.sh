#!/usr/bin/bash

# Author      : zhysunny
# Date        : 2020/12/12 12:57
# Description : start

JAVA_OPTS="${JAVA_OPTS} -Xmx256m -Xms256m -Xmn128m"
JAVA_OPTS="${JAVA_OPTS} -Xdebug -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=30080"
JAVA_OPTS="${JAVA_OPTS} -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:${APP_ROOT}/logs/gc.${APP_NAME}.log"
JAVA_OPTS="${JAVA_OPTS} -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${APP_ROOT}/logs/${APP_NAME}.hprof"
JAVA_OPTS="${JAVA_OPTS} -Djava.ext.dirs=${APP_ROOT}:${APP_ROOT}/lib:${JAVA_HOME}/jre/lib/ext"
JAVA_OPTS="${JAVA_OPTS} -Dprofile=${PROFILE}"
JAVA_OPTS="${JAVA_OPTS} -Dlog.dir=${APP_ROOT}"

${JAVA_HOME}/bin/java ${JAVA_OPTS} ${PROCESS_NAME} 1 > /dev/null 2 > ${APP_ROOT}/logs/out.log &
