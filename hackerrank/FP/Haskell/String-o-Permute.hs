intercambiar:: String -> String
intercambiar [] = []
intercambiar (x:y:xs) = y:x:(intercambiar xs)

casos :: Int -> IO ()
casos n
    | n == 0 = return ()
    | otherwise = do
        linea <- getLine
        putStrLn $ intercambiar linea
        casos (n-1)
            

main:: IO ()
main = do
    linea <- getLine
    let numCasos :: Int
        numCasos = read linea
    casos numCasos

-- Other Solution

main :: IO()
main =  fmap (tail. lines) getContents >>= mapM_ (putStrLn. solve)

solve :: String -> String
solve [] = []
solve (a:b:rest) = b:a: solve rest