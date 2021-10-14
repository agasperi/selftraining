f :: [Int] -> [Int]
f lst
    | length lst < 2 = []
f (x:xs) = take 1 xs ++ f (drop 1 xs)

-- This part deals with the Input and Output and can be used as it is. Do not modify it.
main = do
	inputdata <- getContents
	mapM_ (putStrLn. show). f. map read. lines $ inputdata
	
-- Other Solutions
f [] = []
f (x:xs) = (head xs) : f (tail xs)