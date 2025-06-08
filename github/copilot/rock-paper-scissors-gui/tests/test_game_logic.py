import unittest
from src.game_logic import determine_winner

class TestGameLogic(unittest.TestCase):

    def test_user_wins(self):
        self.assertEqual(determine_winner('rock', 'scissors'), 'user')

    def test_computer_wins(self):
        self.assertEqual(determine_winner('scissors', 'rock'), 'computer')

    def test_tie(self):
        self.assertEqual(determine_winner('paper', 'paper'), 'tie')

if __name__ == '__main__':
    unittest.main()