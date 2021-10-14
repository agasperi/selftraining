maximum' :: (Ord a) => [a]-> a
maximum' [] = error "maximum of empty list"
maximum' [x] = x
maximum' (x:xs)
    | x > maxTail = x
    | otherwise = maxTail
    where maxTail = maximum' xs

maximum2 :: (Ord a) => [a]-> a
maximum2 [] = error "maximum of empty list"
maximum2 [x] = x
maximum2 (x:xs) = max x (maximum2 xs)

replicate' :: (Num i, Ord i) => i -> a -> [a]
replicate' n x
    | n <= 0 = []
    | otherwise = x:replicate' (n - 1) x

replicar :: (Num i, Ord i) => i -> String -> [String]
replicar n msg
    | n <= 0 = []
    | otherwise = msg:replicar (n - 1) msg

tomar :: (Num i, Ord i) => i -> [a] -> [a]
tomar n _
    | n <= 0 = []
tomar _ [] = []
tomar n (x:xs) = x: tomar (n-1) xs

reversar :: [a] -> [a]
reversar [] = []
reversar (x:xs) = reversar xs ++ [x]

repetir :: a -> [a]
repetir x = x: repetir x

zip' :: [a] -> [b] -> [(a,b)]
zip' _ [] = []
zip' [] _ = []
zip' (x:xs) (y:ys) = (x,y):zip' xs ys

elem' :: (Eq a) => a -> [a] -> Bool
elem' a [] = False
elem' a (x:xs)
    | a ==x = True
    | otherwise = a `elem'`xs

quicksort :: (Ord a) => [a] -> [a]
quicksort [] = []
quicksort (x:xs) =
    let smallerSorted = quicksort [a | a <- xs, a <= x]
        biggerSorted = quicksort [a | a <- xs, a > x]
    in smallerSorted ++ [x] ++ biggerSorted