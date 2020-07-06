#
# PARA USAR SNAPSHOTS:
# IMGFROM=vertigo/maven-ibmjava
# MVNPROFILE=-Pallow-snapshots
# PARA USAR APENAS RELEASES:
# IMGFROM=maven:3.6.0-jdk-8-alpine
# MVNPROFILE=
#
# Útil para novas versões das dependências do vtg-ipaas-java8-maven enquanto não forem RELEASE
#
ARG IMGFROM=maven:3.6.0-jdk-8-alpine
FROM $IMGFROM as builder
# repete para reusar
ARG IMGFROM
# outros build args
ARG MVNPROFILE=
# cache dependencies
WORKDIR /home/app
COPY ./function/pom.xml .
RUN mvn dependency:go-offline $MVNPROFILE
COPY ./function/ .
RUN echo "IMGFROM=$IMGFROM, MVNPROFILE=$MVNPROFILE" && \
    mvn clean package $MVNPROFILE

FROM openfaas/of-watchdog:0.7.6 as watchdog

FROM openjdk:11-jre-slim as ship

COPY --from=watchdog /fwatchdog /usr/bin/fwatchdog

RUN addgroup --system app \
    && adduser --system --ingroup app app \
    && mkdir -p /home/app/lib \
    && chmod +x /usr/bin/fwatchdog

WORKDIR /home/app
ARG MODE="http"
ARG EXECUTOR="multi"
ARG FPROCESS="java -XX:+UseContainerSupport -jar function.jar com.openfaas.function.Handler"
ARG UPSTREAM_URL="http://127.0.0.1:8082"
ARG artifactId=function
#ARG handlerClass=com.openfaas.function.Handler
COPY --from=builder /home/app/target/$artifactId-0.1.0-SNAPSHOT.jar ./function.jar
COPY --from=builder /home/app/target/lib/* ./lib/
RUN chown -R app /home/app && \
    ls -l *.jar && \
    ls -l lib/*.jar
USER app

ENV upstream_url="$UPSTREAM_URL"
ENV mode="$MODE"
ENV executor="$EXECUTOR"
ENV fprocess="$FPROCESS"
EXPOSE 8080

HEALTHCHECK --interval=2s CMD [ -e /tmp/.lock ] || exit 1

CMD ["fwatchdog"]
