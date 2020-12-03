FROM openjdk:8u212-jdk-alpine3.9
ENV JAR_FILE_NAME zero-backend-client.jar
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.aliyun.com/g' /etc/apk/repositories && \
    apk add --no-cache  tzdata ttf-dejavu && \
    cp /usr/share/zoneinfo/Asia/Shanghai /etc/localtime && \
    echo "Asia/Shanghai" >  /etc/timezone && \
    apk del tzdata && \
    mkdir /app && \
    mkdir /config
EXPOSE 9010
ADD target/${JAR_FILE_NAME} /app/app.jar
WORKDIR /app
CMD java -jar -Xms256m -Xmx256m  app.jar
