FROM ghcr.io/graalvm/graalvm-ce:ol8-java17

WORKDIR /app
COPY target/coherence-hello-world-1.0-SNAPSHOT.jar /app/
COPY src/main/resources/tangosol-coherence-override.xml /app/

ENV JAVA_OPTS="\
  -Dtangosol.coherence.log.level=9"


CMD ["sh", "-c", "java $JAVA_OPTS -jar coherence-hello-world-1.0-SNAPSHOT.jar"]
