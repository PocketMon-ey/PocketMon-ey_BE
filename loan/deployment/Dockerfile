FROM node:alpine
COPY package.json .
RUN [ "npm", "install" ]
COPY . .
EXPOSE 10004
CMD [ "npm", "start" ]
