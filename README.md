# Real-Time Application Status Monitor

## Features

- Real-time status monitoring of multiple applications.
- Uses WebSocket for real-time communication between the server and clients.
- Periodic status updates using Spring Boot's scheduling capabilities.
- Simple and responsive HTML page to display application statuses.
- Includes a refresh button and a loading indicator for better user experience.
- Timestamps in console logs for better tracking of events.

## Technologies Used

- Java Spring Boot
- WebSocket
- HTML, CSS, JavaScript
- Font Awesome (for icons)
- SLF4J and Logback (for logging)

### Usage
- The HTML page displays the status of multiple applications in a table format.
- The statuses are updated every 10 seconds.
- Click the refresh icon to manually refresh the status.
- The loading icon is displayed while the status is being updated.

### Prerequisites

- JDK 8 or higher
- Maven or Gradle
- A web browser
