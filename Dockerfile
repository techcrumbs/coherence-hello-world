FROM ghcr.io/oracle/coherence-ce:23.03.0

WORKDIR /app
COPY target/coherence-hello-world.jar /app/
COPY src/main/resources/tangosol-coherence-override.xml /app/

ENV JAVA_OPTS="\
  -Dtangosol.coherence.log.level=9"


CMD ["sh", "-c", "java $JAVA_OPTS -jar coherence-hello-world.jar"]
