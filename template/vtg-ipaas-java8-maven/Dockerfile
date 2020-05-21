FROM maven:3.6.0-jdk-8-alpine as builder
COPY . /home/app/
WORKDIR /home/app
RUN  mvn clean package

FROM openfaas/of-watchdog:0.7.6 as watchdog

FROM openjdk:8-jre-slim as ship

COPY --from=watchdog /fwatchdog /usr/bin/fwatchdog

RUN addgroup --system app \
    && adduser --system --ingroup app app \
    && mkdir -p /home/app/lib \
    && chmod +x /usr/bin/fwatchdog

WORKDIR /home/app
ARG artifactId=function
ARG handlerClass=com.openfaas.function.Handler
COPY --from=builder /home/app/target/$artifactId-0.1.0-SNAPSHOT.jar ./function.jar
COPY --from=builder /home/app/target/lib/* ./lib/
RUN chown -R app /home/app
USER app
ENV upstream_url="http://127.0.0.1:8082"
ENV mode="http"
ENV fprocess="java -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap -jar function.jar $handlerClass"
EXPOSE 8080

HEALTHCHECK --interval=2s CMD [ -e /tmp/.lock ] || exit 1

CMD ["fwatchdog"]
