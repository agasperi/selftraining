import Data.Array

wonderous :: Integer -> Integer
wonderous 1 = 0
wonderous x
    | even x    = 1 + wonderous (x `div` 2)
    | otherwise = 1 + wonderous (3*x+1)

wonderous2 :: Integer -> Integer
wonderous2 x
    | x <= maxMemo = memoArray ! x
    | otherwise    = wonderous2' x
    where
        maxMemo = 100
        memoArray = array (1,maxMemo)
            [ (x, wonderous2' x) | x <- [1..maxMemo] ]
        wonderous2' 1 = 0
        wonderous2' x
            | even x    = 1 + wonderous2 (x `div` 2)
            | otherwise = 1 + wonderous2' (3*x+1)