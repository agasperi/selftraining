module Main where

    import Data.List

    filterElements:: [Int] -> Int -> [Int]
    filterElements l k =
        let
            n = nub l
            m = map (head) . filter (\x -> length x >= k) . group $ sort l
        in n `intersect` m

    muestraResultado:: [Int] -> IO ()
    muestraResultado [] = putStrLn "-1"
    muestraResultado xs = putStrLn . unwords $ map (show) xs

    procesaCasos:: Int -> IO ()
    procesaCasos 0 = return ()
    procesaCasos c = do
        n_k <- getLine
        a_i <- getLine
        let
            defCaso = map (read:: String -> Int) $ words n_k
            n = head defCaso
            k = last defCaso
            a = take n $ map (read:: String -> Int) $ words a_i
        muestraResultado $ filterElements a k
        procesaCasos (c - 1)

    main:: IO ()
    main = do
        numCasos <- readLn
        procesaCasos numCasos

-- Other Solution

import Data.List(sort, group, nub)

parse :: [String] -> [[Int]]
parse = map (map (read :: String ->Int) . words) . drop 1

translate :: [[Int]] -> [(Int,[Int])]
translate [] = []
translate ((_:a:[]):b:xs) = (a,b):(translate xs)

write :: [Int] -> String
write [] = "-1"
write xs = unwords . map show $ xs

valid :: Int -> [Int] -> [Int]
valid n = map fst .filter (\(_,a)->a >=n) .map (\l@(a:as)->(a, length l)) .group .sort

filter' :: (Int, [Int]) -> [Int]
filter' (n, xs) = nub . filter (flip elem $ v) $ xs
    where v = valid n xs

main = interact $ unlines . map write . map filter' . translate . parse . lines