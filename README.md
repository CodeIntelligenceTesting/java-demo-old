# Simple Java Demo

This simple Java project showcases two vulnerabilities - a SQL injection and a RCE. Although these have been distilled into simple examples they were inspired by two real CVEs that were detected.

You will be able see the two vulnerabilities that CI Fuzz detected and step into the code directly to see the underlying cause. The fixed branch is re-fuzzed and the vulnerabilities are resolved.

Inspired by:
 - SQL Injection: https://nvd.nist.gov/vuln/detail/CVE-2022-24124
 - RCE: https://cve.mitre.org/cgi-bin/cvename.cgi?name=CVE-2015-3253

Example of running SqlInjectionFuzzer with a dictionary

```
cifuzz run --interactive=false --dict=./sql.dict com.example.SqlInjectionFuzzer
```