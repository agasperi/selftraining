import Text.Printf (printf)

f :: (Integral a, Fractional b) => [a] -> [a] -> b -> b
f as bs x = sum (zipWith (\ae be -> (fromIntegral ae) * (x^^be)) as bs)

pedazos :: Int -> Int -> [Int] -> [Int] -> [Double]
pedazos l r a b = map (f a b) [lb, lb + step .. rb]
    where
        step = 0.001
        lb = fromIntegral l
        rb = fromIntegral r

area :: Int -> Int -> [Int] -> [Int] -> Double
area l r a b = sum (map ((*) step) (pedazos l r a b))
    where step = 0.001 :: Double

volumen :: Int -> Int -> [Int] -> [Int] -> Double
volumen l r a b = sum (map (\x -> pi * x ^ 2 * step) (pedazos l r a b))
    where step = 0.001 :: Double

-- This function should return a list [area, volume].
solve :: Int -> Int -> [Int] -> [Int] -> [Double]
solve l r a b = [area l r a b, volumen l r a b]

--Input/Output.
main :: IO ()
main = getContents >>= mapM_ (printf "%.1f\n"). (\[a, b, [l, r]] -> solve l r a b). map (map read. words). lines