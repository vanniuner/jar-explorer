
## Introduction

This is a desktop Swing application which will recursively scan a directory and index a large number of jar files
all at once. It then allows to explore individual jar files or search all jar files at the same time.
It provides a number of views for resources: class - specific, shows all class information:
interfaces, super class, methods, fields, as well as views for text, HTML, images.

## Installation

You need to have Java 1.4 or higher.
Download the file: [jarexplorer-0.7.jar](https://github.com/javalite/jar-explorer/releases/download/v0.7/jarexplorer-0.7.jar)
and execute the following command:

    java -jar jarexplorer-0.7.jar

## Command Usage
    command:

    -jar jarexplorer-0.8-dev.jar YOUR_JAR_PATH SEARCH

    the output:

    java -jar jarexplorer-0.8-dev-jar-with-dependencies.jar gateway-service.jar Application
    org.springframework.web.context.support.WebApplicationObjectSupport → spring-web-5.2.4.RELEASE.jar
    org.springframework.context.support.AbstractXmlApplicationContext → spring-context-5.2.4.RELEASE.jar
    org.springframework.boot.context.config.DelegatingApplicationListener → spring-boot-2.2.5.RELEASE.jar

## Configuration

Almost nothing to configure. There is one property file:

    .JarExplorer.properties

This file contains a property:

    zip.extensions=jar,zip,war,ear,rar

You can add other file extensions here, as long as the files themselves are in zip format.

## Screen Shot

![jar-explorer.jpg](https://raw.githubusercontent.com/javalite/jar-explorer/master/src/main/resources/jar-explorer.jpg)

add 1

add 3
