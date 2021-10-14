module Main where

    import Data.List

    raizEntera n e = truncate ((fromIntegral n) ** (1 / (fromIntegral e)))
    
    potencias:: Int -> Int -> [Int]
    potencias n e = map (\x -> x^e) $ takeWhile (<= raizEntera n e) [1..]

    sumaPotencias:: Int -> Int -> [Int] -> [Int]
    sumaPotencias n a la = sort $ a:(filter (<=n) (map (+ a) la)) ++ la

    sumOfPower:: Int -> [Int] -> [Int]
    sumOfPower n lp = sumOfPower' n (tail lp) [(head lp)] []
        where
            sumOfPower' 1 _ _ _ = [1]
            sumOfPower' _ [] sp ln = ln
            sumOfPower' n' lp' sp ln =
                let
                    actual = head lp'
                    listaSumas = sumaPotencias n' actual sp
                    listaLimpia = (takeWhile (<n') listaSumas)
                    listaN = dropWhile (<n') listaSumas
                in sumOfPower' n' (tail lp') listaLimpia (ln ++ listaN)

    main:: IO ()
    main = do
        num <- readLn
        exp <- readLn
        print . length $ sumOfPower num (potencias num exp) 