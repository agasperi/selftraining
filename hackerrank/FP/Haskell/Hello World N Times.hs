{-# LANGUAGE FlexibleInstances, UndecidableInstances, DuplicateRecordFields #-}

module Main where

import Control.Monad
import Data.Array
import Data.Bits
import Data.List
import Data.List.Split
import Data.Set
import Debug.Trace
import System.Environment
import System.IO
import System.IO.Unsafe

hello_worlds :: (Num i, Ord i) => i -> String
hello_worlds n
    | n <= 0 = ""
hello_worlds n
    | n == 1 = "Hello World"
hello_worlds n = "Hello World\n" ++ hello_worlds (n-1)

main :: IO()
main = do
    n <- readLn :: IO Int
    putStrLn (hello_worlds n)

Otras soluciones:

hello_worlds n = mapM_ putStrLn $ replicate n "Hello World"

hello_worlds n = mapM_ putStrLn (take n (repeat "Hello World"))

hello_worlds 1 = putStrLn "Hello World"
hello_worlds n = do
        putStrLn "Hello World" 
        hello_worlds (n - 1)