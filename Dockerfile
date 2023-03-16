FROM openjdk:11

ENV SBT_VERSION 1.8.2
RUN curl -L -o sbt-$SBT_VERSION.zip https://github.com/sbt/sbt/releases/download/v$SBT_VERSION/sbt-$SBT_VERSION.zip
RUN unzip sbt-$SBT_VERSION.zip -d ops

WORKDIR enfore

ADD . /enfore

EXPOSE 9000 9000

ENTRYPOINT ["/ops/sbt/bin/sbt", "run"]