sillycat-analyzer-java
======================

Analyzer the @username, URL and {smile}, {sad} ... emoticons.

Three types of contents from string

1. username  (maybe have a dictionary in DB, large number of usernames)

2. emoticons (a dictionary in DB, small number of emoticons)

3. URL       (can be any string following URL pattern)

Required
======================
JDK1.7+

MAVEN 3.2+

How to Run
======================

Run all the tests

>mvn clean test

Make the assembly Package

>mvn clean package

Run the Perf test

>java -jar target/analyzerjava-1.0-jar-with-dependencies.jar

==========================================

Single Regex Perf

Init the ENV in 1216 ms

First Analyzer Hero Test Done in 1397 ms

1000000 Analyzer Hero Test Done in 8437 ms

===========================================

==========================================

Separate Regex Perf

Init the ENV in 703 ms

First Analyzer Hero Test Done in 549 ms

1000000 Analyzer Hero Test Done in 9485 ms

===========================================

==========================================

DFA Perf

Init the ENV in 753 ms

First Analyzer Hero Test Done in 529 ms

1000000 Analyzer Hero Test Done in 9476 ms

===========================================

So I do not see any big performance changes based on the cases right now.

Short Term Plan
======================

Just provide a module to parse the string and fetch the title of URL, requirements are clear here.

1. Setup up Java MAVEN Spring environment to do this(Done)

2. JUnit to set up the function test cases(Done)

3. Junitperf to set up the performance test cases(Cancel)

4. Try Regex to get the all the 3 patterns to parse the string(Done)

5. Try jsoup to fetch the URL title(Done)

6. Try jackson to the JSON mapping(Done)

7. Enable Guava Cache to avoid fetch same URL(Done)

8. Almost functionally working, perf testing to get a baseline.

   1000000 Analyzer Hero Test Done in 8378 ms

9. (Optional) Try 3 separate Regex patterns to parse the string separately, Perf testing if we get better performance (Done)

10. (Optional) Try DFA(Deterministic Finite Automaton) to get the emoticons, Perf testing if we get better performance (Done)

Summary
======================

I do not see a big performance improvement between DFA and Regex. The feature time consuming is fetch the title from Remote HTTP 
Server, so I put a simple Guava cache there.

We can easily replace that implementation with other cache based on Spring configuration.


Long Term Plan(Not implement Now)
======================

If this really go to prod, we may need to provide a server side API. (TODO, we not do that until the requirement is clear)

1. provider REST API on api servers(for example, 2 api servers)

2. provider akka actors to do parsing work on parsing servers(if parsing is CPU consuming, 4 parsing servers)

3. provider akka actors to do URL fetch(2 fetching servers)

4. provider 4 memcached servers to cache the URL resources

Using scala gatling tool to do perf testing to find the bottleneck and other things, add servers into it if we really need.

