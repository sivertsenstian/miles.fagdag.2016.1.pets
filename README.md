# pets

A [re-frame](https://github.com/Day8/re-frame) application designed to show cats!
Demonstration for Miles Fagdag. Introduction to Clojure / ClojurScript

## Development Mode

### Run application:

```
lein clean
lein figwheel dev
```

Figwheel will automatically push cljs changes to the browser.

Wait a bit, then browse to [http://localhost:3449](http://localhost:3449).

## Production Build


To compile clojurescript to javascript:

```
lein clean
lein cljsbuild once min
```

## Run in Docker

Compile production build, before building and running the Docker image:

```
docker build -t pets .
docker run -d -p 80:80 --name pets pets
```

Navigate to [http://localhost/pets](http://localhost/pets). 
