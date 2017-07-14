primes = [2, 3]
last_crossed = [2, 3]


def add_next_prime():
    candidate = primes[-1] + 2
    i = 0
    while i < len(primes):
        while last_crossed[i] < candidate:
            last_crossed[i] += primes[i]
        if last_crossed[i] == candidate:
            candidate += 2
            i = 0
        i += 1

    primes.append(candidate)
    last_crossed.append(candidate)


def fill_primes(n):
    while len(primes) < n:
        add_next_prime()


fill_primes(1000)
print(primes)
