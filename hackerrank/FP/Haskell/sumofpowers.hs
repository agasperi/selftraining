module Main where

    import Data.List
    
    raizEntera n e = truncate ((fromIntegral n) ** (1 / (fromIntegral e)))
    
    potencias:: Int -> Int -> [Int]
    potencias n e = map (\x -> x^e) $ takeWhile (<= raizEntera n e) [1..]
    
    sumaPotencias:: Int ->  [Int] -> Int
    sumaPotencias _ [] = 0
    sumaPotencias 1 _ = 1
    sumaPotencias n lr =
        let restoRaiz = n - (last lr)
        in  if restoRaiz == 0
            then 1
            else
                if restoRaiz < 0
                then sumaPotencias n (init lr)
                else sumaPotencias restoRaiz (init lr)
    
    sumOfPowers::Int ->  [Int] -> Int
    sumOfPowers _ [] = 0
    sumOfPowers n lr = (sumaPotencias n lr) + (sumOfPowers n (init lr))
    
    main:: IO ()
    main = do
        num <- readLn
        exp <- readLn
        putStrLn . show $ potencias num exp
    --    display $ mapaDePotencias num exp
    --    print $ sumaPotencias num (potencias num exp)
        print $ sumOfPowers num (potencias num exp)
    --   print (sumOfPowers num exp)