*** Haskell

Haskell is purely functional programming language.
Haskell is lazy.
Haskell is statically typed.
Haskell uses a very good typed system that has type inference.
Haskell is elegant and concise.
Haskell was made by some really smart guys.
In Haskell every expression or function must return something.

** Commands
ghci -> The interactive mode is invoked by typing in ghci.
:load -> It load a file .hs
:l -> It load a file .hs
:t -> It tells us the type of one valid expression.
:cd -> Change the path of the workspace.
:info -> Whole information about a type or function.
:k -> information about kind of type

* Import modules
ghci> :m + Data.List
ghci> :m + Data.List Data.Map Data.Set  

* Qualified Import

import qualified Data.Map as Map  

** Instructions
let -> let a = 1 -> We can use it to define a name right in ghci.

**Types
Int -> It stands for integer.
Integer -> It stands also integer but it can be use to big numbers.
Float -> It's a real floating point with single precision.
Double -> It's a real floating point with double precision.
Bool -> It's a boolean type.
Char -> It represent a character.

**Operators

*Arithmetics
+ - * / div ^

*Logicals
&& -> and
|| -> or
not -> negation
== -> equality
/= -> not equal

**Decision structures
if x > 100 then x else x * 2 -> If conditional, else part is mandatory in Haskell

*Guards
myCompare :: (Ord a) => a -> a -> Ordering
a `myCompare` b
    | a > b     = GT
    | a == b    = EQ
    | otherwise = LT

*Case
case expression of pattern -> result
                   pattern -> result
                   pattern -> result
                   ...

head' :: [a] -> a
head' xs = case xs of [] -> error "No head for empty lists!"
                      (x:_) -> x

*Where
bmiTell' :: (RealFloat a) => a -> a -> String
bmiTell' weight height
    | bmi <= 18.5 = "You're underweight, you emo, you!"
    | bmi <= 25.0 = "You're supposedly normal. Pffft, I bet you're ugly!"
    | bmi <= 30.0 = "You're fat! Lose some weight, fatty!"
    | otherwise   = "You're a whale, congratulations!"
    where bmi = weight / height ^ 2

* Let .. In
let <bindings> in <expression>
cylinder :: (RealFloat a) => a -> a -> a
cylinder r h =
    let sideArea = 2 * pi * r * h
        topArea = pi * r ^ 2
    in sideArea + 2 * topArea

[let square x = x * x in (square 5, square 3, square 2)]

**Lists
[1,2,3] -> Declaring a list
[] -> Empty list
[[]] -> A list that contains a empty list
[[],[],[]] -> A list that contains three empty lists.
++ -> [1,2,3] ++ [4,5] ->  [1,2,3,4,5] -> Append a list to other
: -> [1,2,3] : 4 -> [1,2,3,4] -> Add a element to the list
!! -> [1,2,3] !! 1 -> 2 -> Get an element of the list by index, the indices start at 0

*List Ranges
[1..5] -> [1,2,3,4,5]
[2,4..10] -> [2,4,6,8,10]
[5,4..1] -> [5,4,3,2,1]
[3,2..(-2)] -> [3,2,1,0,-1,-2]

*List Functions
head -> head [1,2,3,4] -> 1 -> Return the first element of a list
tail -> tail [1,2,3,4] -> [2,3,4] -> Return a list without the first element of the original list
last -> last [1,2,3,4] -> 4 -> Return the last element of a list
init -> init [1,2,3,4] -> [1,2,3] -> Return the list without the last element of the original list
length -> length [1,2,3,4] -> 4 -> Return the length of a list
null -> null [1,2,3,4] -> false -> Return if a list is empty
reverse -> reverse [1,2,3,4] -> [4,3,2,1] -> Return a reverse of the original list
take -> take 2 [1,2,3,4] -> [1,2] -> Return a list with the extract that many elements from the beginning of the original list.
drop -> drop 2 [1,2,3,4] -> [3,4] -> Return a list that it drops the number of elements from the beginning of the original list.
maximum -> maximum [1,2,3,4] -> 4 -> Return the biggest element of the list.
minimum -> minimum [1,2,3,4] -> 4 -> Return the smallest element of the list.
sum -> sum [1,2,3,4] -> 10 -> It takes a number list and return the sum of their elements.
product -> product [1,2,3,4] -> 24 -> It takes a number list and return the product of their elements.
elem -> 3 `elem` [1,2,3,4] -> true -> It takes a thing and check in a list of things if that thing is a element of this list.
cycle -> cycle [1,2] -> [1,2,1,2,1,2,.. -> Take a list and cycle it into an infinity list.
repeat -> repeat 5 -> [5,5,5... -> Take an element and produces an infinity list of just that element.
replicate -> replicate 3 10 -> [10,10,10] -> If you want some number of the same element in a list.

**List Comprehension
[x*2 | x <- [1..5]] -> [2,4,6,8,10]
[x*2 | x <- [1..5], x+2 >= 6] -> [8,10]
[if x < 10 then "BOOM!" else "BANG!" | x <- [7..13], odd x] -> ["BOOM!","BOOM!","BANG!","BANG!"]
[ x | x <- [0..10], x /= 3, x /= 5, x /= 9] -> [0,1,2,4,6,7,8,10]
[ x*y | x <- [1,3,5], y <- [2,4,6]]  -> [2,4,6,6,12,18,10,20,30]
[ x*y | x <- [1,3,5], y <- [2,4,6], x*y > 10] -> [12,18,20,30]

**Tuples
(a,b) -> Declaring a tuple
fst -> fst (11,8) -> 11 -> It takes a tuple and return the first value.
snd -> snd (11,8) -> 8 -> It takes a tuple and return the second value.
zip -> zip [1,2,3] ['a','b','c'] -> [(1,'a'),(2,'b'),(3,'c')] -> It takes two list and zip them together in one list by joining matching the elements into pairs.

**Functions
name_function list_parameters = expression
succ a -> successor
min a b -> minimum between a and b
max a b -> maximum between a and b
odd x -> if a number is odd

**Declaring a Function

removeNonUppercase :: [Char] -> [Char]
removeNonUppercase st = [ c | c <- st, c `elem` ['A'..'Z']]

addThree :: Int -> Int -> Int -> Int
addThree x y z = x + y + z

*Polymorphic Function
head :: [a] -> a
fst :: (a,b) -> a

**Typeclasses
A typeclasses is a sort of interface that define some behavior.

Eq -> It's used for types that support equality testing -> (==) :: Eq a => a -> a -> Bool
Ord -> It's for types that have an ordering. -> (>) :: Ord a => a -> a -> Bool
Show -> It's for types that can be presented by string. -> show :: Show a => a -> String
Read -> It's for types that takes a string and return a type which is a member of Read -> read :: Read a => String -> a
Enum -> Its members are sequentially ordered types. -> succ :: Enum a => a -> a
Bounded -> Its members have an upper and lower bound. -> minBound :: Bounded a => a
Num -> Its members have the property of being able to act like a number. -> sum :: (Foldable t, Num a) => t a -> a
Integral -> It includes only integral numbers. -> fromIntegral :: (Integral a, Num b) => a -> b
Floating -> It includes only floating numbers, so Float and Double.

** Map

* Definition
map :: (a -> b) -> [a] -> [b]
map _ [] = []
map f (x:xs) = f x : map f xs

*Examples
ghci> map (+3) [1,5,3,1,6]
[4,8,6,4,9]
ghci> map (++ "!") ["BIFF", "BANG", "POW"]
["BIFF!","BANG!","POW!"]
ghci> map (replicate 3) [3..6]
[[3,3,3],[4,4,4],[5,5,5],[6,6,6]]
ghci> map (map (^2)) [[1,2],[3,4,5,6],[7,8]]
[[1,4],[9,16,25,36],[49,64]]
ghci> map fst [(1,2),(3,5),(6,3),(2,6),(2,5)]
[1,3,6,2,2]

** Filter

* Definition
filter :: (a -> Bool) -> [a] -> [a]
filter _ [] = []
filter p (x:xs)
    | p x       = x : filter p xs
    | otherwise = filter p xs

* Examples
ghci> filter (>3) [1,5,3,2,1,6,4,3,2,1]
[5,6,4]
ghci> filter (==3) [1,2,3,4,5]
[3]
ghci> filter even [1..10]
[2,4,6,8,10]
ghci> let notNull x = not (null x) in filter notNull [[1,2,3],[],[3,4,5],[2,2],[],[],[]]
[[1,2,3],[3,4,5],[2,2]]
ghci> filter (`elem` ['a'..'z']) "u LaUgH aT mE BeCaUsE I aM diFfeRent"
"uagameasadifeent"
ghci> filter (`elem` ['A'..'Z']) "i lauGh At You BecAuse u r aLL the Same"
"GAYBALLS"

* Using partial Functions
ghci> let listOfFuns = map(*) [0..]
ghci> (listOfFuns !! 4) 5

$ ghc --make helloworld.hs
$ runhaskell helloworld.hs

sequence (map print [1,2,3,4,5])
mapM print [1,2,3]
mapM_ print [1,2,3]
