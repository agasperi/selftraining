module Main where

import Data.List

linea:: Int -> Int -> String
linea numeroLinea profundidad = rayitas ++ unos ++ rayitas
    where 
        unos = replicate (numeroLinea*2 - 1) '1';
        rayitas = replicate (profundidad - numeroLinea) '_';

triangulo:: Int -> [String]       
triangulo p = triangulo' p []
    where 
        triangulo' 0 t = t;
        triangulo' l t = triangulo' (l - 1 ) ((linea l p) : t);

sierpinski:: Int -> Int -> Int -> [String]
sierpinski 0 i p = triangulo (2 ^ (p - i))
sierpinski n i p = map ((space ++) . (++ space)) down ++
                   map (concat . intersperse "_" . replicate 2) down
    where
        down = sierpinski (n - 1) i p;
        space = replicate (2 ^ (n - 1)*(2 ^ (p - i))) '_';

main:: IO ()
main = do
    input <- getLine
    let iteracion = (read :: String -> Int) $ input
    mapM_ putStrLn $ sierpinski iteracion iteracion 5
