greetUser :: String -> IO ()
greetUser greeting = do {
    putStrLn "Please enter your name";
    name <- getLine;
    putStrLn ("Hi " ++ name ++ ". " ++ greeting);
}

main = do {
    greetUser "Welcome!";
    greetUser "Welcome!";
}