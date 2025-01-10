## Security Components
The application implements several layers of security: Transport Layer Security (TLS/SSL), End-to-end message encryption, Message integrity verification, Protection against common web vulnerabilities, Secure session management, Protection against replay attacks

### Authentication Flow
- Username/password validation
- Session token generation
- Authorization verification

### Encryption Process
- Key generation and exchange
- Message encryption/decryption
- MAC generation and verification

### Data Storage
- Encrypted message storage
- Secure user credential storage
- Session management

## Technologies Used
- Spring Boot 3.2.1
- Spring Security
- Spring WebSocket
- Java Cryptography Extension (JCE)
- H2 Database
- Thymeleaf
- SockJS and STOMP

## Future Enhancements
Implementation of perfect forward secrecy, addition of file sharing capabilities, support for group chats with secure key distribution, integration with external authentication providers, enhanced audit logging and monitoring
