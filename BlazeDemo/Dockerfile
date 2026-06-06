FROM maven:3.9-eclipse-temurin-17

# Install Chromium and dependencies
RUN apt-get update && apt-get install -y \
    chromium-browser \
    chromium-driver \
    wget \
    && rm -rf /var/lib/apt/lists/*

# Set working directory
WORKDIR /app

# Copy source code
COPY . .

# Run Maven tests
CMD ["mvn", "test"]
