FROM nodered/node-red:latest-minimal
WORKDIR /data
COPY function/ .
RUN yarn install
HEALTHCHECK --interval=3s CMD ["curl","http://localhost:8080/_/health"]
EXPOSE 8080
CMD ["yarn","start"]
