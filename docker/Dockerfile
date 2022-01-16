FROM centos7/java:1.0.1
MAINTAINER zhysunny
USER root

ARG BASE_DIR=/opt/zhysunny
WORKDIR ${BASE_DIR}

ARG APP_NAME=scaffold
ARG APP_VERSION=1.0.0
ARG APP_ROOT=${BASE_DIR}/${APP_NAME}
ARG PROFILE=dev
ARG PROCESS_NAME=com.zhysunny.ApplicationMain
ARG PACKAGE_NAME=${APP_NAME}-${APP_VERSION}.tar.gz

ENV APP_NAME=${APP_NAME} \
    APP_VERSION=${APP_VERSION} \
    APP_ROOT=${APP_ROOT} \
    PROFILE=${PROFILE} \
    PROCESS_NAME=${PROCESS_NAME}

ADD ${PACKAGE_NAME} ${APP_ROOT}

RUN mv ${APP_ROOT}/entrypoint.sh ${BASE_DIR}/entrypoint.sh \
    && chmod 777 ${BASE_DIR}/entrypoint.sh

CMD [ "bash", "-c", "/opt/zhysunny/entrypoint.sh" ]