import Data.List

combinatoria :: [a] -> [[a]] -> [[a]]
combinatoria as bs = [as ++ b | b <- bs]

raizEntera n e = truncate ((fromIntegral n) ** (1 / (fromIntegral e)))
powRaizEntera n e = (raizEntera n e)^e
modRaiz n e = n - (powRaizEntera n e)

hsp:: Int -> Int -> Int -> [Int]
hsp n e r = sort $ hsp' n e r []
    where
        hsp' 1 _ _ l = 1:l
        hsp' n' e' r' l =
            let 
                mr = n' - r'^e'
            in  if r' < 2 || r' `elem` l
                then []
                else
                    if mr == 0
                    then r':l
                    else hsp' mr e' (raizEntera mr e') (r':l)

hspr:: Int -> Int -> Int -> [Int] -> [[Int]] -> [[Int]]
hspr n e r l lt = hspr' (combinatoria l (hspt (modRaiz n e) e r l)) lt
    where
        hspr' [] lt' = lt'
        hspr' c lt' = c ++ lt'

hspt:: Int -> Int -> Int -> [Int] -> [[Int]]
hspt n e r l = hspt' n e r l []
    where
        hspt' 0 _ _ _ _ = []
        hspt' _ _ 1 [] lt' = lt'
        hspt' _ _ 1 l lt' = l:lt'
        hspt' n' e' r' [] lt' = hspt' n' e' (r'-1) (hsp n' e' (r'-1)) (hspr n' e' r' [r'] lt')
        hspt' n' e' r' l' lt' = hspt' n' e' (r'-1) (hsp n' e' (r'-1)) (l':(hspr n' e' r' [r'] lt'))

tsp:: Int -> Int -> [[Int]]
tsp n e =
    let raiz = raizEntera n e
    in hspt n e raiz (hsp n e raiz)

main:: IO ()
main = do
    linea <- getLine
    let num :: Int
        num = read linea
    linea <- getLine
    let potencia :: Int
        potencia = read linea
--    linea <- getLine
--    let raiz :: Int
--        raiz = read linea
--    putStrLn . show . length $ hsp num potencia raiz
    mapM_ putStrLn . map (show) $ tsp num potencia
--    mapM_ putStrLn . map (show) $ hsp num potencia
--    putStrLn . show . length $ hallaSumaPotencias num potencia
--    putStrLn . show $ buscaTodasSumas num potencia
--    putStrLn . show . length $ evaluaRaiz num potencia (raizEntera num potencia)
