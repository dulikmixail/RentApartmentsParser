FROM dulikmixail/java8
ENV JAVA_VER 8
ENV JAVA_HOME /usr/lib/jvm/java-8-oracle
RUN ./mvnw clean install
