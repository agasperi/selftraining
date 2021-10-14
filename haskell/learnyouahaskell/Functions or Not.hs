esParValido :: [Int] -> [[Int]] -> Bool
esParValido _ [] = True
esParValido p (x:xs) =
    if ((p !! 0) == (x !! 0)) && ((p !! 1) /= (x !! 1))
    then False
    else esParValido p xs;

lineas :: Bool -> Int -> [[Int]] -> IO ()
lineas b l p
    | l == 0 = if b then putStrLn "YES" else putStrLn "NO"
    | b == False = do
        linea <- getLine
        lineas b (l-1) [];
    | (length p) == 0 = do
        linea <- getLine
        let parActual = map (read :: String -> Int) (words linea)
        lineas b (l-1) (parActual : p)
    | otherwise = do
        linea <- getLine
        let parActual = map (read :: String -> Int) (words linea)
        if esParValido parActual p
        then lineas b (l-1) (parActual : p)
        else lineas False (l-1) (parActual : p);

casos :: Int -> IO ()
casos n
    | n == 0 = return ()
    | otherwise = do
        line <- getLine
        let numberLine :: Int
            numberLine = read line
        lineas True numberLine []
        casos (n-1);

main :: IO ()
main = do 
    line <- getLine
    let numberCases :: Int
        numberCases = read line
    casos numberCases
