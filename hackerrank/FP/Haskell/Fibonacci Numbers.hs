--Contributed by Ron Watkins
module Main where

fib n = fibo n 0 1
    where
        fibo 1 a b = a
        fibo n a b = fibo (n-1) b (a + b)


-- This part is related to the Input/Output and can be used as it is
-- Do not modify it
main = do
    input <- getLine
    print . fib . (read :: String -> Int) $ input
