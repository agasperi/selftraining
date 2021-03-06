-- Hello, world!

main = do  
    let a = "hell"  
        b = "yeah"  
    putStrLn $ a ++ " " ++ b

main = do
    putStr "Hey, "  
    putStr "I'm "  
    putStrLn "Andy!"

main = do   putChar 't'  
    putChar 'e'  
    putChar 'h'

import Control.Monad   
main = do  
    c <- getChar  
    when (c /= ' ') $ do  
        putChar c  
        main

main = do  
    return ()  
    return "HAHAHA"  
    line <- getLine  
    return "BLAH BLAH BLAH"  
    return 4  
    putStrLn line

main = do   print True  
print 2  
print "haha"  
print 3.2  
print [3,4,3]  

main = do  
    a <- getLine  
    b <- getLine  
    c <- getLine  
    print [a,b,c]

main = do  
    rs <- sequence [getLine, getLine, getLine]  
    print rs

ghci> mapM print [1,2,3]  
1  
2  
3  
[(),(),()]  
ghci> mapM_ print [1,2,3]  
1  
2  
3


import Control.Monad  
import Data.Char  
  
main = forever $ do  
    putStr "Give me some input: "  
    l <- getLine  
    putStrLn $ map toUpper l


import Control.Monad  

main = do   
    colors <- forM [1,2,3,4] (\a -> do  
        putStrLn $ "Which color do you associate with the number " ++ show a ++ "?"  
        color <- getLine  
        return color)  
    putStrLn "The colors that you associate with 1, 2, 3 and 4 are: "  
    mapM putStrLn colors


-- Files and streams

import Data.Char  
  
main = do  
    contents <- getContents  
    putStr (map toUpper contents)

respondPalindromes contents = unlines (map (\xs -> if isPalindrome xs then "palindrome" else "not a palindrome") (lines contents))  
    where   isPalindrome xs = xs == reverse xs

respondPalindromes = unlines . map (\xs -> if isPalindrome xs then "palindrome" else "not a palindrome") . lines  
    where   isPalindrome xs = xs == reverse xs

openFile
openFile :: FilePath -> IOMode -> IO Handle
type FilePath = String
data IOMode = ReadMode | WriteMode | AppendMode | ReadWriteMode


withFile
import System.IO     
    
main = do     
    withFile "girlfriend.txt" ReadMode (\handle -> do  
        contents <- hGetContents handle     
        putStr contents)


withFile' :: FilePath -> IOMode -> (Handle -> IO a) -> IO a 
withFile' path mode f = do
    handle <- openFile path mode
    result <- f handle
    hClose handle
    return result


import System.IO  

main = do  
    contents <- readFile "girlfriend.txt"  
    putStr contents


import System.IO     
import Data.Char  
    
main = do     
    contents <- readFile "girlfriend.txt"     
    writeFile "girlfriendcaps.txt" (map toUpper contents)


import System.IO

main = do
    todoItem <- getLine
    appendFile "todo.txt" (todoItem ++ "\n")


main = do   
    withFile "something.txt" ReadMode (\handle -> do  
        hSetBuffering handle $ BlockBuffering (Just 2048)  
        contents <- hGetContents handle  
        putStr contents)


import System.IO  
import System.Directory  
import Data.List  
    
main = do        
    handle <- openFile "todo.txt" ReadMode  
    (tempName, tempHandle) <- openTempFile "." "temp"  
    contents <- hGetContents handle  
    let todoTasks = lines contents     
        numberedTasks = zipWith (\n line -> show n ++ " - " ++ line) [0..] todoTasks     
    putStrLn "These are your TO-DO items:"  
    putStr $ unlines numberedTasks  
    putStrLn "Which one do you want to delete?"     
    numberString <- getLine     
    let number = read numberString     
        newTodoItems = delete (todoTasks !! number) todoTasks     
    hPutStr tempHandle $ unlines newTodoItems  
    hClose handle  
    hClose tempHandle  
    removeFile "todo.txt"  
    renameFile tempName "todo.txt"

-- Command line arguments

import System.Environment   
import Data.List  
  
main = do  
   args <- getArgs  
   progName <- getProgName  
   putStrLn "The arguments are:"  
   mapM putStrLn args  
   putStrLn "The program name is:"  
   putStrLn progName


import System.Environment   
import System.Directory  
import System.IO  
import Data.List  
    
dispatch :: [(String, [String] -> IO ())]  
dispatch =  [ ("add", add)  
            , ("view", view)  
            , ("remove", remove)  
            ]

add :: [String] -> IO ()  
add [fileName, todoItem] = appendFile fileName (todoItem ++ "\n")  

main = do  
    (command:args) <- getArgs  
    let (Just action) = lookup command dispatch  
    action args

add :: [String] -> IO ()  
add [fileName, todoItem] = appendFile fileName (todoItem ++ "\n")

view :: [String] -> IO ()  
view [fileName] = do  
    contents <- readFile fileName  
    let todoTasks = lines contents  
        numberedTasks = zipWith (\n line -> show n ++ " - " ++ line) [0..] todoTasks  
    putStr $ unlines numberedTasks

remove :: [String] -> IO ()  
remove [fileName, numberString] = do  
    handle <- openFile fileName ReadMode  
    (tempName, tempHandle) <- openTempFile "." "temp"  
    contents <- hGetContents handle  
    let number = read numberString  
        todoTasks = lines contents  
        newTodoItems = delete (todoTasks !! number) todoTasks  
    hPutStr tempHandle $ unlines newTodoItems  
    hClose handle  
    hClose tempHandle  
    removeFile fileName  
    renameFile tempName fileName

-- Randomness

ghci> random (mkStdGen 949488) :: (Float, StdGen)  
(0.8938442,1597344447 1655838864)  
ghci> random (mkStdGen 949488) :: (Bool, StdGen)  
(False,1485632275 40692)  
ghci> random (mkStdGen 949488) :: (Integer, StdGen)  
(1691547873,1597344447 1655838864)


threeCoins :: StdGen -> (Bool, Bool, Bool)  
threeCoins gen =   
    let (firstCoin, newGen) = random gen  
        (secondCoin, newGen') = random newGen  
        (thirdCoin, newGen'') = random newGen'  
    in  (firstCoin, secondCoin, thirdCoin)

ghci> threeCoins (mkStdGen 21)  
(True,True,True)  
ghci> threeCoins (mkStdGen 22)  
(True,False,True)  
ghci> threeCoins (mkStdGen 943)  
(True,False,True)  
ghci> threeCoins (mkStdGen 944)  
(True,True,True)

ghci> take 5 $ randoms (mkStdGen 11) :: [Int]  
[-1807975507,545074951,-1015194702,-1622477312,-502893664]  
ghci> take 5 $ randoms (mkStdGen 11) :: [Bool]  
[True,True,True,True,False]  
ghci> take 5 $ randoms (mkStdGen 11) :: [Float]  
[7.904789e-2,0.62691015,0.26363158,0.12223756,0.38291094] 

randoms' :: (RandomGen g, Random a) => g -> [a]  
randoms' gen = let (value, newGen) = random gen in value:randoms' newGen

finiteRandoms :: (RandomGen g, Random a, Num n) => n -> g -> ([a], g)  
finiteRandoms 0 gen = ([], gen)  
finiteRandoms n gen =   
    let (value, newGen) = random gen  
        (restOfList, finalGen) = finiteRandoms (n-1) newGen  
    in  (value:restOfList, finalGen)

ghci> randomR (1,6) (mkStdGen 359353)  
(6,1494289578 40692)  
ghci> randomR (1,6) (mkStdGen 35935335)  
(3,1250031057 40692)

ghci> take 10 $ randomRs ('a','z') (mkStdGen 3) :: [Char]  
"ndkxbvmomg"

import System.Random  
  
main = do  
    gen <- getStdGen  
    putStr $ take 20 (randomRs ('a','z') gen)

$ runhaskell random_string.hs  
pybphhzzhuepknbykxhe  
$ runhaskell random_string.hs  
eiqgcxykivpudlsvvjpg  
$ runhaskell random_string.hs  
nzdceoconysdgcyqjruo  
$ runhaskell random_string.hs  
bakzhnnuzrkgvesqplrx

import System.Random  
  
main = do  
    gen <- getStdGen  
    putStrLn $ take 20 (randomRs ('a','z') gen)  
    gen2 <- getStdGen  
    putStr $ take 20 (randomRs ('a','z') gen2)  

    import System.Random  
    import Data.List  

main = do  
    gen <- getStdGen  
    let randomChars = randomRs ('a','z') gen  
        (first20, rest) = splitAt 20 randomChars  
        (second20, _) = splitAt 20 rest  
    putStrLn first20  
    putStr second20

import System.Random  

main = do     
    gen <- getStdGen     
    putStrLn $ take 20 (randomRs ('a','z') gen)     
    gen' <- newStdGen  
    putStr $ take 20 (randomRs ('a','z') gen')

import System.Random  
import Control.Monad(when)  
    
main = do  
    gen <- getStdGen  
    askForNumber gen  
    
askForNumber :: StdGen -> IO ()  
askForNumber gen = do  
    let (randNumber, newGen) = randomR (1,10) gen :: (Int, StdGen)  
    putStr "Which number in the range from 1 to 10 am I thinking of? "  
    numberString <- getLine  
    when (not $ null numberString) $ do  
        let number = read numberString  
        if randNumber == number   
            then putStrLn "You are correct!"  
            else putStrLn $ "Sorry, it was " ++ show randNumber  
        askForNumber newGen

$ runhaskell guess_the_number.hs  
Which number in the range from 1 to 10 am I thinking of? 4  
Sorry, it was 3  
Which number in the range from 1 to 10 am I thinking of? 10  
You are correct!

import System.Random  
import Control.Monad(when)  
  
main = do  
    gen <- getStdGen  
    let (randNumber, _) = randomR (1,10) gen :: (Int, StdGen)     
    putStr "Which number in the range from 1 to 10 am I thinking of? "  
    numberString <- getLine  
    when (not $ null numberString) $ do  
        let number = read numberString  
        if randNumber == number  
            then putStrLn "You are correct!"  
            else putStrLn $ "Sorry, it was " ++ show randNumber  
        newStdGen  
        main

-- Bytestrings

import qualified Data.ByteString.Lazy as B  
import qualified Data.ByteString as S

import System.Environment  
import qualified Data.ByteString.Lazy as B  
  
main = do  
    (fileName1:fileName2:_) <- getArgs  
    copyFile fileName1 fileName2  
  
copyFile :: FilePath -> FilePath -> IO ()  
copyFile source dest = do  
    contents <- B.readFile source  
    B.writeFile dest contents

-- Exceptions

import System.Environment  
import System.IO  
  
main = do (fileName:_) <- getArgs  
          contents <- readFile fileName  
          putStrLn $ "The file has " ++ show (length (lines contents)) ++ " lines!"

import System.Environment  
import System.IO  
import System.Directory  

main = do (fileName:_) <- getArgs  
        fileExists <- doesFileExist fileName  
        if fileExists  
            then do contents <- readFile fileName  
                    putStrLn $ "The file has " ++ show (length (lines contents)) ++ " lines!"  
            else do putStrLn "The file doesn't exist!"

import System.Environment  
import System.IO  
import System.IO.Error  
    
main = toTry `catch` handler  
                
toTry :: IO ()  
toTry = do (fileName:_) <- getArgs  
            contents <- readFile fileName  
            putStrLn $ "The file has " ++ show (length (lines contents)) ++ " lines!"  
    
handler :: IOError -> IO ()  
handler e = putStrLn "Whoops, had some trouble!"

import System.Environment  
import System.IO  
import System.IO.Error  
  
main = toTry `catch` handler  
              
toTry :: IO ()  
toTry = do (fileName:_) <- getArgs  
           contents <- readFile fileName  
           putStrLn $ "The file has " ++ show (length (lines contents)) ++ " lines!"  
  
handler :: IOError -> IO ()  
handler e  
    | isDoesNotExistError e = putStrLn "The file doesn't exist!"  
    | otherwise = ioError e

    import System.IO     
    import System.IO.Error     
        
    main = toTry `catch` handler     
                     
    toTry :: IO ()     
    toTry = do (fileName:_) <- getArgs     
               contents <- readFile fileName     
               putStrLn $ "The file has " ++ show (length (lines contents)) ++ " lines!"     
        
    handler :: IOError -> IO ()     
    handler e     
        | isDoesNotExistError e =   
            case ioeGetFileName e of Just path -> putStrLn $ "Whoops! File does not exist at: " ++ path  
                                     Nothing -> putStrLn "Whoops! File does not exist at unknown location!"  
        | otherwise = ioError e
