# Eventing Switchlist Application

This Spring Boot application provides a framework for message processing using RabbitMQ.

## Key Features

* **Message-driven:** Processes messages received from a RabbitMQ queue named "eventing-switchlist".
* **Flexible Logging:**  Uses a `SystemLogger` interface for log output (current implementation logs to the console).
* **Timing:** Includes a `StopWatchWrapper` to track the processing time of messages.
* **Scalable:** Supports multiple `MessageReceiver` instances for concurrent message handling.

## Getting Started

### Prerequisites

* Java Development Kit (JDK) version 8 or later
* RabbitMQ message broker
* A build tool like Maven or Gradle (Spring Boot works with either)

### Setup

1. Clone this repository.
2. Configure RabbitMQ connection details (if not already done within the application).
3. Implement the core message processing logic within the `SleepWorker` class.
4. Build the project using your build tool.
5. Run the built executable.

## Usage

Once the application is running, send messages to the "eventing-switchlist" RabbitMQ queue. The application will receive, process, and log information about each message.

## Customization

* **Logging:** To customize logging, implement the `SystemLogger` interface and provide your own bean definition.
* **Stopwatch:** Employ a different stopwatch implementation by replacing the `SystemStopWatch` bean.
* **Message Handling:** Extend or modify the `MessageReceiver` class to adjust how messages are processed.

## Project Structure

* **src/main/java/com/softwareascraft/eventingswitchlist**
    * **configuration**: Contains Spring Boot configuration classes
    * **logging**: The `SystemLogger` interface and implementations
    * **receivers**: Contains the `MessageReceiver` class
    * **wrappers**:  Classes for `StopWatchWrapper`
* **src/main/resources**
    * **application.properties (or application.yml)**: Spring Boot configuration file

## License

This project is licensed under **the MIT License**
