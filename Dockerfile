### STAGE 1: Build ###
FROM node:16.13.0-alpine AS build
WORKDIR /usr/src/app
COPY package.json package-lock.json ./
RUN npm install
COPY . .
RUN npm run build
RUN npm run test -- --no-watch --no-progress --browsers=ChromeHeadlessCI
### STAGE 2: Run ###
FROM nginx:alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build /usr/src/app/dist/vista /usr/share/nginx/html
