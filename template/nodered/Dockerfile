FROM node:alpine

RUN mkdir -p /data
RUN apk install curl

# Add non root user
RUN addgroup -S app && adduser app -S -G app
RUN chown app /data

WORKDIR /data
USER app
COPY . .
RUN yarn install
#RUN yarn start
# Populate example here - i.e. "cat", "sha512sum" or "node index.js"

#ENV fprocess="node node_modules/pm2/bin/pm2 start 'yarn start'"
#ENV fprocess="yarn svc"
#ENV fprocess="yarn start"
#Set to true to see request in function logs
#ENV write_debug="true"
#ENV mode="http"
#ENV upstream_url="http://127.0.0.1:1880"
#ENV cgi_headers="true"

#HEALTHCHECK --interval=3s CMD [ -e /tmp/.lock ] || exit 1
HEALTHCHECK --interval=3s CMD ["curl","http://localhost:8080/_/health"]

EXPOSE 8080

#CMD ["fwatchdog"]
CMD ["yarn","start"]
