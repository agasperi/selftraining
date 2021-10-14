f :: (Integral a) => [a] -> a
f [] = 0
f (x:xs)
    | x `rem` 2 /= 0 = x + f xs
    | otherwise = f xs

-- This part handles the Input/Output and can be used as it is. Do not change or modify it.
main = do
	inputdata <- getContents
	putStrLn $ show $ f $ map (read :: String -> Int) $ lines inputdata

-- Other Solutions
f arr = sum (filter odd arr)
-- OR --
f = sum . filter odd
-- or --
f arr = sum [ x | x <- arr, odd x ]