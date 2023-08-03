import pytest


@pytest.fixture
def numberslist():
    list = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    return list


def test_verifysum(numberslist):
    sum = 0
    for i in numberslist:
        sum += i
    assert sum == 55
