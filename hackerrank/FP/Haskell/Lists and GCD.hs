module Main where

    import Data.List

    write:: [Int] -> String
    write = unwords . map show
    
    tupleArrayToArray:: [(Int,Int)] -> [Int]
    tupleArrayToArray [] = []
    tupleArrayToArray (x:xs) = (fst x):(snd x):(tupleArrayToArray xs)

    splitArrayTuples:: [(Int,Int)] -> [[(Int,Int)]]
    splitArrayTuples [] = []
    splitArrayTuples (x:xs) = splitArrayTuples' xs (fst x) [x] []
        where
            splitArrayTuples' [] x' ls  t = ls:t
            splitArrayTuples' (y':ys') x' ls t =
                if x' == (fst y')
                then splitArrayTuples' ys' x' (y':ls) t
                else splitArrayTuples' ys' (fst y') [y'] (ls:t)
    
    filtrar:: Int -> [[(Int,Int)]]  -> [(Int,Int)]
    filtrar n ls = map (last) $ filter (\x -> length x == n) ls

    arrayToTuple:: [Int] -> [(Int,Int)]
    arrayToTuple [] = []
    arrayToTuple (x:y:xs) = (x,y):(arrayToTuple xs)

    listGdc:: [[(Int,Int)]] -> [(Int,Int)]
    listGdc xs = sort $ listGdc' xs []
        where
            listGdc' [] g = g
            listGdc' (x:xs) g = listGdc' xs (x ++ g)

    translate:: [[Int]] -> [[(Int,Int)]]
    translate [] = []
    translate (x:xs) = (arrayToTuple x):(translate xs)

    parse:: [String] -> [[Int]]
    parse = map (map (read :: String ->Int) . words)

    main:: IO ()
    main = do
        numCasos <- readLn
        interact $ write . tupleArrayToArray . sort . filtrar numCasos . splitArrayTuples. listGdc . translate . parse . lines

-- Other Solution

import Text.Printf
import Control.Applicative

main :: IO ()
main = do
    con <- map (map read. words). lines <$> getContents
    let facts = map getFactors (tail con)
        ans = foldl1 merge facts
    mapM_ (uncurry (printf "%d %d ")) ans

getFactors :: [Int] -> [(Int, Int)]
getFactors [] = []
getFactors (x:y:xs) = (x, y): getFactors xs

merge :: (Ord a, Ord b) => [(a, b)] -> [(a, b)] -> [(a, b)]
merge [] _ = []
merge _ [] = []
merge xxs@((x, xp):xs) yys@((y, yp):ys)
    | x < y  = merge xs yys
    | x > y  = merge xxs ys
    | x == y = (x, min xp yp): merge xs ys

-- Other Solution

import qualified Data.Map.Strict as M;
import Control.Monad;

buildList [] = []
buildList (x:y:xs) = (x, y) : buildList xs

backToList [] = []
backToList ((k,v):xs) = [k, v] ++ (backToList xs)

buildMap :: Ord a => [a] -> M.Map a a
buildMap = M.fromList . buildList 

-- Other Solution

main = do
  n <- read <$> getLine :: IO Int
  lines <- map (map read . words) <$> replicateM n getLine :: IO [[Int]]
  let
    maps = map buildMap lines
    res = foldr (M.intersectionWith min) (head maps) maps
  putStrLn . unwords . map show . backToList . M.toList $ res


  newList :: [Int] -> [(Int,Int)]
  newList list = zip (evenList list)  (oddList list)
                    where
                          oddList (x:y:xs) = y: oddList xs
                          oddList _ =[]
                          evenList list = oddList (1:list) 
  solve :: [[Int]] -> [(Int,Int)]
  solve list = foldl step (head iList) iList 
              where 
                    iList = map newList list
                    step x@(i:is) y = (comp i y) ++ (step is y)
                    step _ y = []
                    comp i@(x1,x2) ((y1,y2):ys) | x1 == y1 = if x2 < y2 then [(y1,x2)] else [(y1,y2)]
                                            | otherwise = comp i ys
                    comp i _ = [] 
  iToList ((x1,x2):xs) = (show x1) ++" "++ (show x2) ++ " " ++ (iToList xs)
  iToList _ = ""  
  main = getContents >>=  putStrLn.iToList.solve.tail.(map (map read)).(map words).lines