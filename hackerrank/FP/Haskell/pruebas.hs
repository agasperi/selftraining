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