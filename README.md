sillycat-analyzer-java
======================

Analyzer the @username, URL and {smile}, {sad} ... emoticons.

Three types of contents from string

1. username  (maybe have a dictionary in DB, large number of usernames)

2. emoticons (a dictionary in DB, small number of emoticons)

3. URL       (can be any string following URL pattern)



Short Term Plan

Just provide a module to parse this function, requirement is clear here.

1. Setup up Java MAVEN Spring environment to do this

2. JUnit to set up the function test cases

3. Junitperf to set up the performance test cases

4. Try Regex to get the all the 3 patterns to parse the string

5. Try jsoup to fetch the URL title

6. Enable Guava Cache to avoid fetch same URL

7. Almost functionally working, perf testing to get a baseline.

7. (Optional) Try 3 separate Regex patterns to parse the string separately, Perf testing if we get better performance

8. (Optional) Try DFA(Deterministic Finite Automaton) to get the emoticons, Perf testing if we get better performance


Long Term Plan

If this really go to prod, we may need to provide a server side API. (TODO, we not do that until the requirement is clear)

1. provider REST API on api servers(for example, 2 api servers)

2. provider akka actors to do parsing work on parsing servers(if parsing is CPU consuming, 4 parsing servers)

3. provider akka actors to do URL fetch(2 fetching servers)

4. provider 4 memcached servers to cache the URL resources

Using scala gatling tool to do perf testing to find the bottleneck and other things, add servers into it if we really need.

