#!/bin/bash
mvn compile
mvn package
mvn install:install-file -Dfile=target/MultiChainJavaAPI-0.4.11-SNAPSHOT.jar -DgroupId=com.multichainjavaapi -DartifactId=MultiChainJavaAPI -Dversion=0.4.11
mvn install:install-file -Dfile=target/MultiChainJavaAPI-0.4.11-SNAPSHOT-jar-with-dependencies.jar -DgroupId=com.multichainjavaapi -DartifactId=MultiChainJavaAPI -Dversion=0.4.11-full
