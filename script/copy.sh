#!/usr/bin/bash

# Author      : zhysunny
# Date        : 2020/12/12 12:57
# Description : 复制工程

local_path=`dirname $0`
path=`cd ${local_path}/../;pwd`

name=$1
if [[ -z ${name} ]]; then
    echo "Usage: sh copy.sh [name]"
    exit 1
fi

project_name="zhysunny-${name}"
cd ${path}/../
cp -r ${path} ${project_name}

cd ${project_name}
rm -rf .idea
rm -rf .git
rm -rf *.iml

sed -i 's/scaffold/'${name}'/g' docker/*
sed -i 's/scaffold/'${name}'/g' src/main/resources/application.yml
sed -i 's/scaffold/'${name}'/g' pom.xml