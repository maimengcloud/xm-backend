#!/bin/bash
######################################################################################
###          xm  starter
###          cyc 20190221
###
###
#####################################################################################
cd ..


SERVICE_NAME=xm
MVERSION=M
SVERSION="2.0.0-RELEASE"
PROFILES=prod

echo "将启动${SERVICE_NAME} 主版本${MVERSION} 子版本号${SVERSION} 配置文件${PROFILES}"

if [ ! -d "./start-service/pid" ];then
  mkdir ./start-service/pid
fi

# 清理进程
if [ -f "./start-service/pid/${SERVICE_NAME}.pid" ];then
	PID=$(cat "./start-service/pid/${SERVICE_NAME}.pid")
	kill -9 ${PID}
	echo "成功停止服务${SERVICE_NAME}"
fi


# 执行启动程序
echo "启动服务${SERVICE_NAME}"

JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64

# 单体应用
nohup ${JAVA_HOME}/bin/java -server -Xms512m -Xmx512m -Dfile.encoding=UTF-8 -jar ./lib/${SERVICE_NAME}-bootstrap-${SVERSION}.jar --spring.profiles.active=${PROFILES} >/dev/null 2>&1 &

# cloud应用
#nohup ${JAVA_HOME}/bin/java -server -Xms512m -Xmx512m -Dfile.encoding=UTF-8 -jar ./lib/${SERVICE_NAME}-cloud-bootstrap-${SVERSION}.jar --spring.profiles.active=${PROFILES} >/dev/null 2>&1 &

# 记录进程号
echo $! > ./start-service/pid/${SERVICE_NAME}.pid

echo "启动服务成功!!!!!!!! pid $!"
