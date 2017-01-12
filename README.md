# Movierp-server
API REST and persistence layer for Movierp

# Tech stack

It's made using the following technologies:

* Spring boot
* Spring Rest
* Spring JPA
* Maven

# Architecture

```
-com.movierp.server
    - cinema
         UserService
         UserController
         UserDAO
         User
    - movie
         Movie
         MovieController
         MovieService
         MovieDAO
```

http://stackoverflow.com/questions/19284417/how-to-define-package-structure-for-a-spring-rest-mvc-application

https://www.youtube.com/watch?v=tEm0USdF-70