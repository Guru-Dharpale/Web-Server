# Multi-Threaded Client-Server Communication in Java  

A simple Java project demonstrating **socket programming** and **multi-threading** by handling multiple client requests concurrently.  

## **Features**  
- **Server:**  
  - Listens on port `8080` and handles each client in a **separate thread**.  
  - Responds with _"Hello from server"_ upon receiving a message.  
- **Client:**  
  - Connects to the server and sends _"Hello from client"_.  
  - Supports **100 concurrent threads** (simulated in `main()`).  

## **Tech Stack**  
- **Core Java** (Sockets, Threads, I/O Streams)  
- **Concurrency** (Handling multiple clients without blocking)  

## **How to Run**  
1. Start the server:  
   ```sh
   javac Server.java && java Server