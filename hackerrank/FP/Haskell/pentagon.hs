module Main where

    import Data.Function
    import Data.Array

    penNumNemo::[Int] -> [Int]
    penNumNemo = map (memoized_pNumber)
--    penNumNemo = map (fix (memoize . pentagonalNumber))
    
    parse :: [String] -> [Int]
    parse = map (read :: String ->Int) . drop 1
    
    memoize:: (Int -> a) -> (Int -> a)
    memoize f = (map f [0 ..] !!)
    
    pentagonalNumber:: (Int -> Int) -> Int -> Int
    pentagonalNumber f 1 = 1
    pentagonalNumber f n = 4 + (3*(n-2)) + f (n - 1)

    memoized_pNumber:: Int -> Int
    memoized_pNumber = (map pNumber [0 ..] !!)
        where
            pNumber 1 = 1
            pNumber n = 4 + (3*(n-2)) + memoized_pNumber (n - 1)

    pnMemo:: Int -> Int
    pnMemo = fix (memoize . pentagonalNumber)

    pnMemo2::[Int]->[Int]
    pnMemo2 x = x
        where
            maxMemo = maximum x
            memoArray = (1,maxMemo)

    main:: IO ()
    main = do
        interact $ unlines.
                   map show.
--                   map pnMemo.
--                   map (read :: String -> Int).
                   pnMemo2.
                   parse.
--                   drop 1.
                   lines