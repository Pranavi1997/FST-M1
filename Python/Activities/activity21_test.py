import pytest

def test_addition():
    x = 10
    y = 34
    sum = x + y
    assert sum == 44

def test_subtraction():
    x = 25
    y = 12
    difference = x - y
    assert difference == 13
def test_multiplication():
    x = 9
    y = 12
    product = x * y
    assert product == 108

def test_division():
    x = 200
    y = 5
    num = x / y 
    assert num == 40 
