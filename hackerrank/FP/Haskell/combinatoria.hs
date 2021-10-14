combinatoriaR :: [[a]] -> [[a]] -> [[a]]
combinatoriaR [] [] = []
combinatoriaR [] bs = bs
combinatoriaR as bs = combinatoria as bs

combinatoriaL :: [[a]] -> [[a]] -> [[a]]
combinatoriaL [] [] = []
combinatoriaL as [] = as
combinatoriaL as bs = combinatoria as bs

combinatoria :: [[a]] -> [[a]] -> [[a]]
combinatoria as bs = [a ++ b | a <- as, b <- bs]