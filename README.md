# prime
Prime numbers investigations

Originally sieve of Eratosthenes requires a lot of memory. This algorithm is my attempt to limit the memory usage. 
In fact it requires ln(N) memory (for each found prime number we keep last crossed number).

Amount of operation (sum and compare) is limited by sequence
N/2 + N/3 + N/5 + N/7 .... + N/P<sub>k</sub> = O(N log log N) 
