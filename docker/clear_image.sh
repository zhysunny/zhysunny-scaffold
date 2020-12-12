#!/usr/bin/bash

# Author      : zhysunny
# Date        : 2020/12/12 14:00
# Description : TODO

docker image rm `docker images | grep -v "grep" | grep "<none>" | awk '{print $3}'`
