FROM nodered/node-red:latest-12-minimal

# Copy package.json to the WORKDIR so npm builds all
# of your added nodes modules for Node-RED
COPY function/package.json .
RUN npm install --unsafe-perm --no-update-notifier --no-fund --only=production

# Copy _your_ Node-RED project files into place
# NOTE: This will only work if you DO NOT later mount /data as an external volume.
#       If you need to use an external volume for persistence then
#       copy your settings and flows files to that volume instead.
COPY function/settings.js /data/settings.js
COPY function/flow_cred.json /data/flow_cred.json
COPY function/flow.json /data/flow.json

# Disabled Nodered editor
ENV DISABLE_EDITOR=true

HEALTHCHECK --interval=3s CMD ["curl","http://localhost:8080/_/health"]
EXPOSE 8080
