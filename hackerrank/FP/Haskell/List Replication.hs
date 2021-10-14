f :: Int -> [Int] -> [Int]
f _ [] = []
f 0 _ = []
f n (x:xs) = [x] ++ f (n-1) [x] ++ f n xs

-- This part handles the Input and Output and can be used as it is. Do not modify this part.
main :: IO ()
main = getContents >>=
       mapM_ print. (\(n:arr) -> f n arr). map read. words

Other answers
f n arr = do
    [num | num <- arr , a <- [1..n]]

f n arr = concatMap (\num -> replicate n num) arr