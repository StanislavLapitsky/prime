# prime
Prime numbers investigations

Originally sieve of Eratosthenes requires a lot of memory. This algorithm is my attempt to limit the memory usage. 
In fact it requires ln(N) memory (for each found prime number we keep last crossed number).

Amount of operation (sum and compare) is limited by sequence
N/2 + N/3 + N/5 + N/7 .... + N/P<sub>k</sub> = O(N log log N) 

Algoritm is following:
Suppose we have some found prime numbers (the described algorithm starts from 2 and 3) sorted. For each prime number we store highest number we crossed with the prime. We introduce a prime candidate number = last found prime + 1 (in fact the algorithm can skip even numbers so we can use last found prime + 2).
Starting to check the candidate. For each found prime use the last crossed number and compare with the candidate. If the last crossed is less than the candidate increase the last crossed by the prime. If after next increasing candidate equals the last crossed then the candidate is not prime (can be divided by the current prime) and we should choose a new prime candidate (by increasing current candidate). And restart the algoritm.
If we jumped over the candidate and last crossed is bigger we use next prime and do the same checks with the last crossed of next prime.
If all the last crossed of each prime is bigger than candidate (jumped over the candidate) we found a new prime number.
The found prime is added to the found primes sequence and last crossed is set to the prime.
