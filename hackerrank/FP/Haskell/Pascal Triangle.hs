module Main where

factorial :: Integral a => a -> a
factorial n = factorial' n 1
    where
        factorial' 0 acc = acc
        factorial' n acc = factorial' (n-1) (n*acc)

coeficiente :: Integral a => a -> a -> a
coeficiente fila columna = (factorial fila) `div` ((factorial columna) * (factorial(fila - columna)))

filaCoeficientes::  Integral a => a -> [a]
filaCoeficientes n = filaCoeficientes' n n []
    where
        filaCoeficientes' _ 0 coeficientes = coeficientes
        filaCoeficientes' n c coeficientes = filaCoeficientes' n (c-1) ((coeficiente (n-1) (c-1)):coeficientes)

trianguloPascal :: Integral a => a -> [[a]]
trianguloPascal n = trianguloPascal' n []
    where
        trianguloPascal' 0 filaPascal = filaPascal
        trianguloPascal' n filaPascal = trianguloPascal' (n - 1) ((filaCoeficientes n):filaPascal)

showRow :: (Integral a, Show a) => a -> [a] -> String
showRow x [] = show x
showRow x (y:ys) = show x ++ " " ++ (showRow y ys)

showTrianguloPascal :: (Integral a, Show a) => [[a]] -> IO ()
showTrianguloPascal [] = putStr ""
showTrianguloPascal ((y:ys):xs) = do
    putStrLn (showRow y ys)
    showTrianguloPascal xs

main :: IO ()
main = do
    input <- getLine
    showTrianguloPascal . trianguloPascal . (read :: String -> Int) $ input


-- Other solution

mapM_ putStrLn (map (\x -> unwords (map show x)) result)