# Base OS layer
# docker build -t container_tag --build-arg IMAGE_SOURCE=openjdk IMAGE_TAG=latest IMAGE_DIR=images .

ARG IMAGE_SOURCE=openjdk
ARG IMAGE_TAG=latest

FROM ${IMAGE_SOURCE}:${IMAGE_TAG}

RUN groupadd spring && useradd -m -g spring -s /bin/bash spring
USER spring:spring

VOLUME /tmp

LABEL org.opencontainers.image.title="BrainShells.OpenImageCV"
LABEL org.opencontainers.image.description="BrainShells Open Image recognition application"
LABEL org.opencontainers.image.vendor="BrainShells, Inc."
LABEL org.opencontainers.image.version="1.0"

# The application's jar file
ARG JAR_FILE
# The application's image directory
ARG IMAGE_DIR=images

# Add the application's jar to the container
ADD ${JAR_FILE} /opt/app/io.brainshells.api-openimagecv-processor.jar
ADD ./entrypoint.sh /opt/app/entrypoint.sh
ADD ${IMAGE_DIR} /opt/app/images

# Set workdir inside container
WORKDIR /opt/app

# Expose service default port
EXPOSE 8080

# General environment options
ENV TERM xterm

# Run service process
ENTRYPOINT [ "./entrypoint.sh" ]
CMD ["OpenImageCV container started"]
