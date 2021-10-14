import Data.List

main:: IO ()
main = interact solucion

solucion:: String -> String
solucion = nub . map (\s -> head s) . group

-- Other solution

main =
    getLine >>=
    putStrLn. reduce
  
  reduce :: String -> String
  reduce str = foldl (\acc ch -> if ch `elem` acc then acc else acc ++ [ch]) [] str