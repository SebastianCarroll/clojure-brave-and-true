# Ch 3: Do Things
Form = valid code
expression ~= form
clojure evaluates every form to produce a value
operations are how you do things
operation form: (operator operand1 op2 op3 ... opn)
no commas, commas are whitespace in clojure
clojures structure uniformity big win
Other languages: diff operations can have different structures depending on operator and operands
Clojures structure is simple and consistent

## Control flow
if, do and when

### if
Structure
(if boolean-form
    then-form
    optional-else-form)

boolean-form: form that evaluates to a truthy or falsey value

Omitting the false branch returns nil if evaluates to false
(if false
    "truthy!")
; => nil

if uses position to differentate the the from the else branch. Thus only one form per branch
Get around this with the do

### do
Do lets you 'wrap up' multiple forms and run each of them

(if true
    (do (println "success")
        'ret val')
    (do (println "falsey")
        'ret val else'))

### when
Is like if and do when if always has no else
(when true
    (println "success")
    'ret value')

Equivalent with if
(if true
    (do
        (println "success")
        'ret value'))

## Truthiness
true and false values
nil indicates no value

(nil? 1)
; => false

Falsey = nil and false
all other values are truthey

### and or
or - returns either the first truthy or last value
and - returns the first falsey or the last truthy

## Def
Think of as defining constants
Binds a name to a value

## Data structures
Data structures are immutable

### Numbers
here for more details: http://clojure.org/data_structures#Data%20Structures-Numbers
Excellent number support
Represent fractions directly: e.g. 1/2

### Strings
Only double quotes: " not '
No interpolation natively: https://blog.wjlr.org.uk/2015/01/15/string-interpolation-clojure.html
Only str for concatination and format for all else

### Maps
Like dictionaries or hashes
Associating some value with another
two kinds: hash maps and sorted maps

Empty map: {}
Map literal

:first-name => are keywords

e.g.
{:first-name "charlie"
 :last-name "Mcfishwish"}

Associated string with function
{"string" +}

Map values can be any time

use hash-map to create as well
get will look up values, returns nil if key not found

get-in for nested loops

Maps are also functions with the key as an argument will get the value
(def m {:name "the coffee"})
(m :name)
;; => "the coffee"

### Keywords
Start with a colon
:a
:name
etc

Keywords are functions that can be used to look up the value in a ds
(:name a)
; => "the coffee"

can give a default
(:not-there a "not the coffee")
"not the coffee"

### Vectors
literal: [3 2 1]
Similar to array
0 indexed

(get [3 2 1] 1)
; => 2

Vector elements can be of any type

conj: adds elements. To the end of vectors

### Lists
Similar to vecotrs
Cant use get
literal:
'(1 2 3 4)

use nth instead
(nth '(1 2 3 4) 0)
; => 1

nth:list is slower than get:vector
Lists are linked. To get nth clojure traverses all elements till it finds the one at n

Conj adds elements but to the beginning of lists

Use:
Lists if: need to add items at the beginning or writing a macro
vectors if: everything else

### Sets
Hash and sorted sets
Literal notation #{}
use conj to add to a set
can create from existing vector
(set [3 3 3 4 4 4])
; => #{3 4}

check membership
Contains?: true or false
get or keyword as function: value if exists or nil

## Simplicity
Code reuse by sticking to basic datastructures and writing functions to operate on them

## Functions
Calling functions in the usual way (fn arg1 arg2 ..)
Fn expression - expression that returns fn
HoF
First class functions
Can't use strings or numbers as fns
Think as generalising over processes
e.g map transforms collection by by applying fn to the elements
Expression arguments are evaluated recursively - ie depth first, in place

### Special forms and macros
Special forms don't always evaluate all the arguments e.g. if and def
Special forms and macros cannot be passed to fns and cannot be made with fns

Macros: similar as they don't evaluate all their operands and also can't be passed to fns

### Defining fns
1. Defn
2. func name
3. docsting (optional)
4. arguments 
5. Body

### Arity and parameters
Can define multiple arity on fns
With arity overloading
can be completely unrelated though not advised
rest parameter is & and converts any remaining params to a list

### Destructuring
Bind names to values based on strucutre of paramter
Lists, maps all work
Can be used with & as well
Use :keys to get all bindings
Retain access to original map with :as
e.g
(defn location
    [{:keys [lat long] :as orig-map}]
    ;;do something
    )

All fns are created equal. No higher priviledge on the + or the defn you create yourself
This is the heart of simplicity. Clojure doesn't care about order or hierarchy or special fns. Give it a fn it will apply it and move on

### Anonymous fns
(fn ... )
 ```#(.. %...)```
 %1 %2 are the args and % => %1
These are possible by reader macros. Not sure what they are yet

Can return fns









