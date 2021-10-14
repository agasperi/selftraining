import Control.Monad

distancia :: [Int] -> [Int] -> Float
distancia x y = sqrt $ fromIntegral ((((y!!0) - (x!!0 ))^2) + (((y!!1) - (x!!1))^2))

perimetro :: [[Int]] -> Float
perimetro (x:xs)
    | length xs == 1 = (distancia x (xs!!0))
    | otherwise = (distancia x (head xs)) + (perimetro xs)

main :: IO ()
main = do
    line <- getLine
    let numPuntos :: Int
        numPuntos = read line
    poligono <- forM [1..numPuntos] (\a -> do
        linea <- getLine
        let vertice = map (read :: String -> Int) (words linea)
        return vertice
        )
    putStrLn $ show (perimetro (poligono ++ [poligono!!0]))

-- Other solutions
--1
perimeter ls = sum [distance p q | (p, q) <- (zipW . makeCircular . zipV) ls]


distance :: (Int, Int) -> (Int, Int) -> Double
distance (x, y) (u, v) = sqrt (fromIntegral ((x - u)^2 + (y - v)^2)) 


zipV :: [a] -> [(a, a)]
zipV [] = []
zipV (x:y:ls) = ((x, y):(zipV ls))


zipW :: [a] -> [(a, a)]
zipW (x:ls) = zip (x:ls) ls


makeCircular :: [a] -> [a]
makeCircular ls = [last ls] ++ ls


main :: IO ()
main = do
    _ <- getLine
    x <- getContents
    let f = map (read::String->Int) $ words x
    print (perimeter f)

--2
main = interact $ show . perimiter . getPairs . map (read :: String -> Float) . tail . words


perimiter :: [(Float, Float)] -> Float
perimiter xs = sum [distanceBetween (xs !! (n+1)) (xs !! n) | n <- [0..((length xs) - 2)]]
                                + distanceBetween (head xs) (last xs)


distanceBetween :: (Float, Float) -> (Float, Float) -> Float
distanceBetween (a, b) (c, d) = sqrt $ (a-c)^2 + (b-d)^2

getPairs :: [Float] -> [(Float, Float)]
getPairs (x:y:[]) = [(x, y)]
getPairs (x:y:xs) =  (x, y) : getPairs xs