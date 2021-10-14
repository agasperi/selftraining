module Main where

    import Data.List

    incDecLetra:: Char -> Char -> Char -> Int -> Int
    incDecLetra x a b acc =
        if x == a
        then acc + 1
        else if x == b
             then acc - 1
             else acc;

    equals:: String -> Char -> Char -> Bool
    equals xs a b =
        let
            contador = foldl (\acc x -> incDecLetra x a b acc) 0 xs
        in if contador == 0 then True else False
    
    diffPrefix:: String -> Char -> Char -> Bool
    diffPrefix xs a b =
        let
            contador = scanl (\acc x -> incDecLetra x a b acc) 0 xs
            buscaDiff = find (\x -> x < -1 || x > 1) contador
        in if buscaDiff == Nothing then True else False

    procesaLinea:: Int -> IO ()
    procesaLinea 1 = do
        linea  <- getLine
        putStrLn . show $ (equals linea 'R' 'G') && (equals linea 'Y' 'B') && (diffPrefix linea 'R' 'G') && (diffPrefix linea 'Y' 'B')
    procesaLinea n = do
        linea <- getLine
        putStrLn . show $ (equals linea 'R' 'G') && (equals linea 'Y' 'B') && (diffPrefix linea 'R' 'G') && (diffPrefix linea 'Y' 'B')
        procesaLinea (n-1)

    main:: IO ()
    main = do
        numLineas <- readLn
        procesaLinea numLineas

-- Other solutions

import Text.Printf                           -- printf "%0.6f" (1.0)

main :: IO ()
main = getContents >>= mapM_ (print. (\x -> parse x 0 0)). tail. lines

parse [] rg yb =
  rg == 0 && yb == 0
parse (x:xs) rg yb
  | abs rg > 1 = False
  | abs yb > 1 = False
  | x == 'R' = parse xs (rg+1) yb
  | x == 'G' = parse xs (rg-1) yb
  | x == 'Y' = parse xs rg     (yb+1)
  | x == 'B' = parse xs rg     (yb-1)