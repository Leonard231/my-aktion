FROM airhacks/glassfish
COPY ./target/my-aktion.war ${DEPLOYMENT_DIR}
