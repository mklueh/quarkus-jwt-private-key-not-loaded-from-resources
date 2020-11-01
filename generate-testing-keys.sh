ssh-keygen -t rsa -P "" -b 4096 -m PEM -f src/main/resources/META-INF/resources/privateKey.pem
ssh-keygen -e -m PEM -f jwtRS256.key > src/main/resources/META-INF/resources/publicKey.pem
cp src/main/resources/META-INF/resources/privateKey.pem src/test/resources/META-INF/resources/privateKey.pem
cp src/main/resources/META-INF/resources/publicKey.pem src/test/resources/META-INF/resources/publicKey.pem