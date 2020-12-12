#!/usr/bin/bash

# Author      : zhysunny
# Date        : 2020/12/12 13:22
# Description : build

if [[ $# -ne 1 && $# -ne 2 ]]; then
    echo "sh `basename $0` (version) (profile)"
    exit 1
fi

docker build -t scaffold:$1 ./ --build-arg APP_VERSION=$1 --build-arg PROFILE=${2:dev}
exit 0
