lengthPrefijo :: String -> String -> Int
lengthPrefijo x y = lengthPrefijo' x y 0
    where
        lengthPrefijo' [] _ p = p
        lengthPrefijo' _ [] p = p
        lengthPrefijo' (x':xs) (y':ys) p =  if x' == y' then lengthPrefijo' xs ys (p+1) else p

main:: IO ()
main = do
    x <- getLine
    y <- getLine
    let pos = lengthPrefijo x y
        p = take pos x
        x' = drop pos x
        y' = drop pos y
    putStrLn $ (show . length) p ++ " " ++ p
    putStrLn $ (show . length) x' ++ " " ++ x'
    putStrLn $ (show . length) y' ++ " " ++ y'

-- Other Solution

main :: IO ()
main = getContents >>= putStrLn. solve. lines

solve [a, b] =
  unlines [   show (length p) ++ " " ++ p
    , show (length x) ++ " " ++ x
    , show (length y) ++ " " ++ y
  ]
  where
    (p, x, y) = compress a b
    aLen = length a
    bLen = length b

compress :: String -> String -> (String, String, String)
compress [] [] = ([], [], [])
compress xs [] = ([], xs, [])
compress [] xs = ([], [], xs)
compress (x:xs) (y:ys)
  | x /= y     = ([], x:xs, y:ys)
  | otherwise  =
      let (p, a, b) = compress xs ys
      in  (x:p, a, b)