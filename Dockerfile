# Use Ubuntu Focal as the base image
FROM ubuntu:focal

# Set environment variables
ENV COSIGN_EXPERIMENTAL=1

# Install necessary packages
RUN apt-get update && apt-get install -y \
    ruby \
    docker.io \
    # Add other packages as needed
    && rm -rf /var/lib/apt/lists/*

# Copy your application code
COPY . /app

# Set working directory
WORKDIR /app

# Example of running a script or command
CMD ["echo", "Hello, world!"]
