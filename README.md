## Log V3 Thinking
### Question
- If you use the `TraceIdHolder` field, you won't need to add a parameter and can develop a clean log chaser. Now, imagine that you publish this log chaser on REAL service:
Is there any problem with that?
1. `concurrency` issue
 The `FieldLogTrace` is a spring bean adopted as a Singleton. In other word, this instance of the object exists only once.
If multiple threads access to the `traceIdHolder`, which also exists only once, a problem may occur.
This is very common and harmful issue for programmers.