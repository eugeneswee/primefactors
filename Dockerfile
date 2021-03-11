FROM openjdk:11-jdk
COPY PrimeFactors.java .
RUN javac PrimeFactors.java
CMD java PrimeFactors
