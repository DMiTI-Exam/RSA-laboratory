import math


class RSA:
    def __init__(self, p, q):
        self.set_prime_factors(p, q)
        self.get_e()
        self.get_d()

    def set_prime_factors(self, p, q):
        self.n = p * q
        self.phi_n = (p - 1) * (q - 1)

    def get_e(self, upper_bound = 50):
        for e in range(3, upper_bound):
            if math.gcd(e, self.phi_n) == 1:
                self.e = e
                break
        else:
            raise ValueError('"e" impossible to find!')

    def get_d(self):
        k = 2
        while (self.phi_n * k + 1) % self.e != 0:
            k += 1
        self.d = (self.phi_n * k + 1) // self.e

    @staticmethod
    def modular_pow(base, index_n, modulus):
        c = 1
        for _ in range(index_n):
            c = (c * base) % modulus
        return c
    
    def encrypt(self, message):
        if message < self.n:
            #encrypt_message = message ** self.e % self.n
            encrypt_message = self.modular_pow(message, self.e, self.n)
        else:
            raise ValueError('message must be less then "n"')
        return encrypt_message

    def decrypt(self, message):
        #decrypt_message = message ** self.d % self.n
        decrypt_message = self.modular_pow(message, self.d, self.n)
        return decrypt_message


if __name__ == '__main__':
    rsa = RSA(9973, 8929)
    normal_message = 34500000
    message_1 = rsa.encrypt(normal_message)
    message_2 = rsa.decrypt(message_1)
    print(normal_message, message_1, message_2)