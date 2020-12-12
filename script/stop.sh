#!/usr/bin/bash

# Author      : zhysunny
# Date        : 2020/12/12 12:57
# Description : stop

if [[ -f ${APP_ROOT}/${APP_NAME}.pid ]]; then
    kill $(ps -ef | grep -v "grep" | grep ${PROCESS_NAME} | awk '{print $2}')
else
    echo "${APP_ROOT}/${APP_NAME}.pid file is not found"
fi
