import pytest


@pytest.fixture
def walletamount():
    amount = 0
    return amount


@pytest.mark.parametrize("earned, spent,expected", [(30, 10, 20), (20, 2, 18)])
def test_multiplication_11(walletamount, earned, spent, expected):
    # I add {earned} units of cash to the wallet,
    walletamount += earned
    # I spend {spent} units of cash, and
    walletamount -= spent
    # I add {earned} units of cash to the wallet,
    assert walletamount == expected
