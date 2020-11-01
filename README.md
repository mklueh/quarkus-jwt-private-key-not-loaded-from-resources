# Quarkus Reproducer for JWT privateKey.pem loading from resources issue 

This example is not functional and is meant to reproduce Issue https://github.com/quarkusio/quarkus/issues/13043

#### Version

* Quarkus 1.9.1.Final

#### Issue

Not able to load privateKey.pem from resources to sign JWTs.

Tried different approaches such as application.properties based loading with smallrye.jwt.sign.key-location