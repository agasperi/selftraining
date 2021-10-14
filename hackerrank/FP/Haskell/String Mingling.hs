import Data.List

main:: IO ()
main = do
    pawelString <- getLine
    shakaString <- getLine
    putStrLn . concat $ transpose [pawelString , shakaString]

-- Other Solution

main :: IO ()
main = getContents >>= putStrLn. (\[p, q] -> solve p q). lines

solve :: String -> String -> String
solve [] [] = []
solve (x:xs) (y:ys) = x:y: solve xs ys