main = do {
    inp <- getLine;
    printOften (length inp) inp;
}

printOften :: Int -> String -> IO ()
printOften 0 str = return ()
printOften n str = do {
    putStrLn str;
    printOften (n-1) str;
}