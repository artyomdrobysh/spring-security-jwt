# spring-security-jwt

Application is built using Spring Boot, Spring Security, OAuth2.

## Certs
private key: openssl genrsa -out <location>/<name>.pem 2048
<br>
public key: openssl rsa -in <location>/<name>.pem -pubout -outform PEM -out <location>/<name>.pem
