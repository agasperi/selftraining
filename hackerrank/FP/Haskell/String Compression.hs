import Data.List

compression:: [String] -> String
compression [] = []
compression (a:xs) = if length a == 1 then a!!0:(compression xs) else a!!0:((show (length a))++ compression xs)

main:: IO ()
main = do
    linea <- getLine
    putStrLn . compression $ group linea

-- Other Solution

import Data.List

formatGroup :: String -> String
formatGroup cs | length cs == 1 = [head cs]
               | otherwise      = head cs : (show . length) cs

compress :: String -> String
compress s = concatMap formatGroup $ group s

main = do
    s <- getLine
    putStrLn (compress s)

-- Other Solution

import Data.List

main :: IO ()
main = getContents >>= putStrLn. solve

solve msg = concat. map (\s -> stringify (head s) (length s)). group $msg
  where
    stringify ch n
      | n == 1    = [ch]
      | otherwise = [ch] ++ show n