# Scala Study Group #

## Build & Run ##

```sh
$ cd Scala_Study_Group
$ ./sbt
> container:start
> browse
```

If `browse` doesn't launch your browser, manually open [http://localhost:8080/](http://localhost:8080/) in your browser.

## Automatic code reloading ##

To automatically recompile & reload code when it's saved, run the following

```sh
$ cd Scala_Study_Group
$ ./sbt
> ~ ;copy-resources;aux-compile
```
