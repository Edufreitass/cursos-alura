# Dockerfile baseado no comando -> docker run -d -p 8080:3000 -v "$(pwd):/var/www" -w "/var/www" node npm start
FROM node:latest
LABEL maintainer="Eduardo Freitas"
ENV NODE_ENV=production
ENV PORT=3000
COPY . /var/www
WORKDIR /var/www
RUN npm install
ENTRYPOINT [ "npm", "start" ]
EXPOSE $PORT
