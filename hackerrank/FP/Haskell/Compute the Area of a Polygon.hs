import Control.Monad

avgArea :: (Int, Int) -> (Int,Int) -> Float
avgArea (x,y) (w,z) =  fromIntegral (x - w) * ((fromIntegral (y + z)) / 2.0)

area :: [(Int,Int)] ->  Float
area (x:xs)
    | length xs == 1 = avgArea x (xs !! 0)
    | otherwise = (avgArea x (head xs)) + (area xs)

arrayToTuple :: [a] -> (a,a)
arrayToTuple [x,y] = (x,y)

main :: IO()
main = do
    line <- getLine
    let numPuntos :: Int
        numPuntos = read line
    poligono <- forM[1..numPuntos](\a -> do
        linea <- getLine
        let vertice = arrayToTuple $ map (read :: String -> Int) (words linea)
        return vertice
        )
    putStrLn $ show (area (poligono ++ [poligono!!0]))


-- Other solutions

-- 1
sol :: Fractional a => [[a]] -> a
sol ps = (/2) . abs . sum $ zipWith op ps (last ps: ps)
    where
    op p q = head p*last q - last p*head q

-- 2
import Control.Monad

areaOfPolygon :: (Eq a, Floating a) => [(a,a)] -> a
areaOfPolygon points
  | points == [] = 0.0
  | otherwise = let shiftedPoints = [points] >>= (\x -> tail x ++ [head x])
                    areas = zipWith (\(x1,y1) (x2,y2) -> (x1*y2 - x2*y1)/2) points shiftedPoints
                in sum $ areas

main :: IO ()
main = do
    _ <- getLine
    inputdata <- getContents
    let input = [(read (words str !! 0) :: Float, read (words str !! 1) :: Float ) | str <- lines inputdata]
    print $ areaOfPolygon input