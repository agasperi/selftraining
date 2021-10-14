{-# LANGUAGE FlexibleInstances, UndecidableInstances, DuplicateRecordFields #-}

module Main where

import Control.Monad
import Data.Array
import Data.Bits
import Data.List.Split
import Debug.Trace
import System.Environment
import System.IO
import System.IO.Unsafe

factorial :: Int -> Int
factorial 0 = 1
factorial x = x * factorial (x - 1)

eFirstN :: Int -> Double -> Double
eFirstN 0 _ = 1
eFirstN n x = ((x ^ n) / (fromIntegral (factorial n))) + (eFirstN (n - 1) x)

f :: Int -> [Double] -> [Double]
f 0 _ = []
f n [] = []
f n (x:xs) = (eFirstN 9 x) : f (n-1) xs

main :: IO()
main = do
    n <- readLn :: IO Int
    inputdata <- getContents
    let
        numbers = map read (lines inputdata) :: [Double]
    putStrLn . unlines $ (map show . f n) numbers