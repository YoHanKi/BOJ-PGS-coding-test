import math

def solution(w,h):
    total = w * h
    sub = w + h - math.gcd(w, h)
    return total - sub