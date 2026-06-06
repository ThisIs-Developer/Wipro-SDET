FROM maven:3.9.11-eclipse-temurin-21

# Install dependencies
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    unzip \
    curl

# Add Google Chrome repository
RUN wget -q -O - https://dl.google.com/linux/linux_signing_key.pub | \
    gpg --dearmor -o /usr/share/keyrings/google-chrome.gpg

RUN echo "deb [arch=amd64 signed-by=/usr/share/keyrings/google-chrome.gpg] \
    http://dl.google.com/linux/chrome/deb/ stable main" \
    > /etc/apt/sources.list.d/google-chrome.list

# Install Chrome and ChromeDriver
RUN apt-get update && apt-get install -y \
    google-chrome-stable \
    chromium-driver

# Set Chrome binary path for Selenium Manager (optional, helps Selenium find Chrome)
ENV CHROME_BIN=/usr/bin/google-chrome \
    CHROMEDRIVER_PATH=/usr/bin/chromedriver

WORKDIR /app

COPY . .

RUN mvn clean install -DskipTests

CMD ["mvn", "test"]
