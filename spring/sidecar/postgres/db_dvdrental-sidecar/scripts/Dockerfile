FROM asimio/db_dvdrental:latest
MAINTAINER Orlando L Otero ootero@asimio.net, https://bitbucket.org/asimio/postgres
# Manually build using command: docker build -t asimio/db_dvdrental-sidecar:latest .
# Install JDK
RUN \
  mkdir -p /usr/lib && \
  wget https://download.java.net/openjdk/jdk8u40/ri/openjdk-8u40-b25-linux-x64-10_feb_2015.tar.gz  && \
  tar -zxf openjdk-8u40-b25-linux-x64-10_feb_2015.tar.gz -C /usr/lib && \
  ln -s /usr/lib/openjdk-8u40-b25 /usr/lib/jdk && \
  chown -R root:root /usr/lib/openjdk-8u40-b25 && \
  rm openjdk-8u40-b25-linux-x64-10_feb_2015.tar.gz  
ENV JAVA_HOME="/usr/lib/openjdk-8u40-b25"
ENV PATH="$JAVA_HOME/bin:$PATH"
ENV JAVA_TOOL_OPTIONS="-Xms256M -Xmx256M -Djava.awt.headless=true -Djava.security.egd=file:/dev/./urandom"
COPY scripts/sidecar.jar /opt/asimio-cloud/sidecar.jar
ADD scripts/sidecar.sh /docker-entrypoint-initdb.d/
RUN chmod 755 /docker-entrypoint-initdb.d/sidecar.sh