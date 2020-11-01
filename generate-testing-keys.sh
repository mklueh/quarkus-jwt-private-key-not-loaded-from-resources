mkdir -p src/main/resources/META-INF/resources

ssh-keygen -t rsa -P "" -b 4096 -m PEM -f src/main/resources/privateKey.pem
ssh-keygen -e -m PEM -f src/main/resources/privateKey.pem > src/main/resources/META-INF/resources/publicKey.pem

mkdir -p src/test/resources/META-INF/resources

cp src/main/resources/privateKey.pem src/test/resources/privateKey.pem
cp src/main/resources/META-INF/resources/publicKey.pem src/test/resources/META-INF/resources/publicKey.pem
