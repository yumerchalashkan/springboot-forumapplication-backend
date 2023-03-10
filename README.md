# Spring Boot Forum Application Back-end

A web-based forum application developed using Spring Boot as the primary framework. The system allows users to register and log in, and once logged in they can create and interact with posts by liking or commenting on them. The application is divided into two parts: the back-end and the front-end.

## Demo
https://incomparable-pasca-ecfd16.netlify.app/

## Back-end
The back-end is implemented as a RESTful API, with a layered architecture comprising of entities, repositories, data transfer objects (DTOs), services, and controllers. This architecture allows for efficient processing of REST API requests and data manipulation with a database. The authentication and authorization of users is handled by Spring Security, which utilizes JSON Web Tokens (JWT) for secure communication.

## Front-end
The front-end is built using React, a JavaScript library for building user interfaces. It makes use of Material-UI library for some icons and uses Fetch API to send requests to the back-end and receive data to be displayed to the user.<br />
[Front-end](https://github.com/yumerchalashkan/springboot-forumapplication-frontend)


## Deployment
The application was deployed using Docker and Kubernetes to different cloud providers. This allows for easy scaling and management of the application in a production environment.

## How to run the application
1. Clone the repository
2. Build and run the back-end application using Spring Boot
3. Build and run the front-end application using npm or yarn
4. The application can be accessed at http://localhost:3000
